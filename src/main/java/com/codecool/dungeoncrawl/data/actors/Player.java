package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;

public class Player extends Actor {
    boolean hasSword = false;
    private Actor neighbourEnemy;
    private final int baseStrength = 5;
    private Cell cell = getCell();

    public Set<Item> getInventory() {
        return new HashSet<>(inventory);
    }

    private final Set<Item> inventory = new HashSet<>();

    public void pickUpItem(Item item) {
        if(!inventory.add(item)) {
            inventory.add(item);
        }
    }

    public Player(Cell cell) {
        super(cell);
    }

    @Override
    public Actor checkForEnemy(int dx, int dy) {
        Actor neighbourActor = cell.getNeighbor(dx, dy).getActor();
        if (neighbourActor != null) {
            return neighbourActor;
        }
        return null;
    }

    public void fight(int dx, int dy) {
        if (!checkForEnemy(dx, dy).equals(cell.getActor()) && checkForEnemy(dx, dy) != null) {
            calculateDamage();
            cell.getNeighbor(dx, dy).getActor().calculateDamage();
        }
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() == CellType.FLOOR) {
            if (nextCell.getActor() != null) {
                neighbourEnemy = nextCell.getActor();
                fight(dx, dy);
            } else {
                if (nextCell.getItem() != null) {
                    System.out.println(nextCell.getItem().getTileName());
                    pickUpItem(nextCell.getItem());
                    nextCell.setItem(null);
                }
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }
        } else if (nextCell.getType() == CellType.DOOR) {
            if (nextCell.getDoor().checkPlayerAccess(inventory)) {
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
                System.out.println(nextCell.getDoor().getTileName());
            }
        }
    }

    @Override
    public void calculateDamage() {
        int dmgMultiplier = 1;
        if (!inventory.stream().filter(i -> i.getTileName().equals("sword")).collect(Collectors.toList()).isEmpty()) {
            dmgMultiplier = 2;
        }
        neighbourEnemy.setHealth(neighbourEnemy.getHealth() - (baseStrength * dmgMultiplier));
    }

}

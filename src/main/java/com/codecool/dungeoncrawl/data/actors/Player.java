package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;

public class Player extends Actor {

    boolean isBossDefeated = false;
    boolean isPrincessRescued = false;
    private Actor neighbourEnemy;
    public int strength = 5;

    private Cell cell = getCell();

    public Set<Item> getInventory() {
        return new HashSet<>(inventory);
    }

    private final Set<Item> inventory = new HashSet<>();

    public void pickUpItem(Item item) {
        if(!inventory.contains(item)) {
            inventory.add(item);
            if(item.getTileName().equals("sword")){
                strength *= 2;
            }
        } else {
            System.out.println("item already in inventory");
        }
    }
    public void consumeItem(Item item) {
            inventory.remove(item);

    }
    public Player(Cell cell) {
        super(cell);
    }

    @Override
    public Actor checkForNeighbouringActor(int dx, int dy) {
        return cell.getNeighbor(dx, dy).getActor();
    }

    public int getStrength() {
        return strength;
    }

    public void fight(int dx, int dy) {

        if (!checkForNeighbouringActor(dx, dy).equals(cell.getActor()) && checkForNeighbouringActor(dx, dy) != null) {
            if (checkForNeighbouringActor(dx, dy).getTileName().equals("boss")) {
                System.out.println("boss attacked");
                calculateDamage();
                if(cell.getNeighbor(dx, dy).getActor().calculateDamage()) {
                    setBossDefeated(true);
                } else {
                    System.out.println("boss is alive");
                }
            } else {
                calculateDamage();
                cell.getNeighbor(dx, dy).getActor().calculateDamage();
            }
        }
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() == CellType.FLOOR || nextCell.getType() == CellType.WEB) {
            if (nextCell.getActor() != null) {
                neighbourEnemy = nextCell.getActor();
                if(neighbourEnemy.getTileName().equals("princess") && isBossDefeated) {
                    neighbourEnemy.setHealth(20);
                    System.out.println("princess rescued");
                    setPrincessRescued(true);
                }
                fight(dx, dy);
            } else {
                if (nextCell.getItem() != null) {
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

            }
        } else if (nextCell.getType() == CellType.FIRE) {
            setHealth(0);


        }
    }

    @Override
    public boolean calculateDamage() {

        neighbourEnemy.setHealth(neighbourEnemy.getHealth() - (strength));

        return true;
    }
    public void setPrincessRescued(boolean princessRescued) {
        isPrincessRescued = princessRescued;


    }

    public void setBossDefeated(boolean bossDefeated) {
        isBossDefeated = bossDefeated;
    }

}

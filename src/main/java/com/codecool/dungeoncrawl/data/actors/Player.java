package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashSet;

import java.util.Set;

public class Player extends Actor {
    private Cell cell = getCell();
    private final Set<Item> inventory = new HashSet<>();
    public void pickUpItem (Item item) {
        inventory.add(item);
        System.out.println("item picked");
    }
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);


        if (nextCell.getType() == CellType.FLOOR) {
            if (nextCell.getActor() != null) {
                System.out.println(nextCell.getActor().getTileName());
            } else {
                if (nextCell.getType() == CellType.FLOOR) {

                }
                if (nextCell.getItem() != null) {
                    System.out.println(nextCell.getItem().getTileName());

                    pickUpItem(nextCell.getItem());
                    nextCell.setItem(null);
                }


                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;

            }

        }

        if (nextCell.getType() == CellType.DOOR) {

            if (nextCell.getDoor().checkPlayerAccess(inventory)) {
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
                System.out.println(nextCell.getDoor().getTileName());
            }
        }

    }


}

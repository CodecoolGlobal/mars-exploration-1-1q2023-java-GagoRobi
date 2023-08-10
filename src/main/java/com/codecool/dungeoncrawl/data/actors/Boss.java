package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Boss extends Actor {
    private Cell cell = getCell();
    public Boss(Cell cell) {
        super(cell);
        setHealth(30);
    }
    @Override
    public String getTileName() {
        return "boss";
    }

    @Override
    public Actor checkForNeighbouringActor(int dx, int dy) {
        return null;
    }
    public Actor findEnemy() {
        int XCoordinates = 0;
        int YCoordinates = 0;
        if (getCell().getNeighbor(0, 1).getActor() != null) {
            YCoordinates = 1;
        } else if (getCell().getNeighbor(0, -1).getActor() != null) {
            YCoordinates = -1;
        } else if (getCell().getNeighbor(1, 0).getActor() != null) {
            XCoordinates = 1;
        } else if (getCell().getNeighbor(-1, 0).getActor() != null) {
            XCoordinates = -1;
        }
        if (XCoordinates == 0 && YCoordinates == 0) {
            System.out.println("zero coordinates");
            return null;
        } else {
            System.out.println("enemy found");
            return getCell().getNeighbor(XCoordinates, YCoordinates).getActor();
        }
    }

    @Override
    public boolean calculateDamage() {
        System.out.println("boss hp: " + getHealth());
        System.out.println("boss dmg: " + 4);
        /*Actor actor = findEnemy();

        if (actor.getTileName().equals("player")) {
            actor.setHealth(actor.getHealth() - 4);
        }*/

        if (getHealth() <= 0) {
            super.getCell().setActor(null);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void move(int dx, int dy) {
        try {
            Cell nextCell = cell.getNeighbor(dx, dy);
            if (cell.getNeighbor(dx,dy).getType() != CellType.WALL && cell.getNeighbor(dx,dy).getType() != CellType.CANDLE
                && cell.getNeighbor(dx,dy).getType() != CellType.DOOR && !cell.getNeighbor(dx,dy).getTileName().equals("player")
                ) {
                    cell.setActor(null);
                    nextCell.setActor(this);
                    cell = nextCell;
                }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }
}

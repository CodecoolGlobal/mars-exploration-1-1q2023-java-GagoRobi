package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import com.codecool.dungeoncrawl.data.CellType;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.logic.FightLogic;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Skeleton extends Actor {
    private int moveCount = 0;
    private String tileName = "skeleton";

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private Cell cell = getCell();

    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {
        if (getHealth() <= 0) {
            super.getCell().setActor(null);
            return;
        }
        if(findEnemy() !=null){
            System.out.println("before move found enemy");
            calculateDamage();
        }
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() == null) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }

    }

    @Override
    public Actor checkForEnemy(int dx, int dy) {
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
            return null;
        } else {
            return getCell().getNeighbor(XCoordinates, YCoordinates).getActor();
        }
    }

    @Override
    public void calculateDamage() {
        System.out.println("skeleton hp: " + getHealth());
        System.out.println("skeleton dmg: " + 2);
        Actor actor = findEnemy();
        if (actor != null) {
            System.out.println("actor found");
            if (actor.getTileName().equals("player")) {
                System.out.println("player found");
                actor.setHealth(actor.getHealth() - 2);
            }
        }
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }


    @Override
    public String getTileName() {
        return tileName;
    }

    public void setTileName(String tileName) {
        this.tileName = tileName;
    }
}

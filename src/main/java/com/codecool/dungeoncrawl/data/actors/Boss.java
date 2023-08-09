package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Boss extends Actor {
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
            return null;
        } else {
            return getCell().getNeighbor(XCoordinates, YCoordinates).getActor();
        }
    }

    @Override
    public void calculateDamage() {
        System.out.println("boss hp: " + getHealth());
        System.out.println("boss dmg: " + 4);
        Actor actor = findEnemy();
        if (actor.getTileName().equals("player")) {
            actor.setHealth(actor.getHealth() - 4);
        } else if (actor.getTileName().equals("player")) {
            actor.setHealth(actor.getHealth() - 4);
        } else if (actor.getTileName().equals("player")) {
            actor.setHealth(actor.getHealth() - 4);
        } else if (actor.getTileName().equals("player")) {
            actor.setHealth(actor.getHealth() - 4);
        }
        if (getHealth() <= 0) {
            super.getCell().setActor(null);
        }
    }
    @Override
    public void move(int dx, int dy) {

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

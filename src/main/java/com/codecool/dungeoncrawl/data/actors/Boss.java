package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Boss extends Actor {
    private Cell cell = getCell();
    public Boss(Cell cell) {
        super(cell);
    }
    @Override
    public String getTileName() {
        return "boss";
    }

    @Override
    public Actor checkForNeighbouringActor(int dx, int dy) {
        return null;
    }

    @Override
    public void calculateDamage() {
        System.out.println("boss hp: " + getHealth());
        System.out.println("boss dmg: " +2);
        Actor actor = cell.getActor();
        if (actor.getTileName().equals("player")) {
            actor.setHealth(actor.getHealth() - 2);
        } else if (actor.getTileName().equals("player")) {
            actor.setHealth(actor.getHealth() - 2);
        } else if (actor.getTileName().equals("player")) {
            actor.setHealth(actor.getHealth() - 2);
        } else if (actor.getTileName().equals("player")) {
            actor.setHealth(actor.getHealth() - 2);
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
}

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

    }
    @Override
    public void move(int dx, int dy) {

    }
}

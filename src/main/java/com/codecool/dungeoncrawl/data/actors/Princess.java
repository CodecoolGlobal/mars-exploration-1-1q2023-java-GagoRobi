package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Princess extends Actor {
    private Cell cell = getCell();

    public Princess (Cell cell) {
        super(cell);
    }
    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public String getTileName() {
        return "princess";
    }

    @Override
    public String checkForEnemy(int dx, int dy) {
        return null;
    }

    @Override
    public void calculateDamage() {

    }
}

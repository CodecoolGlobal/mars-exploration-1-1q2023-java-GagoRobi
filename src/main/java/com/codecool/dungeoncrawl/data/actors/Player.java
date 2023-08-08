package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Player extends Actor {
    private boolean hasSword = false;
    private Cell cell = getCell();

    public Player(Cell cell) {
        super(cell);
    }
    @Override
    public String checkForEnemy(int dx, int dy) {
        Actor neighbourActor = cell.getNeighbor(dx, dy).getActor();
        if (neighbourActor != null) {
            return neighbourActor.getTileName();
        }
        return "none";
    }

    public void fight(int dx, int dy) {
        if (!checkForEnemy(dx, dy).equals(cell.getActor().getTileName()) && !checkForEnemy(dx, dy).equals("none")) {
            calculateDamage();
            cell.getNeighbor(dx, dy).getActor().calculateDamage();
        }
    }
@Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        fight(dx, dy);

        if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() == null) {
            if (nextCell.getItem() != null) {
                //System.out.println(nextCell.getItem().getTileName());
            }
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public void calculateDamage() {
        setHealth(getHealth()-2);
    }
}

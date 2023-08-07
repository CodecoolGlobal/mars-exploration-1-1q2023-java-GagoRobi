package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    private boolean enemy;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);


        if(nextCell.getType() == CellType.FLOOR  ){
            if(nextCell.getActor() != null ){
                enemy = true;
                System.out.println(nextCell.getActor().getTileName());
            }else{
                enemy = false;
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;

            }

        }

    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}

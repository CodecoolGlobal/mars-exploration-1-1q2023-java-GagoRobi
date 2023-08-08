package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.Key;

import java.util.HashSet;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;



    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }


    public abstract void move(int dx, int dy);

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

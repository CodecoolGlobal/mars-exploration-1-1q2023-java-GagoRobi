package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.Cell;

public abstract class Item implements Drawable {

    private Cell cell;
    public Item (Cell cell) {
        this.cell = cell;
        this.cell.setItem(this);
    }

}

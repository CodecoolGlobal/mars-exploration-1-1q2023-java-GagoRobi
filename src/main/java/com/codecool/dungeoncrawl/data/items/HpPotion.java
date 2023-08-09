package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class HpPotion extends Item{

    public HpPotion(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "HP-potion";
    }
}

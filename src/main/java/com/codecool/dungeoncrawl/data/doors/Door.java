package com.codecool.dungeoncrawl.data.doors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.Key;

import java.util.HashSet;
import java.util.Iterator;

public class Door implements Drawable {
    private Cell cell;


    public Door(Cell cell) {
        this.cell = cell;
        this.cell.setDoor(this);
    }


    public boolean checkPlayerAccess(HashSet <Item> inventory){

         for (Item item : inventory) {
             if (item.getTileName().equals("key")){
                 cell.setType(CellType.FLOOR);
                 inventory.remove("key"); // remove key
                 return true;
             }
         }
        return false;
    }



    public Cell getCell() {
        return cell;
    }



    public String getTileName() {
        return "door";
    }
}

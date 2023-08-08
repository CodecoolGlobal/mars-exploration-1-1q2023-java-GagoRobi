package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashSet;
import java.util.Set;

public class Player extends Actor {
    private final Set<Item> inventory = new HashSet<>();
    public void pickUpItem (Item item) {
        inventory.add(item);
    }
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }
}

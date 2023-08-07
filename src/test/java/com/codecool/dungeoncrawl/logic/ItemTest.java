package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Sword;
import org.junit.jupiter.api.Test;
import com.codecool.dungeoncrawl.data.GameMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    GameMap gameMap = new GameMap(3, 3, CellType.FLOOR);
    @Test
    void checkIfItemCreated () {
        Sword sword = new Sword(gameMap.getCell(1, 1));

        assertEquals(1, sword.getX());
        assertEquals(1, sword.getY());
    }
}

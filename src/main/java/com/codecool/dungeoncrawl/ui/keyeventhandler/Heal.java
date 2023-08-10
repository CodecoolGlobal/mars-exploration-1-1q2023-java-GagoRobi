package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.HpPotion;
import com.codecool.dungeoncrawl.data.items.Item;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.stream.Collectors;

public class Heal implements KeyHandler {
    public static final KeyCode code = KeyCode.E;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())){
            if (map.getPlayer().getInventory().stream().anyMatch(item -> item.getTileName().equals("HP-potion"))) {
                map.getPlayer().setHealth(20);
                for (Item item : map.getPlayer().getInventory()){
                    if(item.getTileName().equals("HP-potion")){
                        map.getPlayer().consumeItem(item);
                    }
                }
            }


        }
    }
}


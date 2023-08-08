package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.logic.FightLogic;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.input.KeyEvent;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {

    }
    @Override
    public String checkForEnemy(int dx, int dy) {
        return null;
    }

    @Override
    public void calculateDamage() {
        System.out.println("skeleton hp: "+getHealth());
        setHealth(getHealth()-5);
        if(getHealth() <=0){
            super.getCell().setActor(null);
        }
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }


}

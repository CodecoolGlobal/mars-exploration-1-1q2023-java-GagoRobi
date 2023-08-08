package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.FightLogic;

public class Skeleton extends Actor implements FightLogic{
    public Skeleton(Cell cell) {

        super(cell);
    }

    @Override
    public void calculateDamage() {
        System.out.println(getHealth());
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

package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.actors.Actor;

public interface FightLogic {


    public Actor checkForNeighbouringActor(int dx, int dy);
    public boolean calculateDamage();


}

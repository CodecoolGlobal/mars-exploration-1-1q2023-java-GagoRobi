package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.actors.Actor;

public interface FightLogic {

    public Actor checkForEnemy(int dx, int dy);
    public void calculateDamage();


}

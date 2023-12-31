package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.Set;
import com.codecool.dungeoncrawl.data.actors.Troll;


public class GameLogic {
    private GameMap map;



    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public boolean isRescueSuccess () {
        return map.getPlayer().isPrincessRescued();
    }
    public boolean isBossDefeated () {
        return map.getPlayer().isBossDefeated();
    }
    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {

    }


    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public Set<Item> getPlayerInventory() {return map.getPlayer().getInventory();}
    public String getPlayerStrength () {
        return Integer.toString(map.getPlayer().getStrength());
    }
    public String getBossHealth () {
        return Integer.toString(map.getBoss().getHealth());
    }

    public GameMap getMap() {
        return map;
    }

    public void monsterMovement(){
        if(map.getTroll().getHealth() >0){
            map.getTroll().moveAround();
        }

    }


}

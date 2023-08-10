package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Boss;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private Boss boss;

    private Skeleton skeleton;
    private Skeleton skeleton2;


    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setBoss(Boss boss) {this.boss = boss;}
    public Boss getBoss() {return boss;}

    public void setSkeleton(Skeleton skeleton) {
        this.skeleton = skeleton;
    }

    public Skeleton getSkeleton() {
        return skeleton;
    }
    public void setSkeleton2(Skeleton skeleton) {
        this.skeleton2 = skeleton;
    }

    public Skeleton getSkeleton2() {
        return skeleton2;
    }
    public void moveSkeleton(){
        if (skeleton2 != null) {
            if (skeleton2.getHealth() <= 0) {
                skeleton2 = null;
            } else {
                if (skeleton2.getMoveCount() %2 == 0) {
                    skeleton2.move(-1, 0);
                    skeleton2.setMoveCount(skeleton2.getMoveCount()+1);
                } else {
                    skeleton2.move(1, 0);
                    skeleton2.setMoveCount(skeleton2.getMoveCount()+1);
                }
            }
        } /*else {
            System.out.println("skeleton2 dead");
        }*/
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

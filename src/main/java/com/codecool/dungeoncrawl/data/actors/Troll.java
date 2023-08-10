package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Troll extends Actor {

    private Cell cell = getCell();

    int moveCounter = 1;

    public Troll(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }


    @Override
    public String getTileName() {
        return "troll";
    }


    public String checkForEnemy(int dx, int dy) {
        Actor neighbourActor = cell.getNeighbor(dx, dy).getActor();
        if (neighbourActor != null) {
            return neighbourActor.getTileName();
        }
        return "none";
    }

    @Override
    public void calculateDamage() {
        System.out.println("Troll hp: "+getHealth());
        setHealth(getHealth()-5);
        if(getHealth() <=0){
            super.getCell().setActor(null);
        }

    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }


    private void checkTrollHealth(){
        if(getHealth() < 0) {
            cell.setActor(null);
        }
    }

    private void checkConflict(){
        // stops when  it receives damage
        if (getHealth()==10) {
            moveCounter=10;
        }
    }

    public void moveAround() {
        // dies when the health is 0
        checkTrollHealth();
        // stops when  it receives damage
        checkConflict();
        //moves in circle
        switch (moveCounter) {
            case 1:
            case 2:
                move(0, 1); // up
                moveCounter++;
                break;
            case 3:
            case 4:
                move(1, 0);//right
                moveCounter++;
                break;
            case 5:
            case 6:
                move(0, -1); // down
                moveCounter++;
                break;
            case 7:
            case 8:
                move(-1, 0);// left
                moveCounter++;
                break;
            case 9:
                moveCounter = 1;
        }


        }
    }


package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class UI {
    private Canvas canvas;
    private GraphicsContext context;

    private MainStage mainStage;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;


    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
    }

    public void setUpPain(Stage primaryStage) {

        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

    }

    public void moveMonsters() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            logic.monsterMovement();
            refresh();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap());

        }
        refresh();
    }

    public void refresh() {

        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < logic.getMapWidth(); x++) {
            for (int y = 0; y < logic.getMapHeight(); y++) {
                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null) {
                    if(cell.getActor().getHealth() <= 0){
                        cell.setActor(null);
                        Tiles.drawTile(context, cell, x, y);
                    }else{
                    Tiles.drawTile(context, cell.getActor(), x, y);
                    }

                } else if(cell.getItem() != null) {
                Tiles.drawTile(context, cell.getItem(), x, y);
            } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        mainStage.setHealthLabelText(logic.getPlayerHealth());
        mainStage.setInventoryLabelText(logic.getPlayerInventory());
        mainStage.setDamageLabelText(logic.getPlayerStrength());

        if (!Objects.equals(logic.getBossHealth(), "0")) {
            mainStage.setEnemyHealthLabelText(logic.getBossHealth());
        } else {
            mainStage.setEnemyHealthLabelText("DEAD");
        }
        if (Integer.parseInt(logic.getPlayerHealth()) < 1) {
            mainStage.setGameStatusLabelText("YOU LOST!");
        } else if (logic.isBossDefeated() && logic.isRescueSuccess()) {
            mainStage.setGameStatusLabelText("YOU WON!");
        }
    }
}

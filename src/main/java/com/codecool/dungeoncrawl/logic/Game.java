package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.actors.Troll;
import com.codecool.dungeoncrawl.ui.UI;
import com.codecool.dungeoncrawl.ui.keyeventhandler.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Set;

public class Game extends Application {
    private UI ui;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.keyHandlers = Set.of(new Up(), new Down(), new Left(), new Right());
        this.logic = new GameLogic();
        this.ui = new UI(logic, keyHandlers);
        ui.setUpPain(primaryStage);

        ui.moveMonsters();

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
        this.logic.getMap().getTroll();
    }
}

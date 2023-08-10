package com.codecool.dungeoncrawl.ui.elements;

import com.codecool.dungeoncrawl.data.items.Item;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

import java.util.Set;

public class MainStage {
    private Canvas canvas;
    private Scene scene;
    private StatusPane statusPane;

    public MainStage(Canvas canvas) {
        this.canvas = canvas;
        statusPane = new StatusPane();
        scene = setUpScene();
    }

    private Scene setUpScene() {
        BorderPane borderPane = statusPane.build();
        borderPane.setCenter(canvas);
        Scene scene = new Scene(borderPane);
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void setHealthLabelText(String text) {
        this.statusPane.setHealthValue(text);
    }

    public void setInventoryLabelText(Set<Item> items) {
        StringBuilder inventory = new StringBuilder();
        if (!items.isEmpty()) {
            for (Item item : items) {
                inventory.append(" [ ").append(item.getTileName()).append(" ] ").append("\n");
                this.statusPane.setInventoryValues(inventory.toString());
            }
        }else{
            this.statusPane.setInventoryValues(" ");
        }
    }
    public void setDamageLabelText(String text) {this.statusPane.setDamageValue(text);}
    public void setEnemyHealthLabelText(String text) {this.statusPane.setEnemyHealthValue(text);}
    public void setGameStatusLabelText(String text) {this.statusPane.setGameStatusValue(text);}
}


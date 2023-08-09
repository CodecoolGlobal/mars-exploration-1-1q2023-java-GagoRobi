package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private final Label healthTextLabel;
    private final Label healthValueLabel;
    private final Label inventoryTextLabel;
    private final Label inventoryValuesLabel;
    private final Label attackDamageTextLabel;
    private final Label attackDamageValueLabel;

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("[ Health: ]");
        healthValueLabel = new Label();
        inventoryTextLabel = new Label("[ Inventory: ]");
        inventoryValuesLabel = new Label();
        attackDamageTextLabel = new Label("[ Attack Damage: ]");
        attackDamageValueLabel = new Label();
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);

        ui.add(inventoryTextLabel, 0, 1);
        ui.add(inventoryValuesLabel, 0, 2);

        ui.add(attackDamageTextLabel, 0, 3);
        ui.add(attackDamageValueLabel, 0, 4);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }
    public void setInventoryValues(String text) {inventoryValuesLabel.setText(text);}
    public void setDamageValue(String text) {attackDamageValueLabel.setText(text);}
}

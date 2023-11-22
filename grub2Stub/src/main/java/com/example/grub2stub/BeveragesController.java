package com.example.grub2stub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class BeveragesController {

    private ArrayList<FoodItem> foodItems;

    @FXML
    private Button btnHomeB;

    @FXML
    private Button btnBevCart;

    @FXML
    private GridPane gridPane;


    @FXML
    void btnHomeBClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnBevCartClick(ActionEvent event) {

    }
    @FXML
    private void initialize() {
        FileHandler fileHandler = new FileHandler();
        foodItems = fileHandler.readFoodItemsFromFile("cinemaDrinksNonAlcoholic.txt");

        for (int i = 0; i < foodItems.size(); i++) {
            FoodItem item = foodItems.get(i);

            Label nameLabel = new Label(String.format("%s - $%.2f", item.getFoodName(), item.getFoodPrice()));
            TextField qtyField = new TextField("0");
            qtyField.setPrefWidth(50); // Adjust the width as necessary

            Button incrementButton = new Button("+");
            incrementButton.setOnAction(e -> {
                int qty = Integer.parseInt(qtyField.getText());
                qtyField.setText(String.valueOf(qty + 1));
            });

            Button decrementButton = new Button("-");
            decrementButton.setOnAction(e -> {
                int qty = Integer.parseInt(qtyField.getText());
                qty = (qty > 0) ? qty - 1 : 0;
                qtyField.setText(String.valueOf(qty));
            });

            // Add elements to the GridPane
            gridPane.add(nameLabel, 0, i);      // Column 0, Row i
            gridPane.add(incrementButton, 1, i);// Column 1, Row i
            gridPane.add(qtyField, 2, i);       // Column 2, Row i
            gridPane.add(decrementButton, 3, i);// Column 3, Row i
        }


    }
}


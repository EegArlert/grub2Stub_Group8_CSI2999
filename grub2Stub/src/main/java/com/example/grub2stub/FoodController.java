package com.example.grub2stub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class FoodController {

    // This assumes you have a TextField for quantity next to each item
    private ArrayList<TextField> quantityFields = new ArrayList<>();

    private ArrayList<FoodItem> foodItems;

    private HashMap<FoodItem, Integer> cart = new HashMap<>();

    @FXML
    private Button btnHomeF;

    @FXML
    private Button btnFoodCart;

    @FXML
    private GridPane gridPane;

    @FXML
    private void btnHomeFClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnFoodCartClick(ActionEvent event) {
        cart.clear(); // Clear the cart before adding items

    }

    private void addToCart(ActionEvent event) {
        // Iterate over the quantityFields and their corresponding FoodItems
        for (int i = 0; i < foodItems.size(); i++) {
            TextField qtyField = quantityFields.get(i); // Quantity TextField for the current item
            int quantity;
            try {
                quantity = Integer.parseInt(qtyField.getText()); // Parse the quantity as an integer
            } catch (NumberFormatException e) {
                // If the text is not a number, skip this item and continue with the next
                continue;
            }

            if (quantity > 0) {
                FoodItem item = foodItems.get(i); // Get the corresponding FoodItem
                Cart.getInstance().addItem(item, quantity); // Add the item and quantity to the cart
            }
        }
    }



    @FXML
    private void initialize() {
        FileHandler fileHandler = new FileHandler();
        foodItems = fileHandler.readFoodItemsFromFile("cinemaFood.txt");

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

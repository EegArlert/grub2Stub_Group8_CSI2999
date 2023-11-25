package com.example.grub2stub;

import javafx.application.Platform;
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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SnacksController {
    private ArrayList<TextField> quantityFields;
    private ArrayList<FoodItem> foodItems;
    @FXML
    private Button btnHomeS;

    @FXML
    private Button btnSnackCart;

    @FXML
    private GridPane gridPane;

    @FXML
    void btnHomeSClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnSnackCartClick(ActionEvent event) {
        for (int i = 0; i < foodItems.size(); i++) {
            TextField qtyField = quantityFields.get(i); // Quantity TextField for the current item
            int quantity;
            try {
                quantity = Integer.parseInt(qtyField.getText()); // Parse the quantity as an integer
            } catch (NumberFormatException e) {
                // If the text is not a number, skip this item and continue with the next
                continue;
            }

            FoodItem item = foodItems.get(i); // Get the corresponding FoodItem
            if (quantity > 0) {
                Cart.getInstance().addItem(item, quantity); // Add/update the item and quantity in the cart
            } else {
                Cart.getInstance().removeItem(item); // Remove the item if the quantity is zero
            }
        }
    }

    public void updateQuantityFields() {
        if (quantityFields == null || quantityFields.isEmpty()) {
            System.out.println("quantityFields is null or empty");
            return;
        }

        for (int i = 0; i < foodItems.size(); i++) {
            FoodItem item = foodItems.get(i);
            TextField qtyField = quantityFields.get(i);
            int quantity = Cart.getInstance().getEnteredQuantity(item);
            qtyField.setText(String.valueOf(quantity));
        }
    }

    @FXML
    private void initialize() {
        quantityFields = new ArrayList<>();
        FileHandler fileHandler = new FileHandler();
        foodItems = fileHandler.readFoodItemsFromFile("cinemaSnacks.txt");
        updateQuantityFields();

        for (int i = 0; i < foodItems.size(); i++) {
            FoodItem item = foodItems.get(i);

            // Create a final variable for use inside the lambda
            final FoodItem currentItem = item;
            int storedQuantity = Cart.getInstance().getEnteredQuantity(item);
            Label nameLabel = new Label(String.format("%s - $%.2f", currentItem.getFoodName(), currentItem.getFoodPrice()));
            TextField qtyField = new TextField(String.valueOf(storedQuantity));
            qtyField.textProperty().addListener((observable, oldValue, newValue) -> {
                System.out.println("Quantity for " + currentItem.getFoodName() + " changed to: " + newValue);
                try {
                    int quantity = Integer.parseInt(newValue);
                    Platform.runLater(() -> Cart.getInstance().setEnteredQuantity(currentItem, quantity));
                } catch (NumberFormatException e) {
                    // Handle invalid input, if necessary
                }
            });
            qtyField.setPrefWidth(50); // Adjust the width as necessary
            quantityFields.add(qtyField);

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
            gridPane.add(decrementButton, 1, i);// Column 1, Row i
            gridPane.add(qtyField, 2, i);       // Column 2, Row i
            gridPane.add(incrementButton, 3, i);// Column 3, Row i
        }

    }
}

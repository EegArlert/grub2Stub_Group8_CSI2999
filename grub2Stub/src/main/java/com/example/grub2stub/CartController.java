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

import java.util.Map;

public class CartController {

    @FXML
    private Button btnHomeC;

    @FXML
    private Button btnCheckout;

    @FXML
    private GridPane cartGridPane;


    @FXML
    void btnHomeCClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnCheckoutClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize() {
        updateCartDisplay(); // This should be called to populate the cart when the view is loaded
    }

    public void updateCartDisplay() {
        Cart cart = Cart.getInstance();
       // cartGridPane.getChildren().clear(); // Clear previous cart items

        int row = 1; // Start at the first row
        for (Map.Entry<FoodItem, Integer> entry : cart.getItems().entrySet()) {
            FoodItem item = entry.getKey();
            Integer quantity = entry.getValue();
            double cost = item.getFoodPrice() * quantity;

            // Create and add the item name label
            Label nameLabel = new Label(item.getFoodName());
            GridPane.setConstraints(nameLabel, 0, row); // Column 0, current row

            // Create and add the quantity label
            Label quantityLabel = new Label(quantity.toString());
            GridPane.setConstraints(quantityLabel, 1, row); // Column 1, current row

            // Create and add the cost label
            Label costLabel = new Label(String.format("$%.2f", cost));
            GridPane.setConstraints(costLabel, 2, row); // Column 2, current row

            // Add all to the GridPane
            cartGridPane.getChildren().addAll(nameLabel, quantityLabel, costLabel);

            row++; // Move to the next row for the next item
        }


    }
}

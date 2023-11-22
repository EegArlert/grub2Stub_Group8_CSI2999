package com.example.grub2stub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    // Method called automatically by JavaFX to set up the controller
    public void initialize() {
        // Here you can set up the initial state of the cart view
        updateCartDisplay();
    }

    // Method to update the display of the cart with its current contents
    private void updateCartDisplay() {
        // Retrieve the cart items from the singleton Cart instance
        Map<FoodItem, Integer> cartItems = Cart.getInstance().getItems();
        // Now use cartItems to update the UI of your cart
        // For example, populate a ListView or TableView with the cart contents


    }
}

package com.example.grub2stub;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {
    @FXML
    private Button btnFood;

    @FXML
    private Button btnBeverages;

    @FXML
    private Button btnSnacks;

    @FXML
    private Button btnCart;

    private OrderStatus orderStatus = OrderStatus.getInstance();



    @FXML
    private void btnFoodClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Food.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnBeveragesClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Beverages.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnSnacksClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Snacks.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnCartClick(ActionEvent event) throws Exception {
        orderStatus.setOrderPlaced(false); // Reset the flag
        Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}
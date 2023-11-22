package com.example.grub2stub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CheckoutController {
    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnBackCart;

    @FXML
    private Button btnBackHome;

    private int totalCounter = 0000000;


    @FXML
    void btnConfirmClick(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("OrderConfirmed.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnBackCartClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void btnBackHomeClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }


}

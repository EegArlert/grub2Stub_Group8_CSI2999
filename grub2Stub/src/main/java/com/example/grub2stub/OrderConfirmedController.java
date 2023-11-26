package com.example.grub2stub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class OrderConfirmedController {

    @FXML
    private Button btnOrderHome;

    @FXML
    private Label orderNumberLabel;

    public void setOrderNumberLabel(String orderNumber){
        String text = "Order #: " + orderNumber;
        orderNumberLabel.setText(text);
    }

    @FXML
    void btnOrderHomeClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

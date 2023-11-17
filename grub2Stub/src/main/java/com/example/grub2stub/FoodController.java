package com.example.grub2stub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.Connection;

public class FoodController {
    @FXML
    private Button btnHomeF;

    @FXML
    private Button btnFoodCart;

    @FXML
    private TextArea testText;

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
        Connection conn = DBConnector.connect();

        if (conn != null) {
            testText.setText("Connection successful!");
        } else {
            testText.setText("Connection failed!");
        }
    }
}

package com.example.grub2stub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.scene.control.TextFormatter;

import java.util.ArrayList;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class CheckoutController {
    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnBackCart;

    @FXML
    private Button btnBackHome;
    @FXML
    private TextField creditCardName;

    @FXML
    private TextField creditCardNumber;

    @FXML
    private TextField creditCardCVV;

    @FXML
    private TextField creditCardEXP;

    @FXML
    private TextField rowNumber;

    @FXML
    private TextField seatNumber;

    @FXML
    private TextField errorField;

    @FXML
    private CheckBox confirmAge;
    @FXML
    void initialize() {
        // Set up TextFormatter for creditCardNumber
        setupNumericTextField(creditCardNumber);

        // Set up TextFormatter for creditCardCVV
        setupNumericTextField(creditCardCVV);
    }

    private void setupNumericTextField(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (isValidNumericInput(newText)) {
                return change;
            } else {
                return null; // Reject the change
            }
        };

        TextFormatter<Integer> textFormatter = new TextFormatter<>(filter);
        textField.setTextFormatter(textFormatter);
    }

    // Helper method to check if the input is a valid numeric value
    private boolean isValidNumericInput(String input) {
        return Pattern.matches("\\d*", input);
    }

    public boolean luhnTest(String cardNumber){
        int sum = 0;
        int numDigits = cardNumber.length();
        boolean alternator = false;

        //check valid range of total # of digits
        if (numDigits < 7 || numDigits > 19){
            return false;
        }

        for (int i = (numDigits - 1); i >= 0; i--){
            int d = cardNumber.charAt(i) - '0';

            if (alternator){
                d *= 2;
            }
            sum += (d / 10);
            sum += (d % 10);
            alternator = !alternator;
        }
        return (sum % 10 == 0);
    }

    @FXML
    void btnConfirmClick(ActionEvent event) throws Exception{
        TextField[] allTextFields = {creditCardName, creditCardNumber, creditCardCVV, creditCardEXP, rowNumber, seatNumber};

        boolean anyInputFieldEmpty = false;

        //Check for incomplete user input
        for (TextField currentTextfield: allTextFields) {
            if (currentTextfield.getText().isEmpty()) {
                anyInputFieldEmpty = true;
                break;
            }
        }

        if (anyInputFieldEmpty) {
            errorField.setText("At least one field is empty.");
        }
        else if (!luhnTest(creditCardNumber.getText())){
            errorField.setText("Credit Card is invalid.");
        }
        else {
            Parent root = FXMLLoader.load(getClass().getResource("OrderConfirmed.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            //Create customer
            Customer customer = new Customer(creditCardName.getText());
            customer.setSeatRow(rowNumber.getText());
            customer.setSeatNumber(seatNumber.getText());

            //Create order
            ArrayList<FoodItem> INSERT_FOODITEM_ARRAYLIST = new ArrayList<>(); //PLACEHOLDER
            OrderDetail order = new OrderDetail(customer, INSERT_FOODITEM_ARRAYLIST);

            order.displayOrderDetails();
        }
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

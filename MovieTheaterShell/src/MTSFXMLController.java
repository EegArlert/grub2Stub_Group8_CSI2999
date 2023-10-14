/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


/**
 * FXML Controller class
 *
 * @author mojo
 */
public class MTSFXMLController implements Initializable {

    @FXML
    private Button btnCon;
    
    @FXML
    private ComboBox cbTickets;
    
    @FXML
    private Button btn9A;

    @FXML
    private Button btn3P;

    @FXML
    private Button btn9P;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Buy Tickets", "Cancel Tickets", "Ticket Status");
        cbTickets.setItems(list);
    }    

    @FXML
    private void btnConClicked(ActionEvent event) {
    }
    
}

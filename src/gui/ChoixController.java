/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class ChoixController implements Initializable {
 @FXML
    private TextField tfmailU;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
     @FXML

     private void User(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterFXML.fxml"));
            Parent root = loader.load();
            AjouterFXMLController controller = loader.getController();
            tfmailU.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @FXML
      private void Role(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterRoleFXML.fxml"));
            Parent root = loader.load();
            AjouterRoleFXMLController controller = loader.getController();
            tfmailU.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

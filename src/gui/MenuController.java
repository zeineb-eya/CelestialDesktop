/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author skanr
 */
public class MenuController implements Initializable {

    @FXML
    private TextField fusee;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void localisationt(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouPlaninng.fxml"));
            Parent root = loader.load();
            AjouPlaninngController controller = loader.getController();
            controller.setUsername(fusee.getText());
            fusee.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Login(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutLocalisation.fxml"));
            Parent root = loader.load();
            AjoutLocalisationController controller = loader.getController();
            controller.setUsername(fusee.getText());
            fusee.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }

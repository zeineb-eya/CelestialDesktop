/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Billet;
import com.mycompany.services.BilletService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutBilletController implements Initializable {

    @FXML
    private TextField chair_billet;
    @FXML
    private TextField voyage_num;
    @FXML
    private TextField terminal;
    @FXML
    private TextField portail;
    @FXML
    private DatePicker embarquement;
    @FXML
    private TextField localisation;
    @FXML
    private Button AjouterBillet;
    @FXML
    private Button ListerBillets;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public Boolean ValidateFields() {
   
        if (chair_billet.getText().isEmpty() | voyage_num.getText().isEmpty()| terminal.getText().isEmpty() | portail.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez indiquer l'objet réclamation s'il vous plait!!");
            alert.showAndWait();
            return false;
        }
        return true;
 }
    public void setUsername(String s) {
        chair_billet.setText(s);
    }
    @FXML
    private void AjouterBillet(ActionEvent event) {
       if(ValidateFields()  ){
        Billet b = new Billet();
        b.setChairBillet(Integer.parseInt(chair_billet.getText()));
        b.setVoyageNum(Integer.parseInt(voyage_num.getText()));
        b.setTerminal(Integer.parseInt(terminal.getText()));
        b.setPortail(Integer.parseInt(portail.getText()));
        b.setEmbarquement(Date.valueOf(embarquement.getValue()));
        b.setLocalisation(Integer.parseInt(localisation.getText()));
        
        BilletService bs = new BilletService();
        bs.ajouterBiller2(b);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Billet ajoutée");
        a.show();}
    }

    @FXML
    private void ListerBillets(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListBillet.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}

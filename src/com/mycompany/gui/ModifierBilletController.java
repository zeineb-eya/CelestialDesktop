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
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
public class ModifierBilletController implements Initializable {


    @FXML
    private Button ModifierBillet;
    @FXML
    private Button ListerBillets;
    @FXML
    private TextField chair_billet_modif;
    @FXML
    private TextField voyage_num_modif;
    @FXML
    private TextField terminal_modif;
    @FXML
    private TextField portail_modif;
    @FXML
    private TextField localisation_modif;
    @FXML
    private DatePicker embarquement_modif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        Billet b=new Billet();
    @FXML
    private void ModifierBillet(ActionEvent event) {
          if (b == null) {

            System.out.println("Choisir un billet");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modifier Billet");
            alert.setHeaderText(null);
            alert.setContentText("Le billet n'est pas modifié!");

            alert.showAndWait();
        }else {
            
       
        b.setChairBillet(Integer.parseInt(chair_billet_modif.getText()));
        b.setVoyageNum(Integer.parseInt(voyage_num_modif.getText()));
        b.setTerminal(Integer.parseInt(terminal_modif.getText()));
        b.setPortail(Integer.parseInt(portail_modif.getText()));
        b.setEmbarquement(Date.valueOf(embarquement_modif.getValue()));
        b.setLocalisation(Integer.parseInt(localisation_modif.getText()));
        BilletService bs = new BilletService();
             try{
             bs.modifierBillet(b);
             System.out.println("ok");}
             catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("Modification terminé");}
             
           
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification terminée avec succès.");
        alert.setHeaderText(null);
        alert.setContentText("Votre billet a été modifié avec succés.");
        alert.showAndWait();
        javafx.scene.Parent tableview = null;
        try {
            tableview = FXMLLoader.load(getClass().getResource("ListBillet.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifierBilletController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
    void setData(int id,String c,String v,String t, String p, LocalDate e,String l) {
        b.setId(id);
        chair_billet_modif.setText(c);
        voyage_num_modif.setText(v);
        terminal_modif.setText(t);
        portail_modif.setText(p);
        embarquement_modif.setValue(e);
        localisation_modif.setText(l);
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

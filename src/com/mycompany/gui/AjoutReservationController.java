/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Billet;
import com.mycompany.entities.Reservation;
import com.mycompany.services.BilletService;
import com.mycompany.services.ReservationService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class AjoutReservationController implements Initializable {

    @FXML
    private Button Reserver;
    @FXML
    private TextField Etat_reservation;
    @FXML
    private TextField user;
    @FXML
    private TextField billet;
    @FXML
    private DatePicker date_reservation;
    @FXML
    private Button ListerReservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setPassword(String s) {
        user.setText(s);
    }
    
    @FXML
    private void Reserver(ActionEvent event) {
        Reservation r = new Reservation();
        r.setDateReservation(Date.valueOf(date_reservation.getValue()));
        r.setEtatReservation(Etat_reservation.getText());
        r.setUser(Integer.parseInt(user.getText()));
        r.setBillet(Integer.parseInt(billet.getText()));
      
        
        ReservationService rs = new ReservationService();
        rs.ajouterReservation2(r);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Reservation envoyée");
        a.show();
    }

    @FXML
    private void ListerReservation(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListReservation.fxml"));
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

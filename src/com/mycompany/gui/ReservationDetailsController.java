/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Reservation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ReservationDetailsController implements Initializable {

    @FXML
    private Label date_reservation;
    @FXML
    private Label etat_reservation;
    @FXML
    private Label user;
    @FXML
    private Label billet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    void initData(Reservation r) {
   String datereservation = String.valueOf(r.getDateReservation());
    date_reservation.setText(datereservation);
    etat_reservation.setText(r.getEtatReservation());
     String u = String.valueOf(r.getUser());
    user.setText(u);
    String b = String.valueOf(r.getBillet());
    billet.setText(b);
  }
    
}

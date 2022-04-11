/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GestionReservationController implements Initializable {

    @FXML
    private TextField chair_billet;
    @FXML
    private TextField voyage_num;
    @FXML
    private TextField terminal;
    @FXML
    private TextField portail;
    @FXML
    private TextField embarquement;
    @FXML
    private TextField localisation;
    @FXML
    private Button AjouterBillet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterBillet(ActionEvent event) {
    }
    
}

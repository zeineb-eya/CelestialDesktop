/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.Billet;

import com.mycompany.entities.Billet;
import com.mycompany.services.BilletService;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author HP
 */
public class AddBilletController {
    @FXML
    private AnchorPane parentContainer;
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
    public void addBillet (ActionEvent event) {

            BilletService bs = new BilletService();
       
          Billet b = new Billet(Integer.parseInt(chair_billet.getText()), Integer.parseInt(voyage_num.getText()),Integer.parseInt(terminal.getText()), Integer.parseInt(portail.getText()),embarquement.getText(),Integer.parseInt(localisation.getText()) );
//            if (ajouterBiller2(b)) {
//            System.out.println("Billet added successfully !");
//            try {
//                fadeTransition("profile");
//            } catch (IOException ex) {
//               System.err.println(ex.getMessage());
//            }
//        }
    }
    public void initialize() {
        
    }
     void fadeTransition(String scene) throws IOException {
        
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(500));
        ft.setNode(parentContainer);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setOnFinished((ActionEvent event) -> {
            try {
                Parent second;
                if (scene.equals("login")) {
                    second = (StackPane) FXMLLoader.load(getClass().getResource("/com/mycompany/gui/" + scene + ".fxml"));
                } else {
                    second = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/mycompany/gui/" + scene + ".fxml"));
                }
                Scene s = new Scene(second);
                Stage current = (Stage) parentContainer.getScene().getWindow();
                current.setScene(s);
            } catch (IOException ex) {
               System.err.println(ex.getMessage());
            }
        });
        ft.play();
        
    }
}

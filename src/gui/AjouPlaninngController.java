/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Planinng;

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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.PlaninngService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AjouPlaninngController implements Initializable {

    @FXML
    private TextField nom_planning;
    @FXML
    private TextField periode_planning;
    @FXML
    private TextField prix_planning;
    @FXML
    private DatePicker dateDebut_planning;
    @FXML
    private DatePicker dateFin_planning;
    @FXML
    private TextField destination_planning;
    @FXML
    private TextArea description_planning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void setUsername(String s) {
        description_planning.setText(s);
    }
private boolean Validchamp(){
         if(description_planning.getText().isEmpty() | description_planning.getLength() <3|nom_planning.getText().isEmpty() | nom_planning.getLength() <6 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier votre saisie!");
            alert.showAndWait();
      return false;
    }return true;
}
    @FXML
       private void Ajouter(ActionEvent event) {
            if( Validchamp() &&  Validchamp()){    
        Planinng p = new Planinng();
        p.setNomPlanning(nom_planning.getText());
        p.setDateDebutPlanning(Date.valueOf(dateDebut_planning.getValue()));
        p.setDateFinPlanning(Date.valueOf(dateFin_planning.getValue()));
        p.setDestinationPlanning(destination_planning.getText());
        p.setDescriptionPlanning(description_planning.getText());
        p.setPeriodePlanning(Integer.parseInt(periode_planning.getText()));
        p.setPrixPlanning(Integer.parseInt(prix_planning.getText()));

        PlaninngService ps = new PlaninngService() {};
        ps.ajouter(p);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Planinng ajoutée");
        a.show();
    }
       }

    @FXML
    private void Afficher(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("AffichePlaninng.fxml"));
                       prix_planning.getScene().setRoot(root2);


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }

    


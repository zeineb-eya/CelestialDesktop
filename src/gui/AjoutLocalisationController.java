/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Localisation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import services.LocalisationService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AjoutLocalisationController implements Initializable {

    @FXML
    private TextField position_depart_localisation;
    @FXML
    private TextField position_arivee_planning;
    @FXML
    private TextField heure_depart_localisation;
    @FXML
    private TextField heure_arrivee_loacalisation;
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
       private void Ajouter(ActionEvent event) {
        Localisation l = new Localisation();
        l.setHeureDepartLocalisation(heure_depart_localisation.getText());
        l.setHeureArriveeLoacalisation(heure_arrivee_loacalisation.getText());
        l.setPositionDepartLocalisation(position_depart_localisation.getText());
        l.setPositionAriveePlanning(position_arivee_planning.getText());
        l.setFusee(fusee.getText());

        LocalisationService ps = new LocalisationService() {};
        ps.ajouterLocalisation(l);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Localisation ajoutée");
        a.show();
    }

    @FXML
    private void Afficher(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherLocalisation.fxml"));
            position_depart_localisation.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}

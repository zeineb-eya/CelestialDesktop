/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Equipement;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ServiceEquipement;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AjouterEqFXMLController implements Initializable {
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfetat;
    @FXML
    private TextField tfdes;
   @FXML
    private TextField tfimage;
    @FXML
    private TextField tfcat;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void Ajouter(ActionEvent event) {
        Equipement p = new Equipement();
        p.setNom_equipement(tfnom.getText());
        int x = Integer.parseInt(tfcat.getText());
        p.setCategorie_equipement_id(x);
        p.setDescription_equipement(tfdes.getText());    
        p.setEtat_equipement(tfetat.getText());
        p.setImage_equipement(tfimage.getText());
           ServiceEquipement ps = new ServiceEquipement();
        ps.ajouter(p);
        System.out.println( p );
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne ajoutée");
        a.show();
    }
    @FXML
    private void Afficher(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEqFXML.fxml"));
            Parent root = loader.load();
            AfficherEqFXMLController controller = loader.getController();
            tfcat.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        @FXML

    private void Update(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierFXML.fxml"));
            Parent root = loader.load();
            UpdateEqFXMLController controller = loader.getController();
            tfcat.getScene().setRoot(root);  System.out.println("wsselt lehne");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

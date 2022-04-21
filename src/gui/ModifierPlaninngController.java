/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Planinng;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.PlaninngService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class ModifierPlaninngController implements Initializable {

    private TextField nomplaninngmodif;
    Planinng p=new Planinng();
    @FXML
    private TextField nomplanningmodif;
    @FXML
    private TextField periodeplanningmodif;
    @FXML
    private TextField prixplanningmodif;
    @FXML
    private DatePicker dateDebutplanningmodif;
    @FXML
    private DatePicker dateFinplanningmodif;
    @FXML
    private TextField destinationplanningmodif;
    @FXML
    private TextArea descriptionplanningmodif;
    @FXML
    private Label idp;
    @FXML
    private Button SwitchToGestionPlanBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
   Planinng pl = new Planinng();
        private boolean Validchamp(TextField T){
         if(T.getText().isEmpty() | T.getLength() <5 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}
    


 
 @FXML
    private void modifier(ActionEvent event) {
         if (p == null) {

            System.out.println("Choisir un planinng");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modifier planinng");
            alert.setHeaderText(null);
            alert.setContentText("Le planinng n'est pas modifié!");

            alert.showAndWait();
        }else {
            
        p.setNomPlanning(nomplanningmodif.getText());
        p.setDateDebutPlanning(Date.valueOf(dateDebutplanningmodif.getValue()));
        p.setDateFinPlanning(Date.valueOf(dateFinplanningmodif.getValue()));
        p.setDestinationPlanning(destinationplanningmodif.getText());
        p.setDescriptionPlanning(descriptionplanningmodif.getText());
        p.setPeriodePlanning(Integer.parseInt(periodeplanningmodif.getText()));
        p.setPrixPlanning(Integer.parseInt(prixplanningmodif.getText()));
         PlaninngService ps = new PlaninngService();
             try{
             ps.updatePlaninng(p);
             System.out.println("ok");}
             catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("Modification terminé");}
             
           
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification terminée avec succès.");
        alert.setHeaderText(null);
    alert.setContentText("Votre Planinng a été modifié avec succés.");
        alert.showAndWait();
        javafx.scene.Parent tableview = null;
        try {
            tableview = FXMLLoader.load(getClass().getResource("AffichePlaninng.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifierLocalisationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
     void setData(int id, String su, String ds, String dss, int pe, int pr) {
       p.setId(id);
       nomplanningmodif.setText(su);
       destinationplanningmodif.setText(ds);
       descriptionplanningmodif.setText(dss);
       p.setPeriodePlanning(pe);
       p.setPrixPlanning(pr);


    }

    @FXML
    private void SwitchToGestionplaninng(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("AffichePlaninng.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();
    }
    }
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Offre;
import com.mycompany.services.ServiceOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutOffreFXMLController implements Initializable {

    @FXML
    private TextField nom_offre;
    @FXML
    private TextField description_offre;
    @FXML
    private TextField prix_offre;
    @FXML
    private TextField reduction;
    @FXML
    private DatePicker date_debut_offre;
    @FXML
    private DatePicker date_fin_offre;
    @FXML
    private Button ajouterOffreButton;
    @FXML
    private Button displayOffreButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterOffre(ActionEvent event) {
            
        Offre o = new Offre();
       o.setNom_offre(nom_offre.getText());
       o.setDescription_offre(description_offre.getText());
       o.setPrix_offre(Double.parseDouble(prix_offre.getText()));
       o.setReduction(Double.parseDouble(reduction.getText()));
     //  o.setDate_debut_offre(date_debut_offre.getText());
      o.setDate_debut_offre(date_debut_offre.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      o.setDate_fin_offre(date_fin_offre.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
  //   o.setDate_debut_offre(LocalDate.parse(date_debut_offre,formatter));
    //   o.setDate_fin_offre(date_fin_offre.getText());
        ServiceOffre pst = new ServiceOffre();
        pst.ajouterOffre(o);
        
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nouvelle offre");
            alert.setHeaderText(null);
            alert.setContentText("Votre offre a ete bien ajoute");
            alert.showAndWait();
    }
    
        
    
    private void afficherOffre(ActionEvent event) {
           try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherOffreFXMLController.fxml"));
            description_offre.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
  
       @FXML
    private void displayOffre(ActionEvent event) throws IOException {
           javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherOffreFXML.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutReclamationFXMLController implements Initializable {

    @FXML
    private TextField description_reclamation;
    @FXML
    private Button reclamerButton;
    private TextField date_reclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
    }   
    public Boolean ValidateFields() {
        if (description_reclamation.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate fields");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Into The Fields");
            alert.showAndWait();
            return false;
        }

        return true;

    }
    
    @FXML
        private void AjouterReclam(ActionEvent event) {
                  if(ValidateFields() ){
        Reclamation r = new Reclamation();
        r.setDescription_reclamation(description_reclamation.getText());
       // r.setDate_reclamation(date_reclamation.getText());
       // r.setDate_reclamation(Date.valueOf(date_reclamation.getValue()));
        ServiceReclamation pst = new ServiceReclamation();
        pst.ajouterReclamation2(r);
       /*Alert a = new Alert(Alert.AlertType.CONFIRMATION);
       a.setTitle("reclamation bien ajoutée");
      // JOptionPane.showMessageDialog(null,"reclamation bien ajoute");
      a.show();*/
   
         
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("réclamer");
            alert.setHeaderText(null);
            alert.setContentText("Votre réclamation a ete bien ajoute");
            alert.showAndWait();
    }
        }
    
    private void afficherReclam(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamationFXMLController.fxml"));
            description_reclamation.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

       @FXML
    private void retour(ActionEvent event) throws IOException {
           javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherReclamationFXML.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
    
}

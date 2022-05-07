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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DetailReclamationFrontController implements Initializable {

    @FXML
    private Label detail_reclam;
    @FXML
    private Label etat_reclam;
    @FXML
    private Label descript_reclam;
    @FXML
    private Button retourButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
     public void detailReclam(Reclamation reclam) throws IOException {
         
              ServiceReclamation sr = new ServiceReclamation();
    descript_reclam.setText(reclam.getDescription_reclamation());
    etat_reclam.setText(reclam.getEtat_reclamation());
    detail_reclam.setText(reclam.getDate_reclamation());
    
    
     
            
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

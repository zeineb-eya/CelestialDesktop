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
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DetailReclamationFXMLController implements Initializable {

    private TextField description_reclamation;
    private TextField date_reclamation;
    
   ObservableList myList ;
    private TextField etat_reclamation;


    @FXML
    private Label descript_reclam;
    @FXML
    private Label etat_reclam;
    @FXML
    private Label detail_reclam;
    
    Reclamation r;
    @FXML
    private Label msg;
    @FXML
    private Button traiterButton;
    @FXML
    private Button retourButton;
    @FXML
    private Label mail;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }
    
    public void detailReclam(Reclamation reclam) throws IOException {
         traiterButton.setVisible(false);
         retourButton.setVisible(false);
              ServiceReclamation sr = new ServiceReclamation();
    descript_reclam.setText(reclam.getDescription_reclamation());
    etat_reclam.setText(reclam.getEtat_reclamation());
    detail_reclam.setText(reclam.getDate_reclamation());
    
        String priority;
        String negative = "Negative";
        String re = descript_reclam.getText(); 
        String positive= "Positive";
        String VeryNegative= "Very negative";
         String neutral= "Neutral";
          
 
     nlpPipeline.init();
     nlpPipeline.findSentiment(re);
    
     if(etat_reclam.getText().equals("Traitée")){
          retourButton.setVisible(true);
              priority = "Détail de la réclamation";
            msg.setText("\n\n Réclamation déjà traité");  
            
     } else if(nlpPipeline.findSentiment(re).equals(VeryNegative) && etat_reclam.getText().equals("envoye")){
               traiterButton.setVisible(true);
              priority = "Réclamation trés urgente , priorité de classe 1 ";
            msg.setText(priority+ "\n\n Client faché et insatisfait avec le service, Veuillez la traiter maintenant s'il vous plait !!!");    
    
     }else if(nlpPipeline.findSentiment(re).equals(negative)&& etat_reclam.getText().equals("envoye")){
                traiterButton.setVisible(true);
            priority = "Réclamation urgente,priorité  de classe 2";
            msg.setText(priority+ "\n\n Client mécontent réclamation à traiter dans les brefs délais !!!");
       
     }else if (nlpPipeline.findSentiment(re).equals(neutral)&& etat_reclam.getText().equals("envoye")){
                  traiterButton.setVisible(true);
              priority = "Réclamation du client";
            msg.setText(priority+ "\n\n Veuillez traiter la réclamation du client !!!");      
     
     }else if(nlpPipeline.findSentiment(re).equals(positive)&& etat_reclam.getText().equals("envoye")){
                
              priority = "Appréciation d'un client , priorité de classe 3 ";
            msg.setText(priority+ "\n\n Client satisfait avec le service,à traiter cette appréciation afin d'ameliorer le service de Celstial!!!");  
              traiterButton.setVisible(true);
             }
      
         System.out.println("Review: " + descript_reclam.getText() + "\t" +"Sentiment: " + nlpPipeline.findSentiment(re));
         

    }    @FXML
    private void traiterReclam(javafx.event.ActionEvent event) throws IOException, MessagingException {
      ServiceReclamation sr = new ServiceReclamation();
   
      if (etat_reclam.getText().equals("envoye"))
            {
                traiterButton.setVisible(true);
                    javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("ReclamationAdminFXML.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
            }
     
            
   }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        if (etat_reclam.getText().equals("Traitée"))
            {
                retourButton.setVisible(true);
            
           javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherReclamationFXML.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    
            }  
         }
    
    
    }    

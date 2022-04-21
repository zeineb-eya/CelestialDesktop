/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Reservation;
import com.mycompany.services.ReservationService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifierReservationController implements Initializable {

    @FXML
    private Button ModifierReservation;
    @FXML
    private TextField Etat_reservation_modif;
    @FXML
    private Button ListerReservation;

      
    private TextField id;
    Reservation r =new Reservation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierReservation(ActionEvent event) {
         if (r == null) {

            System.out.println("Choisir une Reservation");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modifier Reservation");
            alert.setHeaderText(null);
            alert.setContentText("La Reservation n'est pas modifié!");

            alert.showAndWait();
        }else {
            
        //r.setId(Integer.parseInt(id.getText()));
        r.getId();
        r.getDateReservation();
        r.setEtatReservation(Etat_reservation_modif.getText());
        ReservationService rs = new ReservationService();
             try{
             rs.modifierReservation(r);
             System.out.println("ok");}
             catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("Modification terminé");}
             
           
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification terminée avec succès.");
        alert.setHeaderText(null);
        alert.setContentText("Votre Reservation a été modifié avec succés.");
        alert.showAndWait();
        javafx.scene.Parent tableview = null;
        try {
            tableview = FXMLLoader.load(getClass().getResource("ListReservation.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifierReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
       sendMailConfirmation();
    }
     void setData(int id,String sub) {
        r.setId(id);
        Etat_reservation_modif.setText(sub);
        
    }

    @FXML
    private void ListerReservation(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListReservation.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void sendMailConfirmation(){
      try{
            String host ="smtp.gmail.com" ;
            String user = "celestialservice489@gmail.com";
            String pass = "celestialgroup98";
            //String to =tfEmail.getText();
            String to ="zeinebeyarahmani@gmail.com";
            String from ="pawp6703@gmail.com";
            String subject = "!Etat de votre Réservation!";
            String messageText = "Bonjour cher client  , votre réservation à la date "+String.valueOf(r.getDateReservation())+" est "+r.getEtatReservation()+". Cordialemment";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.ssh.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new java.util.Date());
            msg.setText(messageText);
           javax.mail.Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        
        
        
        
    }
  }
}

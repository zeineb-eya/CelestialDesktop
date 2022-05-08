/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Billet;
import com.mycompany.entities.Reservation;
import com.mycompany.services.BilletService;
import com.mycompany.services.ReservationService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.mycompany.utils.MyConnection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutReservationController implements Initializable {

    @FXML
    private Button Reserver;
    
    private TextField user;
    
    @FXML
    private Button ListerReservation;
    @FXML
    private ComboBox<String> BilletCombo;
    @FXML
    private ComboBox<String> userCombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setPassword(String s) {
        user.setText(s);
    }
    
    
    @FXML
    private void Reserver(ActionEvent event) {
        Reservation r = new Reservation();
       // r.setDateReservation(Date.valueOf(date_reservation.getValue()));
        //r.setEtatReservation(Etat_reservation.getText());
       // r.setUser(Integer.parseInt(user.getText()));
         r.setUser(Integer.parseInt(userCombo.getValue().toString().split("_")[0]));
         String userid =  userCombo.getValue().toString();

         String sql2="select reservation.user_id from reservation join user ON reservation.user_id = user.id where user.id";
                int user_id=0;
                  try {
                Statement ste2;
                Connection cnx2;
                cnx2 = MyConnection.getInstance().getCnx();
                ste2 = cnx2.prepareStatement(sql2);
                ResultSet rs2 = ste2.executeQuery(sql2);
                if(rs2.next())
                {
                  user_id=rs2.getInt("user_id");
                    
                }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
            }
       // r.setBillet(Integer.parseInt(billet.getText()));
        r.setBillet(Integer.parseInt(BilletCombo.getValue().toString().split("_")[0]));
        //String b = String.valueOf(r.getBillet());
        String billetid =  BilletCombo.getValue().toString();

         String sql1="select reservation.billet_id from reservation join billet ON reservation.billet_id = billet.id where billet.id";
                int billet_id=0;
                  try {
                Statement ste;
                Connection cnx;
                cnx = MyConnection.getInstance().getCnx();
                ste = cnx.prepareStatement(sql1);
                ResultSet rs = ste.executeQuery(sql1);
                if(rs.next())
                {
                  billet_id=rs.getInt("billet_id");
                    
                }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
            }
        ReservationService rs = new ReservationService();
        rs.ajouterReservation2(r);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Reservation envoyée");
        a.show();
        //sendMail();
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
     public void sendMail(){
      try{
            String host ="smtp.gmail.com" ;
            String user = "celestialservice489@gmail.com";
            String pass = "celestialgroup98";
            //String to =tfEmail.getText();
            String to ="zeinebeyarahmani@gmail.com";
            String from ="pawp6703@gmail.com";
            String subject = "Réservation bien reçu";
            String messageText = "Bonjour cher client  , votre réservation a été bien reçu et en cours de traitement. Cordialemment";
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

    @FXML
    private void remplirCB(MouseEvent event) {
        try {
            String sql="select id from billet ";
            List<String> nm =new ArrayList<String>();
            PreparedStatement ste;
            Statement st;
            Connection cnx;
            cnx = MyConnection.getInstance().getCnx();
            st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                nm.add(rs.getString("id"));
                   BilletCombo.setItems(FXCollections.observableArrayList(nm));
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void remplirCB2(MouseEvent event) {
        try {
            String sql="select id from user ";
            List<String> nm =new ArrayList<String>();
            PreparedStatement ste;
            Statement st;
            Connection cnx;
            cnx = MyConnection.getInstance().getCnx();
            st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                nm.add(rs.getString("id"));
                   userCombo.setItems(FXCollections.observableArrayList(nm));
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
}

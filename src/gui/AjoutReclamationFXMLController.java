/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;

import com.mycompany.entities.User;
import com.mycompany.services.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Properties;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import tray.Notification.NotificationType;
import tray.Notification.TrayNotification;

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
    @FXML
    private TextField id_user;
    @FXML
    private TextField tfEmail;

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
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez indiquer l'objet réclamation s'il vous plait!!");
            alert.showAndWait();
            return false;
        }

        return true;

    }
     private boolean Validchamp(TextField T){
         if(T.getText().isEmpty() |  T.getLength() <5){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}
     

     
    @FXML
        private void AjouterReclam(ActionEvent event) {
                if(Validchamp(description_reclamation) ){
             // User user = (User) user_idcol.getSelectionModel().getSelectedItem();   
    
        Reclamation r = new Reclamation();
        
         r.setDescription_reclamation(description_reclamation.getText());
        r.setUser(Integer.parseInt(id_user.getText()));
       //  tmp.setPrenom_utilisateur(id_user.getText());

     //   r.setEtat_reclamation(etat_reclamation.getText());
       //r.setDate_reclamation(Date.valueOf(date_reclamation.getValue()));
        ServiceReclamation pst = new ServiceReclamation();
        pst.ajouterReclamation2(r);
          
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("réclamer");
            alert.setHeaderText(null);
            alert.setContentText("Votre réclamation a ete bien ajoute");
            alert.showAndWait();
            sendMail();
         /*     TrayNotification tray = null;
        tray = new TrayNotification("Reclamation envoyée", "Cher client votre réclamation a été prise en compte et sera traitée dès que possible,Cordialement  ", NotificationType.SUCCESS);
       
        tray.showAndDismiss(javafx.util.Duration.seconds(5));*/
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
    public void sendMail(){
      try{
            String host ="smtp.gmail.com" ;
            String user = "celestialservice489@gmail.com";
            String pass = "celestialgroup98";
            String to =tfEmail.getText();
            String from ="mariembenmassoud123@gmail.com";
            String subject = "Réclamation bien reçu";
            String messageText = "Bonjour cher client  , votre reclamation a été bien reçu et en cours de traitement. Cordialemment";
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

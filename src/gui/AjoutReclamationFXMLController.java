/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;

import com.mycompany.entities.User;
import com.mycompany.services.ServiceReclamation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import static java.util.Arrays.asList;
import java.util.List;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import sun.applet.Main;
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
    @FXML
    private ImageView smileFace;
    @FXML
    private ImageView neutralFace;
    @FXML
    private ImageView angryFace;
    
  static String experience = "";

  Reclamation r = new Reclamation();
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
     
  public void setExperience() {

        experience = experience;
    }

     
    @FXML
        private void AjouterReclam(ActionEvent event) throws IOException, MessagingException {
                if(Validchamp(description_reclamation) ){
             // User user =id_user.getSelectionModel().getSelectedItem();   
      Reclamation r = new Reclamation();
       r.setDescription_reclamation(description_reclamation.getText());
      r.setUser_id(Integer.parseInt(id_user.getText()));//temchi
      //r.setUser(id_user.getText());
 //  r.setExperiencee(experience);
     ServiceReclamation pst = new ServiceReclamation();
        pst.ajouterReclamation2(r);
          
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("réclamer");
            alert.setHeaderText(null);
            alert.setContentText("Votre réclamation a ete bien ajoute");
            alert.showAndWait();
            sendMail();
          //StanfordCoreNLP pipeline = new StanfordCoreNLP("frensh");
            String re = description_reclamation.getText();
            nlpPipeline.init();
           
             nlpPipeline.findSentiment(re);
              System.out.println("Review: " + description_reclamation.getText() + "\t" +"Sentiment: " + nlpPipeline.findSentiment(re));
                
         
       }
            //nlpPipeline.estimatingSentiment(re);
         /*     TrayNotification tray = null;
        tray = new TrayNotification("Reclamation envoyée", "Cher client votre réclamation a été prise en compte et sera traitée dès que possible,Cordialement  ", NotificationType.SUCCESS);
       
        tray.showAndDismiss(javafx.util.Duration.seconds(5));*/
    
         }
        
        private void afficherReclam(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamationFXMLController.fxml"));
            description_reclamation.getScene().setRoot(root);
           // getExperience();
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
    
    public boolean FindTextLine(){
        String[] words = {"mauvaise", "mauvais","insatisfait","décu"};
        String experience_des = description_reclamation.getText();
        CharSequence c = words.toString();
        if(experience_des.contains(c)){
            //System.out.println("");     
        
        return false;
    }return true;
        
}
    
    
    //getTfEmail().getText()
    public void sendMail(){
      try{
            String host ="smtp.gmail.com" ;
            String user = "celestialservice489@gmail.com";
            String pass = "celestialgroup98";
            String to =tfEmail.getText();
            String from ="mariembenmassoud123@gmail.com";
            String subject;
            String  messageText;
            //equals("mauvaise")
            if(FindTextLine()){
           // if (description_reclamation.getText().matches("mauvaise")) {
            subject = "Retour sur votre Réclamation";
             messageText= "Celestial Groupe\n Cher,client," +
                    "Nous avons bien recu votre réclamation et nous la traitons dans les meilleurs délais.\n"
                   + "Votre souci va être directement transmis au departement concerné."
                   + "Nous revenons vers vous dès que possible"
                   + "" + "En vous souhaitant une agréable journée\n\n Celestial Group \n\n"
                     + "Details de votre réclamation : \n\n" +description_reclamation.getText()+"-Cordialement-\n";
            
            }else{
              subject ="Retour sur votre Feedback";
                    messageText= "Celestial Groupe\n Cher,client," + 
                        "Nous avons bien recu votre feedback ,nous vous remercions pour votre confiance.\n"
                    + " Restés connecter sur le site Celestial pour ne manquez rien"
                   + "" + "En vous souhaitant une agréable journée\n Celestial Group\n\n"
                            + "Details de votre feedback :\n"+description_reclamation.getText()+"-Cordialement-\n\n";
                        
            }
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

    public TextField getTfEmail() {
        return tfEmail;
    }

    public void setTfEmail(TextField tfEmail) {
        this.tfEmail = tfEmail;
    }
    
    
  
  private void enableSubmitButton() {

        if (experience != null)
            reclamerButton.setDisable(false);
        else
            return;
    }
    @FXML
    private void selectExperience(MouseEvent event) {
         smileFace.setVisible(false);
        neutralFace.setVisible(false);
        angryFace.setVisible(false);
 
       
         switch (((Node) event.getSource()).getId().toString()) {
        case "smileFace":
            smileFace.setVisible(true);
            String smile = smileFace.toString();
            break;
        case "neutralFace":
            neutralFace.setVisible(true);
            break;
        case "angryFace":
            angryFace.setVisible(true);
        }
          this.experience = ((Node) event.getSource()).getId().toString();
        enableSubmitButton();

         
    }

    private String getExperience() {
return experience;    
    }
    private void sendFeedback (ActionEvent e) throws IOException {

        setExperience();
       
        sendMail();
    }
 
     
}

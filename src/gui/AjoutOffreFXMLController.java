/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Offre;
import com.mycompany.services.ServiceOffre;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     private boolean ValidchampDate(){
         
        if (date_debut_offre.getValue().compareTo(LocalDate.now()) < 0 ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("La date debut ne peut pas etre avant la date d'aujourd'hui!!");
            alert.showAndWait();
            return false;
                     
    }else if (date_debut_offre.getValue().compareTo(date_fin_offre.getValue()) > 0){
         Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("La date de fin ne peut pas etre avant la date de debut!!");
            alert.showAndWait();  
       
    return false;
      }else if (date_debut_offre.getValue().compareTo(date_fin_offre.getValue()) == 0){
         Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("La date de fin ne peut pas etre la meme que la date de debut!!");
            alert.showAndWait();  
       
    return false;
      
     } return true;
     }
     
   
     private boolean Validchamp(TextField T){
         if(T.getText().isEmpty() | T.getLength() <5 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez v??rifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}

    @FXML
    private void AjouterOffre(MouseEvent event) throws IOException  {
            if( Validchamp(nom_offre) &&  Validchamp(description_offre)&& ValidchampDate()){    
             Offre o = new Offre();
       o.setNom_offre(nom_offre.getText());
       o.setDescription_offre(description_offre.getText());
       o.setPrix_offre(Integer.parseInt(prix_offre.getText()));
    
     o.setReduction(Integer.parseInt(reduction.getText()));
     o.setDate_debut_offre(Date.valueOf(date_debut_offre.getValue()));
     o.setDate_fin_offre(Date.valueOf(date_fin_offre.getValue()));

        ServiceOffre pst = new ServiceOffre();
        pst.ajouterOffre(o);
         
       Image img = new Image("/images/tick.png", 50, 50, false, false);
   Notifications notificationBuilder  = Notifications.create()
            
                    .title("Ajoutoffre")
                    .text("L'offre a ??t?? ajout?? avec succ??s")
                    .graphic(new ImageView(img) )
                    .hideAfter(Duration.seconds(8))
                    .position(Pos.CENTER);
      notificationBuilder.show();
            
            
            }else{
                
   Notifications notificationBuilder  = Notifications.create()
            
                    .title("Probl??me")
                    .text("Echec lors de l'ajout de l'offre")
                    .hideAfter(Duration.seconds(8))
                    .position(Pos.CENTER);
      notificationBuilder.showError();
            }
            
         
    }
   
   
    private void afficherOffre(MouseEvent event) {
           try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherOffreFXMLController.fxml"));
            description_offre.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
  
      @FXML
    private void displayOffre(MouseEvent event) throws IOException {
           javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherOffreFXML.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }

  
}

  

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierReclamationFXMLController implements Initializable {

    @FXML
    private TextField descript_reclam_modif;
    
     Reclamation rec=new Reclamation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void modifier(ActionEvent event) throws FileNotFoundException, IOException {
         
        if (rec == null) {

            System.out.println("Choisir une réclamation");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modifier réclamation");
            alert.setHeaderText(null);
            alert.setContentText("La réclamation n'est pas modifié!");

            alert.showAndWait();
        }else {
            
             rec.setDescription_reclamation(descript_reclam_modif.getText());
            ServiceReclamation sr = new ServiceReclamation();
             try{
             sr.updateReclamation(rec);
             System.out.println("ok");}
             catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("Modification terminé");}
             
          Image img = new Image("/images/tick.png", 50, 50, false, false);
      Notifications notificationBuilder  = Notifications.create()
            
                    .title("Modification")
                    .text("Votre réclamation a été modifié avec succés")
                    .graphic(new ImageView(img) )
                    .hideAfter(Duration.seconds(8))
                    .position(Pos.CENTER);
                notificationBuilder.show();
      
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherReclamationFXML.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
     void setData(int id, String sub,String e) {
       rec.setId(id);
       descript_reclam_modif.setText(sub);
      // etat_reclam_modif.setText(e);
       
       
    
    
      
    }

    @FXML
    private void modifierReclam(MouseEvent event) {
        
    }
}

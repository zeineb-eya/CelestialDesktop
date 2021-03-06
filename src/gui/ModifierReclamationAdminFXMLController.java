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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierReclamationAdminFXMLController implements Initializable {
     Reclamation rec=new Reclamation();

    @FXML
    private TextField descript_reclam_modif;
    @FXML
    private TextField etat_reclam_modif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) throws IOException {
          if (rec == null) {

            System.out.println("Choisir une réclamation à traiter");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Traiter réclamation");
            alert.setHeaderText(null);
            alert.setContentText("La réclamation n'est pas traité!");

            alert.showAndWait();
        }else {
            
             rec.setDescription_reclamation(etat_reclam_modif.getText());
            ServiceReclamation sr = new ServiceReclamation();
             try{
             sr.updateReclamation(rec);
             System.out.println("ok");}
             catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("Traitement terminé");}
             
           
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Traitement de réclamation terminé avec succès.");
        alert.setHeaderText(null);
    alert.setContentText("Réclamation traitéavec succés.");
        alert.showAndWait();
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("ReclamationAdminController.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
     void setData(int id, String sub,String e) {
       rec.setId(id);
      etat_reclam_modif.setText(sub);
      // etat_reclam_modif.setText(e);
       
    }


}

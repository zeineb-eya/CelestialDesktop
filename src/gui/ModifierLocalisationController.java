/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Localisation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import com.mycompany.services.LocalisationService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class ModifierLocalisationController implements Initializable {

    @FXML
    private TextField PositionDepartModif;
    Localisation l=new Localisation();
    @FXML
    private TextField positionariveeplanningmodif;
    @FXML
    private TextField heuredepartlocalisationmodif;
    @FXML
    private TextField heurearriveeloacalisationmodif;
    @FXML
    private TextField fuseemodif;
    @FXML
    private Button SwitchToGestionlocalBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
         if (l == null) {

            System.out.println("Choisir une localisation");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modifier localisation");
            alert.setHeaderText(null);
            alert.setContentText("La localisation n'est pas modifié!");

            alert.showAndWait();
        }else {
            
        l.setPositionDepartLocalisation(PositionDepartModif.getText());
        l.setHeureDepartLocalisation(heuredepartlocalisationmodif.getText());
        l.setHeureArriveeLoacalisation(heurearriveeloacalisationmodif.getText());
        l.setPositionAriveePlanning(positionariveeplanningmodif.getText());
        l.setFusee(fuseemodif.getText());
         LocalisationService ps = new LocalisationService();
             try{
             ps.modifierLocalistaion(l);
             System.out.println("ok");}
             catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("Modification terminé");}
             
           
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification terminée avec succès.");
        alert.setHeaderText(null);
    alert.setContentText("Votre localisation a été modifié avec succés.");
        alert.showAndWait();
        javafx.scene.Parent tableview = null;
        try {
            tableview = FXMLLoader.load(getClass().getResource("AfficherLocalisation.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifierLocalisationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
     void setData(int id, String sub, String ha,String pd, String pa, String fu) {
       l.setId(id);
       heuredepartlocalisationmodif.setText(sub);
heurearriveeloacalisationmodif.setText(ha);
PositionDepartModif.setText(pd);
positionariveeplanningmodif.setText(pa);
fuseemodif.setText(fu);


    }

    @FXML
    private void SwitchToGestionlocal(ActionEvent event) throws IOException {
         Object root = FXMLLoader.load(getClass().getResource("AfficherLocalisation.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();
    }
    }
    


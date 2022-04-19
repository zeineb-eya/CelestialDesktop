/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Planinng;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.PlaninngService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class ModifierPlaninngController implements Initializable {

    private TextField nomplaninngmodif;
    Planinng p=new Planinng();
    @FXML
    private TextField nomplanningmodif;
    @FXML
    private TextField periodeplanningmodif;
    @FXML
    private TextField prixplanningmodif;
    @FXML
    private DatePicker dateDebutplanningmodif;
    @FXML
    private DatePicker dateFinplanningmodif;
    @FXML
    private TextField destinationplanningmodif;
    @FXML
    private TextArea descriptionplanningmodif;
    @FXML
    private Label idp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
   Planinng pl = new Planinng();
        private boolean Validchamp(TextField T){
         if(T.getText().isEmpty() | T.getLength() <5 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}
    


 
  @FXML
     public void modifier(ActionEvent event) throws FileNotFoundException, IOException, SQLException {
      if(Validchamp(nomplanningmodif) && Validchamp(destinationplanningmodif)){
          
      
        int opt = JOptionPane.showConfirmDialog(null, "Confirmer la modification ?","modifier",JOptionPane.YES_NO_OPTION);
        if(opt==0){
        if(nomplanningmodif.getText().isEmpty() | destinationplanningmodif.getText().isEmpty()){  
            
       
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setHeaderText(null);
        al.setContentText("remplir les champs vides svp");
        al.showAndWait();
        }else{
 }
         PlaninngService ps = new PlaninngService();
        Planinng p = new  Planinng (Integer.parseInt(prixplanningmodif.getText()),Integer.parseInt(periodeplanningmodif.getText()),nomplanningmodif.getText(),Date.valueOf(dateDebutplanningmodif.getValue()),Date.valueOf(dateFinplanningmodif.getValue()),descriptionplanningmodif.getText(),destinationplanningmodif.getText());


          JOptionPane.showMessageDialog(null, "planinng modifié");
       ps.updatePlaninng(p);
        //afficherOffre();
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AffichePlaninng.fxml"));
        Scene scene=new Scene(loader.load());
       
//       AfficherReclamationFXMLController mr= loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

     }
     }
}
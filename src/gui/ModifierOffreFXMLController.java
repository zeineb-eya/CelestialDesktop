/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Offre;
import com.mycompany.services.ServiceOffre;

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
import javafx.scene.control.Button;
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
public class ModifierOffreFXMLController implements Initializable {

   
    
     Offre o=new Offre();
    @FXML
    private TextField nom_offre_modif;
    @FXML
    private TextField description_offre_modif;
    @FXML
    private TextField prix_offre_modif;
    @FXML
    private Button modifOffreButton;
    @FXML
    private TextField reduction_modif;
    /**
     * Initializes the controller class.
     */
    
       public  double getPrixFromTextField(TextField textField) {
        String prix = prix_offre_modif.getText();
        return Double.parseDouble(prix);
       }
       
     /*   public  double getReductionFromTextField(TextField textField) {
        String reduction = reduction_modif.getText();
        return Double.parseDouble(reduction);
       }*/
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               
        // TODO
       
    }    
    
        private boolean Validchamp(TextField T){
         if(T.getText().isEmpty() |  T.getLength() <5){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez v??rifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}
    
    @FXML
    private void modifier(ActionEvent event) throws FileNotFoundException, IOException {
        if(Validchamp(description_offre_modif)){
            
        
        if (o == null) {

            System.out.println("Choisir une r??clamation");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modifier r??clamation");
            alert.setHeaderText(null);
            alert.setContentText("La r??clamation n'est pas modifi??!");

            alert.showAndWait();
        }else {
              o.setNom_offre(nom_offre_modif.getText());
             o.setDescription_offre(description_offre_modif.getText());
            int p = Integer.parseInt(prix_offre_modif.getText());
            o.setPrix_offre(p);
             
             int r = Integer.parseInt(reduction_modif.getText());
             o.setReduction(r);

            ServiceOffre so = new ServiceOffre();
             try{
             so.updateOffre(o);
             System.out.println("ok");}
             catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("Modification termin??");}
           
          Image img = new Image("/images/tick.png", 50, 50, false, false);
        Notifications notificationBuilder  = Notifications.create()
            
                    .title("Modification offre")
                    .text("Votre offre a ??t??t modifi?? avec succ??s")
                    .graphic(new ImageView(img) )
                    .hideAfter(Duration.seconds(8))
                    .position(Pos.CENTER);
      notificationBuilder.show();
      
     javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("AfficherOffreFXML.fxml"));

        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
}
//double reduction
 void setData(int id, String nom_offre, String description_offre, int p,int reduc) {
        o.setId(id);
       nom_offre_modif.setText(nom_offre);
    description_offre_modif.setText(description_offre);
    
    //o.setReduction(reduc);
  //  int i = Integer.parseInt(reduction_modif.getText());

  String prix = String.valueOf(p);
  prix_offre_modif.setText(prix);
  
String red = String.valueOf(reduc);
    reduction_modif.setText(red);
    
    
}

    @FXML
    private void modifierReclam(MouseEvent event) {
    }
}
    
      
    

  


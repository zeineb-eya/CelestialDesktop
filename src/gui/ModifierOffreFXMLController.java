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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierOffreFXMLController implements Initializable {

    @FXML
    private Button modifOffreButton;

    /**
     * Initializes the controller class.
     */
    
        
    //off.setDate_debut_offre(date_debut_offre_modif.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    @FXML
    private TextField nom_offre_modif;
    @FXML
    private TextField description_offre_modif;
    @FXML
    private TextField prix_offre_modif;
    @FXML
    private TextField reduction_modif;
    @FXML
    private DatePicker date_fin_offre_modif;
    @FXML
    private DatePicker date_debut_offre_modif;
      Offre o;
    
Offre rv=new Offre();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //  category.setItems(options);
        
                }
    
  /*  private void modifier(ActionEvent event) throws FileNotFoundException, IOException {
        
}*/
    private void save(ActionEvent event) throws IOException {
           if (rv == null) {

            System.out.println("choisir un evenement");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modify Review");
            alert.setHeaderText(null);
            alert.setContentText("your review is not modified !");

            alert.showAndWait();
        }else {
           
             rv.setNom_offre(nom_offre_modif.getText());
             rv.setDescription_offre(description_offre_modif.getText());
           //  rv.setPrix_offre((double) prix_offre_modif.getValue());
             rv.setReduction(Double.parseDouble(prix_offre_modif.getText()));
              rv.setPrix_offre(Double.parseDouble(reduction_modif.getText()));
  //rv.setReducton(reductioncol.getValue());
            // rv.setDate_debut_offre(date_debut_offre_modif.getText());
             rv.setDate_debut_offre(date_debut_offre_modif.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
             rv.setDate_fin_offre(date_debut_offre_modif.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

             //rv.setDate_fin_offre(date_fin_offre_modif.getText());

             ServiceOffre es = new ServiceOffre();
             
           //  es.updateOffre();
             System.out.println("ok");
             
            System.out.println("Modification terminé");}
             
           
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification terminée avec succès.");
        alert.setHeaderText(null);
    alert.setContentText("Your review  has been modified.");
        alert.showAndWait();
        javafx.scene.Parent tableview = FXMLLoader.load(getClass().getResource("DashboardReview.fxml"));
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
      
    }
     void setDAta(int id,String sub,String cat, String content, String rate) {
       rv.setId(id);
       nom_offre_modif.setText(sub); 
       description_offre_modif.setText(cat);
      // reduction_.setText(content);
       prix_offre_modif.setText(rate);
    
    
      
    }
}

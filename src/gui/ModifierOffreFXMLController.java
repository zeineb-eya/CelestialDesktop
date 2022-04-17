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
import java.sql.SQLException;
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
import javax.swing.JOptionPane;

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
    
Offre rv=new Offre();
    @FXML
    private TextField id_offre_modif;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //  category.setItems(options);
        
                }
    
  /*  private void modifier(ActionEvent event) throws FileNotFoundException, IOException {
        
}*/
   //modifOffreButton
    @FXML
     public void modifOffreButton(ActionEvent event) throws FileNotFoundException, IOException, SQLException {
         
         
         
         
                 int opt = JOptionPane.showConfirmDialog(null, "Confirmer la modification ?","modifier",JOptionPane.YES_NO_OPTION);
        if(opt==0){
        if(id_offre_modif.getText().isEmpty() |nom_offre_modif.getText().isEmpty() | description_offre_modif.getText().isEmpty()){      
        
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setHeaderText(null);
        al.setContentText("remplir les champs vides svp");
        al.showAndWait();
        }else{
 }
         ServiceOffre a = new ServiceOffre();
        //Offre a1;
           //  a1 = new  Offre (Integer.parseInt(id_offre.getText()),nom_offre.getText(),description_offre.getText(),Double.parseDouble(reduction).getText());
    //  java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(date_debut_offre.getValue());

           Offre a1 = new  Offre ( Integer.parseInt(id_offre_modif.getText()),nom_offre_modif.getText(),description_offre_modif.getText(),Integer.parseInt(reduction_modif.getText()),Integer.parseInt(prix_offre_modif.getText()));

           /*  date_debut_offre.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                      
                      date_fin_offre.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));*/

        JOptionPane.showMessageDialog(null, "offre modifié");
       a.updateOffre(a1);
        //afficherOffre();
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("AfficherOffreFXML.fxml"));
        Scene scene=new Scene(loader.load());
        

//       AfficherReclamationFXMLController mr= loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

   
    }

         
         
         
         
}

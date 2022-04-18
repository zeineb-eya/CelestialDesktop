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
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
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
    

    @FXML
    private TextField id_offre_modif;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //  category.setItems(options);
        
                }
    
    Offre o=new Offre();
    
  /*  private void modifier(ActionEvent event) throws FileNotFoundException, IOException {
        
}*/
    
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
        
   //modifOffreButton
    @FXML
     public void modifOffreButton(ActionEvent event) throws FileNotFoundException, IOException, SQLException {
      if(Validchamp(nom_offre_modif) && Validchamp(description_offre_modif)){
          
      
        int opt = JOptionPane.showConfirmDialog(null, "Confirmer la modification ?","modifier",JOptionPane.YES_NO_OPTION);
        if(opt==0){
        if(nom_offre_modif.getText().isEmpty() | description_offre_modif.getText().isEmpty()){  
            
       
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setHeaderText(null);
        al.setContentText("remplir les champs vides svp");
        al.showAndWait();
        }else{
 }
          //Date d = java.sql.Date.valueOf(date_debut_offremodif.getValue());
         ServiceOffre a = new ServiceOffre();
        Offre a1 = new  Offre (Integer.parseInt(id_offre_modif.getText()),nom_offre_modif.getText(),description_offre_modif.getText(),Integer.parseInt(reduction_modif.getText()),Integer.parseInt(prix_offre_modif.getText()));
          // Offre a1 = new  Offre (nom_offre_modif.getText(),description_offre_modif.getText(),Integer.parseInt(reduction_modif.getText()),Integer.parseInt(prix_offre_modif.getText()));


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

    @FXML
    private void modifierReclam(MouseEvent event) {
    }
 }
     
    
       //test final
       
   /*if (o == null) {

            System.out.println("Veuillez choisir une offre");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modification de l'offre");
            alert.setHeaderText(null);
            alert.setContentText("Pas de modif!");

            alert.showAndWait();
        }else {
        
             //pst.setInt(1,id);
        o.setNom_offre(nom_offre_modif.getText());
        o.setDescription_offre(description_offre_modif.getText());
        o.setPrix_offre(Integer.parseInt(prix_offre_modif.getText()));
        o.setReduction(Integer.parseInt(reduction_modif.getText()));
     
        ServiceOffre so = new ServiceOffre();
             try{
             so.updateOffre(o);
             System.out.println("ok");}
             catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("Modification réussite");}
             
           
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modififcation de l'offre");
        alert.setHeaderText(null);
        alert.setContentText("Offre modifié avec succés.");
        alert.showAndWait();
        javafx.scene.Parent tableview = null;
        try {
            tableview = FXMLLoader.load(getClass().getResource("AfficherOffreFXML.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifierOffreFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene sceneview = new Scene(tableview);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneview);
        window.show();
    }
    void setData(int id,String c,String v,String t, String p) {
      o.setId(id);
        nom_offre_modif.setText(c);
        description_offre_modif.setText(v);
       prix_offre_modif.setText(t);
        reduction_modif.setText(p);
     
    }
}

             
         
         
*/

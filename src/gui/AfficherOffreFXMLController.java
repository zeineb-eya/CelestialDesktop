/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Offre;
import com.mycompany.services.ServiceOffre;
import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



// import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherOffreFXMLController implements Initializable {

    @FXML
    private TableView<?> tableauOffre;
    
     ObservableList myList ;
    @FXML
    private TableColumn<Offre, String> nom_offrecol;
    @FXML
    private TableColumn<?, ?> description_offrecol;
    @FXML
    private TableColumn<?,?> prix_offrecol;
    @FXML
    private TableColumn<?, ?> reductioncol;
    @FXML
    private TableColumn<Offre, String> date_debut_offrecol;
    @FXML
    private TableColumn<?, ?> date_fin_offrecol;
    @FXML
    private AnchorPane Offre;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherOffre();
      }    
    
     @FXML
    private void deleteOffre(MouseEvent event) {
       /*   if (tableauOffre.getSelectionModel().isEmpty() ){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        JOptionPane.showMessageDialog(null,"veuillez choisir uen offre a supprimer");
          }else{
         ServiceOffre so = new ServiceOffre();
        Offre o = (Offre) tableauOffre.getSelectionModel().getSelectedItem();
        so.deleteOffre(o);
        Alert alert = new Alert(Alert.AlertType.WARNING);
                 try {
             if(JOptionPane.showConfirmDialog(null,"Attention vous allez supprimer votre offre,est ce que tu et sure?"
                     ,"supprimer offre",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
                
         alert.setContentText("Votre offre a été bien supprime");
         JOptionPane.showMessageDialog(null,"offre supprimé");
             //ca est pour recharger la list des stagiaire
           
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());} 
          }*/
    if (tableauOffre.getSelectionModel().isEmpty() ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        JOptionPane.showMessageDialog(null,"Aucune offre n'est selectionné ,veuillez choisir une offre");
     }else{
   int responce=JOptionPane.showConfirmDialog(null, "Attention vous allez supprimer l'offre sélectionné etes-vous sur ?","Suppression",JOptionPane.YES_NO_OPTION);
            if (responce==JOptionPane.YES_OPTION){
           ServiceOffre so = new ServiceOffre();
                    Offre o = (Offre) tableauOffre.getSelectionModel().getSelectedItem();
                     so.deleteOffre(o);
             //refresh(true);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);

         alert.setContentText("Votre offre a été bien supprime");
                  JOptionPane.showMessageDialog(null,"offre supprimé");

            } else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Votre offre a été bien supprime");
                 JOptionPane.showMessageDialog(null,"Suppression annulé");
            }
          
    }
       
    }
    
     private void afficherOffre() {
      /* ServiceReclamation sr = new ServiceReclamation();
        ObservableList<Reclamation> o = FXCollections.observableArrayList(sr.afficherReclamation());*/
       ServiceOffre so = new ServiceOffre();
        List<Offre> reclam = so.afficherOffre();
        myList = FXCollections.observableList(reclam);
        tableauOffre.setItems(myList);
        
       nom_offrecol.setCellValueFactory(new PropertyValueFactory<>("nom_offre"));
       description_offrecol.setCellValueFactory(new PropertyValueFactory<>("description_offre"));
       prix_offrecol.setCellValueFactory(new PropertyValueFactory<>("prix_offre"));
       reductioncol.setCellValueFactory(new PropertyValueFactory<>("reduction"));
       date_debut_offrecol.setCellValueFactory(new PropertyValueFactory<>("date_debut_offre"));
       date_fin_offrecol.setCellValueFactory(new PropertyValueFactory<>("date_fin_offre"));
    }
     
    
     
    @FXML
    private void actualiserOffre(MouseEvent event) {
       
        
             ServiceOffre sr = new ServiceOffre();
        List<Offre> off = sr.refreshOffre();
        myList = FXCollections.observableList(off);
        tableauOffre.setItems(myList);
       
        nom_offrecol.setCellValueFactory(new PropertyValueFactory<>("nom_offre"));
        description_offrecol.setCellValueFactory(new PropertyValueFactory<>("description_offre"));
        prix_offrecol.setCellValueFactory(new PropertyValueFactory<>("prix_offre"));
        reductioncol.setCellValueFactory(new PropertyValueFactory<>("reduction"));
        date_debut_offrecol.setCellValueFactory(new PropertyValueFactory<>("date_debut_offre"));
        date_fin_offrecol.setCellValueFactory(new PropertyValueFactory<>("date_fin_offre"));

 
         tableauOffre.setItems(myList);
    
    }     

    private void updateOffre(ActionEvent event) throws SQLException {
         /*   int opt = JOptionPane.showConfirmDialog(null, "Confirmer la modification ?","modifier",JOptionPane.YES_NO_OPTION);
      if(opt==0){
        if(id_offre.getText().isEmpty() |nom_offrecol.getText().isEmpty() | description_offrecol.getText().isEmpty()){      
        
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setHeaderText(null);
        al.setContentText("remplir les champs vides svp");
        al.showAndWait();
        }else{
 }
  ServiceOffre a = new ServiceOffre();
     
           Offre a1 = new  Offre ( Integer.parseInt(id_offre.getText()),nom_offrecol.getText(),description_offrecol.getText(),Integer.parseInt(reductioncol.getText()),Integer.parseInt(prix_offrecol.getText(),Integer.parseInt(date_debut_offrecol.getText())));
  JOptionPane.showMessageDialog(null, "offre modifié");
       a.updateOffre(a1);
        //afficherOffre();
    }*/
Offre r = (Offre) tableauOffre.getSelectionModel().getSelectedItem();
         

if(r==null){
        
           System.out.println("Aucune reclamation séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune reclamation séléctionné");

            alert.showAndWait();
     
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ModifierOffreFXML.fxml"));
        Scene scene=new Scene(loader.load());
        

       ModifierReclamationFXMLController mr= loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
     //   int as=tableauOffre.getSelectionModel().getSelectedItem().getId();
      //  String sub = tableaureclam.getSelectionModel().getSelectedItem().getDescription_reclamation();
        
       // String content = tableaureclam.getSelectionModel().getSelectedItem().getContent();
        
       
        
 /*       mr.setData(tableauOffre.getSelectionModel().getSelectedItem().getId(),
                tableaureclam.getSelectionModel().getSelectedItem().getDescription_reclamation()*/
                // tableaureclam.getSelectionModel().getSelectedItem().getContent()
                 //);
                 
                 
       
        } catch(IOException ex)
    {
     System.out.println("eer");
}
        }

   
    }

    
    
    

}     

    
       
    
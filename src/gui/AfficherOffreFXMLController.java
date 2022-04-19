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
    private TableView<Offre> tableauOffre;
    
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
    @FXML
    private TableColumn<?, ?> id_offrecol;
     
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
       
    if (tableauOffre.getSelectionModel().isEmpty() ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        JOptionPane.showMessageDialog(null,"Aucune offre n'est selectionné ,veuillez choisir une offre");
     }else{
   int responce=JOptionPane.showConfirmDialog(null, "Attention vous allez supprimer l'offre sélectionné etes-vous sur ?","Suppression",JOptionPane.YES_NO_OPTION);
            if (responce==JOptionPane.YES_OPTION){
           ServiceOffre so = new ServiceOffre();
                    Offre o = tableauOffre.getSelectionModel().getSelectedItem();
                     so.deleteOffre(o);
            
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
        
        id_offrecol.setCellValueFactory(new PropertyValueFactory<>("id"));
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

    @FXML
    private void OnModif(MouseEvent event) throws IOException {

           Offre o = tableauOffre.getSelectionModel().getSelectedItem();
   
if(o==null){
        
           System.out.println("Aucune reclamation séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune reclamation séléctionné pour la modifier");

            alert.showAndWait();
     
        }else {
          
               try {
                   FXMLLoader loader = new FXMLLoader
                                        (getClass()
                                                .getResource("ModifierOffreFXML.fxml"));
                   Scene scene=new Scene(loader.load());
                   
                   
                   ModifierOffreFXMLController mr= loader.getController();
                   Stage stageAff=new Stage();
                   stageAff.setScene(scene);
                   stageAff.show();
                   ((Node) (event.getSource())).getScene().getWindow().hide();
                   int as=tableauOffre.getSelectionModel().getSelectedItem().getId();
                   
                   
                   String sub = tableauOffre.getSelectionModel().getSelectedItem().getNom_offre();
                   String e = tableauOffre.getSelectionModel().getSelectedItem().getDescription_offre();
                   double p  = tableauOffre.getSelectionModel().getSelectedItem().getPrix_offre();
                   // double re  = tableauOffre.getSelectionModel().getSelectedItem().getReduction();
           
                   mr.setData(tableauOffre.getSelectionModel().getSelectedItem().getId(),
                           tableauOffre.getSelectionModel().getSelectedItem().getNom_offre(),
                           tableauOffre.getSelectionModel().getSelectedItem().getDescription_offre(),
                           tableauOffre.getSelectionModel().getSelectedItem().getPrix_offre()
                           //tableauOffre.getSelectionModel().getSelectedItem().getReduction()
                           
                           // tableauOffre.getSelectionModel().getSelectedItem().getDate_debut_offre()
                           // tableaureclam.getSelectionModel().getSelectedItem().getContent()
                   );
               } catch (IOException ex) {
  System.out.println("eer");               }
               
               
         
        }

    }
    
       ///testttt
        
     /*   Offre b = (Offre) tableauOffre.getSelectionModel().getSelectedItem();
         

if(b==null){
        
           System.out.println("Modif offre");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez selectionné une offre a modifier");
            alert.showAndWait();
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass().getResource("ModifierOffreFXML.fxml"));
        Scene scene=new Scene(loader.load());
        
        ModifierOffreFXMLController Bc = loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
       
        } catch(IOException ex)
            {
            System.err.println("eer");
            }
        }

    }*/
       
     
     //tets final
     
     /*Offre r = (Offre) tableauOffre.getSelectionModel().getSelectedItem();
         

if(r==null){
        
           System.out.println("Veuillez seelectionné une offre");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucun offre séléctionné");
            alert.showAndWait();
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass().getResource("ModifierOffreFXML.fxml"));
        Scene scene=new Scene(loader.load());
        
        ModifierOffreFXMLController Rc = loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
     
        } catch(IOException ex)
            {
            System.err.println("eer");
            }
        }
    }
    
    
*/
}     

    
       
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import com.mycompany.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherReclamationFXMLController implements Initializable {

    @FXML
    private TableView<Reclamation> tableaureclam;
    @FXML
    private TableColumn<Reclamation,String> description_reclamcol;
    @FXML
    private TableColumn<Reclamation, String> etat_reclamcol;
    @FXML
    private TableColumn<?, ?> date_reclamcol;
    
    ObservableList myList ;
    @FXML
    private Button refreshButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       afficherReclam();
    }    
    
      @FXML
    private void delete(ActionEvent event) {
         ServiceReclamation sr = new ServiceReclamation();
        Reclamation r = (Reclamation) tableaureclam.getSelectionModel().getSelectedItem();
        sr.deleteReclamation(r);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 try {
             if(JOptionPane.showConfirmDialog(null,"attention vous allez supprimer votre reclamation,est ce que tu et sure?"
                     ,"supprimer reclamation",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
            if(r.getDescription_reclamation().length() != 0){
       
         alert.setContentText("Votre réclamation a ete bien supprime");
         JOptionPane.showMessageDialog(null,"reclamation supprime");
             }//ca est pour recharger la list des stagiaire
            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ id !");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());} 
       
    
    }
    
    private void afficherReclam() {
      /* ServiceReclamation sr = new ServiceReclamation();
        ObservableList<Reclamation> o = FXCollections.observableArrayList(sr.afficherReclamation());*/
       ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.afficherReclamation();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
        
       description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
         date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
        
    }
    
    @FXML
     private void modifierReclam(ActionEvent event) {
     Reclamation r = tableaureclam.getSelectionModel().getSelectedItem();
         

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
                         .getResource("ModifierReclamationFXML.fxml"));
        Scene scene=new Scene(loader.load());
        

       ModifierReclamationFXMLController mr= loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        int as=tableaureclam.getSelectionModel().getSelectedItem().getId();
        String sub = tableaureclam.getSelectionModel().getSelectedItem().getDescription_reclamation();
        
       // String content = tableaureclam.getSelectionModel().getSelectedItem().getContent();
        
       
        
        mr.setData(tableaureclam.getSelectionModel().getSelectedItem().getId(),
                tableaureclam.getSelectionModel().getSelectedItem().getDescription_reclamation()
                // tableaureclam.getSelectionModel().getSelectedItem().getContent()
                 );
                 
                 
       
        } catch(IOException ex)
    {
     System.out.println("eer");
}
        }

}
     
        /* public void refresh(boolean x){
    if(x==true){
        
             ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.refreshReclam();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
       
           description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
         date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
                  
         tableaureclam.setItems(myList);
        }
    else
    {}
    }*/

    @FXML
    private void refresh(ActionEvent event) {
       
        
             ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.refreshReclam();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
       
           description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
         date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
                  
         tableaureclam.setItems(myList);
    
    }
}
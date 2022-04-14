/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Localisation;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import services.LocalisationService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AfficherLocalisationController implements Initializable {

    @FXML
    private TableView<?> tablelocalisation;
    @FXML
    private TableColumn<?, ?> heure_arrivee_loacalisation;
    @FXML
    private TableColumn<?, ?> position_depart_localisation;
    @FXML
    private TableColumn<?, ?> position_arivee_planning;
    @FXML
    private TableColumn<?, ?> fusee;
    @FXML
    private TableColumn<?, ?> id;
ObservableList list;
    @FXML
    private TableColumn<?, ?> heure_depart_localisationn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherlocalisation();
    }    
    @FXML
    private void supprimer(ActionEvent event) {
         LocalisationService ps = new LocalisationService();
        Localisation l = (Localisation) tablelocalisation.getSelectionModel().getSelectedItem();
        ps.SupprimerLocalisation(l);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
           /* alert.setTitle("suppression");
            alert.setHeaderText(null);
            alert.setContentText("Votre réclamation a ete bien supprime");
            alert.showAndWait();*/
         
               try {
             if(JOptionPane.showConfirmDialog(null,"attention vous avez supprimer votre localisation,est ce que tu et sure?"
                     ,"supprimer localisation",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
            if(l.getPositionDepartLocalisation().length() != 0){
       
         alert.setContentText("Votre localisation a ete bien supprime");
         JOptionPane.showMessageDialog(null,"localisation supprime");
             }//ca est pour recharger la list des stagiaire
            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ nom !");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());} 
       
    
    }
    private void afficherlocalisation() {
      /* ServiceReclamation sr = new ServiceReclamation();
        ObservableList<Reclamation> o = FXCollections.observableArrayList(sr.afficherReclamation());*/
      /* LocalisationService ls = new LocalisationService();
        List<Localisation> localisations = ls.afficherLocalisations();
        list = FXCollections.observableList(localisations);
        tablelocalisation.setItems(list);
        
       heure_depart_localisationn.setCellValueFactory(new PropertyValueFactory<>("heure_depart_localisation"));
        heure_arrivee_loacalisation.setCellValueFactory(new PropertyValueFactory<>("heure_arrivee_loacalisation"));
         position_depart_localisation.setCellValueFactory(new PropertyValueFactory<>("position_depart_localisation"));
         position_arivee_planning.setCellValueFactory(new PropertyValueFactory<>("position_arivee_planning"));
         fusee.setCellValueFactory(new PropertyValueFactory<>("fusee"));

    }
    
    */
      
       
       LocalisationService ls = new LocalisationService();
        ObservableList<Localisation> localisations = FXCollections.observableArrayList(ls.afficherLocalisations());
         
        heure_depart_localisationn.setCellValueFactory(new PropertyValueFactory<>("heure_depart_localisation"));
       heure_arrivee_loacalisation.setCellValueFactory(new PropertyValueFactory<>("heure_arrivee_loacalisation"));
       position_depart_localisation.setCellValueFactory(new PropertyValueFactory<>("position_depart_localisation"));
         position_arivee_planning.setCellValueFactory(new PropertyValueFactory<>("positionArivee_planning"));
         fusee.setCellValueFactory(new PropertyValueFactory<>("fusee"));
        //date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date reclamation"));
        list = FXCollections.observableList(localisations);
        tablelocalisation.setItems(list);
      
  /*  private void Show(ActionEvent event) {
       ServiceReclamation sr = new ServiceReclamation();
        ObservableList<Reclamation> oc = FXCollections.observableArrayList(sr.afficherReclamation());
       description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description reclamation"));
       etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat reclamation"));
        date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date reclamation"));
        
        tableaureclam.setItems(oc);
    }*/
   
  
    }
}

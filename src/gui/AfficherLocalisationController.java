/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Localisation;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.LocalisationService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AfficherLocalisationController implements Initializable {

    
       ObservableList list;

    
    @FXML
    private TableColumn<?, ?> fusee;
    @FXML
    private TableColumn<?, ?> id;
     
    @FXML
    private TableView<?> tableloca;
    @FXML
    private TableColumn<?, ?> heuredepartlocalisationcol;
    @FXML
    private TableColumn<?, ?> colheure_arrivee_loacalisation;
    @FXML
    private TableColumn<?, ?> colposition_depart_localisation;
    @FXML
    private TableColumn<?, ?> position_arivee_planning;
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
        Localisation l = (Localisation) tableloca.getSelectionModel().getSelectedItem();
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

       LocalisationService ls = new LocalisationService();
        ObservableList<Localisation> localisations = FXCollections.observableArrayList(ls.afficherLocalisations());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        heuredepartlocalisationcol.setCellValueFactory(new PropertyValueFactory<>("heureDepartLocalisation"));
       colheure_arrivee_loacalisation.setCellValueFactory(new PropertyValueFactory<>("heureArriveeLoacalisation"));
       colposition_depart_localisation.setCellValueFactory(new PropertyValueFactory<>("positionDepartLocalisation"));
         position_arivee_planning.setCellValueFactory(new PropertyValueFactory<>("positionAriveePlanning"));
         fusee.setCellValueFactory(new PropertyValueFactory<>("fusee"));
        
        list = FXCollections.observableList(localisations);
                tableloca.setItems(list);


    }
}

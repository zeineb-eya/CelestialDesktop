/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Planinng;
import static java.awt.PageAttributes.MediaType.C;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static javafx.print.Paper.C;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import services.PlaninngService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AffichePlaninngController implements Initializable {
    
     @FXML
    private TableView<?> tableplaninng;
    @FXML
    private TableColumn<? , ?> nom_planning;
    @FXML
    private TableColumn<? , ?> dateDebut_planning;
    @FXML
    private TableColumn<? , ?> dateFin_planning;
    @FXML
    private TableColumn<? , ?> description_planning;
    @FXML
    private TableColumn<? , ?> destination_planning;
    @FXML
    private TableColumn<? , ?> periode_planning;
    
    ObservableList myList;
    @FXML
    private TableColumn<? , ?> id;
    @FXML
    private TableColumn<? , ?>prix_planning;
   
                       


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherPlaninng();
    }
      @FXML
    private void supprimer(ActionEvent event) {
         PlaninngService ps = new PlaninngService();
        Planinng p = (Planinng) tableplaninng.getSelectionModel().getSelectedItem();
        ps.SupprimerPlaninng(p);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
           /* alert.setTitle("suppression");
            alert.setHeaderText(null);
            alert.setContentText("Votre réclamation a ete bien supprime");
            alert.showAndWait();*/
         
               try {
             if(JOptionPane.showConfirmDialog(null,"attention vous avez supprimer votre planinng,est ce que tu et sure?"
                     ,"supprimer planinng",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
            if(p.getNomPlanning().length() != 0){
       
         alert.setContentText("Votre planinng a ete bien supprime");
         JOptionPane.showMessageDialog(null,"planinng supprime");
             }//ca est pour recharger la list des stagiaire
            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ nom !");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());} 
       
    
    }
        private void afficherPlaninng() {
        PlaninngService ps = new PlaninngService();
        List<Planinng> planinngs = ps.afficherPlaninng();
        myList = FXCollections.observableList(planinngs);
        tableplaninng.setItems(myList);
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom_planning.setCellValueFactory(new PropertyValueFactory<>("nom_planning"));
        dateDebut_planning.setCellValueFactory(new PropertyValueFactory<>("date_debut_planning"));
        dateFin_planning.setCellValueFactory(new PropertyValueFactory<>("date_fin_planning"));
        description_planning.setCellValueFactory(new PropertyValueFactory<>("description_planning"));
        destination_planning.setCellValueFactory(new PropertyValueFactory<>("destination_planning"));
        periode_planning.setCellValueFactory(new PropertyValueFactory<>("periode_planning"));
        prix_planning.setCellValueFactory(new PropertyValueFactory<>("prix_planning"));
        


    }    

   
    
}

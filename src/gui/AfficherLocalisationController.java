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
import javafx.scene.control.Button;
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
    private TableColumn<Localisation, Integer> id;
     
    @FXML
    private TableView<Localisation> tableloca;
    @FXML
    private TableColumn<?, ?> heuredepartlocalisationcol;
    @FXML
    private TableColumn<?, ?> colheure_arrivee_loacalisation;
    @FXML
    private TableColumn<Localisation, String> colposition_depart_localisation;
    @FXML
    private TableColumn<?, ?> position_arivee_planning;
    @FXML
    private Button refreshButton;
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
               try {
             if(JOptionPane.showConfirmDialog(null,"attention vous avez supprimer votre localisation,est ce que tu et sure?"
                     ,"supprimer localisation",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
            if(l.getPositionDepartLocalisation().length() != 0){
       
         alert.setContentText("Votre localisation a ete bien supprime");
         JOptionPane.showMessageDialog(null,"localisation supprime");
             }
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
    
    @FXML
    private void modifierLocalisation(ActionEvent event) {
        
        Localisation l = (Localisation) tableloca.getSelectionModel().getSelectedItem();
         

if(l==null){
        
           System.out.println("Aucune localisation séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune localisation séléctionné");

            alert.showAndWait();
     
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ModifierLocalisation.fxml"));
        Scene scene=new Scene(loader.load());
        

        ModifierLocalisationController lc = loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
         int as=tableloca.getSelectionModel().getSelectedItem().getId();
      String sub =tableloca.getSelectionModel().getSelectedItem().getHeureDepartLocalisation();
        

                   lc.setData(tableloca.getSelectionModel().getSelectedItem().getId(),
                   tableloca.getSelectionModel().getSelectedItem().getHeureDepartLocalisation(),
                  tableloca.getSelectionModel().getSelectedItem().getHeureArriveeLoacalisation(),
                 tableloca.getSelectionModel().getSelectedItem().getPositionDepartLocalisation(),
                tableloca.getSelectionModel().getSelectedItem().getPositionAriveePlanning(),
                tableloca.getSelectionModel().getSelectedItem().getFusee());
                 
                 
       
        } catch(IOException ex)
    {
     System.out.println("eer");
}
        }

}

    @FXML
    private void refresh(ActionEvent event) {
        LocalisationService ps = new LocalisationService();
        List<Localisation> localisations = ps.refreshLocalisation();
        list = FXCollections.observableList(localisations);
        tableloca.setItems(list);
       
       id.setCellValueFactory(new PropertyValueFactory<>("id"));
       heuredepartlocalisationcol.setCellValueFactory(new PropertyValueFactory<>("heureDepartLocalisation"));
       colheure_arrivee_loacalisation.setCellValueFactory(new PropertyValueFactory<>("heureArriveeLoacalisation"));
       colposition_depart_localisation.setCellValueFactory(new PropertyValueFactory<>("positionDepartLocalisation"));
       position_arivee_planning.setCellValueFactory(new PropertyValueFactory<>("positionAriveePlanning"));
       fusee.setCellValueFactory(new PropertyValueFactory<>("fusee"));
       tableloca.setItems(list);
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Planinng;
import util.MyDB;
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
import services.PlaninngService;
import gui.ModifierPlaninngController;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AffichePlaninngController implements Initializable {
    

    
    ObservableList myList;
    @FXML
    private TableColumn<? , ?> id;
    @FXML
    private TableColumn<?, ?> nomplanning;
    @FXML
    private TableColumn<?, ?> dateDebutplanning;
    @FXML
    private TableColumn<?, ?> dateFinplanning;
    @FXML
    private TableColumn<?, ?> descriptionplanning;
    @FXML
    private TableColumn<?, ?> destinationplanning;
    @FXML
    private TableColumn<?, ?> periodeplanning;
    @FXML
    private TableColumn<?, ?> prixplanning;
    @FXML
    private TableView<?> tableplaninng;
    @FXML
    private Button refreshButton;
   
                       


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
        ObservableList<Planinng> Planinngs = FXCollections.observableArrayList(ps.afficherPlaninng());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomplanning.setCellValueFactory(new PropertyValueFactory<>("nomPlanning"));
        dateDebutplanning.setCellValueFactory(new PropertyValueFactory<>("dateDebutPlanning"));
        dateFinplanning.setCellValueFactory(new PropertyValueFactory<>("dateFinPlanning"));
         descriptionplanning.setCellValueFactory(new PropertyValueFactory<>("descriptionPlanning"));
         destinationplanning.setCellValueFactory(new PropertyValueFactory<>("destinationPlanning"));
         periodeplanning.setCellValueFactory(new PropertyValueFactory<>("periodePlanning"));
         prixplanning.setCellValueFactory(new PropertyValueFactory<>("prixPlanning"));

        
        myList = FXCollections.observableList(Planinngs);
                tableplaninng.setItems(myList);


    }

    @FXML
    private void modifierPlaninng(ActionEvent event) {
        
        Planinng p = (Planinng) tableplaninng.getSelectionModel().getSelectedItem();
         

if(p==null){
        
           System.out.println("Aucun planinng séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucun planinng séléctionné");

            alert.showAndWait();
     
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ModifierPlaninng.fxml"));
        Scene scene=new Scene(loader.load());
        

       ModifierPlaninngController mp= loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
       //int as=tableplaninng.getSelectionModel().getSelectedItem().getId();
       // String sub = tableplaninng.getSelectionModel().getSelectedItem().getNomPlanning();
        
       // String content = tableaureclam.getSelectionModel().getSelectedItem().getContent();
        
       
        
                //   mp.setData(tableplaninng.getSelectionModel().getSelectedItem().getId(),
                  // tableplaninng.getSelectionModel().getSelectedItem().getNomPlanning());
                 
                 
       
        } catch(IOException ex)
    {
     System.out.println("eer");
}
        }

}

    @FXML
    private void refresh(ActionEvent event) {
             PlaninngService ps = new PlaninngService();
        List<Planinng> planinngs = ps.refreshPlaninng();
        myList = FXCollections.observableList(planinngs);
        tableplaninng.setItems(myList);
       
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomplanning.setCellValueFactory(new PropertyValueFactory<>("nomPlanning"));
        dateDebutplanning.setCellValueFactory(new PropertyValueFactory<>("dateDebutPlanning"));
        dateFinplanning.setCellValueFactory(new PropertyValueFactory<>("dateFinPlanning"));
         descriptionplanning.setCellValueFactory(new PropertyValueFactory<>("descriptionPlanning"));
         destinationplanning.setCellValueFactory(new PropertyValueFactory<>("destinationPlanning"));
         periodeplanning.setCellValueFactory(new PropertyValueFactory<>("periodePlanning"));
         prixplanning.setCellValueFactory(new PropertyValueFactory<>("prixPlanning"));
                  
         tableplaninng.setItems(myList);
    
    }
    }
   
    


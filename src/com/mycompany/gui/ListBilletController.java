/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Billet;
import com.mycompany.services.BilletService;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ListBilletController implements Initializable {

    @FXML
    private TableView<?> tabBillet;
    @FXML
    private TableColumn<?, ?> chair_billet;
    @FXML
    private TableColumn<?, ?> voyage_num;
    @FXML
    private TableColumn<?, ?> terminal;
    @FXML
    private TableColumn<?, ?> portail;
    @FXML
    private TableColumn<?, ?> embarquement;
    @FXML
    private TableColumn<?, ?> localisation;
    @FXML
    private Button AjouterBillet;
    
    ObservableList list ;
    @FXML
    private Button ModifierBillet;
    @FXML
    private Button SupprimerBillet;
    @FXML
    private Button ActualiserBillet;
    @FXML
    private TableColumn<?, ?> id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BilletService bs = new BilletService();
        List<Billet> Billets = bs.afficherBillets();
        
        list = FXCollections.observableList(Billets);
        tabBillet.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        chair_billet.setCellValueFactory(new PropertyValueFactory<>("chair_billet"));
        voyage_num.setCellValueFactory(new PropertyValueFactory<>("voyage_num"));
        terminal.setCellValueFactory(new PropertyValueFactory<>("terminal"));
        portail.setCellValueFactory(new PropertyValueFactory<>("portail"));
        embarquement.setCellValueFactory(new PropertyValueFactory<>("embarquement"));
        localisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
      
    }    

    @FXML
    private void AjouterBillet(ActionEvent event) {
   try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AjoutBillet.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @FXML
    private void ModifierBillet(ActionEvent event) {
          Billet b = (Billet) tabBillet.getSelectionModel().getSelectedItem();
         

if(b==null){
        
           System.out.println("Aucun billet séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucun billet séléctionné");
            alert.showAndWait();
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass().getResource("ModifierBillet.fxml"));
        Scene scene=new Scene(loader.load());
        
        ModifierBilletController Bc = loader.getController();
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

    @FXML
    private void SupprimerBillet(ActionEvent event) {
        BilletService bs = new BilletService();
        Billet b = (Billet) tabBillet.getSelectionModel().getSelectedItem();
        bs.supprimerBillet(b);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("suppression");
            alert.setHeaderText(null);
            alert.setContentText("Votre Billet a ete bien supprime");
            alert.showAndWait();
   
    }

    @FXML
    private void ActualiserBillet(ActionEvent event) {
        BilletService bs = new BilletService();
        List<Billet> Billets = bs.afficherBillets();
        
        list = FXCollections.observableList(Billets);
        tabBillet.setItems(list);
         id.setCellValueFactory(new PropertyValueFactory<>("id"));
        chair_billet.setCellValueFactory(new PropertyValueFactory<>("chair_billet"));
        voyage_num.setCellValueFactory(new PropertyValueFactory<>("voyage_num"));
        terminal.setCellValueFactory(new PropertyValueFactory<>("terminal"));
        portail.setCellValueFactory(new PropertyValueFactory<>("portail"));
        embarquement.setCellValueFactory(new PropertyValueFactory<>("embarquement"));
        localisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
    }
    
}

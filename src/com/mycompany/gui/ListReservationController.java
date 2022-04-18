/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Billet;
import com.mycompany.entities.Reservation;
import com.mycompany.services.BilletService;
import com.mycompany.services.ReservationService;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ListReservationController implements Initializable {

  
    @FXML
    private TableColumn<?, ?> date_reservation;
    @FXML
    private TableColumn<?, ?> Etat_reservation;
    @FXML
    private TableColumn<?, ?> user;
    @FXML
    private TableColumn<?, ?> billet;
    @FXML
    private Button Reserver;
    @FXML
    private TableView<?> tabReservation;

    ObservableList list ;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private Button SupprimerReservation;
    @FXML
    private Button ModifierReservation;
    @FXML
    private Button ActualiserReservation;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReservationService bs = new ReservationService();
        List<Reservation> Reservations = bs.afficherReservations();
        
        list = FXCollections.observableList(Reservations);
        tabReservation.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        date_reservation.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
        Etat_reservation.setCellValueFactory(new PropertyValueFactory<>("etat_reservation"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        billet.setCellValueFactory(new PropertyValueFactory<>("billet"));
       
    }    

    @FXML
    private void Reserver(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AjoutReservation.fxml"));
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
    private void SupprimerReservation(ActionEvent event) {
         ReservationService rs = new ReservationService();
        Reservation r = (Reservation) tabReservation.getSelectionModel().getSelectedItem();
        rs.supprimerReservation(r);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("suppression");
            alert.setHeaderText(null);
            alert.setContentText("Votre Reservation a ete bien supprime");
            alert.showAndWait();
    }

    @FXML
    private void ModifierReservation(ActionEvent event) {
            Reservation r = ( Reservation) tabReservation.getSelectionModel().getSelectedItem();
         

if(r==null){
        
           System.out.println("Aucun  Reservation séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucun  Reservation séléctionné");
            alert.showAndWait();
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass().getResource("ModifierReservation.fxml"));
        Scene scene=new Scene(loader.load());
        
        ModifierReservationController Rc = loader.getController();
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
    private void ActualiserReservation(ActionEvent event) {
        ReservationService bs = new ReservationService();
        List<Reservation> Reservations = bs.afficherReservations();
        
        list = FXCollections.observableList(Reservations);
        tabReservation.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        date_reservation.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
        Etat_reservation.setCellValueFactory(new PropertyValueFactory<>("etat_reservation"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        billet.setCellValueFactory(new PropertyValueFactory<>("billet"));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Reservation;
import com.mycompany.services.ReservationService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ReslisttestController implements Initializable {

    
    ObservableList list ;
    @FXML
    private TableView<Reservation> tabReservation;
    @FXML
    private TableColumn<Reservation, Integer> id;
    @FXML
    private TableColumn<Reservation, Date> date_reservation;
    @FXML
    private TableColumn<Reservation, String> Etat_reservation;
    @FXML
    private TableColumn<Reservation, Integer> user;
    @FXML
    private TableColumn<Reservation, Integer> billet;
    @FXML
    private Button Reserver;
    @FXML
    private Button SupprimerReservation;
    @FXML
    private Button ModifierReservation;
    @FXML
    private Button ActualiserReservation;
    @FXML
    private Button StatistiqueReservation;
    @FXML
    private Button showDetails;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReservationService bs = new ReservationService();
        List<Reservation> Reservations = bs.afficherReservations();
        
        list = FXCollections.observableList(Reservations);
        tabReservation.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("id"));
        user.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("user"));
        date_reservation.setCellValueFactory(new PropertyValueFactory<Reservation, Date>("datereservation"));
        billet.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("billet"));
        Etat_reservation.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Etatreservation"));
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
        
           System.out.println("Aucune Reservation séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune Reservation séléctionné");
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
      Rc.setData(tabReservation.getSelectionModel().getSelectedItem().getId(),
              tabReservation.getSelectionModel().getSelectedItem().getEtatReservation());
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
        id.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("id"));
        user.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("user"));
        date_reservation.setCellValueFactory(new PropertyValueFactory<Reservation, Date>("datereservation"));
        billet.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("billet"));
        Etat_reservation.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Etatreservation"));
    }

    @FXML
    private void StatistiqueReservation(ActionEvent event) {
         try {
            ReservationService bs = new ReservationService();
        List<Reservation> Reservations = bs.afficherReservations();
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("StatisticsReservation.fxml"));
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
    private void showDetails(ActionEvent event) throws IOException {
          Reservation r = ( Reservation) tabReservation.getSelectionModel().getSelectedItem();
       FXMLLoader loader = new FXMLLoader(
    getClass().getResource(
      "ReservationDetails.fxml"
    )
  );

  Stage stage = new Stage(StageStyle.DECORATED.DECORATED);
  stage.setScene(
    new Scene(loader.load())
  );

  ReservationDetailsController controller = loader.getController();
  controller.initData(r);

  stage.show();
    }

    @FXML
    private void search(ActionEvent event) {
          FilteredList<Reservation> filteredData = new FilteredList<>(list, b -> true);
		
	// 2. Set the filter Predicate whenever the filter changes.
	filterField.textProperty().addListener((observable, oldValue, newValue) -> {
	filteredData.setPredicate(r -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				String datereservation = String.valueOf(r.getDateReservation());
				if (datereservation.toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (r.getEtatReservation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                  
				else if (String.valueOf(r.getBillet()).indexOf(lowerCaseFilter)!=-1){
				     return true;}
                                else if (String.valueOf(r.getUser()).indexOf(lowerCaseFilter)!=-1){
				     return true;}
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Reservation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tabReservation.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tabReservation.setItems(sortedData);
    }
    
}

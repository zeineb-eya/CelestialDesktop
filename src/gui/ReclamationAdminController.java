/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Pagination;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReclamationAdminController implements Initializable {

    @FXML
    private TableView<Reclamation> tableaureclam;
    @FXML
    private TableColumn<?, ?> description_reclamcol;
    @FXML
    private TableColumn<?, ?> etat_reclamcol;
    @FXML
    private TableColumn<?, ?> date_reclamcol;
    @FXML
    private TableColumn<?, ?> user;
    @FXML
    private TextField rechercher;
    ObservableList myList ;
    
Reclamation rec=new Reclamation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       afficherReclam();
    }    

 
       private void afficherReclam() {
      ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.afficherReclamation();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
        
        description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
        date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
        user.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        RechercheAV();
          
    }
       
       //sorted
         private void afficherSortReclam() {
      ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.sortByEtat();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
        
        description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
        date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
        user.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        RechercheAV();
          
    }

    @FXML
    private void refresh(MouseEvent event) {
           ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.refreshReclam();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
       
        description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
         date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
                  
         tableaureclam.setItems(myList);
          RechercheAV();
    }


    @FXML
    private void traiterReclam(javafx.event.ActionEvent event) {
        
       Reclamation r = tableaureclam.getSelectionModel().getSelectedItem();
      ServiceReclamation sr = new ServiceReclamation();
      
   if (r.getEtat_reclamation().equals("envoye"))
            {
                    sr.updateReclamationAdmin(r);
                 System.out.println("ok");
                  
            System.out.println("Traitement terminé");
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Traitement terminée avec succès.");
        alert.setHeaderText(null);
    alert.setContentText("La réclamation a été traité avec succés.");
        alert.showAndWait();
                  
            }
    }
       public void RechercheAV(){
     FilteredList<Reclamation> filteredData = new FilteredList<>(myList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(tmp -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				if (tmp.getEtat_reclamation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                                       // (String.valueOf(tmp.getId()).indexOf(lowerCaseFilter)!=-1)
				} else if (String.valueOf(tmp.getDate_reclamation()).indexOf(lowerCaseFilter)!=-1){
				     return true;
                               } else  
				    	 return false; // Does not match.
			
		});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableaureclam.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableaureclam.setItems(sortedData);
                
       }

}
       
 
     
                
        
    
    


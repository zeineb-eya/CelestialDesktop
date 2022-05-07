/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Offre;
import com.mycompany.services.ServiceOffre;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FrontOffreFXMLController implements Initializable {

    @FXML
    private TextField rechercher;
    @FXML
    private TableView<Offre> tableauOffre;
    @FXML
    private TableColumn<?, ?> nom_offrecol;
    @FXML
    private TableColumn<?, ?> description_offrecol;
    @FXML
    private TableColumn<?, ?> prix_offrecol;
    @FXML
    private TableColumn<?, ?> reductioncol;
    @FXML
    private TableColumn<?, ?> date_debut_offrecol;
    @FXML
    private TableColumn<?, ?> date_fin_offrecol;

       ObservableList myList ;
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              afficherOffre();
    }    
    
      private void afficherOffre() {
      /* ServiceReclamation sr = new ServiceReclamation();
        ObservableList<Reclamation> o = FXCollections.observableArrayList(sr.afficherReclamation());*/
       ServiceOffre so = new ServiceOffre();
        List<Offre> reclam = so.afficherOffre();
        myList = FXCollections.observableList(reclam);
        tableauOffre.setItems(myList);
        
       nom_offrecol.setCellValueFactory(new PropertyValueFactory<>("nom_offre"));
       description_offrecol.setCellValueFactory(new PropertyValueFactory<>("description_offre"));
       prix_offrecol.setCellValueFactory(new PropertyValueFactory<>("prix_offre"));
       reductioncol.setCellValueFactory(new PropertyValueFactory<>("reduction"));
       date_debut_offrecol.setCellValueFactory(new PropertyValueFactory<>("date_debut_offre"));
       date_fin_offrecol.setCellValueFactory(new PropertyValueFactory<>("date_fin_offre"));
          RechercheAV();
    }
    
    @FXML
    private void actualiserOffre(MouseEvent event) {
           ServiceOffre sr = new ServiceOffre();
        List<Offre> off = sr.refreshOffre();
        myList = FXCollections.observableList(off);
        tableauOffre.setItems(myList);
       
        nom_offrecol.setCellValueFactory(new PropertyValueFactory<>("nom_offre"));
        description_offrecol.setCellValueFactory(new PropertyValueFactory<>("description_offre"));
        prix_offrecol.setCellValueFactory(new PropertyValueFactory<>("prix_offre"));
        reductioncol.setCellValueFactory(new PropertyValueFactory<>("reduction"));
        date_debut_offrecol.setCellValueFactory(new PropertyValueFactory<>("date_debut_offre"));
        date_fin_offrecol.setCellValueFactory(new PropertyValueFactory<>("date_fin_offre"));

        tableauOffre.setItems(myList);
    }

    
    public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Offre> filteredData = new FilteredList<>(myList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(fo -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				if (fo.getNom_offre().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                                       // (String.valueOf(tmp.getId()).indexOf(lowerCaseFilter)!=-1)
				} else if (fo.getDescription_offre().toLowerCase().indexOf(lowerCaseFilter) != -1){
				     return true;
                                }else if(String.valueOf(fo.getPrix_offre()).indexOf(lowerCaseFilter)!=-1){
                                    return true;
                                }else if(String.valueOf(fo.getReduction()).indexOf(lowerCaseFilter)!=-1){
                                    return true;
                                     }else if(String.valueOf(fo.getDate_debut_offre()).indexOf(lowerCaseFilter)!=-1){
                                    return true;
                                    }else if(String.valueOf(fo.getDate_fin_offre()).indexOf(lowerCaseFilter)!=-1){
                                    return true;
                                }else  
				    	 return false; // Does not match.
			
		});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Offre> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableauOffre.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableauOffre.setItems(sortedData);
                
                        }

    
    
}

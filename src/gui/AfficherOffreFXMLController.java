/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Offre;
import com.mycompany.services.ServiceOffre;
import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;



// import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherOffreFXMLController implements Initializable {

    @FXML
    private TableView<Offre> tableauOffre;
    
     ObservableList myList ;
    @FXML
    private TableColumn<Offre, String> nom_offrecol;
    @FXML
    private TableColumn<?, ?> description_offrecol;
    @FXML
    private TableColumn<?,?> prix_offrecol;
    @FXML
    private TableColumn<?, ?> reductioncol;
    @FXML
    private TableColumn<Offre, String> date_debut_offrecol;
    @FXML
    private TableColumn<?, ?> date_fin_offrecol;
    @FXML
    private AnchorPane Offre;
    @FXML
    private TextField rechercher;
     
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
    private void deleteOffre(MouseEvent event) {
       
    if (tableauOffre.getSelectionModel().isEmpty() ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        JOptionPane.showMessageDialog(null,"Aucune offre n'est selectionné ,veuillez choisir une offre");
     }else{
   int responce=JOptionPane.showConfirmDialog(null, "Attention vous allez supprimer l'offre sélectionné etes-vous sur ?","Suppression",JOptionPane.YES_NO_OPTION);
            if (responce==JOptionPane.YES_OPTION){
           ServiceOffre so = new ServiceOffre();
                    Offre o = tableauOffre.getSelectionModel().getSelectedItem();
                     so.deleteOffre(o);
            
          Alert alert = new Alert(Alert.AlertType.INFORMATION);

         alert.setContentText("Votre offre a été bien supprime");
                  JOptionPane.showMessageDialog(null,"offre supprimé");

            } else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Votre offre a été bien supprime");
                 JOptionPane.showMessageDialog(null,"Suppression annulé");
            }
          
    }
       
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

    @FXML
    private void OnModif(MouseEvent event) throws IOException {

           Offre o = tableauOffre.getSelectionModel().getSelectedItem();
   
if(o==null){
        
           System.out.println("Aucune reclamation séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune reclamation séléctionné pour la modifier");

            alert.showAndWait();
     
        }else {
          
               try {
                   FXMLLoader loader = new FXMLLoader
                                        (getClass()
                                                .getResource("ModifierOffreFXML.fxml"));
                   Scene scene=new Scene(loader.load());
                   
                   
                   ModifierOffreFXMLController mr= loader.getController();
                   Stage stageAff=new Stage();
                   stageAff.setScene(scene);
                   stageAff.show();
                   ((Node) (event.getSource())).getScene().getWindow().hide();
                   int as=tableauOffre.getSelectionModel().getSelectedItem().getId();
                   
                   
                   String sub = tableauOffre.getSelectionModel().getSelectedItem().getNom_offre();
                   String e = tableauOffre.getSelectionModel().getSelectedItem().getDescription_offre();
                   double p  = tableauOffre.getSelectionModel().getSelectedItem().getPrix_offre();
                  int redu  = tableauOffre.getSelectionModel().getSelectedItem().getReduction();
           
                   mr.setData(tableauOffre.getSelectionModel().getSelectedItem().getId(),
                           tableauOffre.getSelectionModel().getSelectedItem().getNom_offre(),
                           tableauOffre.getSelectionModel().getSelectedItem().getDescription_offre(),
                           tableauOffre.getSelectionModel().getSelectedItem().getPrix_offre(),
                           tableauOffre.getSelectionModel().getSelectedItem().getReduction()
                           
                           // tableauOffre.getSelectionModel().getSelectedItem().getDate_debut_offre()
                           // tableaureclam.getSelectionModel().getSelectedItem().getContent()
                   );
               } catch (IOException ex) {
  System.out.println("eer");               }
        }
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

    @FXML
    private void ajouterOffre(MouseEvent event) throws IOException {
         
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AjoutOffreFXML.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
       
    }

}     

    
       
    
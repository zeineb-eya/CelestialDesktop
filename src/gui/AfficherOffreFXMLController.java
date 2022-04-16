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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherOffreFXMLController implements Initializable {

    @FXML
    private TableView<?> tableauOffre;
    @FXML
    private Button modifierButoon;
    @FXML
    private Button supprimerButton;
    @FXML
    private Button actualiserButton;
    
     ObservableList myList ;
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


        
    }
    
    
}

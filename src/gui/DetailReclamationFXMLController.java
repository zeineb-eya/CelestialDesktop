/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DetailReclamationFXMLController implements Initializable {

    private TextField description_reclamation;
    private TextField date_reclamation;
    
   ObservableList myList ;
    private TextField etat_reclamation;

Reclamation r;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }
    
    private void detailReclam(Reclamation reclam) {
              ServiceReclamation sr = new ServiceReclamation();
  description_reclamation.setText(reclam.getDescription_reclamation());
    etat_reclamation.setText(reclam.getEtat_reclamation());
    date_reclamation.setText(reclam.getDate_reclamation());
   
    }
    
}

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
//import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FrontOfferFXMLController implements Initializable {

    @FXML
    private TextField rechercher;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label nom_offrecol;
    @FXML
    private Label fruitPriceLabel;
    @FXML
    private ImageView fruitImg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
}
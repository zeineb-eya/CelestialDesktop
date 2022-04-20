/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Localisation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class DetailsLocalisationsController implements Initializable {

    @FXML
    private Label heuredepartdet;
    @FXML
    private Label heurearrivedet;
    @FXML
    private Label positiondepartdet;
    @FXML
    private Label positionarrivedet;
    @FXML
    private Label fussedet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    void initData(Localisation localisation) {
    heuredepartdet.setText(localisation.getHeureDepartLocalisation());
    heurearrivedet.setText(localisation.getHeureArriveeLoacalisation());
    positiondepartdet.setText(localisation.getPositionDepartLocalisation());
    positionarrivedet.setText(localisation.getPositionAriveePlanning());
    fussedet.setText(localisation.getFusee());
  }
    
}

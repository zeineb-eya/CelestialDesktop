/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import entities.Localisation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    @FXML
    private void mail(ActionEvent event) {
    try {
            Parent root = FXMLLoader.load(getClass().getResource("Mail.fxml"));
            positiondepartdet.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

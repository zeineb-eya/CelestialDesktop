/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Billet;
import com.mycompany.services.BilletService;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class BilletFrontController implements Initializable {
 ObservableList list ;
    @FXML
    private TableView<Billet> tabBillet;
    @FXML
    private TableColumn<Billet, Integer> id;
    @FXML
    private TableColumn<Billet, Integer> terminal;
    @FXML
    private TableColumn<Billet, Integer> portail;
    @FXML
    private TableColumn<Billet, Date> embarquement;
    @FXML
    private TableColumn<Billet, Integer> localisation;
    @FXML
    private TableColumn<Billet, Integer> chair_billet;
    @FXML
    private TableColumn<Billet, Integer> voyage_num;
    @FXML
    private Button ActualiserBillet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BilletService bs = new BilletService();
        List<Billet> Billets = bs.afficherBillets();
        
        list = FXCollections.observableList(Billets);
        tabBillet.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("id"));
        chair_billet.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("chair_billet"));
        voyage_num.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("voyage_num"));
        terminal.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("terminal"));
        portail.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("portail"));
        embarquement.setCellValueFactory(new PropertyValueFactory<Billet, Date>("embarquement"));
        localisation.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("localisation"));
      
    }    

    @FXML
    private void ActualiserBillet(ActionEvent event) {
        BilletService bs = new BilletService();
        List<Billet> Billets = bs.afficherBillets();
        
        list = FXCollections.observableList(Billets);
        tabBillet.setItems(list);
        id.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("id"));
        chair_billet.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("chair_billet"));
        voyage_num.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("voyage_num"));
        terminal.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("terminal"));
        portail.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("portail"));
        embarquement.setCellValueFactory(new PropertyValueFactory<Billet, Date>("embarquement"));
        localisation.setCellValueFactory(new PropertyValueFactory<Billet, Integer>("localisation"));
    }
    
}

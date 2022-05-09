/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.CategorieEquipement;
import entities.Equipement;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceCategorieEquipement;
import services.ServiceEquipement;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AfficherCFrontFXMLController implements Initializable {
 @FXML
    private TableView<Equipement> TVuser;
 @FXML
 ResourceBundle rb;
 @FXML
 URL url;
     @FXML
    private TextField idsupp;
    @FXML
    private TableColumn<CategorieEquipement,Integer> colidU;
    @FXML
    private TableColumn<CategorieEquipement, String> colnomU;
     
     @FXML
    private Label a;
  
   
         ObservableList list ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceCategorieEquipement ps = new ServiceCategorieEquipement();
        List<CategorieEquipement> personnes = ps.afficher();
        list = FXCollections.observableList(personnes);
       TVuser.setItems(list);
         colidU.setCellValueFactory(new PropertyValueFactory<CategorieEquipement, Integer>("id"));
    colnomU.setCellValueFactory(new PropertyValueFactory<CategorieEquipement, String>("nom_categorie_equipement"));
    }    
     @FXML
    private void RetourAjout(ActionEvent event) {
         
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCFXML.fxml"));
            Parent root = loader.load();
            AddCFXMLController controller = loader.getController();
            idsupp.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
         @FXML

     private void Delete(ActionEvent event) {
         
          ServiceCategorieEquipement ps = new ServiceCategorieEquipement();
           int x = Integer.parseInt(idsupp.getText());
        System.out.println(x);

        ps.Delete(x);
             initialize(url, rb);
        /*ps.afficher();*/


        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne Updated");
        a.show();
        }}
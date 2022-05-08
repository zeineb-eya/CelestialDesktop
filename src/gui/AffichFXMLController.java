/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import entities.Role;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AffichFXMLController implements Initializable {
 @FXML
    private TableView<User> TVuser;
 @FXML
 ResourceBundle rb;
 @FXML
 URL url;
     @FXML
    private TextField idsupp;
    @FXML
    private TableColumn<User,Integer> colidU;
    @FXML
    private TableColumn<User, String> colnomU;
     @FXML
    private TableColumn<User,String> colprenomU;
    @FXML
    private TableColumn<User,String> coladresseU;
     @FXML
    private TableColumn<User,String> colmailU;
    @FXML
    private TableColumn<User,String> colpasswordU;
     @FXML
    private TableColumn<User,String> colnumtelU;
     @FXML
    private TableColumn<User,Integer> colRoleU;
     @FXML
    private Label a;
  
   
         ObservableList list ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserService ps = new UserService();
        List<User> personnes = ps.recuperer();
        list = FXCollections.observableList(personnes);
       TVuser.setItems(list);
         colidU.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
    colnomU.setCellValueFactory(new PropertyValueFactory<User, String>("nom_utilisateur"));
    colprenomU.setCellValueFactory(new PropertyValueFactory<User, String>("prenom_utilisateur"));
       coladresseU.setCellValueFactory(new PropertyValueFactory<User, String>("adresse_utilisateur"));
    colmailU.setCellValueFactory(new PropertyValueFactory<User, String>("mail_utilisateur"));   
    colpasswordU.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
    colnumtelU.setCellValueFactory(new PropertyValueFactory<User, String>("numero_utilisateur"));
         colRoleU.setCellValueFactory(new PropertyValueFactory<User, Integer>("nom_role_id"));

    }    
     @FXML
    private void RetourAjout(ActionEvent event) {
         
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterUserFXML.fxml"));
            Parent root = loader.load();
            AjouterUserFXMLController controller = loader.getController();
            idsupp.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
         @FXML

     private void Delete(ActionEvent event) {
         
          UserService ps = new UserService();
           int x = Integer.parseInt(idsupp.getText());
        System.out.println(x);

        ps.Delete(x);  
        initialize(url,rb);


        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne Updated");
        a.show();
        }
     @FXML
    private void showchart(ActionEvent event){
       try {
           UserService p = new UserService();
           List<User> lp=p.recuperer();
    ObservableList<User> data=FXCollections.observableArrayList(lp);
            FXMLLoader chart= new FXMLLoader(getClass().getResource("chartAdress.fxml"));
            Parent root = chart.load();
            ChartController mc = chart.getController();
           
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Nombre d'equipements par etat");
            modifStage.setScene(scene);
            modifStage.show();
            
             ChartController controller = chart.getController();
        controller.setReclamationData();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(AffichFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

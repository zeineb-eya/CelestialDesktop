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
import javafx.scene.Node;
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
                 User b = (User) TVuser.getSelectionModel().getSelectedItem();

          UserService ps = new UserService();
       

        ps.Delete(b);  
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
     @FXML
    private void Modifier(ActionEvent event){
    User b = (User) TVuser.getSelectionModel().getSelectedItem();
   if(b==null){
        
           System.out.println("Aucun User séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucun User séléctionné");
            alert.showAndWait();
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass().getResource("UpdateFXML.fxml"));
        Scene scene=new Scene(loader.load());
        
       UpdateFXMLController Bc = loader.getController();
        
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
     
           int as=TVuser.getSelectionModel().getSelectedItem().getId();
              String c = TVuser.getSelectionModel().getSelectedItem().getNom_utilisateur();
           String v = TVuser.getSelectionModel().getSelectedItem().getPrenom_utilisateur();
                      String t  = TVuser.getSelectionModel().getSelectedItem().getMail_utilisateur();

           String x = TVuser.getSelectionModel().getSelectedItem().getPassword();
           String p  = TVuser.getSelectionModel().getSelectedItem().getNumero_utilisateur();
          // Date e  = TVuser.getSelectionModel().getSelectedItem().getEmbarquement();
          String l  = TVuser.getSelectionModel().getSelectedItem().getAdresse_utilisateur();
           
                   Bc.setData(TVuser.getSelectionModel().getSelectedItem().getId(),
                           TVuser.getSelectionModel().getSelectedItem().getNom_utilisateur(),
                           TVuser.getSelectionModel().getSelectedItem().getPrenom_utilisateur(),
                            TVuser.getSelectionModel().getSelectedItem().getMail_utilisateur(),

            TVuser.getSelectionModel().getSelectedItem().getPassword(),
           TVuser.getSelectionModel().getSelectedItem().getNumero_utilisateur(),
          TVuser.getSelectionModel().getSelectedItem().getAdresse_utilisateur()
           
                           
                   );
                           initialize(url,rb);

        } catch(IOException ex)
            {
            System.err.println("eer");
            }
        } }
}


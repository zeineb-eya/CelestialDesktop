/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Role;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.RoleService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AffichRoleController implements Initializable {
@FXML
    private TableView<Role> TVrole;
      @FXML
    private TextField idsuppR;
    @FXML
    private TableColumn<Role,String> colnomR;
    @FXML
    private TableColumn<Role, Integer> colidR;
     @FXML
    private TableColumn<Role,String> coldesR;
         ObservableList list ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    RoleService ps = new RoleService();
        List<Role> personnes = ps.recuperer();
        list = FXCollections.observableList(personnes);
       TVrole.setItems(list);
         colidR.setCellValueFactory(new PropertyValueFactory<Role, Integer>("id"));
    colnomR.setCellValueFactory(new PropertyValueFactory<Role, String>("nom_role"));
    coldesR.setCellValueFactory(new PropertyValueFactory<Role, String>("description_role"));
    }    
    @FXML
    private void RetourAjout(ActionEvent event) {
         
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterRoleFXML.fxml"));
            Parent root = loader.load();
            AjouterRoleFXMLController controller = loader.getController();
            idsuppR.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
    
     
    
    @FXML
     private void Delete(ActionEvent event) {
         
          RoleService ps = new RoleService();
           int x = Integer.parseInt(idsuppR.getText());
        System.out.println(x);

        ps.Delete(x);  

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle(" Role Supprimé!");
        a.show();
        }}



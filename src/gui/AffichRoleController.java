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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
                             Role p = new Role();

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
                          Role b = (Role) TVrole.getSelectionModel().getSelectedItem();

          RoleService ps = new RoleService();
          
        ps.Delete(b);  

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle(" Role Supprimé!");
        a.show();
        }


 
    @FXML
     private void Modifier(ActionEvent event) {
                          Role b = (Role) TVrole.getSelectionModel().getSelectedItem();

   if(b==null){
        
           System.out.println("Aucun Role séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucun Role séléctionné");
            alert.showAndWait();
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass().getResource("RoleUpdate.fxml"));
        Scene scene=new Scene(loader.load());
        
       RoleUpdateController Bc = loader.getController();
        
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
           int as=TVrole.getSelectionModel().getSelectedItem().getId();
              String c = TVrole.getSelectionModel().getSelectedItem().getNom_role();
           String v = TVrole.getSelectionModel().getSelectedItem().getDescription_role();
                     
           
                   Bc.setData(TVrole.getSelectionModel().getSelectedItem().getId(),
                           TVrole.getSelectionModel().getSelectedItem().getNom_role(),
                           TVrole.getSelectionModel().getSelectedItem().getDescription_role()
                            
                           
                   );

        } catch(IOException ex)
            {
            System.err.println("eer");
            }
        } }}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Role;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import services.RoleService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AjouterRoleFXMLController implements Initializable {
     RoleService us = new RoleService();

    @FXML
    private TextField tfnomR;
    @FXML
    private TextField tfdesR;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tfdesR.setText(null);
              tfnomR.setText(null);
    }    
     @FXML
    private void Ajouter(ActionEvent event) {
        if((tfnomR.getText()==null) ||  (tfdesR.getText()==null))
        { Alert a = new Alert(Alert.AlertType.ERROR);
                               a.setTitle("Remplissez Les Champs Vides");
                 String content = String.format("Tout les champs doivent etre remplies.");
        a.setContentText(content);
        a.show();   } 
        else {
        String nom = tfnomR.getText();
         String des = tfdesR.getText();
         Role r= new Role(nom,des);

        //User e=new User(7,"ab","ba","ba","ba","ba","ab");
        us.ajouter(r);
        //UserService ps = new UserService();
                              //ps.ajouter(p);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne ajoutée");
                 String content = String.format("L'Ajout du Role est éffectué avec succés.");
        a.setContentText(content);
                              
        a.show();
    }}
      @FXML
    private void Afficher(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichRole.fxml"));
            Parent root = loader.load();
            AffichRoleController controller = loader.getController();
            tfnomR.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @FXML

    private void Update(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("roleUpdate.fxml"));
            Parent root = loader.load();
            RoleUpdateController controller = loader.getController();
            tfnomR.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
 @FXML
    private void RetourAjout(ActionEvent event) {
         
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("choix.fxml"));
            Parent root = loader.load();
            ChoixController controller = loader.getController();
            tfnomR.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
}

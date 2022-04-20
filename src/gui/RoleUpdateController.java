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

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class RoleUpdateController implements Initializable {
 RoleService us = new RoleService();
  @FXML
    private TextField tfidR;
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
    }    
     @FXML
    private void Update(ActionEvent event) {
        Role p = new Role();
        int x = Integer.parseInt(tfidR.getText());
        p.setId(x);
          
                  p.setDescription_role(tfdesR.getText());
        p.setNom_role(tfnomR.getText());


        //User e=new User(7,"ab","ba","ba","ba","ba","ab");
        us.Update(p);
        //UserService ps = new UserService();
                              //ps.ajouter(p);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Role Modifié");
                 String content = String.format("L'Ajout du Role est éffectué avec succés.");
        a.setContentText(content);
                              
        a.show();
    }
      @FXML
    private void RetourAjout(ActionEvent event) {
         
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterRoleFXML.fxml"));
            Parent root = loader.load();
            AjouterRoleFXMLController controller = loader.getController();
            tfnomR.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
}

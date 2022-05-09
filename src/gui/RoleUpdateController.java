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
                        Role p = new Role();

            ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void Update(ActionEvent event) {
       if (p == null) {

            System.out.println("Choisir un Role");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Modifier Role");
            alert.setHeaderText(null);
            alert.setContentText("Le Role n'est pas modifié!");

            alert.showAndWait();
        }     
       else { 
       
        p.setNom_role(tfnomR.getText());
        p.setDescription_role(tfdesR.getText());
        
           RoleService ps = new RoleService();
                  System.out.println(p);

        ps.Update(p);   
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne Updated");
       System.out.println(tfnomR.getText());
        a.show();
      
    }}
    
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
    @FXML

     void setData(int id,String c,String v) {
        p.setId(id);
        tfnomR.setText(String.valueOf(c));
       tfdesR.setText(String.valueOf(v));
        
    }
}

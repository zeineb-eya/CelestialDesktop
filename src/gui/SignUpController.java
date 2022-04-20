/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class SignUpController implements Initializable {

  User u = new User();
    UserService us = new UserService();
    @FXML
    private TextField tfnomU;
    @FXML
    private TextField tfprenomU;
    @FXML
    private TextField tfadresseU;
   @FXML
    private TextField tfnumtelU;
    @FXML
    private TextField tfmailU;
    @FXML
    private TextField tfpasswordU;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void Ajouter(ActionEvent event) {
        
           
           //User p = new User();
        String nom = tfnomU.getText();
        String prenom = tfprenomU.getText();
        
         String mail = tfmailU.getText();
        String adresse = tfadresseU.getText();
                String pe = tfpasswordU.getText();
        String tel = tfnumtelU.getText();
System.out.println(tfpasswordU.getText().length());
      //  p.setNom_utilisateur(tfnomU.getText());
        //p.setPrenom_utilisateur(tfprenomU.getText());
        //p.setAdresse_utilisateur(tfadresseU.getText());    
        //p.setMail_utilisateur(tfmailU.getText());
        //p.setNumero_utilisateur(tfnumtelU.getText());
         //p.setPassword(tfpasswordU.getText());
       
                               User user = new User(mail,nom,prenom,adresse,pe,tel);

                                    System.out.println(user);
        //User e=new User(7,"ab","ba","ba","ba","ba","ab");
        us.ajouter(user);
        //UserService ps = new UserService();
                              //ps.ajouter(p);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne ajoutée");
                 String content = String.format("L'Ajout du User est éffectué avec succés.");
        a.setContentText(content);
                              
        a.show();
      try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformationUser.fxml"));
            Parent root = loader.load();
            InformationUserController controller = loader.getController();
            tfnomU.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       }
}

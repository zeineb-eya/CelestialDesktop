/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.CategoriePost.CategoriePost_FXMLController;
import gui.Commentaire.Commentaire_FXMLController;
import gui.Post.Post_FXMLController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class ChoixController implements Initializable {
 @FXML
    private TextField tfmailU;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
     @FXML

     private void User(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterUserFXML.fxml"));
            Parent root = loader.load();
            AjouterUserFXMLController controller = loader.getController();
            tfmailU.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @FXML
      private void Role(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterRoleFXML.fxml"));
            Parent root = loader.load();
            AjouterRoleFXMLController controller = loader.getController();
            tfmailU.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
      @FXML

     private void Equipement(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddFXML.fxml"));
            Parent root = loader.load();
            AddFXMLController controller = loader.getController();
            tfmailU.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @FXML
      private void CatEquipement(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCFXML.fxml"));
            Parent root = loader.load();
            AddCFXMLController controller = loader.getController();
            tfmailU.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
       @FXML

     private void catPost(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Commentaire_FXML.fxml"));
            
            Parent root = loader.load();
            Commentaire_FXMLController controller = loader.getController();
            tfmailU.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
}

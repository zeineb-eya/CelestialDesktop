/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import gui.AffichFXMLController;
import entities.User;
import java.io.IOException;
import static java.lang.System.console;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class UpdateFXMLController implements Initializable {
    @FXML
    private TextField tfnomU;
    @FXML
    private TextField tfidU;
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
    @FXML
    private TableView<User> TVuser;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tfpasswordU.setText(null);
              tfprenomU.setText(null);
         tfnomU.setText(null);
         tfmailU.setText(null);
         tfadresseU.setText(null);
         tfnumtelU.setText(null);
    }    
    
 @FXML
    private void Update(ActionEvent event) {
        if ((tfnomU.getText()== null) || (tfprenomU.getText()== null)|| (tfmailU.getText()== null)|| (tfpasswordU.getText()== null)|| (tfnumtelU.getText()== null)|| (tfadresseU.getText()== null)) {
                                    
                                Alert a = new Alert(Alert.AlertType.ERROR);
                               a.setTitle("Remplissez Les Champs Vides");
                 String content = String.format("Tout les champs doivent etre remplies.");
        a.setContentText(content);
        a.show();   }
                else {if((tfmailU.getText().matches("^(.+)@(.+)$")))
     
       { User p = new User();
        int x = Integer.parseInt(tfidU.getText());
        p.setId(x);
        p.setNom_utilisateur(tfnomU.getText());
        p.setPrenom_utilisateur(tfprenomU.getText());
        p.setAdresse_utilisateur(tfadresseU.getText());    
        p.setMail_utilisateur(tfmailU.getText());
        p.setNumero_utilisateur(tfnumtelU.getText());
        p.setPassword(tfpasswordU.getText());
           UserService ps = new UserService();
        ps.Update(p);   
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne Updated");
       System.out.println(tfprenomU.getText());
        a.show();
    } else 
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez une adresse Mail Valide");
                 String content = String.format("Adresse Mail non Valide.");
        a.setContentText(content);
                  a.show();
}
       } 
      
    }  
    
     @FXML
    private void RetourAjout(ActionEvent event) {
         
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterFXML.fxml"));
            Parent root = loader.load();
            AjouterFXMLController controller = loader.getController();
            tfprenomU.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
    
}

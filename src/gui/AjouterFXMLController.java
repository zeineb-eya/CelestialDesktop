/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.UserService;
import util.MyDB;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AjouterFXMLController implements Initializable {
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
     @FXML
    private TextField tfrole;
       @FXML
    private ComboBox<String> crole;
    
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
    private void Ajouter(ActionEvent event) {
         if ((tfnomU.getText()== null) || (tfprenomU.getText()== null)|| (tfmailU.getText()== null)|| (tfpasswordU.getText()== null)|| (tfnumtelU.getText()== null)|| (tfadresseU.getText()== null)) {
                                    
                                Alert a = new Alert(Alert.AlertType.ERROR);
                               a.setTitle("Remplissez Les Champs Vides");
                 String content = String.format("Tout les champs doivent etre remplies.");
        a.setContentText(content);
        a.show();   } 
       else {if((tfmailU.getText().matches("^(.+)@(.+)$") &&(tfnomU.getText().matches("[a-zA-Z_]+"))&&(tfprenomU.getText().matches("[a-zA-Z_]+"))&&(tfnumtelU.getText().matches("[0-9]+"))&&(tfpasswordU.getText().length()<6) ))
     
       {   
           
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
         String nomrole =  crole.getValue();

         String sql1="select id from role where nom_role='"+nomrole+"'";
                int nom_role_id=0;
                  try {
                Statement ste;
                Connection cnx;
                cnx = MyDB.getInstance().getConnection();
                ste = cnx.prepareStatement(sql1);
                ResultSet rs = ste.executeQuery(sql1);
                if(rs.next())
                {
                  nom_role_id=rs.getInt("id");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(AjouterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
                               User user = new User(nom_role_id,mail,nom,prenom,adresse,pe,tel);

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
       } else if(!tfmailU.getText().matches("^(.+)@(.+)$"))
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez une adresse Mail Valide");
                 String content = String.format("Adresse Mail non Valide.");
        a.setContentText(content);
                  a.show();
} else if (!tfnomU.getText().matches("[a-zA-Z_]+"))
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un nom de format valide");
                 String content = String.format("Nom ne doit pas contenir de caractere ou chiffres.");
        a.setContentText(content);
                  a.show();
} else if (!tfprenomU.getText().matches("[a-zA-Z_]+"))
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un prenom de format valide");
                 String content = String.format("Prenom ne doit pas contenir de caractere ou chiffres.");
        a.setContentText(content);
                  a.show();
}  else if (!tfnumtelU.getText().matches("[0-9]+")&& tfnumtelU.getText().length()<6)
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un num tel de format valide");
                 String content = String.format("Num tel ne doit pas contenir de Lettress.");
        a.setContentText(content);
                  a.show();
} else if (tfpasswordU.getText().length()<6)
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Mot de passe de taille invalide");
                 String content = String.format("Le mot de passe doit se former d'au moins 6 caractères.");
        a.setContentText(content);
                  a.show();
}
       } 
      
    }  
    
    
    @FXML
    private void Afficher(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichFXML.fxml"));
            Parent root = loader.load();
            AffichFXMLController controller = loader.getController();
            tfmailU.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        @FXML

    private void Update(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateFXML.fxml"));
            Parent root = loader.load();
            UpdateFXMLController controller = loader.getController();
            tfmailU.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
@FXML
    public void remplirCB(MouseEvent event) {
          
        try {
            String sql="select nom_role from role ";
            
            
            List<String> nm =new ArrayList<String>();
            PreparedStatement ste;
            Statement st;
            Connection cnx;
            cnx = MyDB.getInstance().getConnection();
            st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                
                nm.add(rs.getString("nom_role"));
                   crole.setItems(FXCollections.observableArrayList(nm));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AjouterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }    
    
     @FXML
    private void RetourAjout(ActionEvent event) {
         
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("choix.fxml"));
            Parent root = loader.load();
            ChoixController controller = loader.getController();
            tfmailU.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
}

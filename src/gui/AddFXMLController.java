/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Equipement;
import entities.User;
import javafx.scene.input.MouseEvent;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ServiceEquipement;
import services.UserService;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import util.MyDB;
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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AddFXMLController implements Initializable {
    @FXML
    private TextField tfnom;
    @FXML
    private ComboBox<String> tfetat;
    @FXML
    private TextField tfdes;
   @FXML
    private TextField tfimage;
    @FXML
    private TextField tfcat;
    @FXML
    private ComboBox<String> ceq;
   ServiceEquipement us=new ServiceEquipement();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfnom.setText(null);
              tfdes.setText(null);
         tfimage.setText(null);
         tfetat.getItems().removeAll(tfetat.getItems());
    tfetat.getItems().addAll("New", "Used");
    tfetat.getSelectionModel().select("New");
    }    
    
    @FXML
    private void Ajouter(ActionEvent event) {
        if ((tfnom.getText()== null) || (tfdes.getText()== null)|| (tfimage.getText()== null)) {
                                    
                                Alert a = new Alert(Alert.AlertType.ERROR);
                               a.setTitle("Remplissez Les Champs Vides");
                 String content = String.format("Tout les champs doivent etre remplies.");
        a.setContentText(content);
        a.show();   }
        else {if(((tfnom.getText().matches("[a-zA-Z_]+")) ))
        {
        String nom = tfnom.getText();
        String des = tfdes.getText();
        String etat = tfetat.getSelectionModel().getSelectedItem();
        String img = tfimage.getText();
        
       ;
 String nomrole =  ceq.getValue();
                String sql1="select id from categorie_equipement where nom_categorie_equipement='"+nomrole+"'";
                int categorie_equipement_id=0;
                  try {
                Statement ste;
                Connection cnx;
                cnx = MyDB.getInstance().getConnection();
                ste = cnx.prepareStatement(sql1);
                ResultSet rs = ste.executeQuery(sql1);
                if(rs.next())
                {
                  categorie_equipement_id =rs.getInt("id");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
              //recuperer user a ajouter
             Equipement e = new Equipement(categorie_equipement_id,nom,etat,des,img);
             us.ajouter(e);

   
//se.modifier(e1); 
//se.ajouter(p);
        //System.out.println( p );
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne ajoutée");
        a.show();
    }
        else if (!tfnom.getText().matches("[a-zA-Z_]+"))
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un nom de format valide");
                 String content = String.format("Nom ne doit pas contenir de caractere ou chiffres.");
        a.setContentText(content);
                  a.show();
}}}
    @FXML
    private void Afficher(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEqFXML.fxml"));
            Parent root = loader.load();
            AfficherEqFXMLController controller = loader.getController();
            tfnom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        @FXML

    private void Update(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierFXML.fxml"));
            Parent root = loader.load();
            UpdateEqFXMLController controller = loader.getController();
            tfnom.getScene().setRoot(root);  System.out.println("wsselt lehne");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
  
    @FXML
    
    public void remplirCB(MouseEvent event) {
          
        try {
            String sql="select nom_categorie_equipement from categorie_equipement ";
            
            
            List<String> nm =new ArrayList<String>();
            PreparedStatement ste;
            Statement st;
            Connection cnx;
            cnx = MyDB.getInstance().getConnection();
            st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                
                nm.add(rs.getString("nom_categorie_equipement"));
                   ceq.setItems(FXCollections.observableArrayList(nm));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AjouterEqFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }  

}

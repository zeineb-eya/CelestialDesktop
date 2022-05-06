/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.CategorieEquipement;
import entities.Equipement;
import entities.User;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceCategorieEquipement;
import services.ServiceEquipement;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AddCFXMLController implements Initializable {
   
    @FXML
    private TextField tfcat;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void Ajouter(ActionEvent event) {
        if ((tfcat.getText()== null) ) {
                                    
                                Alert a = new Alert(Alert.AlertType.ERROR);
                               a.setTitle("Remplissez Les Champs Vides");
                 String content = String.format("Tout les champs doivent etre remplies.");
        a.setContentText(content);
        a.show();   }
        else {if(((tfcat.getText().matches("[a-zA-Z_]+")) ))
        {
        CategorieEquipement p = new CategorieEquipement();
       
        
        p.setNom_categorie_equipement(tfcat.getText());
          //ServiceCategorieEquipement ps = new ServiceCategorieEquipement();
        /*ps.ajouter(p);*/
        ServiceCategorieEquipement se=new ServiceCategorieEquipement();
        //Equipement e1=new Equipement(87,"aaa","aa","eeee","hjj");
        //Sponsor s4=new Sponsor("d","d","e",5,"f","r");
//Sponsor s5=new Sponsor(91,"dd","d","e",5,"f","r");
//Evennement e1=new Evennement(71,"bbbb",d,"e","j",2,"y",s5);
//Sponsor s4=new Sponsor("d","d","e",5,"f","r");
//Sponsor s5=new Sponsor(91,"dd","d","e",5,"f","r");
//Evennement e1=new Evennement(71,"bbbb",d,"e","j",2,"y",s5);

//se.modifier(e1); 
se.ajouter(p);
        System.out.println( p );
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne ajoutée");
        a.show();
    }else if (!tfcat.getText().matches("[a-zA-Z_]+"))
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un nom de format valide");
                 String content = String.format("Nom ne doit pas contenir de caractere ou chiffres.");
        a.setContentText(content);
                  a.show();
}
        }
    }
    @FXML
    private void Afficher(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCFXML.fxml"));
            Parent root = loader.load();
            AfficherCFXMLController controller = loader.getController();
            tfcat.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        @FXML

    private void Update(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCFXML.fxml"));
            Parent root = loader.load();
            ModifierCFXMLController controller = loader.getController();
            tfcat.getScene().setRoot(root);  System.out.println("wsselt lehne");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}

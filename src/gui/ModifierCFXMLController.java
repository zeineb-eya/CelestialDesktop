/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import entities.CategorieEquipement;
import entities.Equipement;
import gui.AfficherEqFXMLController;
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
import services.ServiceCategorieEquipement;
import services.ServiceEquipement;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class ModifierCFXMLController implements Initializable {
    @FXML
    private TextField tfcatU;
    @FXML
    private TextField tfidU;
    @FXML
    private TableView<User> TVuser;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
 @FXML
    private void Update(ActionEvent event) {
        if ((tfcatU.getText()== null)||(tfidU.getText()== null) ) {
                                    
                                Alert a = new Alert(Alert.AlertType.ERROR);
                               a.setTitle("Remplissez Les Champs Vides");
                 String content = String.format("Tout les champs doivent etre remplies.");
        a.setContentText(content);
        a.show();   }
        else{if(((tfcatU.getText().matches("[a-zA-Z_]+"))&&(tfidU.getText().matches("[0-9]+")) ))
        {
        
        CategorieEquipement p = new CategorieEquipement();
        int x = Integer.parseInt(tfidU.getText());
        p.setId(x);
        p.setNom_categorie_equipement(tfcatU.getText());
        
           //ServiceEquipement ps = new ServiceEquipement();
        //ps.modifier(p);   
        ServiceCategorieEquipement se=new ServiceCategorieEquipement();
        //Equipement e1=new Equipement(116,87,"hii3aaaaih","hiiih","stones","hjj");
        se.modifier(p);
        

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne Updated");
       System.out.println(tfcatU.getText());
        a.show();
    }else if (!tfcatU.getText().matches("[a-zA-Z_]+"))
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un nom de format valide");
                 String content = String.format("Nom ne doit pas contenir de caractere ou chiffres.");
        a.setContentText(content);
                  a.show();
}
                 else if (!tfidU.getText().matches("[0-9]+")&& tfidU.getText().length()<6)
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un ID de format valide");
                 String content = String.format("ID ne doit pas contenir de Lettress.");
        a.setContentText(content);
                  a.show();
}
        }}
     @FXML
    private void RetourAjout(ActionEvent event) {
         
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCFXML.fxml"));
            Parent root = loader.load();
            AddCFXMLController controller = loader.getController();
            tfcatU.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
    
}

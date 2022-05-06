/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import entities.Equipement;
import gui.AfficherEqFXMLController;
import entities.User;
import java.io.IOException;
import static java.lang.System.console;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import services.ServiceEquipement;
import services.UserService;
import util.MyDB;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class UpdateEqFXMLController implements Initializable {
    @FXML
    private TextField tfnomU;
    @FXML
    private TextField tfidU;
    @FXML
    private TextField tfcatU;
    @FXML
    private TextField tfetatU;
   @FXML
    private TextField tfdesU;
    @FXML
    private TextField tfimgU;
    @FXML
    private ComboBox<String> ceq;
    @FXML
    private TableView<User> TVuser;
       ServiceEquipement us=new ServiceEquipement();

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfnomU.setText(null);
              tfdesU.setText(null);
         tfetatU.setText(null);
         tfimgU.setText(null);
    }    
    
 @FXML
    private void Update(ActionEvent event) {
         if ((tfnomU.getText()== null) || (tfdesU.getText()== null)|| (tfetatU.getText()== null)|| (tfimgU.getText()== null)) {
                                    
                                Alert a = new Alert(Alert.AlertType.ERROR);
                               a.setTitle("Remplissez Les Champs Vides");
                 String content = String.format("Tout les champs doivent etre remplies.");
        a.setContentText(content);
        a.show();   }
       else {if(((tfnomU.getText().matches("[a-zA-Z_]+"))&&(tfetatU.getText().matches("[a-zA-Z_]+"))&&(tfidU.getText().matches("[0-9]+")) ))
        {
        
        int id=Integer.parseInt(tfidU.getText());
        String nom = tfnomU.getText();
        String des = tfdesU.getText();
        String etat = tfetatU.getText();
        String img = tfimgU.getText();
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
                Logger.getLogger(UpdateEqFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
              //recuperer use\\r a ajouter
             Equipement e = new Equipement(id,categorie_equipement_id,nom,etat,des,img);
             us.modifier(e);
             System.out.println(e);
        

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne Updated");
       System.out.println(tfnomU.getText());
        a.show();
    }else if (!tfnomU.getText().matches("[a-zA-Z_]+"))
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un nom de format valide");
                 String content = String.format("Nom ne doit pas contenir de caractere ou chiffres.");
        a.setContentText(content);
                  a.show();
} else if (!tfetatU.getText().matches("[a-zA-Z_]+"))
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un etat de format valide");
                 String content = String.format("Etat ne doit pas contenir de caractere ou chiffres.");
        a.setContentText(content);
                  a.show();}
         else if (!tfidU.getText().matches("[0-9]+")&& tfidU.getText().length()<6)
               
               
           {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Entrez un ID de format valide");
                 String content = String.format("ID ne doit pas contenir de Lettress.");
        a.setContentText(content);
                  a.show();
}}}
     @FXML
    private void RetourAjout(ActionEvent event) {
         
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddFXML.fxml"));
            Parent root = loader.load();
            AddFXMLController controller = loader.getController();
            tfnomU.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
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

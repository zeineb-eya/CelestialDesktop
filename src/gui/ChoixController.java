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
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class ChoixController implements Initializable {
 @FXML
    private TextField tfmailU;
    @FXML
    private Button GestionBillet;
    @FXML
    private Button GestionReservation;
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
    private void onClickCommentaire_btn(ActionEvent event) {
               this.getForm ("../gui//Commentaire/Commentaire_FXML.fxml");
    }
    @FXML
    private void onClickPost_btn(ActionEvent event) {
               this.getForm ("../gui//Post/Post_FXML.fxml");
    }
    @FXML
    private void onClickCatPost_btn(ActionEvent event) {
               this.getForm ("../gui//CategoriePost/CategoriePost_FXML.fxml");
    }
         @FXML
private void getForm (String src) {
                  try {                            System.out.println("getForm1");

                           Parent root = FXMLLoader.load(getClass().getResource(src)); 

                           Stage stage = new Stage();
                           
                           Scene scene = new Scene(root);
                           stage.setScene(scene);  
                           System.out.println("getForm");
                           // Specifies the modality for new window.
                           stage.initModality(Modality.WINDOW_MODAL);  
                           stage.setTitle("Edit");
                           Image mylmage = new Image( "img/gui_edit_icon.png" );
                           stage.getIcons().add( mylmage );// tasswira 3ala jnab fo9 ki na3mil min fo9 twali auto min lota*/ 
                           Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                           stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                           stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2); 
                           stage.show(); 
                      } 
                  catch ( Exception ex) {   System.out.println("getForm : "+ex.getMessage());  }   
    }

    @FXML
    private void GestionBillet(ActionEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/mycompany/gui/ListBillet.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void GestionReservation(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/mycompany/gui/ListReservation.fxml"));
           // loader.setLocation(getClass().getResource("Reslisttest.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void GestionPlaninng(ActionEvent event) {
          try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AjouPlaninng.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void GestionLoca(ActionEvent event) {
          try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AjoutLocalisation.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gestionOffreButton(ActionEvent event) {
             try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AfficherOffreFXML.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }

    @FXML
    private void gestionReclamButton(ActionEvent event) {
          try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/ReclamationAdminFXML.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }
     
}

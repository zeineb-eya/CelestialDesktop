/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.FirstPage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khawl
 */
public class FirstPage_FXMLController implements Initializable {

    @FXML
    private Button onClickPost_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickCommentaire_btn(ActionEvent event) {
               this.getForm ("/GUI/Commentaire/Commentaire_FXML.fxml");
    }

    @FXML
    private void onClickCategorie_btn(ActionEvent event) {
        this.getForm ("/GUI/CategoriePost/CategoriePost_FXML.fxml");
    }

    @FXML
    private void onClickPost_btn(ActionEvent event) {
        this.getForm ("/GUI/Post/Post_FXML.fxml");
    }
    
    
    
    
    private void getForm (String src) {
                  try {
                           Parent root = FXMLLoader.load(getClass().getResource(src)); 
                           Stage stage = new Stage();
                           Scene scene = new Scene(root);
                           stage.setScene(scene);  
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
}

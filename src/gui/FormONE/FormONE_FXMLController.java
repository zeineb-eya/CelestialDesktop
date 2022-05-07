/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.FormONE;

import gui.FormONE.InstanceHolder.ClassElementsControllers;
import gui.FormONE.LoadingCenter.Blog_Pannel.ListItemPost.BlogPost_FXMLController;
import gui.FormONE.LoadingCenter.Blog_Pannel.ListView.ListBlog_FXMLController;
import Libs.Page;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FormONE_FXMLController implements Initializable {

    @FXML
    private BorderPane bp;
    private Page objPage;
    @FXML
    private AnchorPane defaultAnchorPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
         objPage = new Page (  ) ; 
         // ClassControllerSpeach.getInstance().Str_text = "AAAAAAAAAAAAA";
         ClassElementsControllers.FormONEBorderPane = bp;
         ClassElementsControllers.Str_text = "AAA";
            // ClassControllerSpeach.getInstance().SetText("AAAAAAAAAAAAA");
            new Page (  ).loadpage (   ClassElementsControllers.FormONEBorderPane ,  BlogPost_FXMLController.URL_FORM  );
      
    }    

//   String [] data = {"AAAAAAAAAAAAAAAAAAAAA", "AAAAAAbbbbbAA"};
  //BlogChoiceBox.getItems().addAll(data);  BlogChoiceBox.setOnAction ( this::GetBlog);
/*public void GetBlog( ActionEvent event  ) {
      P. loadpage (   ClassElementsControllers.FormONEBorderPane , "/GUI/FormONE/LoadingCenter/Blog_Pannel/BlogPost_FXML.fxml"  );
}*/
    @FXML
    private void home_button_click(MouseEvent event) {
          //bp.setCenter(ap);
          objPage. loadpage ( ClassElementsControllers.FormONEBorderPane ,"/GUI/FormONE/LoadingCenter/Blog_Pannel/Home_FXML.fxml"  );
    }
    
    @FXML
    private void Account_button_Click(MouseEvent event) {
       
    }

    @FXML
    private void Service_button_Click(MouseEvent event) {
            try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/FrontOffreFXML.fxml"));
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
    private void Trips_button_Click(MouseEvent event) {
    }

    @FXML
    private void Reservation_button_Click(MouseEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/mycompany/gui/ReservationFront.fxml"));
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
    private void Equipement_button_Click(MouseEvent event) {
    }

    @FXML
    private void Blog_button_Click(MouseEvent event) {
   
  
    if ( !objPage.isOpen( ClassElementsControllers.FormOne_ListBLog ) )
       {
        ClassElementsControllers.FormOne_ListBLog = objPage. addNewForm (  ListBlog_FXMLController.URL_FORM,"img/clipboard_notes_icon.png","",true ); 
        ClassElementsControllers.FormOne_ListBLog.show(); 
        objPage.scene.setFill( Color.TRANSPARENT);
        objPage.setPostonByPointerCursor ( ); 
       } 
    }
    @FXML
    private void Contact_button_Click(MouseEvent event) {
    }

    @FXML
    private void Reclamer_button_Click(MouseEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AjoutReclamationFXML.fxml"));
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

    
    
     
 /*   private void loadpage ( String url ) {
                Parent root= null;
                try {
                      root = FXMLLoader.load(getClass().getResource(url));
                    }
                catch (Exception e ){System.out.println(e.getMessage());}
                bp.setCenter ( root );
                }*/

    @FXML
    private void Billet_button_Click(MouseEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/mycompany/gui/BilletFront.fxml"));
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

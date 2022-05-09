/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.FormONE.LoadingCenter.Blog_Pannel.ListView;

import gui.FormONE.InstanceHolder.ClassElementsControllers;
import gui.FormONE.LoadingCenter.Blog_Pannel.ListItemPost.BlogPost_FXMLController;
import Libs.Page;
import entities.CategoriePost;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import services.CategoriePostService;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ListBlog_FXMLController implements Initializable {

    @FXML
    private ListView<String> Blog_ListView;
    @FXML
    private AnchorPane ListBlogPane;
    @FXML
    private Text textListBloc;
    
    static public final String URL_FORM = "/gui/FormONE/LoadingCenter/Blog_Pannel/ListView/ListBlog_FXML.fxml";
    static public  CategoriePost ChoiceCategoriePost = null;
    List<CategoriePost> list_Categorie ;
    /**
     * Initializes the controller class.
     */
     //Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //   textListBloc.setText( ClassControllerSpeach.getInstance().GetText());
        //textListBloc.setText( ClassElementsControllers.Str_text ) ;
        //   new CategoriePost ()
       ChoiceCategoriePost = null;
       Blog_ListView.getItems().clear();
       this.list_Categorie = new CategoriePostService(). recuperer(); 
       List<String> list =new ArrayList<String>();
       for( CategoriePost Categorie : this.list_Categorie)
          { 
            list.add(  Categorie.getNom_categorie_post() );    
          }  
       Blog_ListView.getItems().addAll( list );
    }    
 
   @FXML
    private void Blog_ListView_OnMouseClicked(MouseEvent event) { 
                 String ChoiceNomCategorie =  Blog_ListView.getSelectionModel().getSelectedItem(); 
                 for( CategoriePost Categorie : this.list_Categorie)
                    { 
                      if (Categorie.getNom_categorie_post() ==   ChoiceNomCategorie  ) { ChoiceCategoriePost = Categorie; }
                    }                 
                 new Page (  ).loadpage (ClassElementsControllers.FormONEBorderPane ,  BlogPost_FXMLController.URL_FORM   );
                 ClassElementsControllers.FormOne_ListBLog.close(); 
                 //methode pour fermer fasade de ListBlog 
                 // Stage stage = (Stage)  ListBlogPane.getScene().getWindow();
                 // stage.close(); 
    }

 
    

    @FXML
    private void ListBlogPane_OnMouseExcited(MouseEvent event) {
                 ClassElementsControllers.FormOne_ListBLog.close(); 
                  //methode pour fermer fasade de ListBlog   
                  //  Stage stage = (Stage)  ListBlogPane.getScene().getWindow();
                  //  stage.close();
    } 
   

    
}

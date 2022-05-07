/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Post.ListView;

import  Libs.FileManagement;
import entities.Post;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
/**
 *
 * @author HP
 */
public class ListViewController_Post extends ListCell<Post> {
    @FXML
    private GridPane gridPane;
    @FXML
    private Label id;  
    @FXML
    private Label UserID;
    @FXML
    private ImageView imageview;
    @FXML
    private Label CategoriePostID;
    @FXML
    private Label Nom;
    @FXML
    private TextArea Description;
            
    private FXMLLoader mLLoader;  
    
     
    
    
   @Override
    protected void updateItem(Post Post, boolean empty) {
                   super.updateItem(Post, empty); 
                   if(empty || Post == null) 
                     { 
                      setText(null);
                      setGraphic(null); 
                     } 
                   else {
                          if (mLLoader == null) 
                             {
                                mLLoader = new FXMLLoader(getClass().getResource("/GUI/Post/ListView/PostListViewCell_FXML.fxml"));
                                mLLoader.setController(this); 
                                try {
                                      mLLoader.load();
                                    }
                                catch (IOException e) {
                                                        // e.printStackTrace(); 
                                                        System.out.println("ListViewController_Post" + e.getMessage()); 
                                                       }  
                             } 
                          id.setText(String.valueOf(Post.getId()));
                          UserID.setText(String.valueOf(Post.getUserId()));
                          CategoriePostID.setText(String.valueOf(Post.getCategoriePost_ID()));
                          Nom.setText(Post.getNom());
                          Description.setText(String.valueOf(Post.getDescription_post()));   
                           
                         // imageview.setImage(Post.getImg_post());  
                          imageview.setImage(new FileManagement ( ).writeBytesToImage( Post.getByte_img_post() )   ); 
                          imageview.setFitHeight(75);
                          imageview.setFitWidth(75); 

                          setText(null);
                          setGraphic(gridPane);
                        } 
                    } 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.FormONE.LoadingCenter.Blog_Pannel.ListItemPost.ItemPost;

/**
 *
 * @author HP
 */

import gui.FormONE.LoadingCenter.Blog_Pannel.ListItemPost.ListenerItemPostController;
import Libs.FileManagement;
import Libs.TextString;
import entities.Post;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
public class ItemPostController implements Initializable {
    @FXML
    private Label title; 
    @FXML
    private ImageView image; 
    @FXML
    private Text description;
  //   private Post post ;  
    static public Post static_post  ;
    public Post post  ;
    static public final String URL_FORM = "/gui/FormONE/LoadingCenter/Blog_Pannel/ListItemPost/ItemPost/ItemPost_FXML.fxml";
    private ListenerItemPostController mylistener ;
    static public ListenerItemPostController  listener ;
  @Override
    public void initialize(URL url, ResourceBundle rb) {
      mylistener = listener;  
      this.post = static_post;
     title.setText( static_post.getNom()); 
     image.setImage(    new FileManagement().writeBytesToImage(   static_post.getByte_img_post() )      );
     description.setText(TextString.textSeparator( static_post.getDescription_post() , 30) ) ;
    }

    @FXML
    private void ItemPostControllerBox_OnClock(MouseEvent event) {
            this.static_post = post; 
            System.out.println( this.static_post.getNom() );
            mylistener.onClickListener(post);
            
    }
     
      
}

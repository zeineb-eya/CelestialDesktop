/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Post.ListView;

/**
 *
 * @author khawl
 */
import  Libs.FileManagement;
import gui.Post.ListView.ListViewController_Post;
import entities.Post;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import services.PostService;
public class ListViewPost  extends PostService  {
           
    
    
           
               public List<Post> ListePost;
              public ListView<Post> List_Post;  
              private final ObservableList<Post> PostObservableList = FXCollections.observableArrayList(); 
               public  ListViewPost( ){   } 
              public  ListViewPost(ListView<Post> List_Post){
                  this.List_Post   = List_Post;   
                    this.List_Post.setItems(this.PostObservableList);
                    this.List_Post.setCellFactory(List_Postx -> new ListViewController_Post());   
              } 
         

              
              
              

    /*   public List<Post> recuperer() {
            List<Post> list =new ArrayList<>();
           for ( int i = 1 ; i< 9 ; i++){      
                list.add(  new Post(i,i,i, "France " + i,   new Image("img/empty_file_icon.png")  , "description_post "+i  ));
           }
           return list;
    }*/
              
              
                     public List<Post> recuperer() {
            List<Post> list =new ArrayList<>();
           for ( int i = 1 ; i< 15 ; i++){ 
                /* Post p = new Post();
                 p.setId(i); 
                  p.setNom("Nom "+i);
                  //p.setImg_post(new Image( "img/481px-Cat03.png" )); 
                  p.setImgLink_post("img/481px-Cat03.jpg"); // p.setImgLink_post("//img"+i);
                  p.setDescription_post("Description_post"+i); 
                  p.setCategoriePost_ID(i); 
                   list.add(p);*/
              
    list.add(  new Post(i,i,i, "France " + i,  new FileManagement(). readImageAsBytes(   new Image("img/empty_file_icon.png") )    , "description_post "+i  ));
           }
           return list;
    }
       public void refrechListView() {  
               
               this.ListePost =this.recuperer();  
                PostObservableList.clear () ;   
               PostObservableList.addAll( this.ListePost ); 
                  
                }
    
       
        private  String [] getListChoiceBox() { 
                            List<String> list =new ArrayList<String>();  // assna3 list type string 5ater list 5ir  
                            for( Post uneCommentaire : ListePost) {// ili jbito min base effrizhomlo wa7da wa7da kol ligne ya3ni index 
                            list.add( Integer.toString( uneCommentaire.getCategoriePost_ID()));    }  
                            String [] ids =  list.toArray(new String[0]);//ki jbitha list yilzim narja3ha tab pour transfert list en tableaus 5ater choice tifhim array  
                            return ids;
                           }    
       
    
}


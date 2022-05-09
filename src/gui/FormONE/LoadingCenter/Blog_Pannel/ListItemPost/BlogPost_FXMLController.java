/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.FormONE.LoadingCenter.Blog_Pannel.ListItemPost;


import gui.FormONE.LoadingCenter.Blog_Pannel.ListItemPost.ItemPost.ItemPostController;
import gui.FormONE.LoadingCenter.Blog_Pannel.ListView.ListBlog_FXMLController;
import gui.Message.LibMessageBox;
import Libs.FileManagement;
import Libs.TextString;
import entities.Commentaire;
// import GUI.Post.ListViewPost;
import entities.Post; 

import javafx.geometry.Insets;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import org.controlsfx.control.Rating;
import services.CommentaireService;
import services.PostService;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class BlogPost_FXMLController extends LibMessageBox implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;
    private List <String> POST_items = new ArrayList<>();
    static public final String URL_FORM = "/gui/FormONE/LoadingCenter/Blog_Pannel/ListItemPost/BlogPost_FXML.fxml";
    private Commentaire objCommentaire ;
    private List <Post> ListPost = new ArrayList<>(); 
    @FXML
    private TextField searchPost;
    @FXML
    private Label TitleChosen;
    @FXML
    private ImageView ImageChosen;
    @FXML
    private Label DescriptionChosen;
    @FXML
    private TextField SaiseCommentaire;
    @FXML
    private Button ButtonCommentaire;
    @FXML
    private TextArea ListMessagesCommentairesChosen;
    @FXML
    private Rating RatingCommentChosen;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            this.objCommentaire   = new Commentaire ( );
         ButtonCommentaire.setDisable(true);
        System.out.println("ChoiceCategoriePost  "+ListBlog_FXMLController.ChoiceCategoriePost);
        
        
     this.objCommentaire.setPost(-1);  
      this.refreshContent();

    }    
    
    
    
    private void refreshContent(){ 
      // this.ListPost = new  PostService().recuperer(); // POST = new ListViewPost().recuperer();
       // this.setDataItems ( this.ListPost ) ;
       if (ListBlog_FXMLController.ChoiceCategoriePost != null) 
           {
            ListPost =  new  PostService().RechercherWithCathegorieId(ListBlog_FXMLController.ChoiceCategoriePost.getId());
            this.setDataItems ( ListPost ) ;
           }
    }
    
    
    private void setChosenPostOnCard ( Post POST ){
        this.objCommentaire.setPost(POST.getId());
       TitleChosen.setText( POST.getNom());    
       ImageChosen.setImage(    new FileManagement().writeBytesToImage(   POST.getByte_img_post() )      );   
       DescriptionChosen.setText(  TextString.textSeparator( POST.getDescription_post() , 30) ) ;  
       List<Commentaire> ListCommentaire =  new CommentaireService().     RechercherCategorie(   String.valueOf(    POST.getId())     ) ; 
       String CommentaireChosen = (ListCommentaire.size()>0 ?"":" Vide ");
       // CommentaireChosen += "1" +System.lineSeparator() +"2"+System.lineSeparator()+"3"+System.lineSeparator()+"4"+System.lineSeparator();
       for (int i = 0 ; i<ListCommentaire.size(); i++ )
                  {
                     CommentaireChosen += "-> " + ListCommentaire.get(i).getDate_commentaire() + "   " + ListCommentaire.get(i).getMsg_commentaire() +System.lineSeparator();
                  }
       ListMessagesCommentairesChosen .setText( CommentaireChosen)  ;
       
       //System.out.println(   POST.getId());
       //System.out.println(   ListCommentaire.size());
       //SaiseCommentaire
    }
    private ListenerItemPostController mylistener ;
    private void setDataItems ( List <Post> ListPost ) {   
        grid.getChildren().clear();
       // grid. 
        int column = 0;
        int row = 0;
        try {
          
            if ( ListPost.size()>0 ){  
                 ButtonCommentaire.setDisable(false);
              //  this.setChosenPostOnCard(ListPost.get(0)   );   
            mylistener = new  ListenerItemPostController () {
                @Override
                public void onClickListener( Post post){
                   setChosenPostOnCard (   post );
                } 
            }; 
            }
           else {  ButtonCommentaire.setDisable(true);   this.objCommentaire.setPost(-1);}
               
                //  System.out.println("AAA"+ListPost.size());
              for (int i = 0 ; i<ListPost.size(); i++ )
                  {
                   FXMLLoader FxmlLoader = new FXMLLoader ( );
                   FxmlLoader.setLocation(getClass().getResource(ItemPostController.URL_FORM)); 
                    // ItemPostController  itemcontroller     = (ItemPostController)FxmlLoader.getController(); 
                    // itemcontroller.set_Data("AAAAAA"); 
                    ItemPostController.static_post =  ListPost.get(i);
                    ItemPostController.listener = mylistener;
                    AnchorPane anotherpane =   FxmlLoader.load();   
                   if (column ==4) {column = 0 ; row++;}
                   grid.add(anotherpane,column ,row ); 
                   grid.setAlignment(Pos.CENTER);
                   column++;
                   grid.setHgap(10);
                   grid.setVgap(10);
                   //grid.setGridLinesVisible(true);
                   System.out.println( grid.getLayoutBounds().getWidth());
                   GridPane.setMargin(anotherpane, new Insets(10));
                   grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                   grid.setPrefWidth(Region.USE_COMPUTED_SIZE); 
                   grid.setMaxWidth(Region.USE_PREF_SIZE); 
                   grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                   grid.setPrefHeight(Region.USE_COMPUTED_SIZE); 
                   grid.setMaxWidth(Region.USE_PREF_SIZE); 
                  }
              grid.setPadding(new Insets(5,5,5,5));
            }
        catch( Exception e ){e.printStackTrace();} 
        }

    @FXML
    private void ButtonCommentaire_OnClick(MouseEvent event) {
    
     
    
     String textFiltred = new TextString().filterText(SaiseCommentaire.getText());
     this.objCommentaire.setMsg_commentaire(textFiltred);
     
      if ( this.objCommentaire.getPost()== -1){ Alert ("Erreur selection ! " , " post est vide selon votre choix categorie") ; return;}
            if ((this.objCommentaire.getMsg_commentaire().length() == 0 )|| (objCommentaire.getMsg_commentaire() == null)){
               Alert ("Erreur saisir message commentaire " , " Champs nmessage commentaire est vide  ") ; 
               return;}
            
     LocalDate Date = LocalDate.now();
     String Format_Date = Date.format(DateTimeFormatter.ofPattern( "yyyy-MM-dd" ));//transfert sous format yyyy-mm-dd
     this.objCommentaire.setDate_commentaire(  Format_Date  ); 
     this.objCommentaire.setrating(RatingCommentChosen.getRating());//na5ith rating se forme double 
     new CommentaireService().ajouter(this.objCommentaire);
     //this.refreshContent();
     
     
             String Nom = searchPost.getText();
        this.ListPost =  new  PostService(). RechercherWithNom(Nom) ; 
       //     System.out.println("rechercherOnKeyReleased"+ ListPost.size());
        this.setDataItems ( this.ListPost ) ;
        
        
     SaiseCommentaire.setText ("");
     RatingCommentChosen.setRating(0);
     this.objCommentaire.setPost(-1); 
    }

    @FXML
    private void rechercherOnKeyReleased(KeyEvent event) { 
        String Nom = searchPost.getText();
        this.ListPost =  new  PostService(). RechercherWithNom(Nom) ; 
       //     System.out.println("rechercherOnKeyReleased"+ ListPost.size());
        this.setDataItems ( this.ListPost ) ;
    }
    
}
   
 

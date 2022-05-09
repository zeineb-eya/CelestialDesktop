/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Post;


import  Libs.FileManagement;
import gui.Message.LibMessageBox;
import gui.Post.ListView.ListViewPost;
import entities.CategoriePost;
import entities.Post;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import services.PostService;
import javafx.scene.image.ImageView;
import services.CategoriePostService;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class Post_FXMLController extends LibMessageBox implements Initializable {

    @FXML
    private Button ajout_Post;
    @FXML
    private Button Modifier_Post;
    @FXML
    private Button suprimer_Post;
    @FXML
    private ListView<Post> List_Post;
    @FXML
    private TextField recherche_Post;
    @FXML
    private Button lire_Post;
    @FXML
    private TextField IdPost;
    @FXML
    private TextField NomPost;
    @FXML
    private ChoiceBox<String> CategoriePostIDPost;
    @FXML
    private TextField UserIdPost;
    @FXML
    private TextField DescriptionPost;
    @FXML
    private Button ImagePostSelection;

    /**
     * Initializes the controller class.
     */
     private List<Post> ListePost; 
     private List<CategoriePost> ListCategorie; 
    private PostService objPostService;
    
       private Post objPost ;  
       private ListViewPost   listviewpostCustom; 
       FileManagement obj_FileManagement ;
      CategoriePostService  objCategoriePostService;
    @FXML
    private ImageView imagekkkk;
    /// Image mylmage = new Image(getClass().getResourceAsStream("shrek2.jpg"));
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        objPost = new Post ( );
         objPostService = new PostService ( ) ; 
         //this.ListeCommentaire=this.recuperer();  
             objCategoriePostService =       new CategoriePostService();  
                 listviewpostCustom = new ListViewPost ( List_Post) ;  
                 listviewpostCustom.refrechListView( );
                  CategoriePostIDPost.getItems().addAll(this.getListChoiceBox()); 
                   System.out.println( CategoriePostIDPost.getItems().addAll(this.getListChoiceBox()));
                 obj_FileManagement = new FileManagement();
                 
                 // System.out.println("SSS"+ obj_FileManagement.readImageAsBytes(new Image("img/empty_file_icon.png")).length); 
                //  obj_FileManagement.writeBytesToImage();
             //  imagekkkk.setImage(new Image(obj_FileManagement.targetStream )); 
    }    

    @FXML
    private void onClickAjoutPost(ActionEvent event) {
        
         try {
                         
            int CategoriePost_ID  = objCategoriePostService.findID_Categorie( CategoriePostIDPost.getValue());
                objPost.setCategoriePost_ID(  CategoriePost_ID );//   Integer.parseInt(     CategoriePostIDPost.getValue()));   //????????
  
             }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre Categorie ID" , " Champs Categorie ID est vide  ") ; 
               return;
           }
        try {
                objPost.setUserId(   Integer.parseInt(      UserIdPost.getText()   )     );
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre User Post" , "  Champs User Id  est vide   ") ; 
               return;
           }   
         objPost.setNom(NomPost.getText( ) ); 
           if ((objPost.getNom().length() < 3 )|| (objPost.getNom()== null)){ this.Alert ("Erreur Saisie Nom" , "Entrez au moin trois caractére") ;  return;}
         objPost.setDescription_post(DescriptionPost.getText( ) ); 
           if ((objPost.getDescription_post().length() == 0 )|| (objPost.getDescription_post()== null)){ this.Alert ("Erreur Saisie Description" , "le champs Description est vide") ;  return;}       
         objPostService.ajouter(objPost);
         listviewpostCustom.refrechListView( );
         CategoriePostIDPost.getItems().addAll(this.getListChoiceBox()); 
         objPost =  new Post(   0,     0,    0, null,   null,   null); 
         
         
         
    }

    @FXML
    private void onClickUpdatePost(ActionEvent event) {
        
         try {
                     int CategoriePost_ID  = objCategoriePostService.findID_Categorie( CategoriePostIDPost.getValue());
                objPost.setCategoriePost_ID(  CategoriePost_ID );//   Integer.parseInt(     CategoriePostIDPost.getValue()));   //????????
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre Categorie ID" , " Champs Categorie ID est vide  ") ; 
               return;
           }
        try {
                objPost.setUserId(   Integer.parseInt(      UserIdPost.getText()   )     );
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre User Post" , "  Champs User Id  est vide   ") ; 
               return;
           }   
         objPost.setNom(NomPost.getText( ) ); 
           if ((objPost.getNom().length() < 3 )|| (objPost.getNom()== null)){ this.Alert ("Erreur Saisie Nom" , "Entrez au moin trois caractére") ;  return;}
         objPost.setDescription_post(DescriptionPost.getText( ) ); 
           if ((objPost.getDescription_post().length() == 0 )|| (objPost.getDescription_post()== null)){ this.Alert ("Erreur Saisie Description" , "le champs Description est vide") ;  return;}       
         
             String Resultat = this.ConfirmationDialog_OUI_NON_CANCEL (null , null , "voulez-vous modifier l'id "+IdPost.getText() );
             if (  Resultat ==  "Oui" )
                { 
                     objPostService.modifier(objPost);
                     //System.out.println(objPost.getId());
                 //en finie par
                listviewpostCustom.refrechListView( );
                }
             else if ( Resultat == "Non") 
                {
                  System.out.println("non Button Clicked");
                } 
             
         listviewpostCustom.refrechListView( );
         CategoriePostIDPost.getItems().addAll(this.getListChoiceBox()); 
         objPost =  new Post(   0,     0,    0, null,   null,   null);       
      
    }

    @FXML
    private void onClickDeletePost(ActionEvent event) {
           int Id ;
           try {
                     Id = Integer.parseInt(IdPost.getText()); 
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre ID" , " Champs ID est vide  ") ; 
               return;
           }     
                      
                          String Resultat = this.ConfirmationDialog_OUI_NON_CANCEL (null , null , "voulez-vous supprimer l'id  "+IdPost.getText() );
                          if (  Resultat ==  "Oui" )
                             { 
                                  
                             objPostService.supprimer(Id);
                                 
                                 
                              //en finie par
                        listviewpostCustom.refrechListView( );
                         CategoriePostIDPost.getItems().addAll(this.getListChoiceBox()); 
                             }
                         else if ( Resultat == "Non") 
                             {
                              System.out.println("non Button Clicked");
                             }   
                        
                   
    }

    @FXML
    private void ListViewPost_OnMouseClicked(MouseEvent event) {
                objPost =  List_Post.getSelectionModel().getSelectedItem();     
                try { 
                     DescriptionPost.setText(objPost.getDescription_post()) ;    
                     NomPost.setText(objPost.getNom()) ; 
                     UserIdPost.setText(  Integer.toString(  objPost.getCategoriePost_ID()) );
                     IdPost.setText(       Integer.toString(     objPost.getId()       )    ) ;     
                     CategoriePostIDPost.getSelectionModel().selectFirst();
                     CategoriePostIDPost.getSelectionModel().select(    Integer.toString(    objPost.getCategoriePost_ID())   ); 
                }
                catch (NumberFormatException e){
                      Alert ("Erreur saisir nombre" , "Entrez uniquement des chiffres s'il vous plaît") ; 
                }
               catch ( Exception e) 
                     { // System.out.println(e.toString());   System.out.println(e.getMessage()); 
                        this. BoîteDialogueExceptions (  e ) ; 
                     } 
    }

    @FXML
    private void recherche_CommentaireOnKeyReleased(KeyEvent event) {
          //System.out.println(recherche_Commentaire.getText());
               this.ListePost  = objPostService.RechercherPost(recherche_Post.getText()  );//list t3adid tsobhomli fil liste ba3d ma cherchit
               List_Post.getItems().clear();//yizim tifra8
               List_Post.getItems().addAll( this.ListePost );//n3awid n3abeha ta recherche
     
    }

    @FXML
    private void onClickLirePost(ActionEvent event) {
    }

    @FXML
    private void ImagePostSelectionOnClick(ActionEvent event) {
                  FileChooser fc = new FileChooser();
                 fc.setInitialDirectory(new File ("C:\\"));//this.objPost.getImg_post()
                 ExtensionFilter [] extensions = {new ExtensionFilter("Image", "*.jpg"),
                                                  new ExtensionFilter("Image", "*.jpeg"),
                                                  new ExtensionFilter("Image", "*.png")};
                 fc.getExtensionFilters().addAll(extensions);
                 File seletedFile = fc.showOpenDialog(null);
                 if (seletedFile != null) 
                    {  
                     this.objPost.setImgLink_post(seletedFile.getAbsolutePath());  System.out.println(seletedFile.getAbsolutePath()); 
                     try { 
                            //   obj_FileManagement.readFileToBytes( seletedFile.getAbsolutePath());
                            //    objPost.setImg_post( obj_FileManagement.writeBytesToImage());
                            obj_FileManagement.readFileToBytes( seletedFile.getAbsolutePath()) ;
                            objPost.setByte_img_post( obj_FileManagement.bytes);      
                            System.out.println(seletedFile.getAbsolutePath()); 
                            if ( obj_FileManagement.length > 4.294967296E9  )
                               { 
                                 Alert ("Erreur Taille Fichier " , "Saisissez les fichiers inférieurs à 4 méga") ;//4miga
                                   objPost.setByte_img_post(null);  
                               } 
                           }
                       catch ( Exception e ) {  System.out.println( "ImagePostSelectionOnClick : " +e.getMessage());     } 
                    }
                 else { 
                     try { 
                         
                         objPost.setByte_img_post(null);  
                         System.out.println("file is not valid");}  
                     catch ( Exception e ) {  System.out.println( "ImagePostSelectionOnClick : " +e.getMessage());     } }
             }
    
    
    
    
    
    
  
    
    
   
       private List<String> getListChoiceBox() {
           // this.ListePost=objPostService.recuperer(); //selec *
          this.ListCategorie = objCategoriePostService.recuperer2();
            List<String> list =new ArrayList<String>();  // assna3 list type string 5ater list 5ir 
             
           for( CategoriePost oneListCategorie : ListCategorie) {// ili jbito min base effrizhomlo wa7da wa7da kol ligne ya3ni index 
          list.add(  oneListCategorie.getNom_categorie_post() );   
          // list.add(uneCommentaire.getnom_categorie_post()); 
           }  
           return list;
    }    
    
}

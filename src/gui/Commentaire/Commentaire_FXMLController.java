/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Commentaire;

import gui.Commentaire.ListView.ListViewCommentaire;
import gui.Message.LibMessageBox;
import entities.Commentaire;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Rating;
import services.CommentaireService;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Commentaire_FXMLController extends LibMessageBox implements Initializable {

    @FXML
    private Button ajout_Commentaire;
    @FXML
    private Button Modifier_Commentaire;
    @FXML
    private Button suprimer_Commentaire;
    @FXML
    private ListView<Commentaire> List_Commentaire;
    @FXML
    private TextField recherche_Commentaire;
    @FXML
    private Button lire_Commentaire;
    @FXML
    private TextField IdCommentaire;
    @FXML
    private ChoiceBox<String> PostIdCommentaire;
    @FXML
    private TextField MessageCommentaire;
    @FXML
    private DatePicker dateCommentaire;
    @FXML
    private Rating RatingCommentaire;//min variable
    /**
     * Initializes the controller class.
     */
    
    private List<Commentaire> ListeCommentaire;
    private Commentaire objCommentaire ;
    private CommentaireService  obj_CommentaireService ;
      private ListViewCommentaire   listviewcommentaireCustom; 
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        objCommentaire = new Commentaire ( );
        obj_CommentaireService = new CommentaireService ();
        listviewcommentaireCustom = new ListViewCommentaire ( List_Commentaire) ;  
                listviewcommentaireCustom.refrechListView( );
         //this.ListeCommentaire=this.recuperer(); 
     // this.refrechListView();
         
         
         dateCommentaire.setValue(LocalDate.now());
       
          //PostIdCommentaire.setOnAction(this::onActionEventPostID);
          
          
          
    }    

    @FXML
    private void onClickAjoutCommentaire(ActionEvent event) { 
          try {
                objCommentaire.setPost(Integer.parseInt(PostIdCommentaire.getValue()));
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre id post " , " Champs ID post  incorrecte  ") ; 
               return;
           } 
         objCommentaire.setMsg_commentaire(MessageCommentaire.getText());
           
       if ((objCommentaire.getMsg_commentaire().length() == 0 )|| (objCommentaire.getMsg_commentaire() == null)){
               Alert ("Erreur saisir message commentaire " , " Champs nmessage commentaire est vide  ") ; 
               return;}
       objCommentaire.setrating(RatingCommentaire.getRating());//na5ith rating se forme double
        LocalDate Date = dateCommentaire.getValue();//getvalue 5ater zone de date
        String Format_Date = Date.format(DateTimeFormatter.ofPattern( "yyyy-MM-dd" ));//transfert sous format yyyy-mm-dd
         objCommentaire.setDate_commentaire( Format_Date );
         obj_CommentaireService.ajouter(objCommentaire  );
                 this.refrechListView();
            
    }

    @FXML
    private void onClickUpdateCommentaire(ActionEvent event) {
               try {
                objCommentaire.setId(Integer.parseInt(     IdCommentaire.getText()));
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre id  " , " Champs ID   incorrecte  ") ; 
               return;
           } 
             try {
                objCommentaire.setPost(Integer.parseInt(     PostIdCommentaire.getValue()));
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre id post " , " Champs ID post  incorrecte  ") ; 
               return;
           } 
               objCommentaire.setrating(RatingCommentaire.getRating());//na5ith rating se forme double
         objCommentaire.setMsg_commentaire(       MessageCommentaire.getText());
           
       if ((objCommentaire.getMsg_commentaire().length() == 0 )|| (objCommentaire.getMsg_commentaire() == null)){
               Alert ("Erreur saisir message commentaire " , " Champs nmessage commentaire est vide  ") ; 
               return;} 
        LocalDate Date = dateCommentaire.getValue();//getvalue 5ater zone de date
        String Format_Date = Date.format(DateTimeFormatter.ofPattern( "yyyy-MM-dd" ));//transfert sous format yyyy-mm-dd
         objCommentaire.setDate_commentaire( Format_Date );
  String Resultat = this.ConfirmationDialog_OUI_NON_CANCEL (null , null , "voulez-vous modifier l'id "+IdCommentaire.getText() );
             if (  Resultat ==  "Oui" )
                { 
                    obj_CommentaireService.modifier(objCommentaire);
                 //en finie par
                 this.refrechListView();
                }
     

    }

    @FXML
    private void onClickDeleteCommentaire(ActionEvent event) {
       try {
                objCommentaire.setId(Integer.parseInt(     IdCommentaire.getText()));
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre id  " , " Champs ID   incorrecte  ") ; 
               return;
           } 
                        String Resultat = this.ConfirmationDialog_OUI_NON_CANCEL (null , null , "voulez-vous supprimer l'id  "+IdCommentaire.getText() );
                          if (  Resultat ==  "Oui" )
                             { 
                                  
                             obj_CommentaireService.supprimer(objCommentaire.getId());
                                 
                                 
                              //en finie par
                              this.refrechListView();  
                             } 
    }

    @FXML
    private void ListViewCommentaire_OnMouseClicked(MouseEvent event) {
                objCommentaire =  List_Commentaire.getSelectionModel().getSelectedItem();   
                try {
                IdCommentaire.setText(Integer.toString(objCommentaire.getId())) ; 
                PostIdCommentaire.getSelectionModel().select(    Integer.toString(    objCommentaire.getPost()  )   );
               
                dateCommentaire.setValue(LocalDate.parse( objCommentaire.getDate_commentaire()));
                MessageCommentaire.setText(objCommentaire.getMsg_commentaire());
                RatingCommentaire.setRating(objCommentaire.getrating()); 
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
               this.ListeCommentaire  = obj_CommentaireService.RechercherCategorie(   recherche_Commentaire.getText()  );//list t3adid tsobhomli fil liste ba3d ma cherchit
               List_Commentaire.getItems().clear();//yizim tifra8
               List_Commentaire.getItems().addAll( this.ListeCommentaire );//n3awid n3abeha ta recherche
    }

    @FXML
    private void onClickLireCommentaire(ActionEvent event) {// refresh 
                 this.refrechListView();
                IdCommentaire.setText("") ; 
                PostIdCommentaire.getSelectionModel().selectFirst();
               
                dateCommentaire.setValue(LocalDate.now());
                MessageCommentaire.setText("");  
    }

    @FXML
    private void dateCommentaire_onClick(ActionEvent event) {// doube manclik date ta9rali auto kenit 9bal w fassatha ;5ater famch click auto
        /*LocalDate myDate = dateCommentaire.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern( "MM-dd-yyyy" ));
        IdCommentaire.setText(myDate.toString());*/
    }
   
    /* private void onActionEventPostID(ActionEvent event) { 
     String  postID = PostIdCommentaire.getValue();
        IdCommentaire.setText(postID);
    }   */ 
    
    
  
       private List<String> getListChoiceBox() {
           this.ListeCommentaire=obj_CommentaireService.recuperer(); //selec *
           
            List<String> list =new ArrayList<String>();  // assna3 list type string 5ater list 5ir 
            
           for( Commentaire uneCommentaire : ListeCommentaire) {// ili jbito min base effrizhomlo wa7da wa7da kol ligne ya3ni index 
           list.add( Integer.toString( uneCommentaire.getPost()));   
           } 
           return list;
    }
   private void refrechListView() {
                  //this.ListeCommentaire= new ArrayList<Commentaire>(); 
                  this.ListeCommentaire=obj_CommentaireService.recuperer(); 
                 // List_Commentaire.getItems().removeAll();
                
                 
                 //List_Commentaire.getSelectionModel().clearSelection();
                 List_Commentaire.getItems().clear();
                         //$$$$$$$$$$$$$ SELECT $$$$$$$$$$$$$$$$$$
                 List_Commentaire.getItems().addAll( this.ListeCommentaire );
                    String [] ids =  this.getListChoiceBox().toArray(new String[0]);//ki jbitha list yilzim narja3ha tab pour transfert list en tableaus 5ater choice tifhim array
                    PostIdCommentaire.getItems().addAll(ids);
                }

 

      


}

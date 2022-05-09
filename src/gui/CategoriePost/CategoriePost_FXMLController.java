/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.CategoriePost;

import gui.Message.LibMessageBox;
import entities.CategoriePost;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable; 
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import services.CategoriePostService;

/**
 * FXML Controller class
 *
 * @author HP
 * m3adich ta3mil costructeur w aka new kol mara new dima this extend
 */
public class CategoriePost_FXMLController  extends LibMessageBox implements Initializable  {

    @FXML
    private Button ajout_CategoriePost;
    @FXML
    private Button Modifier_CategoriePost;
    @FXML
    private Button suprimer_CategoriePost;
    @FXML
    private ListView<CategoriePost> List_CategoriePost;
    @FXML
    private TextField recherche_CategoriePost;
    @FXML
    private Button lire_CategoriePost;
    @FXML
    private TextField nom_CategoriePost;
    @FXML
    private TextField id_CategoriePost;

    /**
     * Initializes the controller class.
     */
    
    ///
    private List<CategoriePost> ListeCatergorie;  // une liste contient array de categories
    private CategoriePost objCategoriePost ; 
    private CategoriePostService obj_CategoriePostService;  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         //this.Modifier_CategoriePost.setDisable(true);
         
         //this.ListeCatergorie=this.recuperer(); 
        obj_CategoriePostService = new CategoriePostService();
        
        this.refrechListView();//remplir tous base de donne dans notre fenetre
         nom_CategoriePost.setText("");//bech na9ta3 chak nfari8 zone de texte
         
       // this.BoîteDialogueExceptions ( "Look, an Exception Dialog" , "Could not find file blabla.txt!","type exception","FFFFFF");
     
        
      //this.BoîteDialogueExceptions ( "Look, an Exception Dialog" , "Could not find file blabla.txt!","Could not find file blabla.txt");
      
      
     
    }   

    @FXML
    private void onClickAjoutCategorie(ActionEvent event) {
                objCategoriePost.setNom_categorie_post(nom_CategoriePost.getText());
           
       if ((objCategoriePost.getNom_categorie_post().length() == 0 )|| (objCategoriePost.getNom_categorie_post() == null)){
               Alert ("Erreur saisir nom Categorie " , " Champs nom Categorie est vide  ") ; 
               return;} 
         
        obj_CategoriePostService.ajouter(objCategoriePost); 
        nom_CategoriePost.setText("");
        //en finie par
        this.refrechListView(); 
    }

    @FXML
    private void onClickUpdateCategorie(ActionEvent event) {  
         try {
                objCategoriePost.setId(Integer.parseInt(    id_CategoriePost.getText()));
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre ID" , " Champs Categorie ID  incorrecte  ") ; 
               return;
           }
         
                objCategoriePost.setNom_categorie_post(    nom_CategoriePost.getText());
           
       if ((objCategoriePost.getNom_categorie_post().length() == 0 )|| (objCategoriePost.getNom_categorie_post() == null)){
               Alert ("Erreur saisir nom Categorie " , " Champs nom Categorie est vide  ") ; 
               return;}
        String Resultat = this.ConfirmationDialog_OUI_NON_CANCEL (null , null , "voulez-vous modifier la ligne "+objCategoriePost.getId());
             if (  Resultat ==  "Oui" )
                {  
                    obj_CategoriePostService.modifier(new CategoriePost(objCategoriePost.getId(),objCategoriePost.getNom_categorie_post()));
                     this.refrechListView();//yizim y3awid refresh kol mana3mil 7aja est ce que fama changement fil base  
                }
    }

    @FXML
    private void onClickDeleteCategorie(ActionEvent event) {
         try {
                objCategoriePost.setId(Integer.parseInt(    id_CategoriePost.getText()));
            }
        catch (NumberFormatException e){
               Alert ("Erreur saisir nombre ID" , " Champs Categorie ID  incorrecte  ") ; 
               return;
           } 
                          String Resultat = this.ConfirmationDialog_OUI_NON_CANCEL (null , null , "voulez-vous supprimer l'id  "+objCategoriePost.getId());
                          if (  Resultat ==  "Oui" )
                             { 
                               obj_CategoriePostService.supprimer(objCategoriePost.getId());
                              //en finie par
                              this.refrechListView();
                             }
                         else if ( Resultat == "Non") 
                             {
                              System.out.println("non Button Clicked");
                             }    
    }

    @FXML
    private void onClickLireCategorie(ActionEvent event) {//bouton lire lire y7ib wa7id refresr ach fama jdid
                 this.refrechListView();
                 id_CategoriePost.setText("");
                 nom_CategoriePost.setText("");
    }
       @FXML
    private void ListViewCategorie_OnMouseClicked(MouseEvent event) {
          objCategoriePost =  List_CategoriePost.getSelectionModel().getSelectedItem();//a9rali ligne ki clickit 3leha
          id_CategoriePost.setText(Integer.toString(objCategoriePost.getId()));//ili 9rito 7ot fil champ ta nom wid 7othomli 8ody
          nom_CategoriePost.setText(objCategoriePost.getNom_categorie_post());
    } 
     @FXML
    private void recherche_CategorieOnKeyReleased(KeyEvent event) { //ta3 recherche 
        //System.out.println(recherche_CategoriePost.getText()); 
          this.ListeCatergorie  = obj_CategoriePostService.RechercherCategorie(recherche_CategoriePost.getText());//list t3adid tsobhomli fil liste ba3d ma cherchit
          List_CategoriePost.getItems().clear();//yizim tifra8
          List_CategoriePost.getItems().addAll( this.ListeCatergorie );//n3awid n3abeha ta recherche
        //this.refrechListView();
    }   
    
    
    
    
    
    
    
    
    
    
  

   private void refrechListView() {
                 List_CategoriePost.getItems().clear();//List_CategoriePost.getSelectionModel().clearSelection();
                         //$$$$$$$$$$$$$ SELECT $$$$$$$$$$$$$$$$$$
                         this.ListeCatergorie=obj_CategoriePostService.recuperer();
                 List_CategoriePost.getItems().addAll( this.ListeCatergorie );
                }




   
   
   
   
   
    
}






/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Commentaire.ListView;
import entities.Commentaire; 
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import services.CommentaireService;
/**
 *
 * @author khawl
 */
public class ListViewCommentaire  extends CommentaireService  {
           
    
    
           
               public List<Commentaire> ListeCommentaire;
              public ListView<Commentaire> List_Commentaire;  
              private final ObservableList<Commentaire> CommentaireObservableList = FXCollections.observableArrayList(); 
              public  ListViewCommentaire(ListView<Commentaire> List_Commentaire){
                  this.List_Commentaire   = List_Commentaire;   
                    this.List_Commentaire.setItems(this.CommentaireObservableList);//ta5li9 list tab
                    this.List_Commentaire.setCellFactory(List_commentaire_-> new ListViewController_Commentaire());//ta5li9 ligne relier listview bi lignr 5la9neha
              }
              
     public void refrechListView() {  
               
               this.ListeCommentaire =this.recuperer();  
                CommentaireObservableList.clear () ;   
             CommentaireObservableList.addAll( this.ListeCommentaire ); 
                  
                }

              }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Commentaire.ListView; 
import entities.Commentaire;
import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import org.controlsfx.control.Rating;
/**
 *
 * @author khawl
 */
public class ListViewController_Commentaire  extends ListCell<Commentaire> {
    @FXML
    private GridPane gridPane;
    @FXML
    private Label id;   
    @FXML
    private Label PostID;
    @FXML
    private Label MessageCommentaire; 
     @FXML
    private DatePicker date;
     @FXML
   private Rating rating ;      
    private FXMLLoader mLLoader;   // fichier xml t3ayit bih forme 
      @Override
    protected void updateItem(Commentaire commentaire, boolean empty) {//kol manzid fil list ajoute bi updateItem
                   super.updateItem(commentaire, empty); 
                   if(empty || commentaire == null) 
                     { 
                      setText(null);
                      setGraphic(null); 
                     } 
                   else {
                          if (mLLoader == null) 
                             {
                                mLLoader = new FXMLLoader(getClass().getResource("/GUI/Commentaire/ListView/CommentaireListViewCell_FXML.fxml"));
                                mLLoader.setController(this); 
                                try {
                                      mLLoader.load();
                                    }
                                catch (IOException e) {
                                                        // e.printStackTrace(); 
                                                        System.out.println("ListViewController_commentaire" + e.getMessage()); 
                                                       }  
                             } 
                          // id   PostID MessageCommentaire   MessageCommentaire  date   rating
                         id.setText(String.valueOf(commentaire.getId()));
                          PostID.setText(String.valueOf(commentaire.getPost()));
                          MessageCommentaire.setText(commentaire.getMsg_commentaire());
                          rating.setRating(commentaire.getrating());
                          date.setValue(LocalDate.parse( commentaire.getDate_commentaire()));
                          

                          setText(null);
                          setGraphic(gridPane);
                        } 
                    } 
}//listview ki t7ib ty7ot feha donne ti9bil ken string bech na3mil update 
//bech na3mil fih update kima n7ib 3ala5et 9dima manijimvh nzid feha fazat compnmen selcet box format  date nzid feha 7ajet

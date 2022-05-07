/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Message;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class LibMessageBox {
    
    public void Alert (String HeaderText , String  ContentText) {
         Alert msg = new Alert(Alert.AlertType.WARNING);
         msg.setTitle("Alert"); 
         msg.setHeaderText(HeaderText);
         msg.setContentText(ContentText);
         msg.show();
    }
    public void Info (String HeaderText , String  ContentText) {
         Alert msg = new Alert(Alert.AlertType.INFORMATION);
         msg.setTitle("Info"); 
         msg.setHeaderText(HeaderText);
         msg.setContentText(ContentText);
         msg.show();
    }   
    
    
    public Alert Confirmation (String HeaderText , String  ContentText) {
        Alert msg = new Alert(Alert.AlertType.CONFIRMATION );
     
        msg.setTitle("Confirmation"); 
        msg.setHeaderText("Modification sur un champs categorie");
        msg.setContentText("Voulez vous moudifier une ligne du tableau ? ");
        return msg; 
    }
    
    
    
    
  /*public enum Resultat {
  Oui,
  Non,
  Cancel
}*/
  
     public  String   ConfirmationDialog_OUI_NON_CANCEL ( String Title ,String HeaderText , String  ContentText ) {  
                  //Resultat msg ;
                  String msg = "N/A";
                  Alert alert = new Alert(AlertType.CONFIRMATION);
                  alert.setTitle( ( (Title == null )   ?  "Confirmation" :  Title )    );
                  alert.setHeaderText(HeaderText);
                  alert.setContentText(ContentText); 
                  ButtonType buttonTypeOui = new ButtonType("Oui");
                  ButtonType buttonTypeNon = new ButtonType("Non"); 
                  ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE); 
                  alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeNon, buttonTypeCancel); 
                  Optional<ButtonType> result = alert.showAndWait();
                  if (result.get() == buttonTypeOui){
                       /*msg = Resultat.Oui;*/   msg = "Oui";
                       } 
                  else if (result.get() == buttonTypeNon) {
                         /*msg = Resultat.Non;*/     msg = "Non";
                       }  
                  else {
                        /*msg = Resultat.Cancel;*/     msg = "Cancel";
                       }
                  return msg    ; 
                 }  
    
    
    
   
    public void  BoîteDialogueExceptions ( Exception e ) {
                 Alert alert = new Alert(AlertType.ERROR);
                 alert.setTitle("Boîte de dialogue des exceptions");
                 alert.setHeaderText(e.toString() );
                 alert.setContentText(e.getMessage());
                 //Exception ex = new FileNotFoundException(TypeException);
                 // Create expandable Exception.
                 StringWriter sw = new StringWriter();
                 PrintWriter pw = new PrintWriter(sw);
                 e.printStackTrace(pw);
                 String exceptionText = sw.toString();
                 Label label = new Label(exceptionText);
                 //Label label = new Label("The exception stacktrace was:");

                 TextArea textArea = new TextArea(exceptionText);
                 textArea.setEditable(false);
                 textArea.setWrapText(true);

                 textArea.setMaxWidth(Double.MAX_VALUE);
                 textArea.setMaxHeight(Double.MAX_VALUE);
                 GridPane.setVgrow(textArea, Priority.ALWAYS);
                 GridPane.setHgrow(textArea, Priority.ALWAYS);

                 GridPane expContent = new GridPane();
                 expContent.setMaxWidth(Double.MAX_VALUE);
                 expContent.add(label, 0, 0);
                 expContent.add(textArea, 0, 1);

                 // Set expandable Exception into the dialog pane.
                 alert.getDialogPane().setExpandableContent(expContent);

                 alert.showAndWait();
    }
    
    
    
    
    
    
    
    
    
    public int Confirmation_YES_NO_CANCEL (String HeaderText , String  ContentText) {
    int input = JOptionPane.showConfirmDialog(null, 
                                              HeaderText, 
                                              ContentText,
                                               JOptionPane.YES_NO_CANCEL_OPTION);
    
    // int a = this.Confirmation_YES_NO_CANCEL ( "header" , "content" );
      //  if(a==JOptionPane.YES_OPTION){System.out.println("OK Button Clicked");
    
    return input;
    }
}

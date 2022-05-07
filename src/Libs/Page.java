/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libs;

import gui.FormONE.LoadingCenter.Blog_Pannel.ListView.ListBlog_FXMLController;
import javafx.scene.paint.Color;
import java.awt.MouseInfo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.effect.Light.Point;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author HP
 */
public class Page {
       public Page ( ) {  } ;
        public void loadpage ( BorderPane Pane ,  String url ) {
                Parent root= null;
                try {
                      root = FXMLLoader.load(getClass().getResource(url));
                    }
                catch (Exception e ){System.out.println(e.getMessage());}
                 Pane.setCenter ( root );
                }
      
 
     private  Stage stage; 
     public Scene scene;
     public boolean isOpen (Stage stage) {
            boolean isOpen = false ; 
            try {
                 isOpen = ( stage.isShowing() ? true:false);
                }
            catch ( Exception ex)  {isOpen = false; }
             System.out.println ( isOpen);
            return isOpen;
     }
    public void setPostonByPointerCursor ( ) {
                  java.awt.Point p = MouseInfo.getPointerInfo().getLocation();
                  this.stage.setX(p.x - (this.stage.getWidth()/2) );
                  this. stage.setY(p.y + 20);}
    public Stage addNewForm (String src, String URL_icon , String Title , boolean hideTitleBar ) {  
                  try {
                         FXMLLoader rootx = new FXMLLoader (getClass().getResource(src));
                         ListBlog_FXMLController scene2Controller = rootx.getController(); 
                         Parent root =  rootx.load( ) ;
                         //  Parent root = FXMLLoader.load(getClass().getResource(src)); 
                         //   ListBlog_FXMLController scene2Controller = root.getc();
                         stage = new Stage(); 
                         if ( hideTitleBar ) {stage.initStyle(StageStyle.TRANSPARENT);}
                         this.scene = new Scene(root);
                         stage.setScene(this.scene);  
                         // Specifies the modality for new window.
                         stage.initModality(Modality.WINDOW_MODAL);  
                         stage.setTitle(Title);
                         //this.scene.setFill( Color.TRANSPARENT);
                         Image mylmage =   new Image( ( URL_icon != null ? URL_icon :  "img/empty_file_icon.png" )  );
                         stage.getIcons().add( mylmage );// tasswira 3ala jnab fo9 ki na3mil min fo9 twali auto min lota*/  
                         // this. stage.show(); 
                         //Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                         //stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                         // stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);   
                       } 
                  catch ( Exception ex) {    System.out.println("addNewForm : "+ex.getMessage());  }  
                  return  stage;
    }
}

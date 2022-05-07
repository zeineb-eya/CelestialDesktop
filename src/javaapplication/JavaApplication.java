/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

/**
 * @author HP
 */
import javafx.scene.image.Image;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.ImageIcon;



public class JavaApplication extends Application {

    /**
     * @param args the command line arguments
     */
 
     @Override
    public void start(Stage primaryStage) {
        try {
          /*  //Parent root = FXMLLoader.load(getClass().getResource("../gui//CategoriePost/CategoriePost_FXML.fxml"));
         // Parent root = FXMLLoader.load(getClass().getResource("../gui//Commentaire/Commentaire_FXML.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("../gui//Post/Post_FXML.fxml"));
          //  Parent root = FXMLLoader.load(getClass().getResource("../gui//FirstPage/FirstPage_FXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene); 
            primaryStage.setTitle("Edit");
            primaryStage.show();
            Image mylmage = new Image( "img/gui_edit_icon.png" );
            primaryStage.getIcons().add( mylmage );// tasswira 3ala jnab fo9 ki na3mil min fo9 twali auto min lota*/
            
            Parent root = FXMLLoader.load(getClass().getResource("../gui//FormONE/FormONE_FXML1.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene); 
            primaryStage.setTitle("Celestial");
            primaryStage.show();
            Image mylmage = new Image( "img/rocket_icon.png" );
            primaryStage.getIcons().add( mylmage ); 

           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

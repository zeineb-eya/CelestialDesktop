package test;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class MainFx extends Application{
    
    
    @Override
    public void start(Stage primaryStage) {
       try {
         Parent root = FXMLLoader.load(getClass().getResource("/gui/HomegestService.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLstatistiques.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       
       /* try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/SendMailFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
        
       /* try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/AjoutOffreFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
    }
    
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
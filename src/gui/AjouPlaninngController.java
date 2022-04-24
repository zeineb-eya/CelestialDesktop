/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Planinng;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import services.PlaninngService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AjouPlaninngController implements Initializable {
    public String imagecomp; 

    @FXML
    private TextField nom_planning;
    @FXML
    private TextField periode_planning;
    @FXML
    private TextField prix_planning;
    @FXML
    private DatePicker dateDebut_planning;
    @FXML
    private DatePicker dateFin_planning;
    @FXML
    private TextField destination_planning;
    @FXML
    private TextArea description_planning;
    @FXML
    private Label imagepath;
    @FXML
    private Button upload;
    @FXML
    private ImageView imagefield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        public void setUsername(String s) {
        description_planning.setText(s);
    }
        private boolean ValidchampDate(){
         
        if (dateDebut_planning.getValue().compareTo(LocalDate.now()) < 0 ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("La date debut ne peut pas etre avant la date d'aujourd'hui!!");
            alert.showAndWait();
            return false;
                     
    }else if (dateDebut_planning.getValue().compareTo(dateFin_planning.getValue()) > 0){
         Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("La date de fin ne peut pas etre avant la date de debut!!");
            alert.showAndWait();  
       
    return false;
      }else if (dateDebut_planning.getValue().compareTo(dateFin_planning.getValue()) == 0){
         Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("La date de fin ne peut pas etre la meme que la date de debut!!");
            alert.showAndWait();  
       
    return false;
      
     } return true;
     }
        private boolean Validchamp(){
         if(description_planning.getText().isEmpty() | description_planning.getLength() <3|nom_planning.getText().isEmpty() | nom_planning.getLength() <6 ){
          
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier votre saisie!");
            alert.showAndWait();
      return false;
    }return true;
}
    @FXML
       private void Ajouter(ActionEvent event) {
            if( Validchamp() &&  Validchamp()&& ValidchampDate()){    
        Planinng p = new Planinng();
        p.setNomPlanning(nom_planning.getText());
        p.setDateDebutPlanning(Date.valueOf(dateDebut_planning.getValue()));
        p.setDateFinPlanning(Date.valueOf(dateFin_planning.getValue()));
        p.setDestinationPlanning(destination_planning.getText());
        p.setDescriptionPlanning(description_planning.getText());
        p.setPeriodePlanning(Integer.parseInt(periode_planning.getText()));
        p.setPrixPlanning(Integer.parseInt(prix_planning.getText()));


        PlaninngService ps = new PlaninngService() {};
        ps.ajouter(p);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Planinng ajoutée");
        a.show();
    }
       }

    @FXML
    private void Afficher(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("AffichePlaninng.fxml"));
                       prix_planning.getScene().setRoot(root2);


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void uploadimg(ActionEvent event) {
                 FileChooser f = new FileChooser();
        String img;

        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));
        File fc = f.showOpenDialog(null);
        if (f != null) {
            //System.out.println(fc.getName());
            img = fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            imagefield.setImage(i);
            imagecomp = fc.toString();
            System.out.println(imagecomp);
            int index = imagecomp.lastIndexOf('\\');
            if (index > 0) {
                String filename = imagecomp.substring(index + 1);
            }
                     String filename = null;

            //source = new File(pathimage);
            //dest = new File(System.getProperty("user.dir") + "\\src\\com\\esprit\\img\\" + filename);
            Planinng.filename = "C:\\Users\\skanr\\Desktop" + filename;
            //se.sendphp(fc.getAbsolutePath());
        }
        imagefield.setFitHeight(215);
        imagefield.setFitWidth(265);
        //..\img\google.png

        //C:\Users\splin\Documents\NetBeansProjects\FanArt\\com\esprit\img
        Planinng.pathfile = fc.getAbsolutePath();
    }
    }

    


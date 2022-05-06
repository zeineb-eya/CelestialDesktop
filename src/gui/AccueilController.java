/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author 21628
 */
public class AccueilController implements Initializable {
    @FXML
    private TextField id;@FXML
    private Label lblMediaTitle;

    @FXML
    private MediaView mainMediaView;

    @FXML
    Slider theVolumeSlider;

    MediaPlayer mediaPlayer;
    Stage stage;

    @FXML
    public void openMediaFile(){




            String MEDIA_URL = "C:\\Users\\21628\\Music\\Interstellar_Main_Theme_-_Extra_Extended_-_Soundtrack_by_Hans_Zimmer[ConConverter.com].mp3";

            // The regex below only extracts the Tittle part of the media

            /* On Windows OS
              String [] mediaTitleParts = MEDIA_URL.split(":");
              String mediaTitleSecondPart = mediaTitleParts [1];
              System.out.println(mediaTitleSecondPart);
              String [] MediaTitlePartsMain = mediaTitleSecondPart.split("\\\\");
              MediaClass the Title part which usually the last String after split
            */

			// On Linux
			// String [] MediaTitlePartsMain = MEDIA_URL.split("/");
			// MediaClass the Title part which usually the last String after split
			// String MediaTitle = MediaTitlePartsMain [MediaTitlePartsMain.length - 1];
            // lblMediaTitle.setText(MediaTitle);

            // Correct Way to get Filename

            Media media = new Media(new File(MEDIA_URL).toURI().toString());

            mediaPlayer = new MediaPlayer(media);

            //mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL).toExternalForm()));


            // Volume Slider
            theVolumeSlider.setValue(mediaPlayer.getVolume() * 100);
            theVolumeSlider.valueProperty().addListener(observable -> mediaPlayer.setVolume(theVolumeSlider.getValue() / 100));


            mainMediaView.setMediaPlayer(mediaPlayer);
                    mediaPlayer.play();
System.out.print(MEDIA_URL);

            //Resize Video

           /* DoubleProperty width = mainMediaView.fitWidthProperty();
            DoubleProperty height = mainMediaView.fitHeightProperty();

            width.bind(Bindings.selectDouble(mainMediaView.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(mainMediaView.sceneProperty(), "height"));
            */
        
    }




  


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
String MEDIA_URL = "C:\\Users\\21628\\Music\\Interstellar_Main_Theme_-_Extra_Extended_-_Soundtrack_by_Hans_Zimmer[ConConverter.com].mp3";

            Media media = new Media(new File(MEDIA_URL).toURI().toString());

            mediaPlayer = new MediaPlayer(media);

            //mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL).toExternalForm()));


            // Volume Slider
            theVolumeSlider.setValue(mediaPlayer.getVolume() * 100);
            theVolumeSlider.valueProperty().addListener(observable -> mediaPlayer.setVolume(theVolumeSlider.getValue() / 100));


            mainMediaView.setMediaPlayer(mediaPlayer);
                    mediaPlayer.play();
System.out.print(MEDIA_URL);
    }
@FXML
    private void Eq(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCFXML.fxml"));
            Parent root = loader.load();
            AfficherCFXMLController controller = loader.getController();
            id.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }@FXML
    private void CEq(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEqFXML.fxml"));
            Parent root = loader.load();
            AfficherEqFXMLController controller = loader.getController();
            id.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }    
      @FXML
    MenuBar menuBar;

    @FXML
    private void play(){
        mediaPlayer.play();
    }

    @FXML
    private void pause(){
        mediaPlayer.pause();
    }
    @FXML
    private void stop(){
        mediaPlayer.stop();
    }
    @FXML
    private void restart(){
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();
    }

}

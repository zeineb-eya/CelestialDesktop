package gui;

/**
 * BUG ALERT
 * handle exceptions in case media controls buttons are pressed without yet loaded media
 * */


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

public class MediaClass implements Initializable {


    @FXML
    private MediaView mainMediaView;

    @FXML
    Slider theVolumeSlider;

    MediaPlayer mediaPlayer;
    Stage stage;
    @FXML
    private Button GestionBillet;
    @FXML
    private Button GestionReservation;

    public void openMediaFile(){





            // String MEDIA_URL = "C:\\Users\\Cipher\\Music\\Pub.mp4";
            String MEDIA_URL = "G:\\Pub.mp4";
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



    @Override
    public void initialize(URL Location, ResourceBundle resources) {

         //  String MEDIA_URL = "C:\\Users\\21628\\Pictures\\aziz.mp4";
            // String MEDIA_URL = "G:\\Pub.mp4";

           //String MEDIA_URL = "C:\\Users\\Cipher\\Pictures\\Pub.mp4";
             String MEDIA_URL = "G:\\Pub.mp4";

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

    @FXML
    private void GestionBillet(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/mycompany/gui/BilletFront.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void GestionReservation(ActionEvent event) {
           try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/mycompany/gui/ReservationFront.fxml"));
           // loader.setLocation(getClass().getResource("Reslisttest.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void GestionReclam(ActionEvent event) {
           try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AjoutReclamationFXML.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void GestionOffre(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/FrontOffreFXML.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
@FXML
    private void GestionEq(ActionEvent event) {
           try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AfficherEqFrontFXML.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void GestionCEq(ActionEvent event) {
           try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AfficherCFrontFXML.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void GestionPlaninng(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AjouPlaninng.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void GestionLoca(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/AjoutLocalisation.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

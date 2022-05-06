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
import java.net.URL;
import java.util.ResourceBundle;

public class MediaClassSong implements Initializable {

    @FXML
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
              MediaClassSong the Title part which usually the last String after split
            */

			// On Linux
			// String [] MediaTitlePartsMain = MEDIA_URL.split("/");
			// MediaClassSong the Title part which usually the last String after split
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

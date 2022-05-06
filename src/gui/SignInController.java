/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import services.UserService;
import util.MyDB;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class SignInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
private Button auth;
@FXML 
private Label message;
    entities.User u = new entities.User();
    UserService us = new UserService();
     Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private TextField username;
     @FXML
    private TextField tfmailU;
      @FXML
    private PasswordField tfpasswordU;
       @FXML
    private Button btnSignin;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             message.setText("");

    }    
     @FXML
    private void Login(ActionEvent event) {
         if (event.getSource() == btnSignin) {
            //login here
            if (logIn().equals("admin")) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Choix.fxml"));
            Parent root = loader.load();
            ChoixController controller = loader.getController();
            username.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    } else if (logIn().equals("Success")) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MediaHome.fxml"));
            Parent root = loader.load();
            MediaClass controller = loader.getController();
            username.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
            
            
            
            else {Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Verifiez vos données.");
                 String content = String.format("Il n'ya pas un compte contenant ce mot de passe et adresse");
        a.setContentText(content);
                  a.show();}}}
      public SignInController() {
        con = MyDB.getInstance().getConnection();
    }
        private String logIn() {
        String status = "Success";
        String email = tfmailU.getText();
        String password = tfpasswordU.getText();
        if(email.isEmpty() || password.isEmpty()) {
            status = "Error";
        } else if(email.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("0000")) 
        { status ="admin";
        }
        
        else {
            //query
            String sql = "SELECT * FROM user Where mail_utilisateur = ? and password = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    status = "Error";
                } else {
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        
        return status;
    }
   @FXML
    private entities.User authUser(ActionEvent event)
    {

    String domain = "https://www.youtube.com/";
    String appId = "1217746542302143";
String authUrl="https://graph.facebook.com/oauth/authorize?type=user_agent&client_id=1217746542302143&redirect_uri=https://www.youtube.com/&ampscope=user_about_me";
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
WebDriver driver =new ChromeDriver();
driver.get(authUrl);
        String accessToken ="EAARTiLYUk78BAByQRQ8ZBejz2n8WEg0je87NZBjxxW7Jisy1YGJELtE7eIKkTTy36SIhwv2w1J6MneQjczxHyhMfjHXxbRwOG0NTVi6Hzz85exqbCdEs1tUjdNxu6SKR4fgfBO1oACbUxO8Jy69zns8uEO7pVrJj93xPRBoC7MCU2Qj0uZAN5UkRN4ErmiBp5elUnalHwcgpDK2lbmsPBWpLJRneKsnv7x9dSApmF1p7VnSa7VS";
      
    if(driver.getCurrentUrl().contains("facebook.com"))
    { String url = driver.getCurrentUrl();   

   // accessToken = url.replaceAll(".*#access_token=(.+)&.*","$1");
    //accessToken.substring(13,accessToken.lastIndexOf("&"));
   FacebookClient fbClient = new DefaultFacebookClient(accessToken);
      User me =fbClient.fetchObject("me", User.class);
      System.out.println(me.getName());
      
    message.setText(me.getName());
     String nom=me.getName();
          String prenom=me.getLastName();


    
     entities.User user = new entities.User(nom,nom,nom+"@gmail.com","",nom+"0000","");
        us.ajouter(user);
user=u;
    }
                System.out.print(u);
                return(u);

    }
@FXML
    private void showchart(ActionEvent event){
       try {
           UserService p = new UserService();
           List<entities.User> lp=p.recuperer();
    ObservableList<entities.User> data=FXCollections.observableArrayList(lp);
            FXMLLoader chart= new FXMLLoader(getClass().getResource("chart.fxml"));
            Parent root = chart.load();
            ChartController mc = chart.getController();
           
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Nombre de personnes par meme adresses");
            modifStage.setScene(scene);
            modifStage.show();
            
             ChartController controller = chart.getController();
        controller.setReclamationData();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(AffichFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

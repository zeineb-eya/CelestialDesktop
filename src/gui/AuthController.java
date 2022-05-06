 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.restfb.FacebookClient;
import com.restfb.DefaultFacebookClient;
import com.restfb.types.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AuthController implements Initializable {
@FXML 
private Button auth;
@FXML 
private Label message;
entities.User u = new entities.User();
    UserService us = new UserService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 @FXML
    private void authUser(ActionEvent event) throws InterruptedException, IOException
    {

    String domain = "https://www.youtube.com/";
    String appId = "1217746542302143";
String authUrl="https://graph.facebook.com/oauth/authorize?type=user_agent&client_id=1217746542302143&redirect_uri=https://www.youtube.com/&ampscope=user_about_me";
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
WebDriver driver =new ChromeDriver();
driver.get(authUrl);
        String accessToken ="EAARTiLYUk78BAKB7113C3lOWMqaQZB8ytybRLblToeypnpqdtYUmUR0ayJ2RDczsZBhN7CiOX1RZAIQABoHoGeH4TkT0r59EeeZCSiiZA8ThnKUgjEXu4SMDo59vtt6m43yTAblGjMNqOdkTIDZAYvK6evJr4UylNd2ZAHm28gIFYZCJ4M9GVQnsGprNB55gw5Envm3aZBvrEfGhhY2ywgtka6NmeY0g2QdGE3I1VZAL7JCq6YDAOkCC6z";
      
    if(driver.getCurrentUrl().contains("facebook.com"))
    { String url = driver.getCurrentUrl();   

    accessToken = url.replaceAll(".*#access_token=(.+)&.*","$1");
    //accessToken.substring(13,accessToken.lastIndexOf("&"));
   FacebookClient fbClient = new DefaultFacebookClient(accessToken);
      User me =fbClient.fetchObject("me", User.class);
      System.out.println(me.getName());
    message.setText(me.getName());
     String nom=me.getName();
          String prenom=me.getLastName();


    
     entities.User user = new entities.User(nom,nom,nom+"@gmail.com","Bizerte",nom+"0000","");

                                    System.out.println(user);
        us.ajouter(user);
        
          
        
    }
        
        
    
    }
}
 
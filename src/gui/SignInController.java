/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
     Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private TextField username;
     @FXML
    private TextField tfmailU;
      @FXML
    private TextField tfpasswordU;
       @FXML
    private Button btnSignin;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InformationUser.fxml"));
            Parent root = loader.load();
            InformationUserController controller = loader.getController();
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
    
    
}

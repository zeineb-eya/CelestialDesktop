/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class InformationUserController implements Initializable {
  private ResultSet rs;
    private Statement st;
   private Connection connection;
   private PreparedStatement ps;
    @FXML
    private Label colnomU;
     @FXML
    private Label colprenomU;
    @FXML
    private Label coladresseU;
     @FXML
    private Label colmailU;
    @FXML
    private Label colpasswordU;
     @FXML
    private Label colnumtelU;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import com.mycompany.utils.MyConnection;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javax.activation.DataSource;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Stat_ratingController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;
    private Connection  connexion =(Connection) MyConnection.getInstance().getCnx();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
         String req =" SELECT category , rating from reclamation ";
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        try {
             PreparedStatement ste = (PreparedStatement) connexion.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                
            }
//           barChart.getData().add(series); 
        } catch (SQLException ex) {
            Logger.getLogger(Stat_ratingController.class.getName()).log(Level.SEVERE, null, ex);
    } 
    } 
   private void loadData(){
        ServiceReclamation rs= new ServiceReclamation();
        Reclamation r=new Reclamation();
        ObservableList<PieChart.Data> list= FXCollections.observableArrayList();
        //rs.getAll();
    
    }
        
}

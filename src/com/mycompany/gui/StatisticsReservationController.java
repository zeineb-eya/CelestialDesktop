/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.services.ReservationService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class StatisticsReservationController implements Initializable {
 ReservationService rs = new ReservationService();
    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<PieChart.Data> pieChartData;
        try {
            pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("waiting for a confirmation", rs.pendingType()),
                    new PieChart.Data("confirmed", rs.confirmedType()),
                    new PieChart.Data("cancelled", rs.cancelledType())
            );
            pieChart.setData(pieChartData);
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}

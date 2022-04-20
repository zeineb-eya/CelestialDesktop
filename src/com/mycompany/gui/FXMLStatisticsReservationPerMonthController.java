/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Reservation;
import com.mycompany.services.ReservationService;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLStatisticsReservationPerMonthController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private CategoryAxis xAxis;

   //  private ObservableList<String> monthNames = FXCollections.observableArrayList();
      private ObservableList<String> EtatReservation = FXCollections.observableArrayList();
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Get an array with the English month names.
        //String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
      
      String pending = "waiting for a confirmation";
              String cancelled = "cancelled";
              String confirmed = "confirmed";
      
        // Convert it to a list and add it to our ObservableList of months.
      //  monthNames.addAll(Arrays.asList(months));
        EtatReservation.addAll(Arrays.asList(pending,cancelled,confirmed));
        // Assign the month names as categories for the horizontal axis.
       // xAxis.setCategories(monthNames);
        xAxis.setCategories(EtatReservation);
    }    
     public void setReservationData(List<Reservation> Reservations) {
    	// Count the number of Reservations having their reservation date in a specific month.
       // int[] monthCounter = new int[12];
       int[] EtatCounter = new int[50];
          int pendingNumber = 0;
            int confirmedNumber = 0;
             int cancelleddNumber = 0;
        for (Reservation r : Reservations) {
//            int month;
//            month = r.getDateReservation().getMonthValue() -1;
//            monthCounter[month]++;
            if (r.getEtatReservation().equals("waiting for a confirmation"))                 
            { pendingNumber++;
                EtatCounter[pendingNumber]++;}
            else if (r.getEtatReservation().equals("confirmed"))                 
            { confirmedNumber++;
                EtatCounter[confirmedNumber]++;}
             else if (r.getEtatReservation().equals("cancelled"))                 
             {  cancelleddNumber++;
                 EtatCounter[cancelleddNumber++]++;}
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < EtatCounter.length; i++) {
        	series.getData().add(new XYChart.Data<>(EtatReservation.get(i), EtatCounter[i]));
        }
        
        barChart.getData().add(series);
    }
}

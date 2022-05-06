/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;


import entities.User;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import services.UserService;




public class ChartController implements Initializable {

    private PieChart piechart;
    @FXML
    private BarChart<String,Integer> barChart;
    @FXML
    private NumberAxis numberAxis;
    @FXML
    private CategoryAxis xAxis;
     int[] nb;
 private ObservableList<String> catNames = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          // Get an array with the FRENCH month names.
          UserService p = new UserService();
           Map<String,Integer> mp=p.NbPdtByCat();
        String[] nom = new String[mp.size()];
         nb = new int [mp.size()];
        int i=0 ;
        for(Map.Entry<String,Integer>elt :mp.entrySet()){
            nom[i]=elt.getKey();
            nb[i]=elt.getValue(); 
            i++;}
        
        // Convert it to a list and add it to our ObservableList of months.
        catNames.addAll(Arrays.asList(nom));
        
        // Assign the month names as categories for the horizontal axis.
        xAxis.setCategories(catNames);
        xAxis.setLabel("Adresse");
        numberAxis.setLabel("Nombre Users par Adresses");
    }  
       public void setReclamationData() {
    	
        
 
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < catNames.size(); i++) {
        	series.getData().add(new XYChart.Data<>(catNames.get(i), nb[i]));
        }
        
        barChart.getData().add(series);
    }
    }
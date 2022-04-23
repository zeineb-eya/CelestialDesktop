/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import com.mycompany.utils.MyConnection;
import static edu.stanford.nlp.util.ArgumentParser.host;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.ProcessBuilder.Redirect.to;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Date.from;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Pagination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.util.HashMap;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReclamationAdminController implements Initializable {

    @FXML
    private TableView<Reclamation> tableaureclam;
    @FXML
    private TableColumn<?, ?> description_reclamcol;
    @FXML
    private TableColumn<?, ?> etat_reclamcol;
    @FXML
    private TableColumn<?, ?> date_reclamcol;
    @FXML
    private TableColumn<?, ?> user;
    @FXML
    private TextField rechercher;
    ObservableList myList ;
    
Reclamation rec=new Reclamation();
  ServiceReclamation sr = new ServiceReclamation();
  
  private Connection cnx2;
    private Statement ste;
    @FXML
    private PieChart TraiteeNonTraitee;
    public TableColumn<?, ?> getDescription_reclamcol() {
        return description_reclamcol;
    }

    public void setDescription_reclamcol(TableColumn<?, ?> description_reclamcol) {
        this.description_reclamcol = description_reclamcol;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       afficherReclam();
    }    

 
       private void afficherReclam() {
      ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.afficherReclamation();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
        
        description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
        date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
        user.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        RechercheAV();
          
    }
       
       //sorted
         private void afficherSortReclam() {
      ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.sortByEtat();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
        
        description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
        date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
        user.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        RechercheAV();
          
    }

    @FXML
    private void refresh(MouseEvent event) {
           ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.refreshReclam();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
       
        description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
         date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
                  
         tableaureclam.setItems(myList);
          RechercheAV();
    }


    @FXML
    private void traiterReclam(javafx.event.ActionEvent event) throws MessagingException {
        
       Reclamation r = tableaureclam.getSelectionModel().getSelectedItem();
      ServiceReclamation sr = new ServiceReclamation();
      
   if (r.getEtat_reclamation().equals("envoye"))
            {
                    sr.updateReclamationAdmin(r);
                 System.out.println("ok");
           
      // sendMail();
                }
        Image img = new Image("/images/tick.png", 50, 50, false, false);
   Notifications notificationBuilder  = Notifications.create()
            
                    .title("Traitement offre")
                    .text("La réclamation a été traité  avec succés")
                    .graphic(new ImageView(img) )
                    .hideAfter(Duration.seconds(8))
                    .position(Pos.CENTER);
      notificationBuilder.show();
    }
    
    
       public void RechercheAV(){
     FilteredList<Reclamation> filteredData = new FilteredList<>(myList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(tmp -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				if (tmp.getEtat_reclamation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                                       // (String.valueOf(tmp.getId()).indexOf(lowerCaseFilter)!=-1)
				} else if (String.valueOf(tmp.getDate_reclamation()).indexOf(lowerCaseFilter)!=-1){
				     return true;
                               } else if (String.valueOf(tmp.getDescription_reclamation()).indexOf(lowerCaseFilter)!=-1){
				     return true;
                               }else
				    	 return false;
                                // Does not match.
			
		});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableaureclam.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableaureclam.setItems(sortedData);
                
       }

    @FXML
    private void detailReclam(javafx.event.ActionEvent event) throws IOException {
          
     
          Reclamation r =  tableaureclam.getSelectionModel().getSelectedItem();
       FXMLLoader loader = new FXMLLoader(getClass().getResource("detailReclamationFXML.fxml"));

  Stage stage = new Stage(StageStyle.DECORATED.DECORATED);
  stage.setScene(
    new Scene(loader.load()));

  DetailReclamationFXMLController controller = loader.getController();
  controller.detailReclam(r);
stage.show();
    }

    @FXML
    private void exportexcel(javafx.event.ActionEvent event) throws IOException {
        
        Workbook workbook = new HSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet spreadsheet = workbook.createSheet("sample");

        org.apache.poi.ss.usermodel.Row row = spreadsheet.createRow(0);

        for (int j = 0; j < tableaureclam.getColumns().size(); j++) {
            row.createCell(j).setCellValue(tableaureclam.getColumns().get(j).getText());
        }

        for (int i = 0; i < tableaureclam.getItems().size(); i++) {
            row = spreadsheet.createRow(i + 1);
            for (int j = 0; j < tableaureclam.getColumns().size(); j++) {
                if(tableaureclam.getColumns().get(j).getCellData(i) != null) { 
                    row.createCell(j).setCellValue(tableaureclam.getColumns().get(j).getCellData(i).toString()); 
                }
                else {
                    row.createCell(j).setCellValue("");
                }   
            }
        }
       //FileOutputStream fileOut = new FileOutputStream("classeur1.xlsx");
            FileOutputStream fileOut = new FileOutputStream(new File ("c:\\xls\\classeur1.xls"));

        workbook.write(fileOut);
        fileOut.close();
    }

     

    @FXML
    public void Stat() throws SQLException{
                ServiceReclamation sr = new ServiceReclamation();
        ObservableList<PieChart.Data> T = FXCollections.observableArrayList(
             new PieChart.Data("Traitée", sr.getTraitee()),
             new PieChart.Data("Non Traitée", sr.getNonTraitee())
         );        
        TraiteeNonTraitee.setData(T);
        //System.out.println("mochekla inisialize");
        //barC= new BarChart<>();
        try{
           /* ResultSet rs = sr.getNbrReclamationType();
            ArrayList<Integer> nombres = new ArrayList<>();
            ArrayList<String> objets= new ArrayList<>();
            HashMap<String,Integer> map = new HashMap();
            while (rs.next())
            {
                nombres.add(rs.getInt("nbr"));
                objets.add(rs.getString("description_reclamation"));
                //map.put(rs.getString("description_reclamation"), rs.getInt("nbr"));
            }*/
             HashMap<String,Integer> map = new HashMap();
            if(!map.isEmpty())
            {
                CategoryAxis xAxis = new CategoryAxis();
                xAxis.setCategories(FXCollections.<String>observableArrayList(map.keySet()));
                NumberAxis yAxis = new NumberAxis(0, 
                                                  map.values().stream().max((a1,a2)-> a1-a2).get()+1 , 
                                                  1);
                ObservableList<BarChart.Series> barChartData = FXCollections.observableArrayList() ;
                
                map.forEach((t,u)-> {
                    BarChart.Series<String,Integer> b = new BarChart.Series<>(t,FXCollections.observableArrayList(
                           new BarChart.Data(t, u)     
                    ));
                    barChartData.add(b);
                    
                });           
                BarChart<String,Integer> m = new BarChart(xAxis, yAxis,barChartData);
//                barC.setData(new BarChart(xAxis, yAxis, barChartData).getData());
//                //barC.setData(new BarChart(xAxis, yAxis, barChartData, 25.0d).getData());
               // recl.getChildren().add(new BarChart(xAxis, yAxis, barChartData,25.0d));
              //  xtx.getChildren().add(createBarChart());
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }    
    }

        
        
    }
    
   
       

       
 
     
                
        
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.entities.Reclamation;
import com.mycompany.entities.User;
import com.mycompany.services.ServiceReclamation;
import com.mycompany.utils.MyConnection;
import com.sun.rowset.internal.Row;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javafx.scene.control.Pagination;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import com.mycompany.utils.MyConnection;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import javafx.scene.chart.BarChart;
import javafx.stage.Modality;
//import gui.nlpPipeline;
//import static gui.nlpPipeline.pipeline;
import java.util.Properties;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
        /**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherReclamationFXMLController implements Initializable {

    @FXML
    private TableView<Reclamation> tableaureclam;
    @FXML
    private TableColumn<Reclamation,String> description_reclamcol;
    @FXML
    private TableColumn<Reclamation, String> etat_reclamcol;
    @FXML
    private TableColumn<?, ?> date_reclamcol;
    
    ObservableList myList ;
    @FXML
    private TableColumn<?, ?> user;

   private  Pagination pagination;
   int nbr_page;
  //pour stat
   private Statement ste;
    private Connection cnx;
    ServiceReclamation sr = new ServiceReclamation();

    @FXML
    private TextField rechercher;
    private TableColumn<?, ?> experience;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       afficherReclam();
       
      /* pagination = new Pagination(3);
       pagination.setStyle("-fx-border-color:blue");
       pagination.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
       
       AnchorPane anchor = new AnchorPane();
       AnchorPane.setTopAnchor(pagination, 10.0);
       AnchorPane.setBottomAnchor(pagination, 10.0);
       AnchorPane.setLeftAnchor(pagination,10.0);
       AnchorPane.setRightAnchor(pagination,10.0);
       
       anchor.getChildren().add(pagination);
       Scene scene = new Scene(anchor);
         Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
   }   
    
   public VBox createPage(int pageIndex){
        VBox pageBox = new VBox();
        Label pageLabel = new Label("Page : "+ (pageIndex+1));
        pageBox.getChildren().add(pageLabel);
       return pageBox;
    }
    */
    }
    
  /*  public int itemsPerPage() {
return 1;
}
public int rowsPerPage() {
return 5;
}
public VBox createPage(int pageIndex) {
int lastIndex = 0;
int displace = myList.size() % rowsPerPage();
if (displace > 0) {
lastIndex = myList.size() / rowsPerPage();
} else {
lastIndex = myList.size() / rowsPerPage() - 1;
}
VBox box = new VBox(5);
int page = pageIndex * itemsPerPage();


}*/
    private void afficherReclam() {
      /*  init();
        Reclamation r = new Reclamation();

      r.getDescription_reclamation();  
   estimatingSentiment(r); */
      ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.afficherReclamation();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
        
        description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
        date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
     //   user.setCellValueFactory(new PropertyValueFactory<>(user.getId()));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
         RechercheAV();
        //user_idcol.setCellValueFactory(new PropertyValueFactory<>("user_id"));
     //  nlpPipeline.init();
     
    }
    
    
    
    
  
    private void afficherReclamN() throws IOException {
        
      ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.afficherReclamation();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
        
        description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
        date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
     //   user.setCellValueFactory(new PropertyValueFactory<>(user.getId()));
        user.setCellValueFactory(new PropertyValueFactory<>("user_id"));
   //  experience.setCellValueFactory(new PropertyValueFactory<>("experiencee"));
     // experience.setCellValueFactory(new PropertyValueFactory<>("experiencee"));
       RechercheAV();
        //  nlpPipeline.findSentiment("experiencee");
      String re = description_reclamcol.getText();
            nlpPipeline.init();
         
    }
     
       public Boolean ValidateFields() {
    if (tableaureclam.getSelectionModel().isEmpty() ){
        Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("Erreur!!");
            alert.setHeaderText(null);
       alert.setContentText("Aucune réclamation n'est selectionné pour la suppresion!!");
            alert.showAndWait();
            
        return false;
        }

        return true;

    }
       
    @FXML
    private void deleteReclam(MouseEvent event) {
       
         if(ValidateFields() ){
                  if(tableaureclam.getSelectionModel().getSelectedItem().getEtat_reclamation().equals("Traitée")){

                        Alert alert2 = new Alert(Alert.AlertType.ERROR, "Cette réclamation est déjà traité vous ne pouvez pas la supprimer!", ButtonType.CLOSE);
                        alert2.showAndWait();
                        if (alert2.getResult() == ButtonType.CLOSE)
                            alert2.close();
                    }else{

         ServiceReclamation sr = new ServiceReclamation();
        Reclamation r = (Reclamation) tableaureclam.getSelectionModel().getSelectedItem();
        sr.deleteReclamation(r);
        sr.refreshReclam();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 try {
             if(JOptionPane.showConfirmDialog(null,"attention vous allez supprimer votre reclamation,est ce que tu et sure?"
                     ,"supprimer reclamation",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
            if(r.getDescription_reclamation().length() != 0){
       
         alert.setContentText("Votre réclamation a ete bien supprime");
         JOptionPane.showMessageDialog(null,"reclamation supprime");
             }//ca est pour recharger la list des stagiaire
            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ id !");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());} 
       
         }
    
    }
    
 /*     @FXML
    private void deleteReclam(MouseEvent event) {
       
         if(ValidateFields() ){
         ServiceReclamation sr = new ServiceReclamation();
        Reclamation r = (Reclamation) tableaureclam.getSelectionModel().getSelectedItem();
        sr.deleteReclamation(r);
        sr.refreshReclam();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 try {
             if(JOptionPane.showConfirmDialog(null,"attention vous allez supprimer votre reclamation,est ce que tu et sure?"
                     ,"supprimer reclamation",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
            if(r.getDescription_reclamation().length() != 0){
       
         alert.setContentText("Votre réclamation a ete bien supprime");
         JOptionPane.showMessageDialog(null,"reclamation supprime");
             }//ca est pour recharger la list des stagiaire
            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ id !");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());} 
       
         }
    
    }*/

//afficherReclam blasetha
    }
    @FXML
     private void modifierReclam(MouseEvent event) {
     Reclamation r = tableaureclam.getSelectionModel().getSelectedItem();
   
if(r==null){
        
           System.out.println("Aucune reclamation séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune reclamation séléctionné pour la modifier");

            alert.showAndWait();
     
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ModifierReclamationFXML.fxml"));
        Scene scene=new Scene(loader.load());
        

       ModifierReclamationFXMLController mr= loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        int as=tableaureclam.getSelectionModel().getSelectedItem().getId();
        
        String sub = tableaureclam.getSelectionModel().getSelectedItem().getDescription_reclamation();
        // String e = tableaureclam.getSelectionModel().getSelectedItem().getEtat_reclamation();
       // String content = tableaureclam.getSelectionModel().getSelectedItem().getContent();
        
       
        
        mr.setData(tableaureclam.getSelectionModel().getSelectedItem().getId(),
                tableaureclam.getSelectionModel().getSelectedItem().getDescription_reclamation(),
                 tableaureclam.getSelectionModel().getSelectedItem().getEtat_reclamation()
                // tableaureclam.getSelectionModel().getSelectedItem().getContent()
                 );
                 
                 
       
        } catch(IOException ex)
    {
     System.out.println("eer");
}
        }

}
     
        /* public void refresh(boolean x){
    if(x==true){
        
             ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.refreshReclam();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
       
           description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
         date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
                  
         tableaureclam.setItems(myList);
        }
    else
    {}
    }*/

    @FXML
    private void refresh(MouseEvent event) {
       
        
             ServiceReclamation sr = new ServiceReclamation();
        List<Reclamation> reclam = sr.refreshReclam();
        myList = FXCollections.observableList(reclam);
        tableaureclam.setItems(myList);
       
           description_reclamcol.setCellValueFactory(new PropertyValueFactory<>("description_reclamation"));
        etat_reclamcol.setCellValueFactory(new PropertyValueFactory<>("etat_reclamation"));
         date_reclamcol.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
       user.setCellValueFactory(new PropertyValueFactory<>("user_id"));          
         tableaureclam.setItems(myList);
          RechercheAV();
    
    }

     public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
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
                                } else  
				    	 return false; // Does not match.
			
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
    private void rechercher(MouseEvent event) {
    }
  
   /* public void initachatPage(int index) {
        //stackPane.setVisible(false);
        pagination.setCurrentPageIndex(index);
        List<Reclamation> article_page = getArticlesPage(index);       
        if (article_page.size() >= 1) {
            box1.setVisible(true);         
            consulter1.setOnAction((event) -> {
                consulter(article_page.get(0).getList());
            });
            
            nbrArticlebox1.setText("NOMBRE ARTICLE : "+String.valueOf(article_page.get(0).getList().size()));
            etatBox1.setText(article_page.get(0).getEtat());
            dateBox1.setText(article_page.get(0).getDate_achat().toString());
            prixBox1.setText("PRIX TOTAL : "+String.valueOf(article_page.get(0).getPrix()) + " DT");
            
        } else {
            
            box1.setVisible(false);
            
        }}*/

   
    @FXML
    private void exportexcel(ActionEvent event) throws SQLException, IOException {
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
    
    /* public void Stat() throws SQLException{
                XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Répartition des Types");
            cnx = MyConnection.getInstance().getCnx();
            ste = cnx.createStatement();
            ResultSet res = ste.executeQuery("select * from type_comptabilite");
            while(res.next()){
            series.getData().add(new XYChart.Data<>(res.getString(2), sr.calculer(res.getInt(1))));
            }        
        barChart.getData().addAll(series);

    }*/

   /* @FXML
    private void exportexcel(ActionEvent event) {
    }*/

    @FXML
    private void detailReclam(ActionEvent event) throws IOException {
        
          Reclamation r =  tableaureclam.getSelectionModel().getSelectedItem();
       FXMLLoader loader = new FXMLLoader(getClass().getResource("detailReclamationFront.fxml"));

  Stage stage = new Stage(StageStyle.DECORATED.DECORATED);
  stage.setScene(
    new Scene(loader.load()));

  DetailReclamationFrontController controller = loader.getController();
  controller.detailReclam(r);
stage.show();
    }
   
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Equipement;

import services.ServiceEquipement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import com.itextpdf.text.BaseColor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.swing.JFileChooser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import util.MyDB;


/**
 * FXML Controller class
 *
 * @author Cipher
 */
public class AfficherEqFrontFXMLController implements Initializable {
 @FXML
    private TableView<Equipement> TVuser;
 @FXML
 ResourceBundle rb;
 @FXML
 URL url;
     @FXML
    private TextField idsupp;
     @FXML
    private TextField filterField;
    @FXML
    private TableColumn<Equipement,Integer> colidU;
    @FXML
    private TableColumn<Equipement, String> colnomU;
     @FXML
    private TableColumn<Equipement,String> colprenomU;
    @FXML
    private TableColumn<Equipement,String> coladresseU;
    @FXML
    private ComboBox<String> combomag;
     @FXML
    private TableColumn<Equipement,String> colmailU;
    @FXML
        private  ObservableList <Equipement> dataList=FXCollections.observableArrayList();
private ObservableList<Equipement> masterData = FXCollections.observableArrayList();

    private Label a;
    String col,ord;
  
   
         ObservableList data ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       //TVuser.setItems(list);
       combomag.getItems().removeAll(combomag.getItems());
    combomag.getItems().addAll("Nom","Etat", "Categorie");
    combomag.getSelectionModel().select("Nom");
    col="nom_equipement";
    ord="ASC"; 
    combomag.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
    
    if (combomag.getSelectionModel().getSelectedItem().equals("Nom"))
            col="nom_equipement";
    else if   (combomag.getSelectionModel().getSelectedItem().equals("Etat"))
            col="etat_equipement" ;
        else if   (combomag.getSelectionModel().getSelectedItem().equals("Categorie"))
            col="categorie_equipement_id" ;
        research();
}); 
         colidU.setCellValueFactory(new PropertyValueFactory<Equipement, Integer>("categorie_equipement_id"));
    colnomU.setCellValueFactory(new PropertyValueFactory<Equipement, String>("nom_equipement"));
    colprenomU.setCellValueFactory(new PropertyValueFactory<Equipement, String>("etat_equipement"));
       coladresseU.setCellValueFactory(new PropertyValueFactory<Equipement, String>("description_equipement"));
    colmailU.setCellValueFactory(new PropertyValueFactory<Equipement, String>("image_equipement")); 
    
    ServiceEquipement ps = new ServiceEquipement();
        List<Equipement> personnes = ps.afficher();
        //dataList = FXCollections.observableList(personnes);
        dataList = FXCollections.observableList(personnes);
         
		TVuser.setItems(dataList);
                


    }    

         @FXML

     private void Delete(ActionEvent event) {
         
          ServiceEquipement ps = new ServiceEquipement();
           int x = Integer.parseInt(idsupp.getText());
        System.out.println(x);

        ps.Delete(x);
                     initialize(url, rb);

        /*ps.afficher();*/


        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Personne Updated");
        a.show();
        }
public void research()
{
  ServiceEquipement sm = new ServiceEquipement ();
        List<Equipement> lm = sm.recherchermutli(filterField.getText(),col,ord);
    TVuser.getItems().clear();
      ObservableList<Equipement> datalist = FXCollections.observableArrayList(lm);
        
         
        
        colidU.setCellValueFactory(new PropertyValueFactory<Equipement, Integer>("categorie_equipement_id"));
    colnomU.setCellValueFactory(new PropertyValueFactory<Equipement, String>("nom_equipement"));
    colprenomU.setCellValueFactory(new PropertyValueFactory<Equipement, String>("etat_equipement"));
       coladresseU.setCellValueFactory(new PropertyValueFactory<Equipement, String>("description_equipement"));
    colmailU.setCellValueFactory(new PropertyValueFactory<Equipement, String>("image_equipement")); 
       
         
         
    TVuser.setItems(datalist); 
    
}
@FXML
    private void exportPDF(MouseEvent event)throws ClassNotFoundException, ClassNotFoundException, SQLException, IOException, URISyntaxException, DocumentException {
        try {
        String file_name="C:/Users/21628/Desktop/xxx.pdf";
        Document doc=new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(file_name));
        doc.open();
        Paragraph para=new Paragraph("this is testing");
        doc.add(para); 
        PdfPTable my_report_table = new PdfPTable(4);
        PdfPCell table_cell;            
        table_cell=new PdfPCell(new Phrase("Nom"));
        table_cell.setBackgroundColor(BaseColor.WHITE);
        my_report_table.addCell(table_cell);
        table_cell=new PdfPCell(new Phrase("Etat"));
        table_cell.setBackgroundColor(BaseColor.WHITE);
        my_report_table.addCell(table_cell);
        table_cell=new PdfPCell(new Phrase("Description"));
        table_cell.setBackgroundColor(BaseColor.WHITE);
        my_report_table.addCell(table_cell);
        table_cell=new PdfPCell(new Phrase("Categorie"));
        table_cell.setBackgroundColor(BaseColor.WHITE);
        my_report_table.addCell(table_cell);
        //doc.add(my_report_table);
        String sql="select * from equipement ";
            
            
            List<String> nm =new ArrayList<String>();
            PreparedStatement ste;
            Statement st;
            Connection cnx;
            cnx = MyDB.getInstance().getConnection();
            st = cnx.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                my_report_table.setHeaderRows(1);
        
        
       
        
                 para =new Paragraph(rs.getString("nom_equipement"));
                 my_report_table.addCell(para);
//                doc.add(para);
//                doc.add(new Paragraph(""));
                para =new Paragraph(rs.getString("etat_equipement"));
                my_report_table.addCell(para);
//                doc.add(para);
//                doc.add(new Paragraph(""));
                para =new Paragraph(rs.getString("description_equipement"));
                my_report_table.addCell(para);
//                doc.add(para);
//                doc.add(new Paragraph(""));
                para =new Paragraph(rs.getString("categorie_equipement_id"));
                my_report_table.addCell(para);
//                doc.add(para);
//                doc.add(new Paragraph(""));
//                para =new Paragraph(rs.getString("image_equipement"));
//                my_report_table.addCell(para);
//                doc.add(para);
//                doc.add(new Paragraph(""));

                

                
            }
            doc.add(my_report_table);
        
        
        
        
        
        
        
        doc.close();
JOptionPane.showMessageDialog(null, "Impression effectuée");
    
        
    }
        catch (Exception e) {
       // TODO Auto-generated catch block
       //e.printStackTrace();
       System.out.println(e);
       }
        
}
    @FXML
    private void ordremag(ActionEvent event) {
        
            ord="ASC";
            if (combomag.getSelectionModel().equals("Nom"))
            col="nom_equipement";
        else if   (combomag.getSelectionModel().equals("Etat"))
            col="etat_equipement" ;
        else if   (combomag.getSelectionModel().equals("Categorie"))
            col="categorie_equipement_id" ;
      
        
        research();
    }
    @FXML
    private void ordremag1(ActionEvent event) {
        
            ord="DESC";
            if (combomag.getSelectionModel().equals("Nom"))
            col="nom_equipement";
        else if   (combomag.getSelectionModel().equals("Etat"))
            col="etat_equipement" ;
        else if   (combomag.getSelectionModel().equals("Categorie"))
            col="categorie_equipement_id" ;
      
        
        research();
    }
     @FXML
   private void trimag(ActionEvent event) {
        if (combomag.getSelectionModel().equals("Nom"))
            col="nom_equipement";
        else if   (combomag.getSelectionModel().equals("Etat"))
            col="etat_equipement" ;
        else if   (combomag.getSelectionModel().equals("Categorie"))
            col="categorie_equipement_id" ;
        
        research();
        

        

    }
   @FXML
    private void showchart(ActionEvent event){
       try {
           ServiceEquipement p = new ServiceEquipement();
           List<Equipement> lp=p.afficher();
    ObservableList<Equipement> data=FXCollections.observableArrayList(lp);
            FXMLLoader chart= new FXMLLoader(getClass().getResource("chartt.fxml"));
            Parent root = chart.load();
            ChartEqController mc = chart.getController();
           
           
            Scene scene = new Scene(root);
           Stage modifStage = new Stage();
            
            modifStage.setTitle("Nombre d'equipements par etat");
            modifStage.setScene(scene);
            modifStage.show();
            
             ChartEqController controller = chart.getController();
        controller.setReclamationData();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(AfficherEqFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

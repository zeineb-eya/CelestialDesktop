/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Planinng;
import java.io.File;
import java.io.FileOutputStream;

import util.MyDB;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
/*import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import comitextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entite.repas;
import static entite.repas.filename;*/
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.SystemTray;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import services.PlaninngService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AffichePlaninngController implements Initializable {
    

    
    ObservableList myList;
    @FXML
    private TableColumn<? , ?> id;
    @FXML
    private TableColumn<?, ?> nomplanning;
    @FXML
    private TableColumn<?, ?> dateDebutplanning;
    @FXML
    private TableColumn<?, ?> dateFinplanning;
    @FXML
    private TableColumn<?, ?> descriptionplanning;
    @FXML
    private TableColumn<?, ?> destinationplanning;
    @FXML
    private TableColumn<?, ?> periodeplanning;
    @FXML
    private TableColumn<?, ?> prixplanning;
    @FXML
    private TableView<?> tableplaninng;
    @FXML
    private Button refreshButton;
    @FXML
    private Button pdfbtn;
    @FXML
    private Button pdf;
   
                       


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherPlaninng();
    }
      @FXML
    private void supprimer(ActionEvent event) {
         PlaninngService ps = new PlaninngService();
        Planinng p = (Planinng) tableplaninng.getSelectionModel().getSelectedItem();
        ps.SupprimerPlaninng(p);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
               try {
             if(JOptionPane.showConfirmDialog(null,"attention vous avez supprimer votre planinng,est ce que tu et sure?"
                     ,"supprimer planinng",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
            if(p.getNomPlanning().length() != 0){
       
         alert.setContentText("Votre planinng a ete bien supprime");
         JOptionPane.showMessageDialog(null,"planinng supprime");
             }
            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ nom !");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());} 
       
    
    }
        private void afficherPlaninng() {

       PlaninngService ps = new PlaninngService();
        ObservableList<Planinng> Planinngs = FXCollections.observableArrayList(ps.afficherPlaninng());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomplanning.setCellValueFactory(new PropertyValueFactory<>("nomPlanning"));
        dateDebutplanning.setCellValueFactory(new PropertyValueFactory<>("dateDebutPlanning"));
        dateFinplanning.setCellValueFactory(new PropertyValueFactory<>("dateFinPlanning"));
         descriptionplanning.setCellValueFactory(new PropertyValueFactory<>("descriptionPlanning"));
         destinationplanning.setCellValueFactory(new PropertyValueFactory<>("destinationPlanning"));
         periodeplanning.setCellValueFactory(new PropertyValueFactory<>("periodePlanning"));
         prixplanning.setCellValueFactory(new PropertyValueFactory<>("prixPlanning"));

        
        myList = FXCollections.observableList(Planinngs);
                tableplaninng.setItems(myList);


    }

    @FXML
    private void modifierPlaninng(ActionEvent event) {
        
        Planinng p = (Planinng) tableplaninng.getSelectionModel().getSelectedItem();
         

if(p==null){
        
           System.out.println("Aucun planinng séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucun planinng séléctionné");

            alert.showAndWait();
     
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ModifierPlaninng.fxml"));
        Scene scene=new Scene(loader.load());
        

        ModifierPlaninngController pc = loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
       //int as=tableplaninng.getSelectionModel().getSelectedItem().getId();
       //String sub =tableplaninng.getSelectionModel().getSelectedItem().getNomPlanning();
        

         //          pc.setData(tableplaninng.getSelectionModel().getSelectedItem(),getId(),
           //        tableplaninng.getSelectionModel().getSelectedItem().getNomPlanning());
                 
                 
       
        } catch(IOException ex)
    {
     System.out.println("eer");
}
        }

}

    @FXML
    private void refresh(ActionEvent event) {
             PlaninngService ps = new PlaninngService();
        List<Planinng> planinngs = ps.refreshPlaninng();
        myList = FXCollections.observableList(planinngs);
        tableplaninng.setItems(myList);
       
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomplanning.setCellValueFactory(new PropertyValueFactory<>("nomPlanning"));
        dateDebutplanning.setCellValueFactory(new PropertyValueFactory<>("dateDebutPlanning"));
        dateFinplanning.setCellValueFactory(new PropertyValueFactory<>("dateFinPlanning"));
         descriptionplanning.setCellValueFactory(new PropertyValueFactory<>("descriptionPlanning"));
         destinationplanning.setCellValueFactory(new PropertyValueFactory<>("destinationPlanning"));
         periodeplanning.setCellValueFactory(new PropertyValueFactory<>("periodePlanning"));
         prixplanning.setCellValueFactory(new PropertyValueFactory<>("prixPlanning"));
                  
         tableplaninng.setItems(myList);
    
    }

    @FXML
    private void exportpdfbtn(ActionEvent event) {
                   PrinterJob job = PrinterJob.createPrinterJob();
       
        Node root= this.tableplaninng;
        
     if(job != null){
     job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
     Printer printer = job.getPrinter();
     PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
     boolean success = job.printPage(pageLayout, root);
     if(success){
        job.endJob();
     }
   }
    }

    @FXML
    private void pdf(ActionEvent event) {
             /*   PlaninngService ps = new PlaninngService();
              
        ObservableList<Planinng> Planinngs = FXCollections.observableArrayList(ps.afficherPlaninng());
        try {
            OutputStream file = new FileOutputStream(new File("D:\\pdf\\export.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();

            Font font = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Planinngs list", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);

            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(3);
            table.setHeaderRows(1);

            table.addCell("Name");
            table.addCell("Date");
            table.addCell("Description");

            list.forEach((_item) -> {
                table.addCell(_item.getNom());
                table.addCell(_item.getDescription());
                table.addCell(_item.getAdresse());
            });

            document.add(table);

            document.close();

            file.close();

        } catch (DocumentException | IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Cannot export data!");
            alert.show();
        }*/
    }
    }
   
    


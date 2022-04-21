/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Localisation;
import entities.Planinng;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import services.PlaninngService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AffichePlaninngController implements Initializable {
    

    
    ObservableList myList;
    @FXML
    private TableColumn<Planinng, Integer > id;
    @FXML
    private TableColumn<Planinng,String> nomplanning;
    @FXML
    private TableColumn<?, ?> dateDebutplanning;
    @FXML
    private TableColumn<?, ?> dateFinplanning;
    @FXML
    private TableColumn<Planinng, String> descriptionplanning;
    @FXML
    private TableColumn<?, ?> destinationplanning;
    @FXML
    private TableColumn<?, ?> periodeplanning;
    @FXML
    private TableColumn<?, ?> prixplanning;
 
        @FXML private TableView<Planinng> tableplaninng;

    @FXML
    private Button refreshButton;
    @FXML
    private Button pdfbtn;
    @FXML
    private Button pdf;
    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<?, ?> Details;
   
                       


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
                addButtonToTable();

                

    }
private void addButtonToTable() {
    PlaninngService ps = new PlaninngService();
        TableColumn<Planinng, Void> colBtn = new TableColumn("Localisation");

        Callback<TableColumn<Planinng, Void>, TableCell<Planinng, Void>> cellFactory = new Callback<TableColumn<Planinng, Void>, TableCell<Planinng, Void>>() {
            @Override
            public TableCell<Planinng, Void> call(final TableColumn<Planinng, Void> param) {
                final TableCell<Planinng, Void> cell = new TableCell<Planinng, Void>() {

                    private final Button btn = new Button("voir localisation");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Localisation l=ps.voirLocalisation(getTableView().getItems().get(getIndex()).getId()).stream().findFirst().get();
                            try {
                                //                            Planinng data = getTableView().getItems().get(getIndex());
                                showCustomerDialog(l);
                            } catch (IOException ex) {
                                Logger.getLogger(AffichePlaninngController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println("localisation: " + l.getPositionAriveePlanning())
                                    ;
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableplaninng.getColumns().add(colBtn);

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
       int as=tableplaninng.getSelectionModel().getSelectedItem().getId();
       String su =tableplaninng.getSelectionModel().getSelectedItem().getNomPlanning();

        

                   pc.setData(tableplaninng.getSelectionModel().getSelectedItem().getId(),
                 tableplaninng.getSelectionModel().getSelectedItem().getNomPlanning(),
                 tableplaninng.getSelectionModel().getSelectedItem().getDestinationPlanning(),
                 tableplaninng.getSelectionModel().getSelectedItem().getDescriptionPlanning(),
                 tableplaninng.getSelectionModel().getSelectedItem().getPeriodePlanning(),
                 tableplaninng.getSelectionModel().getSelectedItem().getPrixPlanning());
                 
                 
       
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
    private void search(ActionEvent event) {
                FilteredList<Planinng> filteredData = new FilteredList<>(myList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(planinng -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (planinng.getNomPlanning().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (planinng.getDestinationPlanning().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(planinng.getPrixPlanning()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Planinng> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableplaninng.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableplaninng.setItems(sortedData);
               
    }
public void showCustomerDialog(Localisation localisation) throws IOException {
  FXMLLoader loader = new FXMLLoader(
    getClass().getResource(
      "DetailsLocalisations.fxml"
    )
  );

  Stage stage = new Stage(StageStyle.DECORATED.DECORATED);
  stage.setScene(
    new Scene(loader.load())
  );

  DetailsLocalisationsController controller = loader.getController();
  controller.initData(localisation);

  stage.show();
}



    @FXML
    private void pdf(ActionEvent event) throws SQLException {
        PlaninngService ps = new PlaninngService();
              
        ObservableList<Planinng> Planinngs = FXCollections.observableArrayList(ps.afficherPlaninng());
        try {
            OutputStream file = new FileOutputStream(new File("C:\\pdf\\planinngs.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();

            Font font = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Planinng list", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);

            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(4);
            table.setHeaderRows(1);

            table.addCell("Name");
          //  table.addCell("Date Debut");
           // table.addCell("Date Fin");
            table.addCell("Destination Planinng");
           // table.addCell("prix planinng");
            table.addCell("periode planinng");
            table.addCell("prix planinng");

            Planinngs.forEach((Planinng p) -> {
                table.addCell(p.getNomPlanning());
                //table.addCell(p.getDateDebutPlanning());
               // table.addCell(p.getDateFinPlanning());
                table.addCell(p.getDestinationPlanning());
                //table.addCell(Integer.parseInt(p.getPeriodePlanning()));
              int pe = p.getPeriodePlanning();
              String ste =String.valueOf(pe); 
             table.addCell(ste);
               int pr = p.getPrixPlanning();
              String st =String.valueOf(pr); 
             table.addCell(st);
                
            });

            document.add(table);

            document.close();

            file.close();

        } catch (DocumentException | IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Cannot export data!");
            alert.show();
        }
    }





    }
   
    


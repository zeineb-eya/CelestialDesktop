/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageConfig;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import entities.Localisation;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import com.mycompany.services.LocalisationService;

/**
 * FXML Controller class
 *
 * @author skanr
 */
public class AfficherLocalisationController implements Initializable {

    
       ObservableList list;

    
    @FXML
    private TableColumn<?, ?> fusee;
    @FXML
    private TableColumn<Localisation, Integer> id;
     
    @FXML
    private TableView<Localisation> tableloca;
    @FXML
    private TableColumn<?, ?> heuredepartlocalisationcol;
    @FXML
    private TableColumn<?, ?> colheure_arrivee_loacalisation;
    @FXML
    private TableColumn<Localisation, String> colposition_depart_localisation;
    @FXML
    private TableColumn<?, ?> position_arivee_planning;
    @FXML
    private Button refreshButton;
    @FXML
    private Button qr;
    private Button map;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherlocalisation();
    }    
    @FXML
    private void supprimer(ActionEvent event) {
         LocalisationService ps = new LocalisationService();
        Localisation l = (Localisation) tableloca.getSelectionModel().getSelectedItem();
        ps.SupprimerLocalisation(l);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
               try {
             if(JOptionPane.showConfirmDialog(null,"attention vous avez supprimer votre localisation,est ce que tu et sure?"
                     ,"supprimer localisation",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
            if(l.getPositionDepartLocalisation().length() != 0){
       
         alert.setContentText("Votre localisation a ete bien supprime");
         JOptionPane.showMessageDialog(null,"localisation supprime");
             }
            else { JOptionPane.showMessageDialog(null,"veuillez remplire le champ nom !");}
        
        }catch (Exception e){JOptionPane.showMessageDialog(null,"erreur de supprimer \n"+e.getMessage());} 
       
    
    }
    private void afficherlocalisation() {

       LocalisationService ls = new LocalisationService();
        ObservableList<Localisation> localisations = FXCollections.observableArrayList(ls.afficherLocalisations());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        heuredepartlocalisationcol.setCellValueFactory(new PropertyValueFactory<>("heureDepartLocalisation"));
        
        colheure_arrivee_loacalisation.setCellValueFactory(new PropertyValueFactory<>("heureArriveeLoacalisation"));
        
        colposition_depart_localisation.setCellValueFactory(new PropertyValueFactory<>("positionDepartLocalisation"));
        
        position_arivee_planning.setCellValueFactory(new PropertyValueFactory<>("positionAriveePlanning"));
        
        fusee.setCellValueFactory(new PropertyValueFactory<>("fusee"));
        
        list = FXCollections.observableList(localisations);
        tableloca.setItems(list);


    }
    
    @FXML
    private void modifierLocalisation(ActionEvent event) {
        
        Localisation l = (Localisation) tableloca.getSelectionModel().getSelectedItem();
         

if(l==null){
        
           System.out.println("Aucune localisation séléctionné");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune localisation séléctionné");

            alert.showAndWait();
     
        }else {
          try {   
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ModifierLocalisation.fxml"));
        Scene scene=new Scene(loader.load());
        

        ModifierLocalisationController lc = loader.getController();
        Stage stageAff=new Stage();
        stageAff.setScene(scene);
        stageAff.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
         int as=tableloca.getSelectionModel().getSelectedItem().getId();
      String sub =tableloca.getSelectionModel().getSelectedItem().getHeureDepartLocalisation();
        

                   lc.setData(tableloca.getSelectionModel().getSelectedItem().getId(),
                   tableloca.getSelectionModel().getSelectedItem().getHeureDepartLocalisation(),
                  tableloca.getSelectionModel().getSelectedItem().getHeureArriveeLoacalisation(),
                 tableloca.getSelectionModel().getSelectedItem().getPositionDepartLocalisation(),
                tableloca.getSelectionModel().getSelectedItem().getPositionAriveePlanning(),
                tableloca.getSelectionModel().getSelectedItem().getFusee());
                 
                 
       
        } catch(IOException ex)
    {
     System.out.println("eer");
}
        }

}

    @FXML
    private void refresh(ActionEvent event) {
        LocalisationService ps = new LocalisationService();
        List<Localisation> localisations = ps.refreshLocalisation();
        list = FXCollections.observableList(localisations);
        tableloca.setItems(list);
       
       id.setCellValueFactory(new PropertyValueFactory<>("id"));
       heuredepartlocalisationcol.setCellValueFactory(new PropertyValueFactory<>("heureDepartLocalisation"));
       colheure_arrivee_loacalisation.setCellValueFactory(new PropertyValueFactory<>("heureArriveeLoacalisation"));
       colposition_depart_localisation.setCellValueFactory(new PropertyValueFactory<>("positionDepartLocalisation"));
       position_arivee_planning.setCellValueFactory(new PropertyValueFactory<>("positionAriveePlanning"));
       fusee.setCellValueFactory(new PropertyValueFactory<>("fusee"));
       tableloca.setItems(list);
    
    }

    @FXML
    private void generateqr(ActionEvent event) throws WriterException {
         LocalisationService ls = new LocalisationService();

                if (tableloca.getSelectionModel().getSelectedItem() != null) {
             try {
                 Localisation l = new Localisation();
                 l.setHeureDepartLocalisation(ls.liste2().get(tableloca.getSelectionModel().getSelectedIndex()).getHeureDepartLocalisation());
                 l.setHeureArriveeLoacalisation(ls.liste2().get(tableloca.getSelectionModel().getSelectedIndex()).getHeureArriveeLoacalisation());
                 l.setPositionDepartLocalisation(ls.liste2().get(tableloca.getSelectionModel().getSelectedIndex()).getPositionDepartLocalisation());
                 l.setPositionAriveePlanning(ls.liste2().get(tableloca.getSelectionModel().getSelectedIndex()).getPositionAriveePlanning());
                 l.setFusee(ls.liste2().get(tableloca.getSelectionModel().getSelectedIndex()).getFusee());
                 
                 Map hints = new HashMap();
                 hints.put(com.google.zxing.EncodeHintType.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.H);
                 com.google.zxing.qrcode.QRCodeWriter writer = new com.google.zxing.qrcode.QRCodeWriter();
                 com.google.zxing.common.BitMatrix BitMatrix = null;
                 ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 
                 // Create a qr code with the url as content and a size of 250x250 px
                 BitMatrix = writer.encode("heure depart= "+l.getHeureDepartLocalisation()+"  "+"heure arrive= "+l.getHeureArriveeLoacalisation()+"  "+"position depart=  "+l.getPositionDepartLocalisation()+"  "+"position arrive=  "+l.getPositionAriveePlanning()+"  "+"fusse=  "+l.getFusee(), BarcodeFormat.QR_CODE, 250, 250,(Hashtable)hints);
                /* MatrixToImageConfig config = new MatrixToImageConfig(MatrixToImageConfig.BLACK, MatrixToImageConfig.WHITE);
                 // Load QR image
                 BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(BitMatrix);*/
                 // Load logo image
                 File file = new File("C:\\qr\\data.png");
                 BufferedImage logoImage = ImageIO.read(file);
                 // Calculate the delta height and width between QR code and logo
                /* int deltaHeight = qrImage.getHeight() - logoImage.getHeight();
                 int deltaWidth = qrImage.getWidth() - logoImage.getWidth();*/
                 // Initialize combined image
              /*   BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
                 Graphics2D g = (Graphics2D) combined.getGraphics();*/
                 // Write QR code to new image at position 0/0
/*                 g.drawImage(qrImage, 0, 0, null);
                 g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
                 // Write logo into combine image at position (deltaWidth / 2) and
                 // (deltaHeight / 2). Background: Left/Right and Top/Bottom must be
                 // the same space for the logo to be centered
                 g.drawImage(logoImage, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);
                 // Write combined image as PNG to OutputStream
                 ImageIO.write(combined, "png", new File("C:\\qr\\QR.png"));
                 //System.out.println("done");*/
             } catch (IOException ex) {
                 Logger.getLogger(AfficherLocalisationController.class.getName()).log(Level.SEVERE, null, ex);
             }
           
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Choose a row !");
            alert.show();
        }
    }


}

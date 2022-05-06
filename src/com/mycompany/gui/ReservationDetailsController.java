/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entities.Reservation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class ReservationDetailsController implements Initializable {

    @FXML
    private Label date_reservation;
    @FXML
    private Label etat_reservation;
    @FXML
    private Label user;
    @FXML
    private Label billet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    void initData(Reservation r) {
   String datereservation = String.valueOf(r.getDateReservation());
    date_reservation.setText(datereservation);
    etat_reservation.setText(r.getEtatReservation());
     String u = String.valueOf(r.getUser());
    user.setText(u);
    String b = String.valueOf(r.getBillet());
    billet.setText(b);
    
    String etatres=String.valueOf(r.getEtatReservation());
    String qrCodeData = "Date Reservation: "+datereservation+" Etat Reservation"+etatres+" Billet: "+b+" User: "+u ;
    generate_qr(String.valueOf(r.getDateReservation()),qrCodeData);
  }
    public void generate_qr(String image_name,String qrCodeData) {
        try {
            String filePath = "QRCodeReservation/"+image_name+".png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

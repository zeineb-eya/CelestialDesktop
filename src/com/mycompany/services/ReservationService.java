/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;


import com.mycompany.entities.Reservation;
import com.mycompany.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author HP
 */
public class ReservationService {
    Connection cnx2;
    public ReservationService(){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    //requete statique
    public void ajouterReservation(){
        String req = "insert into reservation (date_reservation,etat_reservation,user_id,billet_id)"
                    + "values('2022-04-25','pending','1','1')";
        try {
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("Reservation ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    //requete dynamique
    public void ajouterReservation2(Reservation r){
//        String req = "insert into billet(chair_billet,voyage_num,terminal,portail,embarquement,localisation_id)"
//                    + "values( '" + b.getChairBillet() + "', '" + b.getVoyageNum() + "',"+ "" + b.getTerminal() + "', '" + b.getPortail() + "', '" ++ "', '" + b.getEmbarquement() + "', '" + b.getLocalisation()  + ")";
        try {
            String req2 = "insert into reservation (date_reservation,etat_reservation,user_id,billet_id)"
                    + "values(?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(req2);
            pst.setDate(1, r.getDateReservation());
            pst.setString(2, r.getEtatReservation());
            pst.setInt(3, r.getUser());
            pst.setInt(4, r.getBillet());
            pst.executeUpdate();
            System.out.println("Reservation ajoutee avec succes");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
    }
    public List<Reservation> afficherReservations(){
        List<Reservation> myList = new ArrayList<>();
        try {
            String req3 = "select * from reservation";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while (rs.next()){
                Reservation r = new Reservation();
                r.setId(rs.getInt("id"));
                r.setDateReservation(rs.getDate("date_reservation"));
                r.setEtatReservation(rs.getString("etat_reservation"));
                r.setUser(rs.getInt("user_id"));
                r.setBillet(rs.getInt("billet_id"));
                myList.add(r);
            }
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        return myList;
    }
    public void modifierReservation(Reservation r) {
        try {  
            String req4 = "update reservation set Etat_reservation = ? where id = ?";
            PreparedStatement pst = cnx2.prepareStatement(req4);
            pst.setString(1, r.getEtatReservation());
            pst.setInt(2, r.getId());
            pst.executeUpdate();
            System.out.println("Reservation modifiee avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerReservation(Reservation r) {
       try {  
            String req5 = "delete From reservation where id = ?";
            PreparedStatement pst = cnx2.prepareStatement(req5);
            pst.setInt(1, r.getId());
            pst.executeUpdate();
            System.out.println("Reservation suprimee avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        //serach  
     public Reservation findReservation_ByDate(String date_reservation) {

	return afficherReservations().stream().filter(Reservation -> date_reservation.equals(Reservation.getDateReservation())).findFirst().get();

    }
     public Reservation findReservation_ByEtat(String etat_reservation) {

	return afficherReservations().stream().filter(Reservation -> etat_reservation.equals(Reservation.getEtatReservation())).findFirst().get();

    }
        //sort
      public List<Reservation> sortByDate() {

	return afficherReservations().stream().sorted((a, b) -> a.getDateReservation().compareTo(b.getDateReservation())).collect(Collectors.toList());
    }
      public List<Reservation> sortByEtat() {

	return afficherReservations().stream().sorted((a, b) -> a.getEtatReservation().compareTo(b.getEtatReservation())).collect(Collectors.toList());
    }
}

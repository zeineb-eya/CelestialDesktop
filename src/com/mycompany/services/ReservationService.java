/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;


import com.mycompany.entities.Billet;
import com.mycompany.entities.Reservation;
import com.mycompany.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author HP
 */
public class ReservationService implements IserviceReservation<Reservation>{
    Connection cnx2;
     private Statement statement;
     private ResultSet ResultSet;
    private int nb1, nb2, nb3, nb4;
    public ReservationService(){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    //requete statique
    @Override
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
    @Override
    public void ajouterReservation2(Reservation r){
//        String req = "insert into billet(chair_billet,voyage_num,terminal,portail,embarquement,localisation_id)"
//                    + "values( '" + b.getChairBillet() + "', '" + b.getVoyageNum() + "',"+ "" + b.getTerminal() + "', '" + b.getPortail() + "', '" ++ "', '" + b.getEmbarquement() + "', '" + b.getLocalisation()  + ")";
        try {
            String req2 = "insert into reservation (user_id,date_reservation,billet_id,etat_reservation)"
                    + "values(?,DATE( NOW() ),?,'waiting for a confirmation')";
            PreparedStatement pst = cnx2.prepareStatement(req2);
            pst.setInt(1, r.getUser());
            //pst.setDate(2, r.getDateReservation());
            pst.setInt(2, r.getBillet());
            //pst.setString(4, r.getEtatReservation());
            pst.executeUpdate();
            System.out.println("Reservation ajoutee avec succes");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
    }
    @Override
    public List<Reservation> afficherReservations(){
        List<Reservation> myList = new ArrayList<>();
        try {
            String req3 = "select * from reservation";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while (rs.next()){
                Reservation r = new Reservation();
                r.setId(rs.getInt("id"));
                r.setUser(rs.getInt("user_id"));
                r.setDateReservation(rs.getDate("date_reservation"));
                r.setBillet(rs.getInt("billet_id"));
                r.setEtatReservation(rs.getString("etat_reservation"));
                myList.add(r);
            }
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        return myList;
    }
    @Override
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
    @Override
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
    @Override
     public Reservation findReservation_ByDate(String date_reservation) {

	return afficherReservations().stream().filter(Reservation -> date_reservation.equals(Reservation.getDateReservation())).findFirst().get();

    }
     @Override
     public Reservation findReservation_ByEtat(String etat_reservation) {

	return afficherReservations().stream().filter(Reservation -> etat_reservation.equals(Reservation.getEtatReservation())).findFirst().get();

    }
        //sort
     @Override
      public List<Reservation> sortByDate() {

	return afficherReservations().stream().sorted((a, b) -> a.getDateReservation().compareTo(b.getDateReservation())).collect(Collectors.toList());
    }
      @Override
      public List<Reservation> sortByEtat() {

	return afficherReservations().stream().sorted((a, b) -> a.getEtatReservation().compareTo(b.getEtatReservation())).collect(Collectors.toList());
    }
      //Etat
       public int pendingType() throws SQLException {
        String req = "SELECT count(id) from reservation where Etat_reservation ='waiting for a confirmation';";
        
        statement = cnx2.createStatement();
        ResultSet = statement.executeQuery(req);

        while (ResultSet.next()) {
            nb1 = ResultSet.getInt(1);
        }
        return nb1;
    }
       public int confirmedType() throws SQLException {
        String req = "SELECT count(id) from reservation where Etat_reservation ='confirmed';";
        
        statement = cnx2.createStatement();
        ResultSet = statement.executeQuery(req);

        while (ResultSet.next()) {
            nb2 = ResultSet.getInt(1);
        }
        return nb2;
    }
       public int cancelledType() throws SQLException {
        String req = "SELECT count(id) from reservation where Etat_reservation ='cancelled';";
        
        statement = cnx2.createStatement();
        ResultSet = statement.executeQuery(req);

        while (ResultSet.next()) {
            nb3 = ResultSet.getInt(1);
        }
        return nb3;
    }
    public List<Billet> detailsBilletJoinReservation(int id) {
       List<Billet> myList = new ArrayList<>();
       
        try {
         
        String req11 = "SELECT * from billet  join reservation on reservation.billet_id=billet.id where reservation.id="+id;
  // String req11 = "SELECT b.chair_billet, b.voyage_num, b.terminal, b.portail, b.embarquement, b.localisation_id, r.date_reservation,r.etat_reservation,r.user_id,r.billet_id from billet b join reservation r on reservation.billet_id=billet.id where reservation.id="+id;
        Statement st = cnx2.createStatement();
        ResultSet rs =  st.executeQuery(req11);
        while(rs.next()){
           Billet b = new Billet();
                b.setChairBillet(rs.getInt("chair_billet"));
                b.setVoyageNum(rs.getInt("voyage_num"));
                b.setTerminal(rs.getInt("terminal"));
                b.setPortail(rs.getInt("portail"));
                b.setEmbarquement(rs.getDate("embarquement"));
                b.setLocalisation(rs.getInt("localisation_id"));
                myList.add(b);
        }
        } catch (SQLException ex) {
         System.out.println(ex.getMessage()+"hhhhhh");
        }
        if(myList.isEmpty()){
        return Collections.emptyList();
                }
       return myList; 
    }
       public List<Reservation> detailsReservation(int id) {
       List<Reservation> myList = new ArrayList<>();
       
        try {
         
        String req11 = "SELECT * from reservation where id="+id;
        Statement st = cnx2.createStatement();
        ResultSet rs =  st.executeQuery(req11);
        while(rs.next()){
           Reservation r = new Reservation();
                r.setId(rs.getInt("id"));
                r.setUser(rs.getInt("user_id"));
                r.setDateReservation(rs.getDate("date_reservation"));
                r.setBillet(rs.getInt("billet_id"));
                r.setEtatReservation(rs.getString("etat_reservation"));
                
               
                myList.add(r);
        }
        } catch (SQLException ex) {
         System.out.println(ex.getMessage()+"hhhhhh");
        }
        if(myList.isEmpty()){
        return Collections.emptyList();
                }
       return myList; 
    }
}

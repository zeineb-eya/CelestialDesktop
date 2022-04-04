/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.entities.Billet;
import com.mycompany.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class BilletService {
    Connection cnx2;
    public BilletService(){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    //requete statique
    public void ajouterBillet(){
        String req = "insert into billet(chair_billet,voyage_num,terminal,portail,embarquement,localisation_id)"
                    + "values(1,1,1,1,'2022-04-25',1)";
        try {
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("Billet ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    //requete dynamique
    public void ajouterBiller2(Billet b){
//        String req = "insert into billet(chair_billet,voyage_num,terminal,portail,embarquement,localisation_id)"
//                    + "values( '" + b.getChairBillet() + "', '" + b.getVoyageNum() + "',"+ "" + b.getTerminal() + "', '" + b.getPortail() + "', '" ++ "', '" + b.getEmbarquement() + "', '" + b.getLocalisation()  + ")";
        try {
            String req2 = "insert into billet(chair_billet,voyage_num,terminal,portail,embarquement,localisation_id)"
                    + "values(?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(req2);
            pst.setInt(1, b.getChairBillet());
            pst.setInt(2, b.getVoyageNum());
            pst.setInt(3, b.getTerminal());
            pst.setInt(4, b.getPortail());
            pst.setString(5, b.getEmbarquement());
            pst.setInt(6, b.getLocalisation());
            pst.executeUpdate();
            System.out.println("Billet ajoutee avec succes");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
    }
    public List<Billet> afficherBillets(){
        List<Billet> myList = new ArrayList<>();
        try {
            String req3 = "select * from billet";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while (rs.next()){
                Billet b = new Billet();
                b.setId(rs.getInt("id"));
                b.setChairBillet(rs.getInt("chair_billet"));
                b.setVoyageNum(rs.getInt("voyage_num"));
                b.setTerminal(rs.getInt("terminal"));
                b.setPortail(rs.getInt("portail"));
                b.setEmbarquement(rs.getString("embarquement"));
                b.setLocalisation(rs.getInt("localisation_id"));
                myList.add(b);
            }
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
        return myList;
    }
    public void modifierBillet(Billet b) {
        try {  
            String req4 = "update billet set chair_billet= ?, voyage_num = ?, terminal = ?,portail= ?, embarquement = ?, localisation_id = ? where id = ?";
            PreparedStatement pst = cnx2.prepareStatement(req4);
            pst.setInt(1, b.getChairBillet());
            pst.setInt(2, b.getVoyageNum());
            pst.setInt(3, b.getTerminal());
            pst.setInt(4, b.getPortail());
            pst.setString(5, b.getEmbarquement());
            pst.setInt(6, b.getLocalisation());
            pst.setInt(7, b.getId());
            pst.executeUpdate();
            System.out.println("Billet modifiee avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerBillet(Billet b) {
       try {  
            String req5 = "delete From billet where id = ?";
            PreparedStatement pst = cnx2.prepareStatement(req5);
            pst.setInt(1, b.getId());
            pst.executeUpdate();
            System.out.println("Billet suprimee avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
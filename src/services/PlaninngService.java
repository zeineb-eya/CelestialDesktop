/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Planinng;
import util.MyDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author skanr
 */
public class PlaninngService implements Iservice<Planinng>{
    Connection connection;
    public PlaninngService(){
        connection = MyDB.getInstance().getConnection();
    }
    
public void ajouter(Planinng p) {
        try {
            String req1 = "insert into planinng(nom_planning,date_debut_planning,date_fin_planning,destination_planning,description_planning,periode_planning,prix_planning,img_planning) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req1);
            ps.setString(1, p.getNomPlanning());
            ps.setDate(2, (Date) p.getDateDebutPlanning());
            ps.setDate(3, (Date) p.getDateFinPlanning());
            ps.setString(4, p.getDestinationPlanning());
            ps.setString(5, p.getDescriptionPlanning());
            ps.setInt(6, p.getPeriodePlanning());
            ps.setInt(7, p.getPrixPlanning());
            ps.setString(8, p.getImg());

            ps.executeUpdate();
            System.out.println("Planinng ajoutee avec succes");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
    }


    @Override
   public List<Planinng>afficherPlaninng(){
            List<Planinng>myList = new ArrayList<>();
       
        try {
         
        String req11 = "SELECT * FROM planinng";
        Statement st = connection.createStatement();
        ResultSet rs =  st.executeQuery(req11);
        while(rs.next()){
            Planinng p = new Planinng();
             p.setId(rs.getInt("id"));
                p.setNomPlanning(rs.getString("nom_planning"));
                p.setDateDebutPlanning(rs.getDate("date_debut_planning"));
                p.setDateFinPlanning(rs.getDate("date_fin_planning"));
                p.setDestinationPlanning(rs.getString("destination_planning"));
                p.setDescriptionPlanning(rs.getString("description_planning"));
                p.setPeriodePlanning(rs.getInt("periode_planning"));
                p.setPrixPlanning(rs.getInt("prix_planning"));
                                p.setDescriptionPlanning(rs.getString("img_planning"));

            myList.add(p);
        }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
  
       return myList;
    }
    
     public ObservableList<Planinng> getPlaninngList() throws SQLException {
           
        ObservableList<Planinng> myList = FXCollections.observableArrayList();
        
         List <Planinng> rec = new ArrayList<>(); 
        Statement st = connection.createStatement();
        String query = "SELECT id, nom_planning, date_debut_planning, date_fin_planning, destination_planning, description_planning, periode_planning, prix_planning";

        //ResultSet rs;
        ResultSet rs = st.executeQuery(query);
        Planinng Planinng;
        while (rs.next()) {
           Planinng p = new Planinng(); 
           p.setId(rs.getInt("id"));
                p.setNomPlanning(rs.getString("nom_planning"));
                p.setDateDebutPlanning(rs.getDate("date_debut_planning"));
                p.setDateFinPlanning(rs.getDate("date_fin_planning"));
                p.setDestinationPlanning(rs.getString("destination_planning"));
                p.setDescriptionPlanning(rs.getString("description_planning"));
                p.setPeriodePlanning(rs.getInt("periode_planning"));
                p.setPrixPlanning(rs.getInt("prix_planning"));
                myList.add(p);

        }
        return myList;

    }
    public List<Planinng> recherchePlaninng(String nom_planning) {
         List<Planinng> planinngs = new ArrayList<Planinng>();
                   String req="SELECT * FROM planinng WHERE nom = '"+nom_planning+"' ";
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                planinngs.add(new Planinng(rs.getInt("id"),rs.getString("nomPlanning")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return planinngs;
        
    }


    @Override
  public void SupprimerPlaninng(Planinng p) {
       String req ="delete from planinng where id= ?";
         try {
            PreparedStatement pst=connection.prepareStatement(req);
             int id = p.getId();
             pst.setInt(1,id);
             pst.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(PlaninngService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    @Override
   public void updatePlaninng( Planinng p){
        String requete11="update planinng set nom_planning =?,date_debut_planning=?,date_fin_planning=?,destination_planning=?,description_planning=?,periode_planning=?,prix_planning=?,img_planning=? where id=?";
        try {
            
            PreparedStatement ps = connection.prepareStatement(requete11);
            ps.setInt(9,p.getId());
            ps.setString(1, p.getNomPlanning());
            ps.setDate(2, (Date) p.getDateDebutPlanning());
            ps.setDate(3, (Date) p.getDateFinPlanning());
            ps.setString(4, p.getDestinationPlanning());
            ps.setString(5, p.getDescriptionPlanning());
            ps.setInt(6,p.getPeriodePlanning());
            ps.setInt(7,p.getPrixPlanning());
            ps.setString(8,p.getImg());

           
            System.out.println(ps);
            ps.executeUpdate();
             System.out.println("votre Planinng a ete bien modife");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
     public List<Planinng> refreshPlaninng(){
                    List<Planinng>myList = new ArrayList<>();

        try{
        String requete3 = "SELECT * FROM planinng";
        Statement st = connection.createStatement();
        ResultSet rs =  st.executeQuery(requete3);
              while(rs.next()){
                Planinng p = new Planinng();
                p.setId(rs.getInt("id"));
                p.setNomPlanning(rs.getString("nom_planning"));
                p.setDateDebutPlanning(rs.getDate("date_debut_planning"));
                p.setDateFinPlanning(rs.getDate("date_fin_planning"));
                p.setDestinationPlanning(rs.getString("destination_planning"));
                p.setDescriptionPlanning(rs.getString("description_planning"));
                p.setPeriodePlanning(rs.getInt("periode_planning"));
                p.setPrixPlanning(rs.getInt("prix_planning"));
                myList.add(p);}   
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          }
          return myList;
    }

    @Override
    public void modifier(Planinng p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.entities.Reclamation;
import com.mycompany.entities.User;

import com.mycompany.utils.MyConnection;
import com.mycompany.utils.GlobalConfig;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
 */
public class ServiceReclamation {
    
    Connection cnx2;
    
    public ServiceReclamation(){
        cnx2 = MyConnection.getInstance().getCnx();
        
    }

    
    
    public void ajouterReclamation() {
        
        String requete = "INSERT INTO reclamation (description_reclamation,etat_reclamation,date_reclamation) "
                + "VALUES ('reclam1','envoye', DATE '2013-11-26')";
        
        try {
            Statement st = cnx2.createStatement();   //obtention de l'objet connexion en utilisant une instance de la classe myconnection
          st.executeUpdate(requete);
          System.out.println("reclamation ajoute avec succes");
       
        } catch (SQLException ex) {
          System.err.println(ex.getMessage());
        }
    }
    
    public void ajouterReclamation2(Reclamation r){
        String requete2 = "INSERT INTO reclamation (description_reclamation,etat_reclamation,date_reclamation,user_id,experiencee) "
                 + "VALUES(?,'envoye',?,?,?) ";
        
        try {
            //user_id,
           PreparedStatement pst = cnx2.prepareStatement(requete2);  //utilise pour les requete dynamique
          //pst.setInt(1, GlobalConfig.getInstance().getSession());
//          pst.setInt(1,r.getUser());
         //pst.setInt(1,r.getUser_id()) ;
           pst.setString(1, r.getDescription_reclamation());
             //  pst.setString(2, r.getEtat_reclamation());
         java.sql.Date date_reclamation = getCurrentDatetime(); 
         pst.setDate(2, date_reclamation);
         pst.setInt(3,r.getUser_id()) ;
           pst.setString(4,r.getExperiencee()) ;
     //  pst.setInt(3, user.getId());
        // pst.setUser(3, user);
          
           pst.executeUpdate();
           
           System.out.println("votre reclam est ajoute");
        
        
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        
    }
   public List<Reclamation>afficherReclamation(){
            List<Reclamation>myList = new ArrayList<>();
       
        try {
         
       // String requete3 = "SELECT * FROM reclamation  ORDER BY etat_reclamation ASC";
        
        String requete3 = "SELECT * FROM user join reclamation  on user.id=reclamation.user_id ORDER BY etat_reclamation ASC ";
       
        Statement st = cnx2.createStatement();;
        ResultSet rs =  st.executeQuery(requete3);
        while(rs.next()){
            Reclamation r = new Reclamation();
            r.setId(rs.getInt(1));
            r.setDescription_reclamation(rs.getString("description_reclamation"));
            r.setEtat_reclamation(rs.getString("etat_reclamation"));
            r.setDate_reclamation(rs.getString("date_reclamation"));
            //User user = new User();
         //  r.setUser_id(user.getId());
             //r.setUser_id(rs.getInt(user.getId()));
            r.setUser_id(rs.getInt(5));//temchii
           r.setExperiencee(rs.getString("experiencee"));
          
    myList.add(r);
        }
       } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
  
       return myList;
    }
  
   public List<Reclamation>detailsReclamation(int id){
            List<Reclamation>myList = new ArrayList<>();
       
        try {
         
        String requete3 = "SELECT * FROM reclamation  ORDER BY etat_reclamation ASC where id=?"+id;
        
        Statement st = cnx2.createStatement();;
        ResultSet rs =  st.executeQuery(requete3);
        while(rs.next()){
            Reclamation r = new Reclamation();
            r.setId(rs.getInt(1));
            r.setDescription_reclamation(rs.getString("description_reclamation"));
            r.setEtat_reclamation(rs.getString("etat_reclamation"));
            r.setDate_reclamation(rs.getString("date_reclamation"));
             int user=rs.getInt("user_id");
          
    myList.add(r);
        }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
  
       return myList;
    }
  
     
  public void deleteReclamation(Reclamation r) {
     
       String req ="delete from reclamation where id= ?";
         try {
            PreparedStatement pst=cnx2.prepareStatement(req);
             int id = r.getId();
             pst.setInt(1,id);
             pst.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    

     public void updateReclamation( Reclamation r){
        String requete2="update reclamation set description_reclamation=?,etat_reclamation='envoye' where id=?";
        try {
           
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1,r.getDescription_reclamation()); 
           pst.setInt(2,r.getId());
           
            System.out.println(pst);
            pst.executeUpdate();
             System.out.println("votre reclam a ete bien modife");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
     
      public void updateReclamationAdmin( Reclamation r){
        String requete2="update reclamation set etat_reclamation=? where id=?";
        try {
            
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1, "Traitée");
            pst.setInt(2,r.getId());
           
            System.out.println(pst);
            pst.executeUpdate();
             System.out.println("votre reclam a ete bien traité");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
  
     public List<Reclamation> TrouveReclamId(int id) throws SQLException
        
         {
                    List<Reclamation>myList = new ArrayList<>();
             String requete4="SELECT * FROM `reclamation` WHERE `id`=?";
               
              //Statement st = cnx2.createStatement();;
              PreparedStatement pst = cnx2.prepareStatement(requete4);
              //PreparedStatement stm=cnx.prepareStatement(req);
              pst.setInt(1,id);
      ResultSet rst= pst.executeQuery();
      while(rst.next())
      {
       Reclamation r = new Reclamation();
            r.setId(rst.getInt(1));
            r.setDescription_reclamation(rst.getString("description_reclamation"));
            r.setEtat_reclamation(rst.getString("etat_reclamation"));
            r.setDate_reclamation(rst.getString("date_reclamation"));
    
           myList.add(r);
      }
         
     return myList;
         }
     
    /* public   List<Reclamation>afficherReclamation(){
      String req= "select * from reclamation  INNER JOIN user where reclamation.user_id = user.id";
      
     List<Reclamation> list= new ArrayList<>();
         try {
      // PreparedStatement pst = cnx2.prepareStatement(requete2);
            PreparedStatement pst = cnx2.prepareStatement(req);

           //PreparedStatement  pst= cnx2.createStatement();
             ResultSet rst= pst.executeQuery(req);
             while(rst.next()){
              list.add(new Reclamation(rst.getInt("id"),rst.getInt("user_id"),rst.getString("description_reclamation"),rst.getString("etat_reclamation"),rst.getString("date_reclamation")));
                
             }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
         }
        
return list;
 }
     */
      
     public List<Reclamation> TrouveEtatReclam(String etat_reclamation) throws SQLException
          {
                    List<Reclamation>myList = new ArrayList<>();
             String requete5="SELECT * FROM `reclamation` WHERE `etat_reclamation`=?";
              //Statement st = cnx2.createStatement();;
              PreparedStatement pst = cnx2.prepareStatement(requete5);
              //PreparedStatement stm=cnx.prepareStatement(req);
              pst.setString(1,etat_reclamation);
      ResultSet rst= pst.executeQuery();
      while(rst.next())
      {
       Reclamation r = new Reclamation();
            r.setId(rst.getInt(1));
            r.setDescription_reclamation(rst.getString("description_reclamation"));
            r.setEtat_reclamation(rst.getString("etat_reclamation"));
            r.setDate_reclamation(rst.getString("date_reclamation"));
    
           myList.add(r);
      }
         
     return myList;
         }

     public List<Reclamation> TrouveDateReclam(Date date_reclamation) throws SQLException
          {
                    List<Reclamation>myList = new ArrayList<>();
             String requete5="SELECT * FROM `reclamation` WHERE `date_reclamation`=?";
              //Statement st = cnx2.createStatement();;
              PreparedStatement pst = cnx2.prepareStatement(requete5);
              //PreparedStatement stm=cnx.prepareStatement(req);

//LocalDate date = LocalDate.parse(date_reclamation, DateTimeFormatter.BASIC_ISO_DATE);
              pst.setDate(1,date_reclamation);
      ResultSet rst= pst.executeQuery();
      while(rst.next())
      {
       Reclamation r = new Reclamation();
            r.setId(rst.getInt(1));
            r.setDescription_reclamation(rst.getString("description_reclamation"));
            r.setEtat_reclamation(rst.getString("etat_reclamation"));
            r.setDate_reclamation(rst.getString("date_reclamation"));
    
           myList.add(r);
      }
         
     return myList;
         }

     
    private Date getCurrentDatetime() {
        java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
    }
     
     
    public List<Reclamation> refreshReclam(){
                    List<Reclamation>myList = new ArrayList<>();

        try{
        String requete3 = "SELECT * FROM reclamation ORDER BY etat_reclamation ASC";
        Statement st = cnx2.createStatement();
        ResultSet rs =  st.executeQuery(requete3);
        
              while(rs.next()){
                Reclamation r = new Reclamation();
                r.setId(rs.getInt("id"));
                r.setDescription_reclamation(rs.getString("description_reclamation"));
                r.setEtat_reclamation(rs.getString("etat_reclamation"));
                r.setDate_reclamation(rs.getString(4));
                r.setUser_id(rs.getInt("user_id")) ;
               
                myList.add(r);}   
              
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          };
          return myList;
    }
    
      public List<Reclamation> sortByEtat() {

	return afficherReclamation().stream().sorted((a, b) -> a.getEtat_reclamation().compareTo(b.getEtat_reclamation())).collect(Collectors.toList());
    }
 
    }
    


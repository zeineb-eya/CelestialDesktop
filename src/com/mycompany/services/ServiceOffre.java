/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;


import com.mycompany.utils.MyConnection;
import java.sql.Connection;
import com.mycompany.entities.Offre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;




/**
 *
 * @author ASUS
 */
public class ServiceOffre {
    
     Connection cnx2;
    
    public ServiceOffre(){
        cnx2 = MyConnection.getInstance().getCnx();
        
    }

     public void ajouterOffre(Offre o){
        
        String requete2 = "INSERT INTO offre (nom_offre,description_offre,prix_offre,reduction,date_debut_offre,date_fin_offre) "
                 + "VALUES(?,?,?,?,?,?)";
        
        try {
           PreparedStatement pst = cnx2.prepareStatement(requete2);  //utilise pour les requete dynamique
           pst.setString(1, o.getNom_offre());
           pst.setString(2, o.getDescription_offre());
           pst.setDouble(3, o.getPrix_offre());
           pst.setDouble(4, o.getReduction());
           pst.setDate(5, o.getDate_debut_offre());
           pst.setDate(6, o.getDate_fin_offre());
           
           pst.executeUpdate();
           
           System.out.println("votre offre est ajoute");
        
        
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
     }
        
        
      public List<Offre>afficherOffre(){
       List<Offre>myList = new ArrayList<>();
       
        try {
         
        String requete3 = "SELECT * FROM offre";
        Statement st = cnx2.createStatement();;
        ResultSet rs =  st.executeQuery(requete3);
        while(rs.next()){
            Offre o = new Offre();
            o.setId(rs.getInt(1));
            o.setNom_offre(rs.getString("nom_offre"));
            o.setDescription_offre(rs.getString("description_offre"));
            o.setPrix_offre(rs.getInt("prix_offre"));
            o.setReduction(rs.getInt("reduction"));
            o.setDate_debut_offre(rs.getDate("date_debut_offre"));
            o.setDate_fin_offre(rs.getDate("date_fin_offre"));
             myList.add(o);
        }
         //   st = new MyConnection().getCnx().createStatement();
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
  
       return myList;
   
    }
      
      public void deleteOffre(Offre o) {
        String req = "delete from offre where id= ?";
       /* try {
            PreparedStatement pst = cnx2.prepareStatement(req);
           // pst = Connection.createStatement();
            pst.executeUpdate(req);
             System.out.println("votre offre a ete bien supprime");

        } catch (SQLException ex) {
            //Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex.getMessage());
        }*/
       try {
            PreparedStatement pst=cnx2.prepareStatement(req);
             int id = o.getId();
             pst.setInt(1,id);
             pst.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

      public void updateOffre(Offre o){

          //String requete2="UPDATE offre SET nom_offre='"+nom_offre+"',description_offre='"+description_offre+"', prix_offre='"+prix_offre+"',reduction='"+reduction+"' ,date_debut_offre='"+date_debut_offre+"' ,date_fin_offre='"+date_fin_offre+"'  WHERE id='"+id+"'";
 /*  try{
          PreparedStatement pst = cnx2.prepareStatement(requete2);
   pst.executeUpdate(requete2);
            System.out.println("annoncerepas modifi??");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }    */
   
      String requete2="update offre set nom_offre=?,description_offre=?,prix_offre=?,reduction=? where id=?";
      
        try {
            
           // pst=connection.prepareStatement(req);
           //Statement st = cnx2.createStatement();
            PreparedStatement pst = cnx2.prepareStatement(requete2);
           
            pst.setString(1,o.getNom_offre()); 
            pst.setString(2,o.getDescription_offre());
            pst.setDouble(3,o.getPrix_offre());
             pst.setInt(4,o.getReduction());
           // pst.setDouble(4,o.getReduction());
            //pst.setString(5,o.getDate_debut_offre());
            //pst.setString(6,o.getDate_fin_offre());
            pst.setInt(5,o.getId());
            System.out.println(pst);
           // pst.execute();
            pst.executeUpdate();

            System.out.println("votre offre a ete bien modife");
        } catch (SQLException e) {
           e.printStackTrace();
           //  Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, e);
        }

    }
      
       public List<Offre> refreshOffre(){
         List<Offre>myList = new ArrayList<>();

        try{
        String requete3 = "SELECT * FROM offre";
        Statement st = cnx2.createStatement();
        ResultSet rs =  st.executeQuery(requete3);
            while(rs.next()){
                Offre o = new Offre();
               o.setId(rs.getInt("id"));
               o.setNom_offre(rs.getString("nom_offre"));
               o.setDescription_offre(rs.getString(3));
               o.setPrix_offre(rs.getInt(4));
               o.setReduction(rs.getInt(5));
               o.setDate_debut_offre(rs.getDate(6));
               o.setDate_fin_offre(rs.getDate(7));

                myList.add(o);}   
              
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          };
          return myList;
    }
     
      
      
      
         public List<Offre> TrouveOffreId(int id) throws SQLException
        
         {
                    List<Offre>myList = new ArrayList<>();
             String requete4="SELECT * FROM `offre` WHERE `id`=?";
               
              //Statement st = cnx2.createStatement();;
              PreparedStatement pst = cnx2.prepareStatement(requete4);
              //PreparedStatement stm=cnx.prepareStatement(req);
              pst.setInt(1,id);
      ResultSet rst= pst.executeQuery();
      while(rst.next())
      {
       Offre o = new Offre();
            o.setId(rst.getInt(1));
            o.setNom_offre(rst.getString("nom_offre"));
            o.setDescription_offre(rst.getString("description_offre"));
            o.setPrix_offre(rst.getInt("prix_offre"));
            o.setReduction(rst.getInt("reduction"));
            o.setDate_debut_offre(rst.getDate("date_debut_offre"));
            o.setDate_fin_offre(rst.getDate("date_fin_offre"));
    
           myList.add(o);
      }
         
     return myList;
         }
         
         
         public List<Offre> TrouvePrixOffre(double prix_offre) throws SQLException
        
         {
                    List<Offre>myList = new ArrayList<>();
             String requete="SELECT * FROM `offre` WHERE `prix_offre`=?";
               
              //Statement st = cnx2.createStatement();;
              PreparedStatement pst = cnx2.prepareStatement(requete);
              //PreparedStatement stm=cnx.prepareStatement(req);
              pst.setDouble(1,prix_offre);
      ResultSet rst= pst.executeQuery();
      while(rst.next())
      {
       Offre o = new Offre();
            o.setId(rst.getInt(1));
            o.setNom_offre(rst.getString("nom_offre"));
            o.setDescription_offre(rst.getString("description_offre"));
            o.setPrix_offre(rst.getInt("prix_offre"));
            o.setReduction(rst.getInt("reduction"));
            o.setDate_debut_offre(rst.getDate("date_debut_offre"));
            o.setDate_fin_offre(rst.getDate("date_fin_offre"));
    
           myList.add(o);
          //afficherOffre();
      }
         
     return myList;
         }
         
      //********* serach offer 2   
     public Offre findByname_Offer(String nom_offre) {

	return afficherOffre().stream().filter(Offre -> nom_offre.equals(Offre.getNom_offre())).findFirst().get();

    }
         
     
      public List<Offre> sortByName() {

	return afficherOffre().stream().sorted((a, b) -> a.getNom_offre().compareTo(b.getNom_offre())).collect(Collectors.toList());
    }
      
    
}
    


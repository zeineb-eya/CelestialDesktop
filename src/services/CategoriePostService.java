/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import gui.Message.LibMessageBox;
import entities.CategoriePost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyDB;


/**
 *
 * @author khawl
 */
public class CategoriePostService extends LibMessageBox implements Iservice<CategoriePost> {
Connection cnx;
    public CategoriePostService() {
        cnx = MyDB.getInstance().getConnection();
    }
    
    public void ajouter(CategoriePost t) {
                String sql = "insert into  categorie_post(nom_categorie_post) values ('"+t.getNom_categorie_post()+"')";
                try {
                      Statement ste = cnx.createStatement();
                      ste.executeUpdate(sql);
                      System.out.println("category Ajoutee");
                      this.Info ("Category Ajoutee"," validation d'insertion Category");
                      
                    } catch (SQLException e) {  System.out.println("ERROR DB : " + e.getMessage());  this. BoîteDialogueExceptions (  e) ; }
    }

    
    public void modifier(CategoriePost t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try  {
            Statement stmt = this.cnx.createStatement();
            //UPDATE `categorie_post` SET `nom_categorie_post` = 'espace28' WHERE `categorie_post`.`id` = 72; 
           String sql="UPDATE `categorie_post` SET `nom_categorie_post` = '"+t.getNom_categorie_post()+"' WHERE `categorie_post`.`id` = "+t.getId(); 
          //UPDATE `categorie_post` SET `nom_categorie_post` = "vv1" WHERE `nom_categorie_post` ="vv"
      
          
           stmt.executeUpdate(sql);
            System.out.println("categorie modifier");
            this.Info ("categorie modifier"," validation d'modifier Category");
          } 
     catch (SQLException e) {   System.out.println("ERROR DB :"+e.getMessage()); this. BoîteDialogueExceptions (  e) ; }
    }

    
    public void supprimer(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
               try  {
                      //String sql = "DELETE FROM `categorie_post` WHERE `categorie_post`.`id` = '"+id+"'";  
                    //  DELETE FROM `post` WHERE  `post`.`categorie_post_id`  = 72; DELETE FROM `categorie_post` WHERE  `categorie_post`.`id`  = 72
                      String sql = "DELETE FROM `post` WHERE  `post`.`categorie_post_id` = "+id+";";      
                      System.out.println(sql);
                      Statement stmt = this.cnx.createStatement();
                        stmt.executeUpdate(sql);
                       sql = "DELETE FROM `categorie_post` WHERE  `categorie_post`.`id` = "+id+"";
                      stmt.executeUpdate(sql);
                      System.out.println("POST supprimer");
                      this.Info ("categorie supprimer"," validation d'supprimer Category");
                    } 
               catch (SQLException e) {   System.out.println("ERROR DB :"+e.getMessage());  this. BoîteDialogueExceptions (  e ) ;  }
    }

   
    public List<CategoriePost> recuperer() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         List<CategoriePost> list =new ArrayList<>();
          try {
            String req = "SELECT * FROM `categorie_post`";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
            
            while(rs.next()){
                CategoriePost C = new CategoriePost();
                C.setId(rs.getInt(("id")));  
                C.setNom_categorie_post(rs.getString("nom_categorie_post")); 
                list.add(C);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           return list;
    }
    
    
           /*  public List<CategoriePost> RechercherCategorie(CategoriePost c) {
                                   
       java.util.List<CategoriePost> Categorie = new ArrayList<>();
        String query="select * from categorie_post where `categorie_post`.`id`='" +c.getId()+ "'";;
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                CategoriePost rec = new CategoriePost();
                rec.setId(rs.getInt("id"));
                
                rec.setNom_categorie_post(rs.getString("nom_categorie_post"));
               
             
                Categorie.add(rec);
    
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
        
        return Categorie;
         }*/
    
     public List<CategoriePost> RechercherCategorie(String search) {
       java.util.List<CategoriePost> list = new ArrayList<>();
      
        String query="select * from categorie_post  "+ ( (( search.length() == 0 )||(search == " ")) ? "" : "where `id`="+search+" ");
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
                while(rs.next()){
                CategoriePost C = new CategoriePost();
                C.setId(rs.getInt(("id")));  
                C.setNom_categorie_post(rs.getString("nom_categorie_post")); 
                list.add(C);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
         }
 
     
         public List<CategoriePost> recuperer2() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         List<CategoriePost> list =new ArrayList<>();
          try {
            String req = " SELECT * FROM `categorie_post` WHERE EXISTS ( SELECT * FROM `post`  WHERE  `categorie_post`.`id` = `post`.`categorie_post_id` );";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
            
            while(rs.next()){
                CategoriePost C = new CategoriePost();
                C.setId(rs.getInt(("id")));  
                C.setNom_categorie_post(rs.getString("nom_categorie_post")); 
                list.add(C);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           return list;
    }
    
     
     
     
       public int findID_Categorie  (   String Nom_categorie_post) {
           int id = 0;
           List<CategoriePost> ListCategorie = this.recuperer2(); 
         for( CategoriePost oneListCategorie : ListCategorie) { 
             if (Nom_categorie_post.equals(oneListCategorie.getNom_categorie_post())) {      id = oneListCategorie.getId();}
           }  
       return id;
       }
}
 
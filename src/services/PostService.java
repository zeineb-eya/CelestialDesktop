/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import  Libs.FileManagement;
import gui.Message.LibMessageBox;
import java.io.ByteArrayInputStream;
import entities.Post;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.util.List;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyDB;

/**
 *
 * @author khawl
 */
 
public class PostService  extends LibMessageBox  implements Iservice<Post> {
private Connection cnx;
 FileManagement obj_FileManagement ; 
private PreparedStatement pstmt ;
    public PostService() {
        obj_FileManagement =  new  FileManagement ( );
        cnx = MyDB.getInstance().getConnection(); 
    }
    public void ajouter(Post t) { 
      
   try {    this.pstmt = cnx.prepareStatement("INSERT INTO `post` (   `categorie_post_id`, `nom`, `img_post`, `description_post`) VALUES(?,?,?,?)");
           // this. pstmt.setInt(1,  t.getUserId());
             this. pstmt.setInt(1, t.getCategoriePost_ID());
             this. pstmt.setString(2, t.getNom());
               //       obj_FileManagement.readImageAsBytes(t.getImg_post());     old  !!!!!
              //   this.pstmt.setBlob(4, obj_FileManagement.targetStream);      old  !!!!!
              this.  pstmt.setBlob(3,  new ByteArrayInputStream(t.getByte_img_post()));
              this.  pstmt.setString(4,t.getDescription_post() );
              this.  pstmt.execute();
               this.Info ("POST Ajoutee"," validation d'insertion POST");
               System.out.println("POST Ajoutee");
        } catch (SQLException e) { e.printStackTrace();} 
 
 
    }

    public void modifier(Post t) { 
     try  {  
             this.pstmt = cnx.prepareStatement("UPDATE `post` SET `categorie_post_id`=?, `nom`=?, `img_post`= ?, `description_post` = ?  WHERE `post`.`id`=? "); 
            //this. pstmt.setInt(1,  t.getUserId());
             this. pstmt.setInt(1, t.getCategoriePost_ID());
             this. pstmt.setString(2, t.getNom());
               //       obj_FileManagement.readImageAsBytes(t.getImg_post());     old  !!!!!
              //   this.pstmt.setBlob(4, obj_FileManagement.targetStream);      
              this.  pstmt.setBlob(3,  new ByteArrayInputStream(t.getByte_img_post()));
              this.  pstmt.setString(4,t.getDescription_post() );
              this.  pstmt.setInt(5,t.getId());
              this.  pstmt.execute();
              this.Info ("POST modifier"," validation d'modifier POST");
            System.out.println("POST modifier");
          } 
     catch (SQLException e) {   System.out.println("ERROR DB :"+e.getMessage());
      //this. BoîteDialogueExceptions (  e) ;
     }





        
    }

    public void supprimer(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
      
        try  { //DELETE FROM `commentaire` WHERE `commentaire`.`id` = 36;
           String   sql = "DELETE FROM `commentaire` WHERE `commentaire`.`post_id` = "+id+"";
         Statement  stmt = this.cnx.createStatement();
         stmt.executeUpdate(sql);          
                      
              //DELETE FROM `post` WHERE `post`.`id` = 108          
           sql = "DELETE FROM `post` WHERE `post`.`id` = "+id+"";
           stmt = this.cnx.createStatement();
         stmt.executeUpdate(sql);
         this.Info ("POST supprimer"," validation d'supprimer POST");
         System.out.println("POST supprimer");
          } 
     catch (SQLException e) {   System.out.println("ERROR DB :"+e.getMessage());
      this. BoîteDialogueExceptions (  e) ;
     }
         
         
    }

    public List<Post> recuperer() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
      
        List<Post> list =new ArrayList<>();
        try {
            String req = "SELECT * FROM `post`";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
            
            while(rs.next()){ 
                list.add(  new Post(
                        rs.getInt(("id")),
                        rs.getInt(("user_id")),
                        rs.getInt(("categorie_post_id")),
                        rs.getString("nom"),
                        rs.getBytes("img_post"),  //obj_FileManagement.writeBytesToImage(rs.getBytes("img_post")),// new Image("img/empty_file_icon.png")  , //o
                        rs.getString("description_post")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list; 
      
    }
    
   
         public List<Post> RechercherPost(String search) {
       java.util.List<Post> list = new ArrayList<>();
      
        String query="select * from post  "+ ( (( search.length() == 0 )||(search == " ")) ? "" : "where `id`="+search+" ");
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
             while(rs.next()){ 
                list.add(  new Post(
                        rs.getInt(("id")),
                        rs.getInt(("user_id")),
                        rs.getInt(("categorie_post_id")),
                        rs.getString("nom"),
                        rs.getBytes("img_post"),  //obj_FileManagement.writeBytesToImage(rs.getBytes("img_post")),// new Image("img/empty_file_icon.png")  , //o
                        rs.getString("description_post")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
         }
    
    
      public List<Post> RechercherWithCathegorieId(int  CathegorieId) {
       java.util.List<Post> list = new ArrayList<>(); 
        try {
           String query="select * from post where `categorie_post_id`="+CathegorieId+" " ;
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
             while(rs.next()){ 
                list.add(  new Post(
                        rs.getInt(("id")),
                        rs.getInt(("user_id")),
                        rs.getInt(("categorie_post_id")),
                        rs.getString("nom"),
                        rs.getBytes("img_post"),  //obj_FileManagement.writeBytesToImage(rs.getBytes("img_post")),// new Image("img/empty_file_icon.png")  , //o
                        rs.getString("description_post")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
         }
      
      
      
      
      
      
       public List<Post> RechercherWithNom(String   Nom) {
       java.util.List<Post> list = new ArrayList<>(); 
        try {  // select * from post where `nom` LIKE '%fhzoe%'; 
           String query="select * from post  "+ ( (( Nom.length() == 0 )||(Nom == " ")) ? "" : "where `nom` LIKE '%"+Nom+"%' ");
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
             while(rs.next()){ 
                list.add(  new Post(
                        rs.getInt(("id")),
                        rs.getInt(("user_id")),
                        rs.getInt(("categorie_post_id")),
                        rs.getString("nom"),
                        rs.getBytes("img_post"),  //obj_FileManagement.writeBytesToImage(rs.getBytes("img_post")),// new Image("img/empty_file_icon.png")  , //o
                        rs.getString("description_post")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
         } 
     
    
}

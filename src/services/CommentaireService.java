/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import gui.Message.LibMessageBox;
import entities.Commentaire;
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

   
   
public class CommentaireService extends LibMessageBox implements Iservice<Commentaire>{

    
     Connection cnx;
    public  CommentaireService() {
        cnx = MyDB.getInstance().getConnection();
    }
    public void ajouter(Commentaire t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates primary key yitna7a 
     //INSERT INTO `commentaire` (`id`, `post_id`, `date_commentaire`, `msg_commentaire`) VALUES (NULL, '31', '2022-04-12', 'msg comment');"
     System.out.println("AAAAA"+t.getPost());
        String sql="INSERT INTO `commentaire` (`post_id`,`rating`, `date_commentaire`, `msg_commentaire`) VALUES ( '"+t.getPost()+"','"+t.getrating()+"', '"+ t.getDate_commentaire()+"', '"+t.getMsg_commentaire()+"')";//t.getPost()
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("commentaire Ajoutee");
            this.Info ("commentaire Ajoutee"," validation d'insertion commentaire");
        } catch (SQLException e) {this. BoîteDialogueExceptions (  e) ;
            System.out.println("ERROR DB :"+e.getMessage());
        }
    }

    public void modifier(Commentaire t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try  {
               Statement stmt = this.cnx.createStatement();
               String sql="UPDATE `commentaire` SET `post_id` = "+t.getPost()+",`rating`='"+t.getrating()+"', `date_commentaire` = '"+ t.getDate_commentaire()+"', `msg_commentaire` = '"+t.getMsg_commentaire()+"' WHERE `commentaire`.`id` = "+t.getId()+""; 
          
               stmt.executeUpdate(sql);
               System.out.println("commentaire modifier");
               this.Info ("categorie Commentaire"," validation d'modifier Commentaire");
              } 
          catch (SQLException e) {   System.out.println("ERROR DB :"+e.getMessage());  this. BoîteDialogueExceptions (  e) ;  }
    }

    public void supprimer(int id) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.*
               try  {
                      String sql = "DELETE FROM `commentaire` WHERE `commentaire`.`id` = '"+id+"'";   
                      Statement stmt = this.cnx.createStatement();
                      stmt.executeUpdate(sql);
                      System.out.println("commentaire supprimer");
                       this.Info ("commentaire supprimer"," validation d'supprimer commentaire");
                    } 
               catch (SQLException e) {   System.out.println("ERROR DB :"+e.getMessage());  this. BoîteDialogueExceptions (  e ) ;  }
    }

    public List<Commentaire> recuperer() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           List<Commentaire> list =new ArrayList<>();
        try {
            String req = "SELECT * FROM `commentaire`";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
            
            while(rs.next()){
                Commentaire C = new Commentaire();
                C.setId(rs.getInt(("id"))); 
                C.setPost(rs.getInt("post_id"));
                C.setrating(rs.getDouble("rating"));
                C.setDate_commentaire(rs.getString("date_commentaire"));
                C.setMsg_commentaire(rs.getString("msg_commentaire"));
                list.add(C);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
   
    
    
    
    
    
    
    

       public List<Commentaire> RechercherCategorie(String post_id) {
       java.util.List<Commentaire> list = new ArrayList<>();
        String query="select * from commentaire " + ( (( post_id.length() == 0 )||(post_id == "")) ? "" : "where `post_id`="+post_id+" ");
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
               Commentaire C = new Commentaire();
                C.setId(rs.getInt(("id"))); 
                C.setPost(rs.getInt("post_id"));
                C.setrating(rs.getDouble("rating"));
                C.setDate_commentaire(rs.getString("date_commentaire"));
                C.setMsg_commentaire(rs.getString("msg_commentaire"));
                list.add(C); 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
         }
}

        
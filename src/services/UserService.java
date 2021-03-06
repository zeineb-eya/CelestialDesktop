/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.Iservice;
import util.MyDB;
/**
 *
 * @author Cipher
 */
public class UserService implements Iservice<User> {
    private Connection cnx;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
   private Connection connection;
   private PreparedStatement ps;
   
    public UserService() {
        connection = MyDB.getInstance().getConnection();
    }
 //@Override
    public void ajouter(User t) {
        try {
//            
            
            String req1 = "insert into user(nom_utilisateur,prenom_utilisateur,adresse_utilisateur,mail_utilisateur,password,Numero_utilisateur,nom_role_id) values (?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(req1);
            ps.setString(1, t.getNom_utilisateur());
            ps.setString(2, t.getPrenom_utilisateur());
            ps.setString(6, t.getNumero_utilisateur());
            ps.setInt(7, t.getNomRoleId());
            ps.setString(5, t.getPassword());
            ps.setString(4, t.getMail_utilisateur());
            ps.setString(3, t.getAdresse_utilisateur());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   public List<User> recuperer() {
        List<User> list =new ArrayList<>();
        try {
            String req = "select * from user";
            Statement st = connection.createStatement();
            ResultSet rs =st.executeQuery(req);
            
            while(rs.next()){
               User p = new User();
                               p.setId(rs.getInt("id"));
                               p.setNomRoleId(rs.getInt("nom_role_id"));
                p.setNom_utilisateur(rs.getString("nom_utilisateur"));
                p.setPrenom_utilisateur(rs.getString("prenom_utilisateur"));
                               p.setAdresse_utilisateur(rs.getString("adresse_utilisateur"));
                p.setNumero_utilisateur(rs.getString("numero_utilisateur"));
                p.setMail_utilisateur(rs.getString("mail_utilisateur"));
                p.setPassword(rs.getString("password"));
                //System.out.println(p);
                list.add(p);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
   
   

   
    public void Update(User t) {

      
            String req1 = "UPDATE user SET nom_utilisateur =?,prenom_utilisateur=?,adresse_utilisateur=?,mail_utilisateur=?,password=?,numero_utilisateur=?WHERE id= ?";

  try {
            ps = connection.prepareStatement(req1);
                        ps.setInt(7, t.getId());
            ps.setString(1, t.getNom_utilisateur());
            ps.setString(2, t.getPrenom_utilisateur());
            ps.setString(6, t.getNumero_utilisateur());
                       ps.setString(5, t.getPassword());
            ps.setString(4, t.getMail_utilisateur());
            ps.setString(3, t.getAdresse_utilisateur());
            ps.executeUpdate();
            System.out.print(t);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    
    
    
    
    
     public void Delete(int id) {
        try {
//            
String req1 = "DELETE FROM user WHERE id= " + id;

           ps= connection.prepareStatement(req1);
                        
            ps.executeUpdate(); 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      public void Delete(User u) {
        try {
//            
String req1 = "DELETE FROM user WHERE id= ?";

           ps= connection.prepareStatement(req1);
                         ps.setInt(1, u.getId());
            ps.executeUpdate(); 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public Map<String, Integer> NbPdtByCat() {
        Map<String, Integer> mp =new HashMap<>();
        try {
           
                        Statement st = connection.createStatement();

            
            String query="SELECT count(*) as nbp, adresse_utilisateur  FROM  user group by adresse_utilisateur ";
            rs=st.executeQuery(query);
            while(rs.next()){
               
                mp.put(rs.getString("adresse_utilisateur"),rs.getInt("nbp"));
            }
            
        } catch (SQLException ex) {
            System.out.println(" erreur d'affichage du magasin  ");
        }
        return mp ;
    }
    
}

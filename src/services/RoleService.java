/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Role;
import entities.User;
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
 * @author Cipher
 */
public class RoleService  implements Iservice<Role>{
     private Connection connection;
   private PreparedStatement ps;
   
    public RoleService() {
        connection = MyDB.getInstance().getConnection();
    }
     public void ajouter(Role t) {
        try {
//            
            
            String req1 = "insert into role(nom_role,description_role) values (?,?)";
            ps = connection.prepareStatement(req1);
            ps.setString(1, t.getNom_role());
            ps.setString(2, t.getDescription_role());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       public List<Role> recuperer() {
        List<Role> list =new ArrayList<>();
        try {
            String req = "select * from role";
            Statement st = connection.createStatement();
            ResultSet rs =st.executeQuery(req);
            
            while(rs.next()){
               Role p = new Role();
                               p.setId(rs.getInt("id"));
                p.setNom_role(rs.getString("nom_role"));
                p.setDescription_role(rs.getString("description_role"));
                
System.out.println(p);
                list.add(p);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
   
   public void Delete(int id) {
        try {
//            
String req1 = "DELETE FROM role WHERE id= " + id;

           ps= connection.prepareStatement(req1);
                        
            ps.executeUpdate(); 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
   public boolean Update(Role t) {

      
            String req1 = "UPDATE role SET nom_role =?,description_role=? WHERE id= ?";
             Boolean updated=false;

            System.out.print(t);
  try {
System.out.print(t);
            ps = connection.prepareStatement(req1);
                        ps.setInt(3, t.getId());
            ps.setString(1, t.getNom_role());
            ps.setString(2, t.getDescription_role());
       
            
            updated=ps.executeUpdate()>0; 
            System.out.print(t);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
return updated;
    }
   
}

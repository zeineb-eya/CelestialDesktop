/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.CategorieEquipement;
import entities.Equipement;
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
import utils.Myconnexion;

/**
 *
 * @author AhmedBenAbdallah
 */
public class ServiceCategorieEquipement implements IIIService<CategorieEquipement>{

    

 private Connection cnx;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
public ServiceCategorieEquipement(){
        cnx=Myconnexion.getInstance().getCnx();
    }    

    @Override
    public boolean ajouter(CategorieEquipement e) {
       String req="insert into categorie_equipement ( `nom_categorie_equipement`) values (?)";
        Boolean inserted=false;
        try {
            pst=cnx.prepareStatement(req);
            pst.setString(1,e.getNom_categorie_equipement());
           
   
            
            inserted=pst.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }

    @Override
    public boolean supprimer(CategorieEquipement e) {
       String req="DELETE FROM categorie_equipement WHERE id=?";
      Boolean deleted=false;
        try {
             pst=cnx.prepareStatement(req);
             pst.setInt(1,e.getId());
             deleted=pst.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipement.class.getName()).log(Level.SEVERE, null, ex);
        }
     return deleted;
    }

    @Override
    public boolean modifier(CategorieEquipement e) {
       String req="UPDATE categorie_equipement SET nom_categorie_equipement=? WHERE id=?";
       Boolean updated=false;
        try {
            pst=cnx.prepareStatement(req);
         
            pst.setString(1,e.getNom_categorie_equipement());            
            pst.setInt(2,e.getId());            
            
            updated=pst.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipement.class.getName()).log(Level.SEVERE, null, ex);
        }
     return updated;
    }

    @Override
    public List<CategorieEquipement> afficher() {
       String req="select * from categorie_equipement";
        List<CategorieEquipement> list =new ArrayList<>();
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            ServiceEquipement se =new ServiceEquipement();
            while(rs.next())
            { 
                list.add(new CategorieEquipement(rs.getInt("id"),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public CategorieEquipement afficher_id(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
     public void Delete(int id) {
        try {
//            
String req1 = "DELETE FROM categorie_equipement WHERE id= " + id;

           pst= cnx.prepareStatement(req1);
                        
            pst.executeUpdate(); 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

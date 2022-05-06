/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Equipement;
import java.sql.Connection;
import java.sql.Date;
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
import utils.Myconnexion;

/**
 *
 * @author AhmedBenAbdallah
 */
public class ServiceEquipement implements IIService<Equipement>{

    

 private Connection cnx;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
public ServiceEquipement(){
        cnx=Myconnexion.getInstance().getCnx();
    }    

    @Override
    public boolean ajouter(Equipement e) {
       String req="insert into equipement (`categorie_equipement_id`, `nom_equipement`, `etat_equipement`, `description_equipement`, `image_equipement`) values (?,?,?,?,?)";
        Boolean inserted=false;
        try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1,e.getCategorie_equipement_id());
           
            pst.setString(2,e.getNom_equipement());
            pst.setString(3,e.getEtat_equipement());
            pst.setString(4,e.getDescription_equipement());
            pst.setString(5,e.getImage_equipement());
            
            inserted=pst.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }

    @Override
    public boolean supprimer(Equipement e) {
       String req="DELETE FROM equipement WHERE categorie_equipement_id=?";
      Boolean deleted=false;
        try {
             pst=cnx.prepareStatement(req);
             pst.setInt(1,e.getCategorie_equipement_id());
             deleted=pst.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipement.class.getName()).log(Level.SEVERE, null, ex);
        }
     return deleted;
    }

    @Override
    public boolean modifier(Equipement e) {
       String req="UPDATE equipement SET categorie_equipement_id=?,nom_equipement=?,etat_equipement=?,description_equipement=?,image_equipement=? WHERE id=?";
       Boolean updated=false;
        try {
            pst=cnx.prepareStatement(req);
         
            pst.setInt(1,e.getCategorie_equipement_id());            
            pst.setString(2,e.getNom_equipement());
            pst.setString(3,e.getEtat_equipement());
           
            pst.setString(4,e.getDescription_equipement());
            pst.setString(5,e.getImage_equipement());
            pst.setInt(6,e.getId());            
            
            updated=pst.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipement.class.getName()).log(Level.SEVERE, null, ex);
        }
     return updated;
    }

    @Override
    public List<Equipement> afficher() {
       String req="select * from equipement";
        List<Equipement> list =new ArrayList<>();
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            ServiceEquipement se =new ServiceEquipement();
            while(rs.next())
            { 
                list.add(new Equipement(rs.getInt("id"),rs.getString("categorie_equipement_id"),rs.getString("nom_equipement"),rs.getString("etat_equipement"),rs.getString("description_equipement")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Equipement afficher_id(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
     public void Delete(int id) {
        try {
//            
String req1 = "DELETE FROM equipement WHERE id= " + id;

           pst= cnx.prepareStatement(req1);
                        
            pst.executeUpdate(); 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @Override
     public  List<Equipement> recherchermutli(String critere, String col, String ordre)
       {
             List<Equipement> lm =new ArrayList<>();
        try {
            System.out.println(critere);
            st=cnx.createStatement();
           // System.out.println(" SELECT * FROM  magasin where nom like '%"+critere+"%' or adresse like '%"+critere+"%' or cast(nombrebloc as char) like '%"+critere+"%' order by "+col+" "+ordre);
            String query=" SELECT * FROM  equipement where nom_equipement like '%"+critere+"%' or etat_equipement like '%"+critere+"%' or categorie_equipement_id = '%"+critere+"%' or id = '%"+critere+"%' order by "+col+" "+ordre;
           
                rs=st.executeQuery(query);
                while(rs.next()){
                    lm.add(new Equipement(rs.getInt("id"),rs.getString("categorie_equipement_id"),rs.getString("nom_equipement"),rs.getString("etat_equipement"),rs.getString("description_equipement")));
            } } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lm ;
       }
     public Map<String, Integer> NbPdtByCat() {
        Map<String, Integer> mp =new HashMap<>();
        try {
           
            st=cnx.createStatement();
            
            String query="SELECT count(*) as nbp, etat_equipement  FROM  equipement group by etat_equipement ";
            rs=st.executeQuery(query);
            while(rs.next()){
               
                mp.put(rs.getString("etat_equipement"),rs.getInt("nbp"));
            }
            
        } catch (SQLException ex) {
            System.out.println(" erreur d'affichage du magasin  ");
        }
        return mp ;
    }
}

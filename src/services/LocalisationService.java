/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Localisation;
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

/**
 *
 * @author skanr
 */
public class LocalisationService {

    Connection connection;

    public LocalisationService() {
        connection = MyDB.getInstance().getConnection();
    }

    public void ajouterLocalisation(Localisation l) {
        try {
//           String req = "insert into personne(nom,prenom,age) "
//                    + "values('"+ t.getNom()+"','"+ t.getPrenom()+"',"+ t.getAge()+")";
//            Statement st = connection.createStatement();
//            st.executeUpdate(req);

            String req1 = "insert into localisation(heuredepartlocalisation,heure_arrivee_loacalisation,position_depart_localisation,position_arivee_planning,fusee) values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req1);
            ps.setString(1, l.getHeureDepartLocalisation());
            ps.setString(2, l.getHeureArriveeLoacalisation());
            ps.setString(3, l.getPositionDepartLocalisation());
            ps.setString(4, l.getPositionAriveePlanning());
            ps.setString(5, l.getFusee());

            ps.executeUpdate();
            System.out.println("Localisation ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Localisation> afficherLocalisations() {
        List<Localisation> list = new ArrayList<>();
        try {

            String requete3 = "SELECT * FROM localisation";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                Localisation l = new Localisation();
                l.setId(rs.getInt(1));
                l.setHeureDepartLocalisation(rs.getString("heuredepartlocalisation"));
                l.setHeureArriveeLoacalisation(rs.getString("heure_arrivee_loacalisation"));
                l.setPositionDepartLocalisation(rs.getString("position_depart_localisation"));
                l.setPositionAriveePlanning(rs.getString("position_arivee_planning"));
                l.setFusee(rs.getString("fusee"));

                list.add(l);
            }
            //   st = new MyConnection().getCnx().createStatement();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    public void modifierLocalistaion(Localisation l) {
       String requete11="update localisation set position_depart_localisation =? where id=?";
        try {
            
            PreparedStatement ps = connection.prepareStatement(requete11);
            ps.setInt(2,l.getId());
            ps.setString(1,l.getPositionDepartLocalisation());
            
           
            System.out.println(ps);
            ps.executeUpdate();
             System.out.println("votre localisation a ete bien modife");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void supprimerPlaninng(Localisation l) {
        try {
            String req5 = "delete From localisation where id = ?";
            PreparedStatement pst = connection.prepareStatement(req5);
            pst.setInt(1, l.getId());
            pst.executeUpdate();
            System.out.println("localisation suprimee avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void SupprimerLocalisation(Localisation l) {
        /* String req = "delete from reclamation where id=" + id;
        try {
            PreparedStatement pst = cnx2.prepareStatement(req);
           // pst = Connection.createStatement();
            pst.executeUpdate(req);
             System.out.println("votre reclam a ete bien supprime");
        } catch (SQLException ex) {
            //Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex.getMessage());
        }*/
        String req = "delete from localisation where id= ?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            int id = l.getId();
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LocalisationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Localisation> refreshLocalisation(){
                    List<Localisation>list = new ArrayList<>();

        try{
        String requete3 = "SELECT * FROM localisation";
        Statement st = connection.createStatement();
        ResultSet rs =  st.executeQuery(requete3);
        
        
         /* PreparedStatement pst = cnx2.prepareStatement(requete2);
              Connexion c= MyConnection.getInstance().getCnx();
          PreparedStatement pt;
              pt = c.prepareStatement("SELECT id,email,sujet,description,etat from reclamation");
             // String requete = "select id_utilisateur,username,nom,prenom,email,tel,adresse,id_role,etat from utilisateur";
              ResultSet rs=pt.executeQuery();*/
               
              while(rs.next()){
                Localisation l = new Localisation();
               l.setId(rs.getInt(1));
                l.setHeureDepartLocalisation(rs.getString("heuredepartlocalisation"));
                l.setHeureArriveeLoacalisation(rs.getString("heure_arrivee_loacalisation"));
                l.setPositionDepartLocalisation(rs.getString("position_depart_localisation"));
                l.setPositionAriveePlanning(rs.getString("position_arivee_planning"));
                l.setFusee(rs.getString("fusee"));
            
                list.add(l);}   
              
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          };
          return list;
    }

}
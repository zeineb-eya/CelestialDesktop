/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Planinng;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author skanr
 */
public class PlaninngService implements Iservice<Planinng>{
    Connection connection;
    public PlaninngService(){
        connection = MyDB.getInstance().getConnection();
    }
    
public void ajouter(Planinng p) {
        try {
//           String req = "insert into personne(nom,prenom,age) "
//                    + "values('"+ t.getNom()+"','"+ t.getPrenom()+"',"+ t.getAge()+")";
//            Statement st = connection.createStatement();
//            st.executeUpdate(req);
            
            
            String req1 = "insert into planinng(nom_planning,date_debut_planning,date_fin_planning,destination_planning,description_planning,periode_planning,prix_planning) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req1);
            ps.setString(1, p.getNomPlanning());
            ps.setDate(2, (Date) p.getDateDebutPlanning());
            ps.setDate(3, (Date) p.getDateFinPlanning());
            ps.setString(4, p.getDestinationPlanning());
            ps.setString(5, p.getDescriptionPlanning());
            ps.setInt(6, p.getPeriodePlanning());
            ps.setInt(7, p.getPrixPlanning());


            ps.executeUpdate();
            System.out.println("Planinng ajoutee avec succes");
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
    }


    @Override
   public List<Planinng>afficherPlaninng(){
            List<Planinng>myList = new ArrayList<>();
       
        try {
         
        String req11 = "SELECT * FROM planinng";
        Statement st = connection.createStatement();
        ResultSet rs =  st.executeQuery(req11);
        while(rs.next()){
            Planinng p = new Planinng();
             p.setId(rs.getInt("id"));
                p.setNomPlanning(rs.getString("nom_planning"));
                p.setDateDebutPlanning(rs.getDate("date_debut_planning"));
                p.setDateFinPlanning(rs.getDate("date_fin_planning"));
                p.setDestinationPlanning(rs.getString("destination_planning"));
                p.setDescriptionPlanning(rs.getString("description_planning"));
                p.setPeriodePlanning(rs.getInt("periode_planning"));
                p.setPrixPlanning(rs.getInt("prix_planning"));
            myList.add(p);
        }
         //   st = new MyConnection().getCnx().createStatement();
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());
        }
  
       return myList;
    }
  //  public void modifierPlaninng(Planinng p) {
        //try {  
      //      String req4 = "update planinng set nom_planning= ?, dateDebut_planning = ?, dateFin_planning = ?,destination_planning= ?, description_planning = ?, periode_planning = ?, prix_planning = ?  where id = ?";
           // PreparedStatement pst = cnx2.prepareStatement(req4);
           // pst.setString(1, p.getNomPlanning());
          //  pst.setDate(2, (Date) p.getDateDebutPlanning());
            //pst.setDate(3, (Date) p.getDateFinPlanning());
           // pst.setString(4, p.getDestinationPlanning());
            //pst.setString(5, p.getDescriptionPlanning());
            //pst.setInt(6, p.getPeriodePlanning());
            //pst.setInt(6, p.getPrixPlanning());
            //pst.setInt(7, p.getId());

            //pst.executeUpdate();
        //    System.out.println("Planinng modifiee avec succes");
       // } catch (SQLException ex) {
         //   System.out.println(ex.getMessage());
       // }
   // }//
    
     public ObservableList<Planinng> getPlaninngList() throws SQLException {
           
        ObservableList<Planinng> myList = FXCollections.observableArrayList();
        
         List <Planinng> rec = new ArrayList<>(); 
        Statement st = connection.createStatement();
        String query = "SELECT id, nom_planning, date_debut_planning, date_fin_planning, destination_planning, description_planning, periode_planning, prix_planning";

        //ResultSet rs;
        ResultSet rs = st.executeQuery(query);
        Planinng Planinng;
        while (rs.next()) {
           Planinng p = new Planinng(); 
           p.setId(rs.getInt("id"));
                p.setNomPlanning(rs.getString("nom_planning"));
                p.setDateDebutPlanning(rs.getDate("date_debut_planning"));
                p.setDateFinPlanning(rs.getDate("date_fin_planning"));
                p.setDestinationPlanning(rs.getString("destination_planning"));
                p.setDescriptionPlanning(rs.getString("description_planning"));
                p.setPeriodePlanning(rs.getInt("periode_planning"));
                p.setPrixPlanning(rs.getInt("prix_planning"));
            //System.out.println(events);
            myList.add(p);

        }
        return myList;

    }
  public void SupprimerPlaninng(Planinng p) {
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
       String req ="delete from planinng where id= ?";
         try {
            PreparedStatement pst=connection.prepareStatement(req);
             int id = p.getId();
             pst.setInt(1,id);
             pst.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(PlaninngService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
   public void updatePlaninng( Planinng p){
        String requete2="update planinng set nom_planning=? where id=?";
        try {
            
            PreparedStatement ps = connection.prepareStatement(requete2);
            ps.setInt(2,p.getId());
            ps.setString(1,p.getNomPlanning());
            
           
            System.out.println(ps);
            ps.executeUpdate();
             System.out.println("votre planinng a ete bien modife");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
     public List<Planinng> refreshPlaninng(){
                    List<Planinng>myList = new ArrayList<>();

        try{
        String requete3 = "SELECT * FROM planinng";
        Statement st = connection.createStatement();
        ResultSet rs =  st.executeQuery(requete3);
        
        
         /* PreparedStatement pst = cnx2.prepareStatement(requete2);
              Connexion c= MyConnection.getInstance().getCnx();
          PreparedStatement pt;
              pt = c.prepareStatement("SELECT id,email,sujet,description,etat from reclamation");
             // String requete = "select id_utilisateur,username,nom,prenom,email,tel,adresse,id_role,etat from utilisateur";
              ResultSet rs=pt.executeQuery();*/
               
              while(rs.next()){
                Planinng p = new Planinng();
                p.setId(rs.getInt("id"));
                  p.setNomPlanning(rs.getString("nom_planning"));
                p.setDateDebutPlanning(rs.getDate("date_debut_planning"));
                p.setDateFinPlanning(rs.getDate("date_fin_planning"));
                p.setDestinationPlanning(rs.getString("destination_planning"));
                p.setDescriptionPlanning(rs.getString("description_planning"));
                p.setPeriodePlanning(rs.getInt("periode_planning"));
                p.setPrixPlanning(rs.getInt("prix_planning"));
            
                myList.add(p);}   
              
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          };
          return myList;
    }

    @Override
    public void modifier(Planinng p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    

   

    
}

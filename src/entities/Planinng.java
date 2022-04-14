/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Comparator;

/**
 *
 * @author skanr
 */
public class Planinng {
    
    private int id,periode_planning,prix_planning;
    private String nom_planning,destination_planning,description_planning;
    private Date dateDebut_planning, dateFin_planning;
   // Localisation localisation;
    
    public Planinng(int id, int periode_planning, int prix_planning, String nom_planning, Date dateDebut_planning, Date dateFin_planning, String destination_planning, String description_planning) {
        this.id = id;
        this.periode_planning = periode_planning;
        this.prix_planning = prix_planning;
        this.nom_planning = nom_planning;
        this.dateDebut_planning = dateDebut_planning;
        this.dateFin_planning = dateFin_planning;
        this.destination_planning = destination_planning;
        this.description_planning = description_planning;


    }
     public Planinng(int periode_planning, int prix_planning,String nom_planning, Date dateDebut_planning, Date dateFin_planning, String destination_planning, String description_planning) {
        this.periode_planning = periode_planning;
        this.prix_planning = prix_planning;
        this.nom_planning = nom_planning;
        this.dateDebut_planning = dateDebut_planning;
        this.dateFin_planning = dateFin_planning;
        this.destination_planning = destination_planning;
        this.description_planning = description_planning;


    }
      public Planinng() {  
    }
       public Planinng(int id) {
        this.id = id;
    }

    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public int getPeriodePlanning() {
        return periode_planning;
    }
    public void setPeriodePlanning(int periode_planning) {
        this.periode_planning = periode_planning;
    }
    
    public int getPrixPlanning() {
        return prix_planning;
    }
    public void setPrixPlanning(int prix_planning) {
        this.prix_planning = prix_planning;
    }
    
    public String getNomPlanning() {
        return nom_planning;
    }
    public void setNomPlanning(String nom_planning) {
        this.nom_planning = nom_planning;
    }
    
    public Date getDateDebutPlanning() {
        return dateDebut_planning;
    }
    public void setDateDebutPlanning(Date dateDebut_planning) {
        this.dateDebut_planning = dateDebut_planning;
    }
    
   public Date getDateFinPlanning() {
        return dateFin_planning;
    }
    public void setDateFinPlanning(Date dateFin_planning) {
        this.dateFin_planning = dateFin_planning;
    }
    
    public String getDestinationPlanning() {
        return destination_planning;
    }
    public void setDestinationPlanning(String destination_planning) {
        this.destination_planning = destination_planning;
    }
     public String getDescriptionPlanning() {
        return description_planning;
    }
    public void setDescriptionPlanning(String description_planning) {
        this.description_planning = description_planning;
    }
   
    
    @Override
    public String toString() {
        return "Planinng{" + "id=" + id + ", periode_planning=" + periode_planning + ", prix_planning=" + prix_planning +", nom_planning=" + nom_planning + ", dateDebut_planning=" + dateDebut_planning +", dateFin_planning=" + dateFin_planning +", destination_planning=" + destination_planning + ", description_planning=" + description_planning +"\n";
    }

}

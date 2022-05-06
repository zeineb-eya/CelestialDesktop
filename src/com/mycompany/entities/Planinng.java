/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Comparator;

/**
 *
 * @author skanr
 */
public class Planinng {

    public static String pathfile; 
    public static String filename="";
    private int id;
    private int   periodePlanning;
    private int  prixPlanning;
    private String nomPlanning;
    private String destinationPlanning;
    private String descriptionPlanning;
    private Date dateDebutPlanning; 
    private Date  dateFinPlanning;
    private String img; 

    
    public Planinng(int id, int periodePlanning, int prixPlanning, String nomPlanning, Date dateDebutPlanning, Date dateFinPlanning, String destinationPlanning, String descriptionPlanning,String img) {
        this.id = id;
        this.periodePlanning = periodePlanning;
        this.prixPlanning = prixPlanning;
        this.nomPlanning = nomPlanning;
        this.dateDebutPlanning = dateDebutPlanning;
        this.dateFinPlanning = dateFinPlanning;
        this.destinationPlanning = destinationPlanning;
        this.descriptionPlanning = descriptionPlanning;
                this.img=img; 

    }
    
    
     public Planinng(int periodePlanning, int prixPlanning, String nomPlanning, Date dateDebutPlanning, Date dateFinPlanning, String destinationPlanning, String descriptionPlanning, String img) {
        this.periodePlanning = periodePlanning;
        this.prixPlanning = prixPlanning;
        this.nomPlanning = nomPlanning;
        this.dateDebutPlanning = dateDebutPlanning;
        this.dateFinPlanning = dateFinPlanning;
        this.destinationPlanning = destinationPlanning;
        this.descriptionPlanning = descriptionPlanning;
        this.img=img; 

    }
      public Planinng() {  
    }

    public Planinng(int id, String nomPlanning) {
        this.id = id;
        this.nomPlanning = nomPlanning;
    }
      
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public int getPeriodePlanning() {
        return periodePlanning;
    }
    public void setPeriodePlanning(int periodePlanning) {
        this.periodePlanning = periodePlanning;
    }
    
    public int getPrixPlanning() {
        return prixPlanning;
    }
    public void setPrixPlanning(int prixPlanning) {
        this.prixPlanning = prixPlanning;
    }
    
    public String getNomPlanning() {
        return nomPlanning;
    }
    public void setNomPlanning(String nomPlanning) {
        this.nomPlanning = nomPlanning;
    }
    
    public Date getDateDebutPlanning() {
        return dateDebutPlanning;
    }
    public void setDateDebutPlanning(Date dateDebutPlanning) {
        this.dateDebutPlanning = dateDebutPlanning;
    }
    
   public Date getDateFinPlanning() {
        return dateFinPlanning;
    }
    public void setDateFinPlanning(Date dateFinPlanning) {
        this.dateFinPlanning = dateFinPlanning;
    }
    
    public String getDestinationPlanning() {
        return destinationPlanning;
    }
    public void setDestinationPlanning(String destinationPlanning) {
        this.destinationPlanning = destinationPlanning;
    }
     public String getDescriptionPlanning() {
        return descriptionPlanning;
    }
    public void setDescriptionPlanning(String descriptionPlanning) {
        this.descriptionPlanning = descriptionPlanning;
    }
    public String getImg()
   { return img;}

     public void setImg(String img)
   {this.img=img;}
   
    
    @Override
    public String toString() {
        return "Planinng{" + "id=" + id + ", periodePlanning=" + periodePlanning + ", prixPlanning=" + prixPlanning +", nomPlanning=" + nomPlanning + ", dateDebutPlanning=" + dateDebutPlanning +", dateFinPlanning=" + dateFinPlanning +", destinationPlanning=" + destinationPlanning + ", descriptionPlanning=" + descriptionPlanning +",img=" + img +"\n";
    }
    
    
public static Comparator<Planinng> DateComparator = new Comparator<Planinng>() {
        @Override
        public int compare(Planinng o1, Planinng o2) {
            return (int) (o1.getDateDebutPlanning().compareTo(o2.getDateFinPlanning()));
        }
    };
}

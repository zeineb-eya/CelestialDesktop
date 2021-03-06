/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.sql.Date;
import java.sql.JDBCType;

/**
 *
 * @author ASUS
 */
public class Offre {
    
     private int id,reduction,prix_offre;
    private String nom_offre,description_offre;
    //private double prix_offre;
   // private String date_debut_offre;
    
 private Date date_debut_offre,date_fin_offre;
 
    public Offre() {
    }

    public Offre(String nom_offre, String description_offre) {
        this.nom_offre = nom_offre;
        this.description_offre = description_offre;
    }

    public Offre(int id, String nom_offre, String description_offre, int prix_offre, int reduction, Date date_debut_offre, Date date_fin_offre) {
        this.id = id;
        this.nom_offre = nom_offre;
        this.description_offre = description_offre;
        this.prix_offre = prix_offre;
        this.reduction = reduction;
        this.date_debut_offre = date_debut_offre;
        this.date_fin_offre = date_fin_offre;
    }

    public Offre(String nom_offre, String description_offre, int prix_offre, int reduction, Date date_debut_offre, Date date_fin_offre) {
        this.nom_offre = nom_offre;
        this.description_offre = description_offre;
        this.prix_offre = prix_offre;
        this.reduction = reduction;
        this.date_debut_offre = date_debut_offre;
        this.date_fin_offre = date_fin_offre;
    }

    public Offre(String nom_offre, String description_offre, int prix_offre, int reduction) {
        this.nom_offre = nom_offre;
        this.description_offre = description_offre;
        this.prix_offre = prix_offre;
        this.reduction = reduction;
    }

    public Offre(int id, String nom_offre, String description_offre) {
        this.id = id;
        this.nom_offre = nom_offre;
        this.description_offre = description_offre;
    }

    public Offre(int id, String nom_offre, String description_offre, int prix_offre, int reduction) {
        this.id = id;
        this.nom_offre = nom_offre;
        this.description_offre = description_offre;
        this.prix_offre = prix_offre;
        this.reduction = reduction;
    }

   
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_offre() {
        return nom_offre;
    }

    public void setNom_offre(String nom_offre) {
        this.nom_offre = nom_offre;
    }

    public String getDescription_offre() {
        return description_offre;
    }

    public void setDescription_offre(String description_offre) {
        this.description_offre = description_offre;
    }

    public int getPrix_offre() {
        return prix_offre;
    }

    public void setPrix_offre(int prix_offre) {
        this.prix_offre = prix_offre;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public Date getDate_debut_offre() {
        return date_debut_offre;
    }

    public void setDate_debut_offre(Date date_debut_offre) {
        this.date_debut_offre = date_debut_offre;
    }

    public Date getDate_fin_offre() {
        return date_fin_offre;
    }

    public void setDate_fin_offre(Date date_fin_offre) {
        this.date_fin_offre = date_fin_offre;
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", nom_offre=" + nom_offre + ", description_offre=" + description_offre + ", prix_offre=" + prix_offre + ", reduction=" + reduction + ", date_debut_offre=" + date_debut_offre + ", date_fin_offre=" + date_fin_offre + '}';
    }
    
    
}

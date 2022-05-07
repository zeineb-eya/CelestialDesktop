/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.File;

/**
 *
 * @author ASUS
 */
public class Reclamation {
    
    private int id;
    private int user_id;
    private String description_reclamation;
    private String etat_reclamation;
    private String date_reclamation;
    private String nom_utilisateur;
    private String experiencee;

 
 
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    
    
    public String getExperiencee() {
        return experiencee;
    }

    public void setExperiencee(String experiencee) {
        this.experiencee = experiencee;
    }
    
    

    public String getNomUtilisateur() {
        return nom_utilisateur;
    }

    public void setNomUtilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public Reclamation(int id, int user_id, String description_reclamation, String etat_reclamation, String date_reclamation, String nom_utilisateur) {
        this.id = id;
        this.user_id = user_id;
        this.description_reclamation = description_reclamation;
        this.etat_reclamation = etat_reclamation;
        this.date_reclamation = date_reclamation;
        this.nom_utilisateur = nom_utilisateur;
    }

    public Reclamation(int id, int user_id, String description_reclamation, String etat_reclamation, String date_reclamation) {
        this.id = id;
        this.user_id = user_id;
        this.description_reclamation = description_reclamation;
        this.etat_reclamation = etat_reclamation;
        this.date_reclamation = date_reclamation;
    }

    public Reclamation(int id, String description_reclamation, String etat_reclamation, String date_reclamation) {
        this.id = id;
        this.description_reclamation = description_reclamation;
        this.etat_reclamation = etat_reclamation;
        this.date_reclamation = date_reclamation;
    }


    public Reclamation(String description_reclamation, String etat_reclamation, String date_reclamation) {
        this.description_reclamation = description_reclamation;
        this.etat_reclamation = etat_reclamation;
        this.date_reclamation = date_reclamation;
    }

    public Reclamation() {
    }

    public Reclamation(String description_reclamation, String etat_reclamation) {
        this.description_reclamation = description_reclamation;
        this.etat_reclamation = etat_reclamation;
    }

    public Reclamation(String etat_reclamation) {
        this.etat_reclamation = etat_reclamation;
    }

/*public Reclamation(String description_reclamation) {
        this.description_reclamation = description_reclamation;
    }
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user_id;
    }

    public void setUser(int user_id) {
        this.user_id = user_id;
    }

    public String getDescription_reclamation() {
        return description_reclamation;
    }

    public void setDescription_reclamation(String description_reclamation) {
        this.description_reclamation = description_reclamation;
    }

    public String getEtat_reclamation() {
        return etat_reclamation;
    }

    public void setEtat_reclamation(String etat_reclamation) {
        this.etat_reclamation = etat_reclamation;
    }

    public String getDate_reclamation() {
        return date_reclamation;
    }

    public void setDate_reclamation(String date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", user_id=" + user_id + ", description_reclamation=" + description_reclamation + ", etat_reclamation=" + etat_reclamation + ", date_reclamation=" + date_reclamation + '}';
    }

    public void gettfEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}



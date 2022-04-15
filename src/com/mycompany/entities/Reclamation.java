/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author ASUS
 */
public class Reclamation {
    
    private int id;
    private int user;
    private String description_reclamation;
    private String etat_reclamation;
    private String date_reclamation;

    public Reclamation(int id, int user, String description_reclamation, String etat_reclamation, String date_reclamation) {
        this.id = id;
        this.user = user;
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
        return user;
    }

    public void setUser(int user) {
        this.user = user;
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
        return "Reclamation{" + "id=" + id + ", user=" + user + ", description_reclamation=" + description_reclamation + ", etat_reclamation=" + etat_reclamation + ", date_reclamation=" + date_reclamation + '}';
    }
    
    
    
    
    
}



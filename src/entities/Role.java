/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Cipher
 */
public class Role {
   
   private int id;
   private String nom_role, description_role;   

    public Role(int id, String nom_role, String description_role) {
        this.id = id;
        this.nom_role = nom_role;
        this.description_role = description_role;
    }

    public Role(String nom_role, String description_role) {
        this.nom_role = nom_role;
        this.description_role = description_role;
    }

    public Role() {
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_role() {
        return nom_role;
    }

    public void setNom_role(String nom_role) {
        this.nom_role = nom_role;
    }

    public String getDescription_role() {
        return description_role;
    }

    public void setDescription_role(String description_role) {
        this.description_role = description_role;
    }
}



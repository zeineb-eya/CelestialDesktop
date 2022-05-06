/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.sql.JDBCType;
import javafx.scene.image.ImageView;

/**
 *
 * @author AhmedBenAbdallah
 */
public class Equipement {
    int id;
    int categorie_equipement_id;
    String nom_equipement	;
    String etat_equipement	;

  
    String description_equipement;
    String image_equipement;

    public Equipement(int id, int categorie_equipement_id, String nom_equipement, String etat_equipement, String description_equipement, String image_equipement) {
        this.id = id;
        this.categorie_equipement_id = categorie_equipement_id;
        this.nom_equipement = nom_equipement;
        this.etat_equipement = etat_equipement;
        this.description_equipement = description_equipement;
        this.image_equipement = image_equipement;
    }

    public Equipement() {
    }

    public Equipement(int categorie_equipement_id, String nom_equipement, String etat_equipement, String description_equipement, String image_equipement) {
        this.categorie_equipement_id = categorie_equipement_id;
        this.nom_equipement = nom_equipement;
        this.etat_equipement = etat_equipement;
        this.description_equipement = description_equipement;
        this.image_equipement = image_equipement;
    }

    public Equipement(JDBCType jdbcType, String aaa, String aa, String eeee, String hjj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategorie_equipement_id() {
        return categorie_equipement_id;
    }

    public void setCategorie_equipement_id(int categorie_equipement_id) {
        this.categorie_equipement_id = categorie_equipement_id;
    }

    public String getNom_equipement() {
        return nom_equipement;
    }

    public void setNom_equipement(String nom_equipement) {
        this.nom_equipement = nom_equipement;
    }

    public String getEtat_equipement() {
        return etat_equipement;
    }

    public void setEtat_equipement(String etat_equipement) {
        this.etat_equipement = etat_equipement;
    }

    public String getDescription_equipement() {
        return description_equipement;
    }

    public void setDescription_equipement(String description_equipement) {
        this.description_equipement = description_equipement;
    }

    public String getImage_equipement() {
        return image_equipement;
    }

    public void setImage_equipement(String image_equipement) {
        this.image_equipement = image_equipement;
    }

    @Override
    public String toString() {
        return "Equipement{" + "id=" + id + ", categorie_equipement_id=" + categorie_equipement_id + ", nom_equipement=" + nom_equipement + ", etat_equipement=" + etat_equipement + ", description_equipement=" + description_equipement + ", image_equipement=" + image_equipement + '}';
    }

    

}

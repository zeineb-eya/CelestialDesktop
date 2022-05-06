/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.JDBCType;

/**
 *
 * @author 21628
 */
public class CategorieEquipement {
    int id;
    String nom_categorie_equipement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_categorie_equipement() {
        return nom_categorie_equipement;
    }

    public void setNom_categorie_equipement(String nom_categorie_equipement) {
        this.nom_categorie_equipement = nom_categorie_equipement;
    }

    @Override
    public String toString() {
        return "CategorieEquipement{" + "id=" + id + ", nom_categorie_equipement=" + nom_categorie_equipement + '}';
    }

    public CategorieEquipement() {
    }

    public CategorieEquipement(String nom_categorie_equipement) {
        this.nom_categorie_equipement = nom_categorie_equipement;
    }

    public CategorieEquipement(int id, String nom_categorie_equipement) {
        this.id = id;
        this.nom_categorie_equipement = nom_categorie_equipement;
    }
    public CategorieEquipement(JDBCType jdbcType, String aaa, String aa, String eeee, String hjj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

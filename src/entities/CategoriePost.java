/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author khawl
 */
public class CategoriePost {
        private int id ;
    
    private String nom_categorie_post;
    public CategoriePost( ) {  }
    public CategoriePost(int id, String nom_categorie_post) {
        this.id = id;
        this.nom_categorie_post = nom_categorie_post;
    }
 public CategoriePost( String nom_categorie_post) {
        this.nom_categorie_post = nom_categorie_post;
    }

    public int getId() {
        return id;
    } 

    public String getNom_categorie_post() {
        return nom_categorie_post;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_categorie_post(String nom_categorie_post) {
        this.nom_categorie_post = nom_categorie_post;
    }

    @Override
    public String toString() {
        return "CategoriePost{" + "id=" + id + ", nom_categorie_post=" + nom_categorie_post + '}';
    }

 

}

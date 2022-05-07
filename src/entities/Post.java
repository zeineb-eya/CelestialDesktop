/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities; 
/**
 *
 * 
 * @author khawl
 */
public class Post {
    private int id ;
    private int userid;
    private String nom ;
    private String img_link_post;
    private byte[]  byte_img_post;
    private String description_post;
    private int CategoriePost_ID;

   


    public Post() {
    }

    public Post(int id, String nom, String img_link_post, String description_post, int CategoriePost_ID) {
        this.id = id;
        this.nom = nom;
        this.img_link_post = img_link_post;
        this.description_post = description_post;
        this.CategoriePost_ID=CategoriePost_ID;
    }

    public Post(String nom, String img_link_post, String description_post,int CategoriePost_ID) {
        this.nom = nom;
        this.img_link_post = img_link_post;
        this.description_post = description_post;
        this.CategoriePost_ID=CategoriePost_ID; 
    }

    
      public Post(int id, int userid , int CategoriePost_ID , String nom, byte[]  byte_img_post, String description_post) {
        this.id = id;
        this.userid = userid; 
        this.CategoriePost_ID=CategoriePost_ID;   
        this.nom = nom ;
         this.byte_img_post = byte_img_post;
        this.description_post = description_post;
        
    }  
    
    
    
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    
     public int getUserId() {
        return this.userid;
    }

    public void  setUserId(int userid) {
         this.userid =  userid;
    }



    public String getDescription_post() {
        return this.description_post;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public void setImgLink_post(String img_link_post) {
        this.img_link_post = img_link_post;
    }
    public String getImgLink_post() {
        return this.img_link_post;
    }
    
     public void setByte_img_post(byte[]  byte_img_post) {
        this.byte_img_post = byte_img_post;
    }
    public byte[]  getByte_img_post() {
        return this.byte_img_post;
    }
    
    
    
    public void setDescription_post(String description_post) {
        this.description_post = description_post;
    }
    
    public void setCategoriePost_ID(int CategoriePost_ID) {
        this.CategoriePost_ID = CategoriePost_ID;
    }

    public int getCategoriePost_ID() {
        return CategoriePost_ID;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ",User Id= null, Categorie Post id =" + CategoriePost_ID + ", Nom=" + nom + ", Image Link Post=" + img_link_post + ", Description Post=" + description_post + '}';
    }     
}

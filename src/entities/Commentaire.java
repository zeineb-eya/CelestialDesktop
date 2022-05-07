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
public class Commentaire {
      private int id ;
    private String date_commentaire;
    private String msg_commentaire;
    private int post_id;
    private double rating;
  //private Post  post ;
    public Commentaire() { }
        
    public Commentaire(int id, String date_commentaire, String msg_commentaire,int post_id) {
        this.id = id;
        this.date_commentaire = date_commentaire;
        this.msg_commentaire = msg_commentaire;
        this.post_id=post_id;
    }

 
      public Commentaire(String date_commentaire, String msg_commentaire,int post_id) {

        this.date_commentaire = date_commentaire;
        this.msg_commentaire = msg_commentaire;
        this.post_id=post_id;
    }

    public Commentaire(Commentaire objCommentaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public void setPost(int post_id) {
        this.post_id= post_id;
    }

    public int getPost() {
        return post_id;
    }
    public int getId() {
        return id;
    }

    public String getDate_commentaire() {
        return date_commentaire;
    }

    public String getMsg_commentaire() {
        return msg_commentaire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_commentaire(String date_commentaire) {
        this.date_commentaire = date_commentaire;
    }

    public void setMsg_commentaire(String msg_commentaire) {
        this.msg_commentaire = msg_commentaire;
    }
    public void setrating ( double rating ){this.rating = rating ;}
    public double getrating () {
        return this.rating ;
    }  
    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ",post_id="+ post_id +",rating="+rating+   ", date_commentaire=" + date_commentaire + ", msg_commentaire=" + msg_commentaire + '}';
    }
      
}

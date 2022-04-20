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
public class User {
     private  int id ,nom_role_id;
     private String mail_utilisateur,sudo_utilisateur,nom_utilisateur,prenom_utilisateur,adresse_utilisateur,password,Numero_utilisateur;
     private String[] Role;
     private boolean isExpired,isVerified;

    public User(int nom_role_id, String mail_utilisateur,String nom_utilisateur, String prenom_utilisateur, String adresse_utilisateur, String password, String Numero_utilisateur) {
        this.nom_role_id = nom_role_id;
        this.mail_utilisateur = mail_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.prenom_utilisateur = prenom_utilisateur;
        this.adresse_utilisateur = adresse_utilisateur;
        this.password = password;
        this.Numero_utilisateur = Numero_utilisateur;
    }

    public User(int id, int nom_role_id, String mail_utilisateur, String nom_utilisateur, String prenom_utilisateur, String adresse_utilisateur, String password, String Numero_utilisateur) {
        this.id = id;
        this.nom_role_id = nom_role_id;
        this.mail_utilisateur = mail_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.prenom_utilisateur = prenom_utilisateur;
        this.adresse_utilisateur = adresse_utilisateur;
        this.password = password;
        this.Numero_utilisateur = Numero_utilisateur;
    }
     public User( String mail_utilisateur,String nom_utilisateur, String prenom_utilisateur, String adresse_utilisateur, String password, String Numero_utilisateur) {
       
        this.mail_utilisateur = mail_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.prenom_utilisateur = prenom_utilisateur;
        this.adresse_utilisateur = adresse_utilisateur;
        this.password = password;
        this.Numero_utilisateur = Numero_utilisateur;
    }

    public int getId() {
        return id;
    }
    public int getNomRoleId() {
        return nom_role_id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNomRoleId(int nom_role_id) {
        this.nom_role_id = nom_role_id;
    }

    @Override
    public String toString() {
        return "User{" + "nom_role_id=" + nom_role_id + "id=" + id + ", mail_utilisateur=" + mail_utilisateur + ", nom_utilisateur=" + nom_utilisateur + ", prenom_utilisateur=" + prenom_utilisateur + ", adresse_utilisateur=" + adresse_utilisateur + ", password=" + password + ", Numero_utilisateur=" + Numero_utilisateur + '}';
    }

    public String getMail_utilisateur() {
        return mail_utilisateur;
    }

    public void setMail_utilisateur(String mail_utilisateur) {
        this.mail_utilisateur = mail_utilisateur;
    }

    public String getSudo_utilisateur() {
        return sudo_utilisateur;
    }

    public void setSudo_utilisateur(String sudo_utilisateur) {
        this.sudo_utilisateur = sudo_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getPrenom_utilisateur() {
        return prenom_utilisateur;
    }

    public void setPrenom_utilisateur(String prenom_utilisateur) {
        this.prenom_utilisateur = prenom_utilisateur;
    }

    public String getAdresse_utilisateur() {
        return adresse_utilisateur;
    }

    public void setAdresse_utilisateur(String adresse_utilisateur) {
        this.adresse_utilisateur = adresse_utilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumero_utilisateur() {
        return Numero_utilisateur;
    }

    public void setNumero_utilisateur(String Numero_utilisateur) {
        this.Numero_utilisateur = Numero_utilisateur;
    }

    public String[] getRole() {
        return Role;
    }

    public void setRole(String[] Role) {
        this.Role = Role;
    }

    public boolean isIsExpired() {
        return isExpired;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public User(String mail_utilisateur, String sudo_utilisateur, String nom_utilisateur, String prenom_utilisateur, String adresse_utilisateur, String password, String Numero_utilisateur, String[] Role, boolean isExpired, boolean isVerified) {
        this.mail_utilisateur = mail_utilisateur;
        this.sudo_utilisateur = sudo_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.prenom_utilisateur = prenom_utilisateur;
        this.adresse_utilisateur = adresse_utilisateur;
        this.password = password;
        this.Numero_utilisateur = Numero_utilisateur;
        this.Role = Role;
        this.isExpired = isExpired;
        this.isVerified = isVerified;
    }

    public User() {
    }

    public User(int id, String mail_utilisateur, String sudo_utilisateur, String nom_utilisateur, String prenom_utilisateur, String adresse_utilisateur, String password, String Numero_utilisateur, String[] Role, boolean isExpired, boolean isVerified) {
        this.id = id;
        this.mail_utilisateur = mail_utilisateur;
        this.sudo_utilisateur = sudo_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.prenom_utilisateur = prenom_utilisateur;
        this.adresse_utilisateur = adresse_utilisateur;
        this.password = password;
        this.Numero_utilisateur = Numero_utilisateur;
        this.Role = Role;
        this.isExpired = isExpired;
        this.isVerified = isVerified;
    }
}

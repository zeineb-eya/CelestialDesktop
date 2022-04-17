/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;
import java.sql.Date;
import java.util.Comparator;

/**
 *
 * @author HP
 */
public class Reservation {
    private int id,user,billet;
    private String Etat_reservation;
    private Date date_reservation;
    public Reservation(int id,Date date_reservation,String Etat_reservation,int user,int billet) {
        this.id = id;
        this.date_reservation = date_reservation;
        this.Etat_reservation = Etat_reservation;
        this.user = user;
        this.billet = billet;
        
    }
    public Reservation(int id,int user,int billet) {
        this.id = id;
        this.user = user;
        this.billet = billet;
        
    }
     public Reservation(int id) {
        this.id = id;    
    }
    public Reservation(Date date_reservation,String Etat_reservation,int user,int billet) {
        this.date_reservation = date_reservation;
        this.Etat_reservation = Etat_reservation;
        this.user = user;
        this.billet = billet;
        
    }
    public Reservation(int id,String Etat_reservation) {
        this.id = id;
        this.Etat_reservation = Etat_reservation;

    }
    public Reservation(int user,int billet) {
        
        this.user = user;
        this.billet = billet;
        
    }
    public Reservation() {
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public Date getDateReservation() {
        return date_reservation;
    }
    public void setDateReservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }
    
    public String getEtatReservation() {
        return Etat_reservation;
    }
    public void setEtatReservation(String Etat_reservation) {
        this.Etat_reservation = Etat_reservation;
    }
    
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
        this.user = user;
    }
    
    public int getBillet() {
        return billet;
    }
    public void setBillet(int billet) {
        this.billet = billet;
    }
    
    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", date_reservation=" + date_reservation + ", Etat_reservation=" + Etat_reservation +", user=" + user +", billet=" + billet + "\n";
    }
    public static Comparator<Reservation> statusComparator = new Comparator<Reservation>() {
        @Override
        public int compare(Reservation o1, Reservation o2) {
            return (int) (o1.getEtatReservation().toLowerCase().compareTo(o2.getEtatReservation().toLowerCase()));
        }
    };
    public static Comparator<Reservation> DateComparator = new Comparator<Reservation>() {
        @Override
        public int compare(Reservation o1, Reservation o2) {
            return (int) (o1.getDateReservation().compareTo(o2.getDateReservation()));
        }
    };
}

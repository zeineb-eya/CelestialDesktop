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
    private String Etatreservation;
    private Date datereservation;
    public Reservation(int id,Date datereservation,String Etatreservation,int user,int billet) {
        this.id = id;
        this.datereservation = datereservation;
        this.Etatreservation = Etatreservation;
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
    public Reservation(Date datereservation,String Etatreservation,int user,int billet) {
        this.datereservation = datereservation;
        this.Etatreservation = Etatreservation;
        this.user = user;
        this.billet = billet;
        
    }
    public Reservation(int id,String Etatreservation) {
        this.id = id;
        this.Etatreservation = Etatreservation;

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
        return datereservation;
    }
    public void setDateReservation(Date datereservation) {
        this.datereservation = datereservation;
    }
    
    public String getEtatReservation() {
        return Etatreservation;
    }
    public void setEtatReservation(String Etatreservation) {
        this.Etatreservation = Etatreservation;
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
        return "Reservation{" + "id=" + id + ", date_reservation=" + datereservation + ", Etat_reservation=" + Etatreservation +", user=" + user +", billet=" + billet + "\n";
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

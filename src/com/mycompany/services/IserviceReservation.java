/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import java.util.List;

/**
 *
 * @author HP
 */
public interface IserviceReservation <R>{
    public void ajouterReservation();
     public void ajouterReservation2(R r);
     public List<R> afficherReservations();
     public void modifierReservation(R r);
     public void supprimerReservation(R r); 
     public R findReservation_ByDate(String date_reservation) ;       
     public R findReservation_ByEtat(String Etat_reservation) ;
     public List<R> sortByDate();
      public List<R> sortByEtat();
    
}

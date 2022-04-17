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
public interface IserviceBillet <B>{
    
     public void ajouterBillet();
     public void ajouterBiller2(B b);
     public List<B> afficherBillets();
     public void modifierBillet(B b);
     public void supprimerBillet(B b); 
     public B findBillet_ByDate(String embarquement) ;       
     public List<B> sortByDate();
    
}

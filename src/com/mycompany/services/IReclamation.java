/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import java.util.List;

/**
 *
 * @author ASUS
 */

       public interface IReclamation <R> {
        
   public void ajouterReclamation2(R r);
   public void deleteReclamation(R r);
   public void updateReclamation(R r);
    public List<R>afficherReclamation();
    
}

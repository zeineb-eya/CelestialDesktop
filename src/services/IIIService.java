/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.CategorieEquipement;
import java.util.List;

/**
 *
 * @author AhmedBenAbdallah
 */
public interface IIIService<T> {
    
         boolean ajouter(T t);
   boolean supprimer(T t);
   boolean modifier(T t);
   public List<T> afficher();
   T afficher_id(int id);
    
}

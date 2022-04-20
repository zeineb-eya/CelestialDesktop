/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Localisation;
import entities.Planinng;
import java.util.List;

/**
 *
 * @author Skander
 */
    public interface Iservice<P> {

    public void ajouter(P p);

    public void modifier(P p);

    public void SupprimerPlaninng(Planinng p);
    
    public List<Planinng>afficherPlaninng();
    
     public void updatePlaninng( Planinng p);
    
    public List<Planinng> refreshPlaninng();
    
     public List<Localisation> voirLocalisation(int id);


}

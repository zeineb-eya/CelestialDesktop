/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Comparator;

/**
 *
 * @author skanr
 */
public class Localisation {
    
    private int id;
    private String heureDepartLocalisation;
   private String heureArriveeLoacalisation;
    private    String positionDepartLocalisation;
         private   String positionAriveePlanning;
        private    String fusee;
   // Localisation localisation;

    public Localisation() {
    }
    
    public Localisation(int id,String heureDepartLocalisation, String heureArriveeLoacalisation, String positionDepartLocalisation, String positionAriveePlanning, String fusee) {
        this.id = id;
        this.heureDepartLocalisation = heureDepartLocalisation;
        this.heureArriveeLoacalisation = heureArriveeLoacalisation;
        this.positionDepartLocalisation = positionDepartLocalisation;
        this.positionAriveePlanning = positionAriveePlanning;
        this.fusee = fusee;
    }

    public Localisation(String heureDepartLocalisation, String heureArriveeLoacalisation, String positionDepartLocalisation, String positionAriveePlanning, String fusee) {
        this.heureDepartLocalisation = heureDepartLocalisation;
        this.heureArriveeLoacalisation = heureArriveeLoacalisation;
        this.positionDepartLocalisation = positionDepartLocalisation;
        this.positionAriveePlanning = positionAriveePlanning;
        this.fusee = fusee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeureDepartLocalisation() {
        return heureDepartLocalisation;
    }

    public void setHeureDepartLocalisation(String heureDepartLocalisation) {
        this.heureDepartLocalisation = heureDepartLocalisation;
    }

    public String getHeureArriveeLoacalisation() {
        return heureArriveeLoacalisation;
    }

    public void setHeureArriveeLoacalisation(String heureArriveeLoacalisation) {
        this.heureArriveeLoacalisation = heureArriveeLoacalisation;
    }

    public String getPositionDepartLocalisation() {
        return positionDepartLocalisation;
    }

    public void setPositionDepartLocalisation(String positionDepartLocalisation) {
        this.positionDepartLocalisation = positionDepartLocalisation;
    }

    public String getPositionAriveePlanning() {
        return positionAriveePlanning;
    }

    public void setPositionAriveePlanning(String positionAriveePlanning) {
        this.positionAriveePlanning = positionAriveePlanning;
    }

    public String getFusee() {
        return fusee;
    }

    public void setFusee(String fusee) {
        this.fusee = fusee;
    }
    
     
}

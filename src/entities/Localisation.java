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
    private String positionDepart_localisation,positionArivee_planning,fusee;
    private String heureDepart_localisation, heureArrivee_loacalisation;
   // Localisation localisation;
    
    public Localisation(int id,String positionDepart_localisation, String positionArivee_planning, String fusee, String heureDepart_localisation, String heureArrivee_loacalisation) {
        this.id = id;
        this.positionDepart_localisation = positionDepart_localisation;
        this.positionArivee_planning = positionArivee_planning;
        this.fusee = fusee;
        this.heureDepart_localisation = heureDepart_localisation;
        this.heureArrivee_loacalisation = heureArrivee_loacalisation;


    }
     public Localisation(String positionDepart_localisation, String positionArivee_planning, String fusee, String heureDepart_localisation, String heureArrivee_loacalisation) {
          this.positionDepart_localisation = positionDepart_localisation;
        this.positionArivee_planning = positionArivee_planning;
        this.fusee = fusee;
        this.heureDepart_localisation = heureDepart_localisation;
        this.heureArrivee_loacalisation = heureArrivee_loacalisation;
    }
      public Localisation() {  
    }
       public Localisation(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPositionDepartLocalisation() {
        return positionDepart_localisation;
    }
    public void setPositionDepartLocalisation(String positionDepart_localisation) {
        this.positionDepart_localisation = positionDepart_localisation;
    }
    
    public String getPositionAriveePlanning() {
        return positionArivee_planning;
    }
    public void setPositionAriveePlanning(String positionArivee_planning) {
        this.positionArivee_planning = positionArivee_planning;
    }
     public String getFusee() {
        return fusee;
    }
    public void setFusee(String fusee) {
        this.fusee = fusee;
    }
    public String getHeureDepartLocalisation() {
        return heureDepart_localisation;
    }
    public void setHeureDepartLocalisation(String heureDepart_localisation) {
        this.heureDepart_localisation = heureDepart_localisation;
    }
    public String getHeureArriveeLoacalisation() {
        return heureArrivee_loacalisation;
    }
    public void setHeureArriveeLoacalisation(String heureArrivee_loacalisation) {
        this.heureArrivee_loacalisation = heureArrivee_loacalisation;
    }
    
    @Override
    public String toString() {
        return "Localisation{" + "id=" + id + ", positionDepart_localisation=" + positionDepart_localisation + ", positionArivee_planning=" + positionArivee_planning +", fusee=" + fusee + ", heureDepart_localisation=" + heureDepart_localisation +", heureArrivee_loacalisation=" + heureArrivee_loacalisation +"\n";
    }

}

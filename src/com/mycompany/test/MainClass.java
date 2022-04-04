/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;
import com.mycompany.entities.Billet;
import com.mycompany.entities.Reservation;
import com.mycompany.services.BilletService;
import com.mycompany.services.ReservationService;
import com.mycompany.utils.MyConnection;
/**
 *
 * @author HP
 */
public class MainClass {
    public static void main(String[] args) {
        //******************************************Test Connection******************************************//
        // MyConnection mc = new MyConnection();
//        MyConnection mc = MyConnection.getInstance();
//        MyConnection mc2 = MyConnection.getInstance();
//        System.out.println(mc.hashCode()+ " - " +mc2.hashCode());

        BilletService bs = new BilletService();
        ReservationService rs = new ReservationService();
        //******************************************ajout statique******************************************//
        //**Billet**//
        //bs.ajouterBillet();
        
        //**Reservation**//
        //rs.ajouterReservation();
        //******************************************ajout dynamique******************************************//
        
        //**Billet**//
//        System.out.println("Agouter Billet");
//       Billet b = new Billet(5,5,5,5,"2022-05-26",1);
//       bs.ajouterBiller2(b);
        
        //**Reservation**//
//        System.out.println("Ajouter Reservation");
//        Reservation r = new Reservation("2022-04-26","waiting for a confirmation",4,16);
//        rs.ajouterReservation2(r);
        
     
        //******************************************modification******************************************//
        
        //**Billet**//
//        System.out.println("Modification Billet");
//        Billet b = new Billet(22,2,25,25,25,"2022-04-26",2);
//        bs.modifierBillet(b);
       
       //**Reservation**//
//       System.out.println("Modification Reservation");
//       Reservation r = new Reservation(13,"2022-04-26","valider",4,19);
//       rs.modifierReservation(r);
       
       //******************************************suppression******************************************//
       
       //**Billet**//
//       System.out.println("Suppression Billet");
//        Billet b = new Billet(22);
//       bs.supprimerBillet(b);
       
       //**Reservation**//
//       System.out.println("Suppression Reservation");
//      Reservation r = new Reservation(20);
//        rs.supprimerReservation(r);
        //******************************************affichage******************************************//
        
        //**Billet**//
        System.out.println("Affichage Billet");
        System.out.println(bs.afficherBillets());
        
        //**Reservation**//
        System.out.println("Affichage Reservation");
        System.out.println(rs.afficherReservations());
        
    }
}

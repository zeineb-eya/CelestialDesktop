/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;
import com.mycompany.entities.Billet;
import com.mycompany.services.BilletService;
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
        //******************************************ajout statique******************************************//
        //bs.ajouterBillet();
        //******************************************ajout dynamique******************************************//
        //Billet b = new Billet(2,2,2,2,"2022-04-26",2);
        //bs.ajouterBiller2(b);
        //******************************************affichage******************************************//
        //System.out.println(bs.afficherBillets());
        //******************************************modification******************************************//
        //Billet b = new Billet(2,2,25,25,25,"2022-04-26",2);
       // bs.modifierBillet(b);
       //******************************************suppression******************************************//
        Billet b = new Billet(2);
        bs.supprimerBillet(b);
    }
}

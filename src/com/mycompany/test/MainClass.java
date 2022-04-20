/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;
import com.mycompany.utils.MyConnection;
/**
 *
 * @author HP
 */
public class MainClass {
    public static void main(String[] args) {
                //******************************************Test Connection******************************************//
        // MyConnection mc = new MyConnection();
        MyConnection mc = MyConnection.getInstance();
        MyConnection mc2 = MyConnection.getInstance();
        System.out.println(mc.hashCode()+ " - " +mc2.hashCode());
    }
}

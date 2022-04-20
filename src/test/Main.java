/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import services.UserService;

/**
 *
 * @author Skander
 */
public class Main {
    
    public static void main(String[] args) {
        UserService  se=new UserService();
        User e=new User(7,"a","a","a","a","a","a");
        se.ajouter(e);
      
    }
    
}

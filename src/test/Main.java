/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.restfb.FacebookClient;
import com.restfb.DefaultFacebookClient;
import com.restfb.types.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Map;

import services.UserService;


/**
 *
 * @author Skander
 */
public class Main {
    
    public static void main(String[] args) {


        String accessToken ="EAARTiLYUk78BAJRJmz7cTAxTpvdIzDc8IZB7V3YsrO0vNljQjgLDrD68KIG8tDjLPLm6u5LkwZBXC3XxNofTe8Hq1FuLZC0ZAlkNuxRQZCfwzWb4h582yJm2jNfERU5pe2U4fyMZB1TUlSnaUkgx4IlS5vleZB5ZB1Tv0asH4g1YT8VZBplWapy8OJDqyTfQdlukg2de1EdcA3TK1ZBtVFiQlucrXLDPuyx8Q51kZBGUfbZCCZCQlJenkeXqL";
      FacebookClient fbClient = new DefaultFacebookClient(accessToken);
      User me =fbClient.fetchObject("me", User.class);
      System.out.println(me.getName());
    }
    
}

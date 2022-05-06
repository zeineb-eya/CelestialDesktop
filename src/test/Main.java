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


        String accessToken ="EAARTiLYUk78BAByQRQ8ZBejz2n8WEg0je87NZBjxxW7Jisy1YGJELtE7eIKkTTy36SIhwv2w1J6MneQjczxHyhMfjHXxbRwOG0NTVi6Hzz85exqbCdEs1tUjdNxu6SKR4fgfBO1oACbUxO8Jy69zns8uEO7pVrJj93xPRBoC7MCU2Qj0uZAN5UkRN4ErmiBp5elUnalHwcgpDK2lbmsPBWpLJRneKsnv7x9dSApmF1p7VnSa7VS";
      FacebookClient fbClient = new DefaultFacebookClient(accessToken);
      User me =fbClient.fetchObject("me", User.class);
      System.out.println(me.getName());
    }
    
}

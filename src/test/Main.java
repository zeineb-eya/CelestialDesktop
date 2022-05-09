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


        String accessToken ="EAARTiLYUk78BAI2BlEvptrwY0T9RyaoPbY4tVZAWU8YUZBZCH0mFL2JpZCGNZBGZBk61PGRUKeGeIt6Dmx7thyhT4GwPPOviBZBarl1m89clkTpSspr0dfXCePKc4bIeMyIoNcxhVQAlPwNXBzXxf5V3GIDdi8UnkdpSISli3nHhOht6vhFtjlZCG6KLbC6pbFkCy7HODZAPtJgZDZD";
      FacebookClient fbClient = new DefaultFacebookClient(accessToken);
      User me =fbClient.fetchObject("me", User.class);
      System.out.println(me.getName());
    }
    
}

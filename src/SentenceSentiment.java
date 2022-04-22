
import com.mycompany.entities.Reclamation;
import gui.nlpPipeline;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class SentenceSentiment {
   
    public static void main(String[] args) throws IOException 
  { Reclamation r = new Reclamation();
  String re =r.getDescription_reclamation();
         //     String text = "This is an excellent book. I enjoy reading it. I can read on Sundays. Today is only Tuesday. Can't wait for next Sunday. The working week is unbearably long. It's awful.";
  //String text = r.getDescription_reclamation();
    nlpPipeline.init();
    nlpPipeline.estimatingSentiment(re);
  }
    
}

package gui;


import com.mycompany.entities.Reclamation;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.StringUtils;
import java.io.IOException;
import java.text.Annotation;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class nlpPipeline {
    
    static StanfordCoreNLP pipeline;
    public static void init() throws IOException 
    {
        Properties props = new Properties();
      //  props.load(IOUtils.readerFromString("StanfordCoreNLP-french.properties"));
/*Properties frenchProperties = StringUtils.argsToProperties(new String[]
{"-props", "StanfordCoreNLP-french.properties"});*/
      props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        //props.setProperty( "annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,kbp,quote");
       
        pipeline = new StanfordCoreNLP(props);
    }
  /*  public static void estimatingSentiment(String text)
    {
   int sentimentInt;
      String sentimentName; 
         edu.stanford.nlp.pipeline.Annotation annotation = pipeline.process(text);
      for(CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class))
      {
         Tree tree = sentence.get(SentimentAnnotatedTree.class);
        sentimentInt = RNNCoreAnnotations.getPredictedClass(tree); 
                sentimentName = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
        System.out.println(sentimentName + "\t" + sentimentInt + "\t" + sentence);
      }
     }*/
    
      public static void estimatingSentiment(String re)
    {
        Reclamation r= new Reclamation();
   int sentimentInt;
   re= r.getDescription_reclamation();
      String sentimentName; 
         edu.stanford.nlp.pipeline.Annotation annotation = pipeline.process(re);
      for(CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class))
      {
         Tree tree = sentence.get(SentimentAnnotatedTree.class);
        sentimentInt = RNNCoreAnnotations.getPredictedClass(tree); 
                sentimentName = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
        System.out.println(sentimentName + "\t" + sentimentInt + "\t" + sentence);
      }
     }
    public static String findSentiment(String text) {
        int sentimentInt = 2;
        String sentimentName = "NULL";
        if (text != null && text.length() > 0) {
            edu.stanford.nlp.pipeline.Annotation annotation = pipeline.process(text);
          CoreMap sentence = annotation
                    .get(CoreAnnotations.SentencesAnnotation.class).get(0);
          Tree tree = sentence
                     .get(SentimentAnnotatedTree.class);
          sentimentInt = RNNCoreAnnotations.getPredictedClass(tree);
          sentimentName = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
        }
        return sentimentName;
}
}
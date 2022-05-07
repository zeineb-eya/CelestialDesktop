/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libs;

/**
 *
 * @author khawl
 */
public class TextString {
    
     private String mots_EN [] = {"arse","bloody","bugger","cow","crap","damn","ginger","git","god","goddam","jesus christ","minger","sod-off","arsehole","balls","bint","bitch","bollocks","bullshit","feck","munter","pissed/pissed off","shit","son of a bitch","bastard","beaver","beef curtains","bellend","bloodclaat","clunge","cock","dick","dickhead","fanny","flaps","gash","knob","minge","prick","punani","snatch","twat","fuck"
    } ;
     public String  filterText(String Text) {
     String filterText = filter(Text);
     this. toUpperCase();
     //filterText = filter("i play fuck");
     this.toLowerCase();
     return filterText;
    }
    private void toUpperCase()
    {
        for (int i = 0; i<this.mots_EN.length ; i++)
        {
          this. mots_EN [i]= this.mots_EN[i].toUpperCase();
        }
    }
    
       private void toLowerCase()
    {
        for (int i = 0; i<this.mots_EN.length ; i++)
        {
          this. mots_EN [i]= this.mots_EN[i].toLowerCase();
        }
    }
    private String filter ( String Text){
        String newText ="";
        String replacemot ="";
        for (String mot : this.mots_EN)
        {  
          if (Text.contains(mot))
             {
            for (int i = 0 ; i<mot.length();i++)
                {
                    replacemot +="*";
                }
            newText = Text.replace (mot,replacemot);
            replacemot ="";
             }   
           
        }
        return newText;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    static public String textSeparator(String oldtext , int count)  {
     String newText = "";
      char[] ch = oldtext.toCharArray();
        for ( int i = 0 ; i < ch.length ; i++ )
        {
          if (i == count - 1  ) {newText += System.lineSeparator(); count = count+i;}
          newText += ch[i] ;
        }  
          return newText; 
      }  
}

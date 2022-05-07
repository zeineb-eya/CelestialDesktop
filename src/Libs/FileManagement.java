/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Libs;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
/**
 *
 * @author khawl
 */
public class FileManagement {
    
      // file to byte[], old and classic way, before Java 7
  public  byte[] bytes ;
  public  int length ;
  public InputStream targetStream;
   public OutputStream target;
  public FileManagement ( ) {}
  public   void readFileToBytes(String filePath) throws IOException {
      // methode 1 https://mkyong.com/java/how-to-convert-file-into-an-array-of-bytes/
      // methode 2 https://jenkov.com/tutorials/java-io/inputstream.html 
         File file = new File(filePath);
         this.bytes = new byte[(int) file.length()]; 
         this. targetStream = new FileInputStream(file);
         this.length =  this. targetStream.read(this.bytes);
  }
  
  
  
  
   
   public Image   writeBytesToImage( )   { 
      InputStream inputStreamx = new ByteArrayInputStream(this.bytes );
      return new  Image(inputStreamx);
  }
    public Image   writeBytesToImage( byte[] bytes )   { 
      InputStream inputStreamx = new ByteArrayInputStream(bytes );
      return new  Image(inputStreamx);
  }
        public  byte[]     readImageAsBytes(  Image image )   {   //????????????????????,, ERRROR
                              // PixelReader generated image bytes
                            /* ByteArrayOutputStream os = new ByteArrayOutputStream();
                             try{ ImageIO.write(
                                     (RenderedImage) image,"jpg", os); 
                             
                             }
                             catch (Exception e ){System.out.println(e .getMessage()); e.printStackTrace();}
                               InputStream fis = new ByteArrayInputStream(os.toByteArray());    */
                            
                            
                            // PixelReader generated image bytes
                            int width = (int) image.getWidth();
                            int height = (int) image.getHeight();
                            this.bytes = new byte[width * height * 4];
                            System.out.println(this.bytes.length);  // 367928 bytes
                            image.getPixelReader().getPixels(0, 0, width, height, PixelFormat.getByteBgraInstance(), this.bytes, 0, width * 4); 
                            return this.bytes;
                               }
}

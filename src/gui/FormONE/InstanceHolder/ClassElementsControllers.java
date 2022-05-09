/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.FormONE.InstanceHolder;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class ClassElementsControllers implements InterfaceElementsControllers {  
       static public String Str_text = "Class";
       static public BorderPane FormONEBorderPane = null;
       static public final String URL_ListBLog = "/gui/FormONE/LoadingCenter/Blog_Pannel/ListView/ListBlog_FXML.fxml";
       static public Stage FormOne_ListBLog = null;
       static public final String URL_BLogPost = "/gui/FormONE/LoadingCenter/Blog_Pannel/ListItemPost/BlogPost_FXML.fxml"; 
}

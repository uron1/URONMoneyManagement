/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uron;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import static javafx.scene.paint.Color.web;
import static javafx.scene.paint.Color.web;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author dan
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private WebView web;
    
    {

    }
    @FXML
    private void start(ActionEvent event) throws IOException, Exception{
       Stage stage = new Stage();
       Parent root = FXMLLoader.load(getClass().getResource("mainUI.fxml"));
       Scene scene = new Scene(root);
       stage.show();
       stage.setScene(scene);
       
       
       
       
       
       
       
    }
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         web.getEngine().load("https://twitter.com/");
    }    
    
}

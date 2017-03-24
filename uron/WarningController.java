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
import static uron.MainUIController.warningpane;

/**
 *
 * @author dan
 */
public class WarningController  implements Initializable{
    @FXML
    private void newproject(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("newproject.fxml"));
        
        Scene a = new Scene(root);
        
        MainUIController.createprojectwindow.setScene(a);
        MainUIController.createprojectwindow.show();
        MainUIController.warningpane.close();
    }
        @FXML
    private void back(ActionEvent event){
        MainUIController.warningpane.close();
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}

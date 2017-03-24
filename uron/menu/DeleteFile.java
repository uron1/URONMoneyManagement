/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uron.menu;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import uron.MainUIController;
import uron.MoneyManagement;
import uron.PathManagement;
import uron.Relay;

/**
 *
 * @author dan
 */
public class DeleteFile  implements Initializable{

   
    @FXML
    ChoiceBox selectproject2;
    @FXML
    private void delete(ActionEvent event){
        
        String selected=selectproject2.getValue().toString();
       
    File file = new File(PathManagement.projectfolder+"/"+selected+".URON");

    if (file.exists()){
      if (file.delete()){
        System.out.println("ファイルを削除しました");
                Relay.deletecheck=true;
        Relay.deletename=selected;
        MainUIController.deletepane.close();
        MoneyManagement.nowmoney=0;
        MoneyManagement.monthmoney=0;


      }else{
        System.out.println("ファイルの削除に失敗しました");
      }
    }else{
      System.out.println("ファイルが見つかりません");
    }
  
               
    }
      
    @FXML
    private void cancel(ActionEvent event){
        MainUIController.deletepane.close();
    }
    
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         String path = PathManagement.projectfolder;
    
         File dir = new File(path);
    File[] files = dir.listFiles();
    for (int i = 0; i < files.length; i++) {
        File file = files[i];
        
        String showfilename;
        String show;
        
        
            
               
            
    
           showfilename =  file.toString().replaceFirst(PathManagement.projectfolder,"");
           System.out.println(showfilename);
           
           

           
           
            show= showfilename.replaceFirst(".URON","");
            
            String substring = show.substring(1);
                    if (!".DS_Store".equals(substring)) {
                      

                
                         selectproject2.getItems().addAll(substring);   
                        System.out.println(substring);
                        

                        
        
}
        

              
        
               

        
    }
    }

    

}

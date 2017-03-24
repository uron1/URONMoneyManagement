/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uron;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static uron.ProjectName.projectname;

/**
 *
 * @author dan
 */
public class NewProjectController implements Initializable{
    @FXML
    TextField inputtext;
    @FXML
    Label warning;
    @FXML
    private void createproject(ActionEvent event){
    String newprojectname = inputtext.getText();
        if ("".equals(newprojectname)) {
            warning.setText("空白では作成できません");
        }else{
            
        
    CreateFile newfile = new CreateFile();
    newfile.newfile(newprojectname);
    Write write = new Write();
    write.newfilewrite(PathManagement.projectfolder+"/"+newprojectname+".URON",newprojectname);
//    MainUIController.selectproject.getItems().addAll(newprojectname);
    MainUIController cont =new MainUIController();   
    Relay.relaycheck=true;
    Relay.relay=newprojectname;

    MainUIController.createprojectwindow.close();
        }
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    }
    
}

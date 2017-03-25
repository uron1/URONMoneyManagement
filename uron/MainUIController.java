
package uron;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class MainUIController implements Initializable{
    public static Stage warningpane = new Stage();
    public static Stage deletepane = new Stage();
    @FXML
    Label useproject;
    @FXML
    Label warning;
    @FXML
    Label money;
    @FXML
     Label monthmoney;
    @FXML
    ChoiceBox selectproject;
    @FXML
    TextField input;

    @FXML
    private void setting(ActionEvent event){
        //設定ウィンドウを開く
    }
    @FXML
    private void use(ActionEvent event) throws IOException{
        //使いかたウィンドウを開く
    }
    @FXML
    private void openosirase(ActionEvent event){
        //お知らせウィンドウを開く
    }  
    @FXML
    private void openotoiawase(ActionEvent event) throws IOException{
        //お問い合わせウィンドウを開く
        Stage  otoiawase = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menu/webview.fxml"));
         Scene a = new Scene(root);
        otoiawase.setScene(a);

        otoiawase.show();
        

        
        
    }
   

    @FXML
    private void loadproject(ActionEvent event) throws IOException{
        Object projectname =selectproject.getValue();
//        money.setText(projectname.toString()); これは気にしないでください
           ReadFile readfile = new ReadFile();
          ProjectName.projectname=projectname.toString();
           readfile.readfile(PathManagement.projectfolder+"/"+projectname.toString());
           this.reload();
           useproject.setText("["+ProjectName.projectname+"]が選択されています");
    }
    @FXML
    private void add(ActionEvent event){
        try{
                    String inputtext = input.getText();
        int inputmoney = Integer.parseInt(inputtext);
       
        MoneyManagement.nowmoney+=inputmoney;
        MoneyManagement.monthmoney+=inputmoney;
        
            if ("".equals(ProjectName.projectname)) {
                        Parent root = FXMLLoader.load(getClass().getResource("warning.fxml"));
        
        Scene a = new Scene(root);
        
        warningpane.setScene(a);
        warningpane.show();
            }else{
        Write write = new Write();
                System.out.println(ProjectName.projectname);
        write.write(PathManagement.projectfolder+"/"+ProjectName.projectname);
        this.reload();
        warning.setText("");
            }
            
        }catch(Exception e){
            System.out.println(e); 
            warning.setText("半角英数の数字を入力してください。");
        }

        
        
    }
    
       public static Stage createprojectwindow = new Stage();
    @FXML
    private void newproject(ActionEvent event) throws IOException{
        
                Parent root = FXMLLoader.load(getClass().getResource("newproject.fxml"));
        
        Scene scene = new Scene(root);
        
        createprojectwindow.setScene(scene);
        createprojectwindow.show();
        
    }
    
    
    
    
    

    
    
    
    
    
    @FXML
    private void deleteproject(ActionEvent event) throws IOException{
        // FXMLファイルの読込
        URL             location    = getClass().getResource( "menu/delete.fxml" );
        FXMLLoader      fxmlLoader  = new FXMLLoader( location );
         
        // シーングラフの作成
        Pane    root        = (Pane) fxmlLoader.load();
         
        // シーンの作成
        Scene   scene       = new Scene(root);
        deletepane.setScene(scene);
        deletepane.show();
        
        
       
      
    }

    
  public void reload(){
      money.setText(String.valueOf(MoneyManagement.nowmoney));
      monthmoney.setText(String.valueOf(MoneyManagement.monthmoney));

  }

    
  
  


public void start(){
      PathKUGIRI.OShantei();
        System.out.println(PathKUGIRI.usepath);
                       String path = PathManagement.projectfolder;
    File dir = new File(path);
    File[] files = dir.listFiles();
    for (int i = 0; i < files.length; i++) {
        File file = files[i];
        
        String showfilename;
        String show;
        
        
            
               
            
    
           showfilename =  file.toString().replaceFirst(PathManagement.projectfolder,"");
           System.out.println(showfilename);
           
           
//           showfilename2 =  showfilename.replaceAll("","");
           
           
            show= showfilename.replaceFirst(".URON","");
            
            String substring = show.substring(1);
                    if (!".DS_Store".equals(substring)) {
                      
                         
            selectproject.getItems().addAll(substring);
                

                       
           
     
                        

                        
        
}
  
              
        
               

        
    

        
    }
}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       start();
            
 
   }
   ScheduledExecutorService serviceExecutor = Executors.newSingleThreadScheduledExecutor();
ScheduledFuture future = serviceExecutor.scheduleWithFixedDelay(new Runnable() {
        @Override
        public void run() {
            //やりたい処理
            
            if (Relay.relaycheck==true) {
               String addcontent=Relay.relay;
                System.out.println(addcontent);
                
                
                        
                           selectproject.getItems().addAll(addcontent);

           
                
                Relay.relay="";
                Relay.relaycheck=false;
            }else if(Relay.deletecheck==true){
                String removecontent = Relay.deletename;//なんかさー！直接static変数呼び出してremoveじゃ、消せなくて一度String型の変数に代入して、removeさせるとできちゃううううんｋｋｋｋｋｋ
                
                            
                           
               
               
            

                                if (Relay.deletename.equals(ProjectName.projectname)) {
                    System.out.println("選択しているプロジェクトと消去するプロジェクトが一致しました");
                    Platform.runLater(() -> selectproject.getItems().remove(removecontent));
                    MoneyManagement.nowmoney=0;
                    MoneyManagement.monthmoney=0;
                    Platform.runLater(() -> reload());
                    Platform.runLater(() -> useproject.setText("プロジェクトが選択されていません"));
                    
                }else{
                                    selectproject.getItems().remove(removecontent);
                                }
                System.out.println("消去されたよ！！");
   
                        

                Relay.deletename="";
                Relay.deletecheck=false;
                
                

            }
        }
    }, 1, 2, TimeUnit.SECONDS);

     


}


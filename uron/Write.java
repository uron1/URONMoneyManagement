/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uron;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dan
 */
public class Write {
    
    public void write(String path){
        
    try{
      
      File file = new File(path + ".URON");

      if (checkBeforeWritefile(file)){
        FileWriter filewriter = new FileWriter(file);

        filewriter.write(MoneyManagement.nowmoney+"\n");
        filewriter.write(MoneyManagement.monthmoney+"\n");
        filewriter.write(ProjectName.projectname+"\n");
        filewriter.write(DataRecord.data);

        filewriter.close();
      }else{
          
        System.out.println("ファイルに書き込めません");
      }
    }catch(IOException e){
      System.out.println(e);
    }
  } 
    public void newfilewrite(String path,String projectname){
                Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM");
    try{
      
      File file = new File(path);

      if (checkBeforeWritefile(file)){
        FileWriter filewriter = new FileWriter(file);

        filewriter.write("0\n");
        filewriter.write("0\n");
        filewriter.write(projectname+"\n");
        filewriter.write(sdf1.format(date));

        filewriter.close();
          System.out.println("かきこめました");
      }else{
        System.out.println("ファイルに書き込めません");
      }
    }catch(IOException e){
      System.out.println(e);
    }
  }

  private static boolean checkBeforeWritefile(File file){
    if (file.exists()){
      if (file.isFile() && file.canWrite()){
        return true;
      }
    }

    return false;
  }

 
    
    
}

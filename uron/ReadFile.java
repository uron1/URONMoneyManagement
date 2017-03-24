/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uron;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author dan
 */
public class ReadFile {
    //ファイルを読み込むメソッド
    public void readfile(String path) throws IOException{//引数にファイルのパスが記録されているString型のものを渡す
            try{
      File file = new File(path + ".URON");

      if (checkBeforeReadfile(file)){
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        int count = 1;
        while((str = br.readLine()) != null){
          switch(count){
              case 1:
                  MoneyManagement.nowmoney=Integer.parseInt(str);
                  
                  count=2;
                  break;
              case 2:
                  MoneyManagement.monthmoney=Integer.parseInt(str);
                   count=3;
                 
                  break;
              case 3:
                  ProjectName.projectname=str;
                  count=4;
                  
                  break;
              case 4:
                  DataRecord.data=str;
                  DataRecord datacheck = new DataRecord();
                  datacheck.datacheck();
                  break;
                  
          }
          
        }
          System.out.println(MoneyManagement.nowmoney);
          System.out.println(MoneyManagement.monthmoney);
          System.out.println(ProjectName.projectname);
          System.out.println(DataRecord.data);
          
          
          
        br.close();
      }else{
        System.out.println("ファイルが見つからないか開けません");
      }
    }catch(FileNotFoundException e){
      System.out.println(e);
    }catch(IOException e){
      System.out.println(e);
    }
  }

  private static boolean checkBeforeReadfile(File file){
    if (file.exists()){
      if (file.isFile() && file.canRead()){
        return true;
      }
    }

    return false;
    
}
}
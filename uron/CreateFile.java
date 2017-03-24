/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uron;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author dan
 */
public class CreateFile {
    public void newfile(String filename){
            File newfile = new File(PathManagement.projectfolder+"/"+filename+".URON");

    try{
      if (newfile.createNewFile()){
        System.out.println("ファイルの作成に成功しました");
      }else{
        System.out.println("ファイルの作成に失敗しました");
      }
    }catch(IOException e){
      System.out.println(e);
    }

    }
}

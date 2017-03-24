/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uron;

import java.text.SimpleDateFormat;
import java.util.Date;
import static uron.ProjectName.projectname;

/**
 *
 * @author dan
 */
public class DataRecord {
    public static String data="";
    
    
    public void datacheck(){
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM");
        
        if (!DataRecord.data.equals(sdf1.format(date))) {
            DataRecord.data=sdf1.format(date);
            MoneyManagement.monthmoney=0;
            System.out.println("今月貯まった金額の記録をリセットしました");
            Write write = new Write();
            write.write(PathManagement.projectfolder+"/"+ProjectName.projectname);
        }
    }
    
}

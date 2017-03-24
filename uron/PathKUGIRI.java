/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uron;

/**
 *
 * @author dan
 */
public class PathKUGIRI {
    public static String usepath="";
    private static String windows="¥";
    private static String mac="/";
    public static void OShantei(){
        String osname = System.getProperty("os.name");
        
            if(osname.indexOf("Windows")>=0){
                usepath=windows;
              // Windowsであったときの処理
                System.out.println("windowsだよ");
            }
            else{
                System.out.println("windows以外のOSだよ");
                usepath=mac;
            }
    }

}

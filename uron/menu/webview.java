/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uron.menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author dan
 */
public class webview implements Initializable{
        @FXML
    WebView webview;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
                    WebEngine engine = webview.getEngine();
        
        engine.load("http://uron2.webcrow.jp/Contact/input.php");
    }
    


}

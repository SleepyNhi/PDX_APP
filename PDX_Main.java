/*
 * Notice this class is not used
 * If you are looking for this code it is in pdx/main/Main.java
 *
 *
 *
 *
 */
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 package pdx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;



/**
 *
 * @author Sleepynhi
 
public class PDX_Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("/pdx/PDX_LoginGUI.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
        public static void main(String[] args) {
        launch(args);
    }
   
}
*/

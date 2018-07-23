/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sleepynhi
 */
public class PDX_HomeNavController implements Initializable {
    @FXML
    private Glow x1;
    @FXML
    private Button Front_Desk;
    @FXML
    private SepiaTone x2;
    @FXML
    private Font x3;
    @FXML
    private Button HR;
    @FXML
    private Button Jan;
    @FXML
    private Button Rest;
    @FXML
    private Button Admin;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void FrontDesk_Issue(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        
  
        stage=(Stage) Front_Desk.getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("/pdx/PDX_FrontDeskGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       
    }

    @FXML
    private void HR_Issue(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        
        stage=(Stage) HR.getScene().getWindow();
        
        root = FXMLLoader.load(getClass().getResource("/pdx/PDX_HRGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Jan_Issue(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        
  
        stage=(Stage) Jan.getScene().getWindow();
        
       
        root = FXMLLoader.load(getClass().getResource("/pdx/PDX_Jan.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Rest_Issue(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        
  
        stage=(Stage) Rest.getScene().getWindow();
        
       
        root = FXMLLoader.load(getClass().getResource("/pdx/PDX_RestaurantGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Admin_Issue(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        
  
        stage=(Stage) Admin.getScene().getWindow();
        
       
        root = FXMLLoader.load(getClass().getResource("/pdx/PDX_AdminTestGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

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
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sleepynhi
 */	
public class PDX_RestaurantGUIController implements Initializable {
    @FXML
    private Button Home;
    @FXML
    private Button Delete;
    @FXML
    private Button Save;
    @FXML

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void home_issue(ActionEvent event) throws IOException {
        
        Stage stage; 
        Parent root;
        
  
        stage=(Stage) Home.getScene().getWindow();
        
       
        root = FXMLLoader.load(getClass().getResource("/pdx/PDX_HomeNav.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

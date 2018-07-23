/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sleepynhi
 */
public class PDX_LoginGUIController implements Initializable {
    @FXML
    private AnchorPane PDX_LoginGUI;
    @FXML
    private TilePane title;
    @FXML
    private PasswordField password_field;
    @FXML
    private TextField User_field;
    @FXML
    private Font x1;
    @FXML
    private Button login_btn;
    @FXML
    private Label message_label;
    @FXML
    private Glow x2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
     private void login_issue(ActionEvent event) throws Exception {
        String acc_info;
        Stage stage; 
        Parent root;
  
        stage=(Stage) login_btn.getScene().getWindow();
        
        if(User_field.getText().equals("admin") && password_field.getText().equals("pdx")){
            root = FXMLLoader.load(getClass().getResource("/pdx/PDX_HomeNav.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            password_field.clear();
            message_label.setText("ID and Password Combination is incorrect!");
        }
    }
    
}

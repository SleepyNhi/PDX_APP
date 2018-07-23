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
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import pdx.rooms.Room;

/**
 * FXML Controller class
 *
 * @author Sleepynhi
 */
public class FrontDesk_GUIController implements Initializable {
    @FXML
    private Tab Room_Book;
    @FXML
    private TableColumn roomNum;
    @FXML
    private TableColumn a_status;
    @FXML
    private Tab guestlist;
    @FXML
    private ListView Guest_List;
    @FXML
    private Tab Calendar;
    @FXML
    private Tab Check_IO;
    @FXML
    private TableColumn FD_Table_First_Name;
    @FXML
    private TableColumn FD_Table_Last_Name;
    @FXML
    private TableColumn FD_Table_Phone;
    @FXML
    private TableColumn FD_Table_RoomNum;
    @FXML
    private Button home_btn;
    @FXML
    private Button Delete_btn;
    @FXML
    private Button Save_btn;

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
        stage=(Stage) home_btn.getScene().getWindow(); 
        root = FXMLLoader.load(getClass().getResource("/pdx/PDX_HomeNav.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @FXML
    private void Populate_Room_Book(ActionEvent event) throws IOException {
        roomNum.setCellFactory(new PropertyValueFactory<Room,Integer>("id"));
        a_status.setCellFactory(new PropertyValueFactory<Room,Integer>("stat"));
    }
    
    
}

package pdx.module.restaurant;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import pdx.database.DatabaseConnection;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
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
    
}*/

public class Menu implements Initializable{
    @FXML
    private Button Home;
    @FXML
    private Button Delete;
    @FXML
    private Button Save;
    @FXML 
    private TableView<Person> ItemsTable;
	@FXML
	private TableColumn<Person,String> ItemName;
	@FXML
	private TableColumn<Person,String> ItemsTable1;
	@FXML
	private TableColumn<Person,String> ItemsTable2;
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
    
	// Gets the infomation from the iteminfo portion  of the database to place the items that
	// are in the menu in a arraylist that we can pull infomation from
	public void getrestmenu(){
		
		System.out.println("Starts");
		//creates table for future use to be implemented in the tableview
		TableView<Person> table = new TableView<Person>();
 
		//the information is stored here to be implemented into the tableview
	    ObservableList<Person> data = FXCollections.observableArrayList();
	    
	    
		ArrayList<Object[]> menu = DatabaseConnection.getFromDatabase("ItemInfo");
		
		for(int i = 0; i < menu.size(); i++) {
			Object[] o = (Object[]) menu.get(i);
			String test = o[5].toString();
			System.out.println("Test is starting here");
			System.out.println(test);
			System.out.println("-->" + o[5]);
			data.add(new Person((String)o[5], (String)o[5]+"ttttttt", (String)o[5]+"adsf"));
			
			
			ItemName.setCellValueFactory(
		            new PropertyValueFactory<Person,String>("firstName"));
			ItemsTable.setItems(data);
			ItemsTable1.setCellValueFactory(
		            new PropertyValueFactory<Person,String>("lastName"));
			ItemsTable.setItems(data);
			ItemsTable2.setCellValueFactory(
		            new PropertyValueFactory<Person,String>("email"));
			
			ItemsTable.setItems(data);
			
			//Creates a table to show what item are being served
			boolean[][] serve = new boolean[menu.size()][3];
			
			//checks if serveBreakfast is "Y"  or "N" and placing the result in
			//the array "serve"
			if(o[2].equals("Y")){
				serve[i][0] = true;
			} else{
				serve[i][0] = false;
			}
			
			//checks if serveLunch is "Y"  or "N" and placing the result in
			//the array "serve"
			if(o[3].equals("Y")){
				serve[i][1] = true;
			} else{
				serve[i][1] = false;
			}
			
			//checks if serveDinner is "Y"  or "N" and placing the result in
			//the array "serve"
			if(o[4].equals("Y")){
				serve[i][2] = true;
			} else{
				serve[i][2] = false;
			}
			
			

			
			
			
			
			
		}
	}
	
	//Updates the array list by inserting a new row into the table "ItemInfo"
	public void insertrestmenu(String sBreakfast, String sLunch, String sDinner, String name, int itemcatID, int cost, int inventory){
		DatabaseConnection.insert("ItemInfo", new String[]{"serveBreakfast", "serveLunch", "serveDinner", "name", "itemCategoryID", "cost", "inventory"}, new Object[]{sBreakfast, sLunch, sDinner, name, itemcatID, cost, inventory});
	}
	
	public void updaterestmenu(String sBreakfast, String sLunch, String sDinner, String name, int itemcatID, int cost, int inventory){
		/*
		 * How do we get the row ID?
		 * Make sure to ask
		 * */
		DatabaseConnection.update("ItemInfo", 1, new String[]{"serveBreakfast", "serveLunch", "serveDinner", "name", "itemCategoryID", "cost", "inventory"}, new Object[]{sBreakfast, sLunch, sDinner, name, itemcatID, cost, inventory});
	}
	
	
	public static class Person {
		 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
 
        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		getrestmenu();
		
	}
}

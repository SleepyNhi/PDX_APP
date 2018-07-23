package pdx.main;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.util.ArrayList;

import pdx.database.DatabaseConnection;

public class Main extends Application{

	@Override
    public void start(Stage primaryStage) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("/pdx/PDX_LoginGUI.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
	
	public static void main(String[] args) {


		//Example of getting a table from the database
		ArrayList<Object[]> al = DatabaseConnection.getFromDatabase("ItemInfo");
		for(int i = 0; i < al.size(); i++) {
			Object[] o = (Object[]) al.get(i);
			System.out.println(o[5]);
		}
		//Example of inserting into a table. Here, we do NOT set OrderInfoID because it auto-increments
		//DatabaseConnection.insert("OrderInfo", new String[]{"total", "orderDate"}, new Object[]{"100", "5.22.2016"});
		
		DatabaseConnection.update("OrderInfo", 1, new String[]{"total", "orderDate"}, new Object[]{"200", "5.23.2016"});
		launch(args);
	}
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * import java.io.IOException;
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


}

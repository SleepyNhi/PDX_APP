package pdx.module.janitorial;

import java.util.ArrayList;

import pdx.database.DatabaseConnection;

public class Inventory {
	//name, amount, price
	// Gets the infomation from the iteminfo portion  of the database to place the items that
	// are in the menu in a arraylist that we can pull infomation from
	public void getrestmenu(){
		ArrayList<Object[]> menu = DatabaseConnection.getFromDatabase("Janitor");
		for(int i = 0; i < menu.size(); i++) {
			Object[] o = (Object[]) menu.get(i);
			System.out.println(o[2]);
			//2 will get the name
			//3 will get the amount left in the inventory
			//4 will get the price of the item at the store if there is need to restock
			
			
			
			//Creates a table to show what item are being served
			boolean[][] serve = new boolean[menu.size()][3];
			
		}
	}
	
	//Updates the array list by inserting a new row into the table "ItemInfo"
	public void insertJanatorialItem(String nameofnewitem, int amount, int cost){
		DatabaseConnection.insert("Janitor", new String[]{"name", "amount", "price"}, new Object[]{nameofnewitem, amount, cost});
	}
	
	public void updaterestmenu(String nameofnewitem, int amount, int cost){
		/*
		 * How do we get the row ID?
		 * Make sure to ask
		 * */
		DatabaseConnection.update("Janitor", 1, new String[]{"name", "amount", "price"}, new Object[]{nameofnewitem, amount, cost});
	}
	
}

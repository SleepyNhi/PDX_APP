package pdx.module.restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * For this class we may need to incorporate a guest name
 */

public class OrderItem {
	public static void placeOrder(int itemid, int quantity/*, int tableId*/){
		pdx.database.DatabaseConnection.insert("OrderInfo", new String[]{"itemID", "quantity"/*, "TableID"*/}, new Object[]{itemid, quantity/*, tableId*/});
	}
}

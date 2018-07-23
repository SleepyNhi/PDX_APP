package pdx.database;

import pdx.module.janitorial.Inventory;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
	static Connection c = null;
	static Statement stmt = null;
	
	/**
	 * Gets entire table and returns in an ArrayList of Object arrays
	 * @param tableName Name of the table
	 * @return Table of form ArrayList<Object[]>
	 */
	public static ArrayList<Object[]> getFromDatabase(String tableName) {
		ArrayList<Object[]> toReturn = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:paradox.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+tableName+";");
			ResultSetMetaData rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			Object[] o = null;
			while(rs.next()) {
				o = new Object[col];
				for(int i = 1; i < col; i++) {
					o[i] = rs.getObject(i);
				}
				toReturn.add(o);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return null;
		}
		return toReturn;
	}
	
	/**
	 * Insert data into database. Do NOT set the first column (usually xId) as this auto-increments naturally
	 * @param tableName Name of the table to insert into
	 * @param entries Names of columns to enter into
	 * @param values Values to insert
	 */
	public static void insert(String tableName, String[] entries, Object[] values) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:paradox.db");
			System.out.println("Opened database successfully");
			//Get entries and values in correct format
			String s = "", s1 = "";
			for(String s2 : entries) {
				s = s+s2+", ";
			}
			for(Object o : values) {
				s1 += "?, ";
			}
			s = s.substring(0, s.length()-2);
			s1 = s1.substring(0, s1.length()-2);
			PreparedStatement query = c.prepareStatement("INSERT INTO "+tableName+" ("+s+") VALUES ("+s1+");");
			
			for(int i = 0; i < values.length; i++) {
				query.setObject(i+1, values[i].toString());
			}
			query.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update an entry in the database. entries size and values must be equal!
	 * @param tableName Name of the table to update
	 * @param rowId ID of the row that needs editing
	 * @param entries Column names to edit
	 * @param values Values to update in the columns
	 * @param columnName The name of the column. This is a constant for each object
	 */
	public static void update(String tableName, int rowId, String[] entries, Object[] values) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:paradox.db");
			System.out.println("Updating table "+tableName+"...");
			String s = "";
			for(int i = 0; i < entries.length; i++) {
				s+=entries[i]+"=?, ";
			}
			s = s.substring(0, s.length()-2);
			System.out.println(s);
			String info = "SELECT * FROM "+tableName;
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(info);
			ResultSetMetaData rsmd = rs.getMetaData();
			String columnName = rsmd.getColumnName(1);
			PreparedStatement query = c.prepareStatement("UPDATE "+tableName+" SET "+s+" WHERE "+columnName+" = "+rowId);
			System.out.println("UPDATE "+tableName+" SET "+s+" WHERE "+columnName+" = "+rowId);
			
			for(int i = 0; i < values.length; i++) {
				System.out.println(values[i].toString());
				query.setString(i+1, values[i].toString());
			}
			query.execute();
			
		} catch(Exception e) {
			
		}
	}
	
}
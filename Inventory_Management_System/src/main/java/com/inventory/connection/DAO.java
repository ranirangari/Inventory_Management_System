package com.inventory.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	
	private static Connection con=null;
	
	public static Connection getCon() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1999");
			
			return con;
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return con;
		
	}
	
}

package com.Vendorly.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;


public class DBConnection {
	public static void main(String[] argv) throws SQLException {

		
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://vos-db.altidev.net:3306/vos_1_qa","vos1x", "vos1x_password");
			
			
			//jdbc:mysql://vos-db.altidev.net:3306/vos_1_qa

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else 
		{
			System.out.println("Failed to make connection!");
		}
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select client_nbr from vos_client where client_name='Azule';");
		 while(rs.next()){
	         //Retrieve by column name
	         int client_nbr  = rs.getInt("client_nbr");
	         

	         //Display values
	         System.out.print("Client Number: " + client_nbr);
	        
	      }
		//System.out.println(rs);
	}
	
}
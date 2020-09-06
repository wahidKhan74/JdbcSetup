package com.simplilearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/ecomercedb";
		String username ="root";
		String password = "root";
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		try {
			
			// 1. Register Driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Create Connection
			conn = DriverManager.getConnection(url,username,password);
			
			// 3. Create Query
			String query = "select * from eproduct";
			
			// 4. Create a Statement
			stm = conn.createStatement();
			 
			// 5. execute query 
			rst = stm.executeQuery(query);
			
			
			while (rst.next()) {
				System.out.println("---------------------------");
				System.out.println(rst.getInt(1)  + "  " +rst.getString(2) +"   "+ rst.getDouble(3));				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
//			rst.close();
			stm.close();
			conn.close();
		}

	}

}

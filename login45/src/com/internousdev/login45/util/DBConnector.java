package com.internousdev.login45.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String url = "jdbc:mysql://localhost/ecsite";
	private static String password = "mysql";

	public Connection getConnection(){
		Connection con = null;
		try{
			Class.forName(driverName);
			con = (Connection)DriverManager.getConnection(userName,url,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return con;
	}
}

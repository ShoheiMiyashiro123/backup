package com.internousdev.EC1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	//jdbcドライバのクラス名のことである。
	public static String driverName = "com.mysql.jdbc.Driver";
	//ユーザ名をrootにする。
	public static String userName = "root";
	//jdbc:mysql://(サーバ名)/(データベース名)の形をとる。
	public static String url = "jdbc:mysql://localhost/ecsite";
	//入力用パスワードの用意
	public static String password = "mysql";

	public Connection getConnection(){
		Connection con = null;
		try{
			//jdbcドライバをロードする。(おそらく、dbms毎に存在するものをすべてロードする。)
			Class.forName(driverName);

			//コネクションを取得する。(接続するdbの種類に応じてdbドライバを選択し接続する。)
			con = DriverManager.getConnection(url,userName,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return con;
	}
}

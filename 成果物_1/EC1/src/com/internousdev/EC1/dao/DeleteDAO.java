package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.EC1.util.DBConnector;


public class DeleteDAO {

	//DBコネクタを起動
	private DBConnector db = new DBConnector();

	//コネクションの作成
	private Connection con = db.getConnection();

	public int delete(String loginUserId) throws SQLException{

		//con = db.getConnection();

		int i = 0;

		String sql= "delete from user_buy_item_transaction "
				+ "where user_master_id like ?";

		//ログインしているユーザの購入情報の履歴を削除。
		try{

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginUserId);
			i = ps.executeUpdate();
		}catch(SQLException e){

			e.printStackTrace();
		}finally{

			con.close();
		}

		return i;
	}
}

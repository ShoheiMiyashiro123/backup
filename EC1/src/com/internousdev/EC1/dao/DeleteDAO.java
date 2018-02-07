package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.EC1.util.DBConnector;


public class DeleteDAO {

	//DBコネクタを起動
	DBConnector db = new DBConnector();

	//コネクションの作成
	Connection con = db.getConnection();

	public int delete(int itemTransactionId,String loginUserId) throws SQLException{

		int i = 0;

		String sql= "delete from user_buy_item_transaction "
				+ "where item_transaction_id=? and login_user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,itemTransactionId);
			ps.setString(2,loginUserId);
			i = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return i;
	}
}

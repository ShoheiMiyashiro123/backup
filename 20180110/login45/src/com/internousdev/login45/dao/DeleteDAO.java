package com.internousdev.login45.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.login45.util.DBConnector;

public class DeleteDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public int deleteInfo(String userMasterId) throws SQLException{
		String sql = "delete from user_buy_item_transaction where user_master_id=?";
		int i = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userMasterId);
			i =ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return i;
	}
}

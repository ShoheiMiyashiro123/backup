package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.EC1.util.DBConnector;
import com.internousdev.EC1.util.UtilDate;


public class UserCreateCompleteDAO {

	/**
	 * 接続情報
	 */
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public void insertUserInfo(
				String loginUserId,
				String userName,
				String loginPassword
			) throws SQLException{
		UtilDate utilDate = new UtilDate();
		String sql = "insert into login_user_transaction(login_id,user_name,login_pass,insert_date) "
				+ "values(?,?,?,?)";

		//ユーザ情報の登録
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginUserId);
			ps.setString(2,userName);
			ps.setString(3,loginPassword);
			ps.setString(4,utilDate.utilDate());
			ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			con.close();

		}
	}
}

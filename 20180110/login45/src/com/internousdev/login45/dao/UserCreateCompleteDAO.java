package com.internousdev.login45.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.login45.util.DBConnector;
import com.internousdev.login45.util.DateUtil;



public class UserCreateCompleteDAO {

	public int insertInfo(String userId,String userPassword,String userName) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int i = 0;

		String sql = "insert into login_user_transaction(login_id,login_pass,user_name,insert_date) values(?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,userPassword);
			ps.setString(3,userName);
			ps.setString(4,dateUtil.getDate());
			i = ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return i;
	}
}

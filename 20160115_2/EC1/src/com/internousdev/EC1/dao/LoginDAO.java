package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.intenrousdev.EC1.util.DBConnector;
import com.internousdev.EC1.dto.LoginDTO;


public class LoginDAO {
	/**
	 * 接続設定
	 */
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		//DBConnector db = new DBConnector();
		//Connection con = db.getConnection();

		LoginDTO loginDTO = null;

		try{
			String sql = "select * from login_user_transaction where login_id=? and login_pass=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginUserId);
			ps.setString(2,loginPassword);
			ResultSet rs = ps.executeQuery();

			System.out.println(rs.next());

			if(rs.next()){
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));
				loginDTO.setLoginFlg(true);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return loginDTO;
	}
}

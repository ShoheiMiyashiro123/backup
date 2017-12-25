package com.internousdev.login45.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.inernousdev.login45.dto.LoginDTO;
import com.internousdev.login45.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){

		String sql = "select * from login_user_transaction where login_id=? and login_pass=?";

		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,loginUserId);
			ps.setString(2,loginPassword);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_password"));
				loginDTO.setUserName(rs.getString("user_name"));

			}

			if(!(loginDTO.getLoginId().equals(null))){
				loginDTO.setLoginFlg(true);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return loginDTO;
	}

	public LoginDTO getLoginDTO(){
		return loginDTO;
	}
}

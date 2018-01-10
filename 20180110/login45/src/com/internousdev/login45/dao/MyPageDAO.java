package com.internousdev.login45.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.inernousdev.login45.dto.MyPageDTO;
import com.internousdev.login45.util.DBConnector;


public class MyPageDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(int item_transaction_id,String user_master_id) throws SQLException{
		String sql = "select ubit.id,ubit.total_price,ubit.total_count,ubit.pay,iit.item_name,lut.user_name from user_buy_item_transaction ubit "+
						"left join item_info_transaction iit on ubit.item_transaction_id=iit.id "+
						"left join login_user_transaction lut on ubit.user_master_id=lut.login_id "+
						"where ubit.item_transaction_id=? and ubit.user_master_id=?";

		ArrayList<MyPageDTO> myPageDTOs = new ArrayList<MyPageDTO>();

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,item_transaction_id);
			ps.setString(2,user_master_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyPageDTO myPageDTO = new MyPageDTO();

				System.out.println(rs.getInt("ubit.total_price")+","+rs.getInt("ubit.total_count")+","+rs.getString("ubit.pay"));
				myPageDTO.setId(rs.getInt("ubit.id"));
				myPageDTO.setItemName(rs.getString("iit.item_name"));
				myPageDTO.setTotalPrice(rs.getInt("ubit.total_price"));
				myPageDTO.setTotalCount(rs.getInt("ubit.total_count"));
				myPageDTO.setPayment(rs.getString("ubit.pay"));
				myPageDTO.setUserName(rs.getString("lut.user_name"));
				myPageDTOs.add(myPageDTO);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return myPageDTOs;
	}
}
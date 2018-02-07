package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.EC1.dto.MyPageDTO;
import com.internousdev.EC1.util.DBConnector;

public class MyPageDAO {

	//DBコネクタのインスタンス作成
	DBConnector db = new DBConnector();

	//コネクションの作成
	Connection con = db.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(int itemTransactionId,String userMasterId) throws SQLException{

		//購入履歴情報格納用DTO用のリスト
		ArrayList<MyPageDTO> myPageDTOs = new ArrayList<MyPageDTO>();

		String sql = "select * from user_buy_item_transaction ubit "
				+ "left join item_info_transaction iit on ubit.item_transaction_id=iit.id "
				+ "where ubit.item_transaction_id=? and ubit.user_master_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,itemTransactionId);
			ps.setString(2,userMasterId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyPageDTO myPageDTO = new MyPageDTO();
				myPageDTO.setId(rs.getInt("ubit.item_transaction_id"));
				myPageDTO.setItemName(rs.getString("iit.item_name"));
				myPageDTO.setPayment(rs.getString("ubit.pay"));
				myPageDTO.setTotalPrice(rs.getInt("ubit.total_price"));
				myPageDTO.setTotalCount(rs.getInt("ubit.total_count"));
				myPageDTO.setInsertDate(rs.getDate("ubit.insert_date"));
				myPageDTOs.add(myPageDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return myPageDTOs;
	}
}

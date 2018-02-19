package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.EC1.dto.MyPageDTO;
import com.internousdev.EC1.util.DBConnector;

public class MyPageDAO {

	//DBコネクタのインスタンス作成
	DBConnector db = new DBConnector();

	//コネクションの作成
	Connection con = db.getConnection();

	public List<List<MyPageDTO>> getMyPageUserInfo(String userMasterId) throws SQLException{

		//購入履歴情報格納用DTO用のリスト
		List<List<MyPageDTO>> myPageDTOs = new ArrayList<List<MyPageDTO>>();

		String sql = "select * from user_buy_item_transaction ubit "
				+ "left join item_info_transaction iit on ubit.item_transaction_id=iit.id "
				+ "where ubit.user_master_id=? order by ubit.buy_id desc,item_transaction_id;";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userMasterId);
			ResultSet rs = ps.executeQuery();

			int buy_id = -1;
			while(rs.next()){
				if(buy_id!=rs.getInt("buy_id")){
						myPageDTOs.add(new ArrayList<MyPageDTO>());
						buy_id = rs.getInt("buy_id");
				}
				MyPageDTO myPageDTO = new MyPageDTO();
				myPageDTO.setId(rs.getInt("ubit.item_transaction_id"));
				myPageDTO.setBuyId(rs.getInt("buy_id"));
				myPageDTO.setItemName(rs.getString("iit.item_name"));
				myPageDTO.setPayment(rs.getString("ubit.pay"));
				myPageDTO.setTotalPrice(rs.getInt("ubit.total_price"));
				myPageDTO.setTotalCount(rs.getInt("ubit.total_count"));
				myPageDTO.setInsertDate(rs.getDate("ubit.insert_date"));
				myPageDTOs.get(myPageDTOs.size()-1).add(myPageDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return myPageDTOs;
	}
}

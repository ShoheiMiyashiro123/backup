package com.internousdev.login45.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.login45.util.DBConnector;
import com.internousdev.login45.util.DateUtil;

public class BuyItemCompleteDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	DateUtil dateUtil = new DateUtil();

	String sql = "insert into user_buy_item_transaction(item_transaction_id,total_price,"+
				 "total_count,user_master_id,pay,insert_date) "+
				 "values(?,?,?,?,?,?)";

	public void buyItemSave(
			int itemTransactionId,
			int totalPrice,
			int totalCount,
			String userMasterId,
			String pay
			) throws SQLException{
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,itemTransactionId);
			ps.setInt(2,totalPrice);
			ps.setInt(3,totalCount);
			ps.setString(4,userMasterId);
			ps.setString(5,pay);
			ps.setString(6,dateUtil.getDate());

			int i = ps.executeUpdate();

			System.out.println(i+"件追加しました。");

		}catch(Exception e){
			e.printStackTrace();

		}finally{
			con.close();

		}
	}
}

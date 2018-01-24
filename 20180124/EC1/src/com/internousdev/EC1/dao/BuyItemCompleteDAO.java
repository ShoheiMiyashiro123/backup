package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.EC1.dto.UserBuyItemDTO;
import com.internousdev.EC1.util.DBConnector;
import com.internousdev.EC1.util.UtilDate;

public class BuyItemCompleteDAO {

	/**
	 * DBコネクタ
	 */
	private DBConnector db = new DBConnector();

	/**
	 * コネクション
	 */
	private Connection con = db.getConnection();

	/**
	 * 日付
	 */
	private UtilDate utilDate = new UtilDate();

	public void insertBuyItemInfo(String userLoginId,ArrayList<UserBuyItemDTO> userBuyItemDTOs) throws SQLException{

		for(int i=0;i<userBuyItemDTOs.size();i++){

			//購入情報の更新
			String sql = "insert into user_buy_item_transaction("
					+ "item_transaction_id,"
					+ "total_price,"
					+ "total_count,"
					+ "user_master_id,"
					+ "pay,"
					+ "insert_date) "
					+ "values(?,?,?,?,?,?)";

			//商品情報(在庫数)の更新
			String sql2 = "update item_info_transaction set item_stock = "
					+ "(select item_stock item_info_transaction where id = ?) - ?,"
					+ "updated_date = ? where id = ?";

			UserBuyItemDTO userBuyItemDTO = userBuyItemDTOs.get(i);

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,userBuyItemDTO.getBuyItemTransactionId());
				ps.setInt(2,userBuyItemDTO.getBuyItemTotalPrice());
				ps.setInt(3,userBuyItemDTO.getBuyItemCount());
				ps.setString(4,userLoginId);
				ps.setString(5,userBuyItemDTO.getBuyItemPay());
				ps.setString(6,utilDate.utilDate());
				ps.executeUpdate();

				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1,userBuyItemDTO.getBuyItemTransactionId());
				ps2.setString(2,utilDate.utilDate());
				ps2.setInt(3,userBuyItemDTO.getBuyItemTotalPrice());
				ps2.setInt(4,userBuyItemDTO.getBuyItemTransactionId());
				ps2.executeUpdate();

			}catch(Exception e){
				e.printStackTrace();
			}

		}

		con.close();
	}
}

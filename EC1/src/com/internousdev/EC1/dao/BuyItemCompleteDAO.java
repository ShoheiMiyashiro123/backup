package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.internousdev.EC1.dto.MyPageDTO;
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

	@SuppressWarnings("unchecked")
	public int insertBuyItemInfo(String userLoginId,List<MyPageDTO> myPageDTOs,Map<String,Object>session) throws SQLException{

		//更新の可能性
		int ret;

		//stockの取得
		List<Collection<Integer>> stock = (List<Collection<Integer>>)session.get("cart");

		//現在の在庫数の確認
		int flg = 1;
		for(int i=0;i<myPageDTOs.size();i++){

			MyPageDTO myPageDTO = myPageDTOs.get(i);
			String sqlStockConf = "select item_stock from item_info_transaction "
					+ "where id = ?;";
			try{

				PreparedStatement ps = con.prepareStatement(sqlStockConf);
				ps.setInt(1,myPageDTO.getId());
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					if(myPageDTO.getTotalCount()>rs.getInt("item_stock")){

						Collection<Integer> st = stock.get(i);
						for(int j=0;j<st.size();j++){
							st.set();
						}

						flg = 0;
					}
				}

			}catch(Exception e){

				e.printStackTrace();
			}

		}

		if(flg==1){
			//各商品の購入情報の登録
			update(userLoginId,myPageDTOs);
			ret = 1;
		}else{
			ret = 0;
		}

		con.close();

		return ret;
	}

	private void update(String userLoginId,List<MyPageDTO> myPageDTOs){

		//購入Idの付番
		int buyId = 1;
		String sqlBuyId = "select ifnull(MAX(buy_id)+1,1) as buy_id from user_buy_item_transaction;";
		try{
			PreparedStatement psBuyId = con.prepareStatement(sqlBuyId);
			ResultSet rs = psBuyId.executeQuery();
			while(rs.next())
				buyId = rs.getInt("buy_id");

		}catch(Exception e){
			e.printStackTrace();
		}

		for(int i=0;i<myPageDTOs.size();i++){

			//購入情報の登録
			String sql = "insert into user_buy_item_transaction("
					+ "buy_id,"
					+ "item_transaction_id,"
					+ "total_price,"
					+ "total_count,"
					+ "user_master_id,"
					+ "pay,"
					+ "insert_date) "
					+ "values(?,?,?,?,?,?,?)";

			//商品情報(在庫数)の更新
			String sql2 = "update item_info_transaction set item_stock = "
					+ "(select item_stock item_info_transaction where id = ?) - ?,"
					+ "updated_date = ? where id = ?";

			MyPageDTO myPageDTO = myPageDTOs.get(i);

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,buyId);
				ps.setInt(2,myPageDTO.getId());
				ps.setInt(3,myPageDTO.getTotalPrice());
				ps.setInt(4,myPageDTO.getTotalCount());
				ps.setString(5,userLoginId);
				ps.setString(6,myPageDTO.getPayment());
				ps.setString(7,utilDate.utilDate());
				ps.executeUpdate();

				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1,myPageDTO.getId());
				ps2.setInt(2,myPageDTO.getTotalCount());
				ps2.setString(3,utilDate.utilDate());
				ps2.setInt(4,myPageDTO.getId());
				ps2.executeUpdate();

			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}
}

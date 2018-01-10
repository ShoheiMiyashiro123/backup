package com.internousdev.login45.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.inernousdev.login45.dto.BuyItemDTO;
import com.internousdev.login45.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo(){
		String sql = "select id,item_name,item_price from item_info_transaction";

		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return buyItemDTO;
	}

	public BuyItemDTO getBuyItemDTO(){
		return buyItemDTO;
	}
}

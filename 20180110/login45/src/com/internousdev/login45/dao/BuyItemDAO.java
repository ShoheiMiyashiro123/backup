package com.internousdev.login45.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.inernousdev.login45.dto.BuyItemDTO;
import com.internousdev.login45.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private ArrayList<BuyItemDTO> buyItemDTOs = new ArrayList<BuyItemDTO>();
	//private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public ArrayList<BuyItemDTO> getBuyItemInfo(){

		String sql = "select id,item_name,item_price from item_info_transaction";

		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
				buyItemDTOs.add(buyItemDTO);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return buyItemDTOs;
	}

	public ArrayList<BuyItemDTO> getBuyItemDTOs(){
		return buyItemDTOs;
	}
}

package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.EC1.dto.BuyItemDTO;
import com.internousdev.EC1.util.DBConnector;

public class BuyItemDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public ArrayList<BuyItemDTO> buyItemInfo() throws SQLException{

		//System.out.println("test");

		ArrayList<BuyItemDTO> buyItemDTOs = null;

		String sql = "select * from item_info_transaction";
		PreparedStatement ps = con.prepareStatement(sql);

		try{
			ResultSet rs = ps.executeQuery();
			buyItemDTOs = new ArrayList<BuyItemDTO>();
			while(rs.next()){
				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setItemId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getInt("item_price"));
				buyItemDTO.setItemStock(rs.getInt("item_stock"));
				buyItemDTOs.add(buyItemDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return buyItemDTOs;
	}
}

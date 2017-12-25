package com.internousdev.login45.dao;

import java.sql.Connection;

import com.internousdev.login45.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private BuyItemDTO buyItemDTO = new buyItemDTO();

	public BuyItemDTO getBuyItemInfo(){
		String sql = "select * from item_info_transaction";

		try{
			PreaparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){

			}
		}
	}
}

package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.EC1.dto.SearchDTO;
import com.internousdev.EC1.util.DBConnector;

public class SearchDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public ArrayList<SearchDTO> itemInfo() throws SQLException{

		//ArrayList<SearchDTO> searchDTOs = null;
		ArrayList<SearchDTO> searchDTOs = new ArrayList<SearchDTO>();

		String sql = "select * from item_info_transaction";
		PreparedStatement ps = con.prepareStatement(sql);

		try{
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				SearchDTO searchDTO = new SearchDTO();
				//searchDTOs = new ArrayList<SearchDTO>();
				searchDTO.setItemId(rs.getInt("id"));
				searchDTO.setItemName(rs.getString("item_name"));
				searchDTO.setItemImage(rs.getString("item_image"));
				searchDTO.setItemPrice(rs.getInt("item_price"));
				searchDTO.setItemStock(rs.getInt("item_stock"));
				searchDTOs.add(searchDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return searchDTOs;
	}
}

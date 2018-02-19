package com.internousdev.EC1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.EC1.dto.MyPageDTO;
import com.internousdev.EC1.dto.SearchDTO;
import com.internousdev.EC1.util.DBConnector;

public class SearchDAO {
	private DBConnector db = new DBConnector();
	private Connection con;
	/*public ArrayList<SearchDTO> itemInfo() throws SQLException{
		return itemInfo("");
	}

	public ArrayList<SearchDTO> itemInfo(String keyword) throws SQLException{

		//keywordに対する入力の例外処理
		if(keyword == null)
			keyword = "";

		ArrayList<SearchDTO> searchDTOs = new ArrayList<SearchDTO>();

		try{

			String sql = "select * from item_info_transaction "
					+ "where item_name like '%"+keyword+"%';";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				SearchDTO searchDTO = new SearchDTO();
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
	}*/

	public <E> ArrayList<E> itemInfo(int itemId,String className) throws SQLException{

		con = db.getConnection();

		String sql = "select * from item_info_transaction "
				+ "where id = "+itemId+";";

		return itemInfoPrototype(sql,className);
	}

	public <E> ArrayList<E> itemInfo(String className) throws SQLException{

		con = db.getConnection();

		return itemInfo("",className);
	}

	public <E> ArrayList<E> itemInfo(String keyword,String className) throws SQLException{

		con = db.getConnection();

		//keywordに対する入力の例外処理
		if(keyword == null)
			keyword = "";

		String sql = "select * from item_info_transaction "
				+ "where item_name like '%"+keyword+"%';";

		return itemInfoPrototype(sql,className);
	}

	private <E> ArrayList<E> itemInfoPrototype(String sql, String className) throws SQLException{

		ArrayList<E> Es = new ArrayList<E>();

		try{

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				E dto = makeDTO(className,rs);
				Es.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return Es;
	}

	@SuppressWarnings("unchecked")
	public <E> E makeDTO(String className, ResultSet rs) throws SQLException{

		if(className.equals("MyPageDTO")){

			//クラス名が"MyPageDTO"であるときは
			//MyPageDTOクラスのインスタンスを生成し商品情報を格納
			MyPageDTO myPageDTO = new MyPageDTO();
			myPageDTO.setId(rs.getInt("id"));
			myPageDTO.setItemName(rs.getString("item_name"));

			return (E) myPageDTO;

		}else if(className.equals("SearchDTO")){

			//クラス名が"SearchDTO"であるときは
			//SearchDTOクラスのインスタンスを生成し商品情報を格納
			SearchDTO searchDTO = new SearchDTO();
			searchDTO.setItemId(rs.getInt("id"));
			searchDTO.setItemName(rs.getString("item_name"));
			searchDTO.setItemImage(rs.getString("item_image"));
			searchDTO.setItemPrice(rs.getInt("item_price"));
			searchDTO.setItemStock(rs.getInt("item_stock"));

			return (E) searchDTO;
		}else{

			return null;
		}
	}

}

package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.SearchDAO;
import com.internousdev.EC1.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	private static String nameSearchDTO = "SearchDTO";

	//商品のidまたはそれに付随するものを取得する
	private int itemId;

	//カート内からの商品の削除
	private int deleteFlg = 0;

	//リスト(商品情報)
	private ArrayList<SearchDTO> cart;

	//リスト(在庫数選択肢情報)
	private Collection<Collection<Integer>> stock;

	//エラーメッセージ
	private String errorMessage;

	public Map<String,Object> session;


	@SuppressWarnings("unchecked")
	public String execute() throws SQLException{

		//リストcartの取得または生成
		if(session.containsKey("cart")){

			cart = (ArrayList<SearchDTO>)session.get("cart");
		}else{

			cart = new ArrayList<SearchDTO>();
		}

		//リストstockの取得または生成
		if(session.containsKey("stock")){

			stock= (Collection<Collection<Integer>>)session.get("stock");
		}else{

			stock = new ArrayList<Collection<Integer>>();
		}

		//商品情報の追加又は削除
		int index = search(itemId,cart);

		switch(deleteFlg){
			case 0:
				if(index==-1) addInto();
				break;
			case 1:
				if(index!=-1) deleteFrom(index);
				break;
		}

		return SUCCESS;
	}

	public int search(int itemId,ArrayList<SearchDTO> array){

		//"array"からitemIdが"itemId"である要素のインデックスの取得
		int index = array.size()-1;
		while(index>=0){
			if(itemId==array.get(index).getItemId()){
				break;
			}
			index--;
		}

		return index;
	}

	private void addInto() throws SQLException{

		//idがitemIdであるような商品情報を検索
		SearchDAO searchDAO = new SearchDAO();
		ArrayList<SearchDTO> searchDTOs = searchDAO.itemInfo(itemId,nameSearchDTO);

		if(searchDTOs.size()!=0){

			//商品情報が存在するときにcart及びstockにその情報を追加
			SearchDTO searchDTO = searchDTOs.get(0);
			cart.add(searchDTO);
			stock.add(serial(searchDTO.getItemStock()));
		}else{

			//商品がない場合はerrorMessageを取得
			this.setErrorMessage("商品がありません。");
		}

		//sessionのキー"cart"の値を更新
		session.put("cart", cart);
		session.put("stock",stock);

	}

	private Collection<Integer> serial(int max){

		Collection<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=max;i++){list.add(i);}
		return list;
	}

	private void deleteFrom(int index){

		//idがitemIdであるような商品情報をcartから削除
		cart.remove(index);

		//idがitemidであるような在庫情報をstockから削除
		stock.remove(index);

		//sessionのキー"cart"の値を更新
		session.put("cart", cart);

		//sessionのキー"stock"の値を更新
		session.put("stock",stock);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public ArrayList<SearchDTO> getCart() {
		return cart;
	}


	public void setCart(ArrayList<SearchDTO> cart) {
		this.cart = cart;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Collection<Collection<Integer>> getStock() {
		return stock;
	}

	public void setStock(Collection<Collection<Integer>> stock) {
		this.stock = stock;
	}
}

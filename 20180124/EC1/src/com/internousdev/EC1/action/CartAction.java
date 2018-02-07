package com.internousdev.EC1.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	//商品のidまたはそれに付随するものを取得する
	private int itemId;

	private ArrayList<SearchDTO> cart;

	public Map<String,Object> session;


	public String execute(){

		//リストcartの取得または生成
		if(/*session内にカートに入れるべきもののリストのキーが存在する。*/){
			cart = (ArrayList<SearchDTO>)session.get(/*ここにカートに入れるべきものを入れたリストのキー値を入れる。*/);
		}else{
			cart = new ArrayList<SearchDTO>();
		}

		//既取得フラグ
		boolean gotten=false;
		for(int i=0;i<cart.size();i++){
			SearchDTO content = cart.get(i);
			if(itemId==content.getItemId()){
				gotten = true;
				break;
			}
		}
		//idがitemIdであるような商品をcartに追加
		if(!gotten){
			ArrayList<SearchDTO> searchDTOs = (ArrayList<SearchDTO>)session.get(/*ここにすべての商品のリストのキー値を入れる*/);
			int size = searchDTOs.size();
			for(int i=0;i<size;i++){
				SearchDTO searchDTO = searchDTOs.get(i);
				if(itemId==searchDTO.getItemId()){
					cart.add(searchDTO);
					break;
				}
			}
		}
		return SUCCESS;
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
}

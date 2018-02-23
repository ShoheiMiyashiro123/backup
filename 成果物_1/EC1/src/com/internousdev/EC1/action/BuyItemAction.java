package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.SearchDAO;
import com.internousdev.EC1.dto.SearchDTO;
import com.internousdev.EC1.util.IlegalCheck;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private static String nameSearchDTO = "SearchDTO";

	/**
	 * 一時保存情報を格納
	 */
	private Map<String,Object> session;

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException{

		//ログアウト後、ブラウザの"戻る"ボタンで
		//戻ってログイン状態のみでできることをできないようにする。
		if(IlegalCheck.ilegalCheck(session) == 0){
			return "ilegal";
		}

		List<SearchDTO> cart = (List<SearchDTO>)session.get("cart");

		//"cart"オブジェクトが取得できないときは"商品一覧"に戻る。
		//商品購入後ブラウザの"戻る"ボタンで"buyItem.jsp"に戻って
		//再度"確認"ボタンを押す場合のエラー対策。
		if(cart==null||cart.size()==0){

			session.put("searchDTOs", (new SearchDAO()).itemInfo(nameSearchDTO));
			return ERROR;
		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}

package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.BuyItemCompleteDAO;
import com.internousdev.EC1.dao.SearchDAO;
import com.internousdev.EC1.dto.LoginDTO;
import com.internousdev.EC1.dto.MyPageDTO;
import com.internousdev.EC1.util.IlegalCheck;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware{

	private static String nameSearchDTO = "SearchDTO";

	/**
	 * エラーメッセージ
	 */
	private String errorMessage;

	/**
	 * 各購入に対する各購入商品の購入情報
	 */
	private List<Object> searchDTOs;

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

		String userLoginId = ((LoginDTO)session.get("loginUser")).getLoginId();
		List<MyPageDTO> buyInfo = (List<MyPageDTO>) session.get("buyInfo");

		try{

			//購入情報のデータベースへの登録
			BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
			int flg = buyItemCompleteDAO.insertBuyItemInfo(userLoginId,buyInfo,session);


			if(flg==0){

				//"session"に登録された購入情報を削除
				session.remove("cart");
				session.remove("stock");
				session.remove("buyInfo");

				return SUCCESS;
			}else{

				//商品をカートに入れてから商品の在庫数が減って
				//ユーザの希望する数量の商品が購入できない場合、
				//データベースの更新は行われずあらためて購入数量を
				//決定する。
				errorMessage = "在庫が不足しています。";
				return "lack";
			}

		}catch(Exception e){

			e.printStackTrace();

			//最新の全商品情報を検索
			session.put("searchDTOs", (new SearchDAO()).itemInfo(nameSearchDTO));

			return ERROR;
		}
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<Object> getSearchDTOs() {
		return searchDTOs;
	}

	public void setSearchDTOs(List<Object> searchDTOs) {
		this.searchDTOs = searchDTOs;
	}

}

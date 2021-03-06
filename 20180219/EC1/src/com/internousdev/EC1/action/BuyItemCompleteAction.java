package com.internousdev.EC1.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.BuyItemCompleteDAO;
import com.internousdev.EC1.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware{

	private String errorMessage;

	public Map<String,Object> session;

	@SuppressWarnings("unchecked")
	public String execute(){

		String userLoginId = session.get("login_user_id").toString();
		List<MyPageDTO> buyInfo = (List<MyPageDTO>) session.get("buyInfo");

		try{

			BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
			int flg = buyItemCompleteDAO.insertBuyItemInfo(userLoginId,buyInfo,session);
			if(flg==0){
				session.remove("cart");
				session.remove("stock");
				session.remove("buyInfo");

				return SUCCESS;
			}else{

				errorMessage = "在庫が不足しています。";
				return "lack";
			}

		}catch(Exception e){

			e.printStackTrace();

			return ERROR;
		}
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}



	public String getErrorMessage() {
		return errorMessage;
	}



	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}

package com.internousdev.EC1.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.BuyItemCompleteDAO;
import com.internousdev.EC1.dto.UserBuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware{

	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public Map<String,Object> session;

	@SuppressWarnings("unchecked")
	public String execute(){

		String userLoginId = session.get("login_user_id").toString();
		ArrayList<UserBuyItemDTO> userBuyItemDTOs = (ArrayList<UserBuyItemDTO>) session.get("user_buyItem");

		try{
			buyItemCompleteDAO.insertBuyItemInfo(userLoginId,userBuyItemDTOs);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}

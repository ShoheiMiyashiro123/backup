package com.internousdev.EC1;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;

	public String execute(){

		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

		try{

			buyItemCompleteDAO.insertBuyItemInfo();
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

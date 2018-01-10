package com.internousdev.login45.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.login45.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	public String execute() throws SQLException{

		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
		buyItemCompleteDAO.buyItemSave(
				(int)session.get("id"),
				(int)session.get("total_price"),
				(int)session.get("stock"),
				(String)session.get("login_user_id"),
				(String)session.get("pay")
				);

		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}

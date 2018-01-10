package com.internousdev.login45.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.login45.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;


	public String execute() throws SQLException{
		String ret = ERROR;
		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

		int i = userCreateCompleteDAO.insertInfo((String)session.get("login_user_id"), (String)session.get("login_password"), (String)session.get("user_name"));
		System.out.println(i+"件のユーザを新規登録しました。");

		if(i>0){
			ret = SUCCESS;
		}

		return ret;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

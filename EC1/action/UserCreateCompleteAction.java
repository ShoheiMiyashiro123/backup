package com.internousdev.EC1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	public String execute(){
		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
		try{
			userCreateCompleteDAO.insertUserInfo(
					session.get("login_user_id").toString(),
					session.get("user_name").toString(),
					session.get("login_password").toString()
					);

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

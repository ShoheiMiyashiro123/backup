package com.internousdev.EC1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;

	private String userName;

	private String loginPassword;

	private String errorMassage;

	public Map<String,Object> session;

	public String execute(){
		int test = loginUserId.length()*userName.length()*loginPassword.length();
		if(test>0){
			session.put("login_user_id", loginUserId);
			session.put("user_name", userName);
			session.put("login_password", loginPassword);

			return SUCCESS;
		}else{
			errorMassage = "すべて入力したうえで'登録'ボタンを押してください。";

			return ERROR;
		}
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}

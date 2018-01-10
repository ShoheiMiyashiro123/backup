package com.internousdev.login45.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/*public class UserCreateConfirmAction extends ActionSupport{
	public UserCreateConfirmAction(){
		super();
	}

	public String execute(){
		return SUCCESS;
	}
}*/

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String userName;
	//空な文字列で初期化すべきか？
	private String errorMessage;


	public Map<String,Object> session;

	public UserCreateConfirmAction(){
		super();
	}

	public String execute(){

		String ret = SUCCESS;

		/*session.put("login_user_id", loginUserId);
		session.put("login_password", loginPassword);
		session.put("user_name", userName);

		if(loginUserId.equals("")||loginPassword.equals("")||userName.equals("") ){
			errorMessage = "空欄の項目があります。";
			ret = ERROR;
		}*/

		if(loginUserId.equals("")||loginPassword.equals("")||userName.equals("") ){
			errorMessage = "空欄の項目があります。";
			ret = ERROR;
		}else{
			session.put("login_user_id", loginUserId);
			session.put("login_password", loginPassword);
			session.put("user_name", userName);
		}

		//session.put("error_message",errorMessage);

		return ret;

	}



	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String,Object> getSession() {
		return session;
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

package com.internousdev.EC1.dto;

public class LoginDTO {

	/**
	 * ログインId
	 */
	private String loginId;

	/**
	 * ログインパスワード
	 */
	private String loginPassword;

	/**
	 * ユーザ名
	 */
	private String userName;

	/**
	 * ログインフラグ(データベースにユーザデータが存在するときはTrueに切り替える。)
	 */
	private boolean loginFlg = false;


	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


}

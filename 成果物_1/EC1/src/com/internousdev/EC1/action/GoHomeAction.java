package com.internousdev.EC1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware{

	/**
	 * 一時保存情報を格納
	 */
	private Map<String,Object> session;

	public String execute(){

		session.remove("loginUser");

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;

	}

	public Map<String, Object> getSession() {
		return session;
	}

}

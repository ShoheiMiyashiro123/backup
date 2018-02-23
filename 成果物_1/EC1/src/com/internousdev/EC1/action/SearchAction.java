package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.SearchDAO;
import com.internousdev.EC1.util.IlegalCheck;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware{

	private static String nameSearchDTO = "SearchDTO";

	/**
	 * 検索キーワード
	 */
	private String keyword;

	/**
	 * 一時保存情報を格納
	 */
	private Map<String,Object> session;


	public String execute() throws SQLException{

		//ログアウト後、ブラウザの"戻る"ボタンで
		//戻ってログイン状態のみでできることをできないようにする。
		if(IlegalCheck.ilegalCheck(session) == 0){
			return "ilegal";
		}

		//最新の全商品情報を検索
		session.put("searchDTOs", (new SearchDAO()).itemInfo(keyword,nameSearchDTO));

		return SUCCESS;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public Map<String, Object> getSession() {
		return session;
	}

}

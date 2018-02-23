package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.LoginDAO;
import com.internousdev.EC1.dao.SearchDAO;
import com.internousdev.EC1.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private static String nameSearchDTO = "SearchDTO";


	/**
	 * ログインID
	 */
	private String loginUserId;

	/**
	 * ログインパスワード
	 */
	private String loginPassword;

	/**
	 * 一時保存情報を格納
	 */
	private Map<String,Object> session;

	public String execute() throws SQLException{

		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);

		/**
		 * ログインユーザ情報が格納されたインスタンスを
		 * そのままsession変数で参照する。
		 * (キー値：loginUser)
		 */
		session.put("loginUser",loginDTO);

		/**
		 * loginDTOにデータベースに入力情報を持つレコードが
		 * 登録されている場合に立つフラグ変数loginFlgが
		 * 存在しているのでその値(True or False)に応じて
		 * 処理が分岐するようにする。
		 */
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){

			//最新の全商品情報を検索
			session.put("searchDTOs", (new SearchDAO()).itemInfo(nameSearchDTO));

			return SUCCESS;
		}else{

			return ERROR;
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
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

}

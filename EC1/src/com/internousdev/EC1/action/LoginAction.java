package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.LoginDAO;
import com.internousdev.EC1.dao.SearchDAO;
import com.internousdev.EC1.dto.LoginDTO;
import com.internousdev.EC1.dto.SearchDTO;
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
	 * ログイン情報を格納
	 */
	public Map<String,Object> session;

	/**
	 * すべての商品の格納
	 */
	private ArrayList<SearchDTO> searchDTOs;

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
		if(
				((LoginDTO)session.get("loginUser")).getLoginFlg()
				){
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("login_password",loginDTO.getLoginPassword());


			SearchDAO searchDAO = new SearchDAO();
			searchDTOs = searchDAO.itemInfo(nameSearchDTO);

			return SUCCESS;
		}else{
			return ERROR;
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	/*public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}*/

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public ArrayList<SearchDTO> getSearchDTOs(){
		return searchDTOs;
	}

	public void setSearchDTOs(ArrayList<SearchDTO> searchDTOs){
		this.searchDTOs = searchDTOs;
	}

}

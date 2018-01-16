package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.BuyItemDAO;
import com.internousdev.EC1.dao.LoginDAO;
import com.internousdev.EC1.dto.BuyItemDTO;
import com.internousdev.EC1.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * ログインID
	 */
	private String loginUserId;

	/**
	 * ユーザ名
	 */
	//private String userName;

	/**
	 * ログインパスワード
	 */
	private String loginPassword;

	/**
	 * ログイン情報を格納
	 */
	public Map<String,Object> session;

	public String execute() throws SQLException{

		System.out.println(loginUserId+", "+loginPassword);
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
				//loginDTO.getLoginUserId().equals(loginUserId)&&loginDTO.getLoginPassword().equals(loginPassword)
				((LoginDTO)session.get("loginUser")).getLoginFlg()
				){
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("login_password",loginDTO.getLoginPassword());

			BuyItemDAO buyItemDAO = new BuyItemDAO();
			ArrayList<BuyItemDTO> buyItemDTOs = buyItemDAO.buyItemInfo();
			BuyItemDTO buyItemDTO = buyItemDTOs.get(0);

			session.put("id",buyItemDTO.getItemId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
			session.put("buyItem_stock",buyItemDTO.getItemStock());

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

}

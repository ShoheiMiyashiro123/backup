package com.internousdev.EC1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.LoginDAO;
import com.internousdev.EC1.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * ログインID
	 * */
	private String loginUserId;
	//private String userName;

	/**
	 * ログインパスワード
	 */
	private String loginPassword;

	/**
	 * ログイン情報を格納
	 */
	public Map<String,Object> session;

	public String execute(){
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

			//BuyItemDAO buyItemDAO = new BuyItemDAO();
			//BuyItemDTO buyItemDTO = buyItemDAO.buyItemInfo();

			/*session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getBuyItemName());
			session.put("buyItem_price",buyItemDTO.getBuyItemPrice());*/
			//session.put("buyItem_",buyItemDTO.getBuyItemStock());

			return SUCCESS;
		}else{
			return ERROR;
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getLoginId() {
		return loginUserId;
	}

	public void setLoginId(String loginUserId) {
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

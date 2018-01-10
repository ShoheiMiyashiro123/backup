package com.internousdev.login45.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.inernousdev.login45.dto.LoginDTO;
import com.internousdev.login45.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String result;
	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute(){
		result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);

		session.put("loginUser",loginDTO);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;

			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			//上の定義でユーザをどのように特定するか？
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",loginDTO.getItemName());
			session.put("buyItem_price",loginDTO.getItemPrice());

			return result;
		}

		return result;
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

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
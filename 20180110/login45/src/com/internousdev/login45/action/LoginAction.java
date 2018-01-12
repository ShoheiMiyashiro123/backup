package com.internousdev.login45.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.inernousdev.login45.dto.BuyItemDTO;
import com.inernousdev.login45.dto.LoginDTO;
import com.internousdev.login45.dao.BuyItemDAO;
import com.internousdev.login45.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	private String result;
	//public ArrayList<Map<String,Object>> sessions;
	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private ArrayList<BuyItemDTO> buyItemDTOs;

	public String execute(){

		result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);

		session.put("loginUser",loginDTO);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;

			//System.out.println(result);

			buyItemDTOs = buyItemDAO.getBuyItemInfo();
			System.out.println(buyItemDTOs.size()+", "+buyItemDTOs.get(0).getId());
			//上の定義でユーザをどのように特定するか？
			/*for(int i=0;i<buyItemDTOs.size();i++){
				BuyItemDTO buyItemDTO = buyItemDTOs.get(i);
				session.put("login_user_id",loginDTO.getLoginId());
				session.put("id",buyItemDTO.getId());
				session.put("buyItem_name",buyItemDTO.getItemName());
				session.put("buyItem_price",buyItemDTO.getItemPrice());
			}*/

			Iterator<BuyItemDTO> iterator = buyItemDTOs.iterator();
			if(!(iterator.hasNext())){
				buyItemDTOs = null;
			}

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

	/*public Map<String, Object> getSession(){
		return session;
	}*/

	public ArrayList<BuyItemDTO> getBuyItemDTOs(){
		return buyItemDTOs;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}

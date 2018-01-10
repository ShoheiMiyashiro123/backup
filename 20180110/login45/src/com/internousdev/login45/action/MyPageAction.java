package com.internousdev.login45.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.inernousdev.login45.dto.MyPageDTO;
import com.internousdev.login45.dao.MyPageDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	//private String message;
	private int deleteFlg = 0;

	ArrayList<MyPageDTO> myPageDTOs;

	public String execute() throws SQLException{

		if(deleteFlg==0){
			int item_transaction_id = Integer.parseInt(session.get("id").toString());
			String user_master_id = session.get("login_user_id").toString();

			MyPageDAO myPageDAO = new MyPageDAO();
			myPageDTOs = myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);

			System.out.println("ここまで実行済み");

			/*session.put("total_price",myPageDTO.getTotalPrice());
			session.put("total_count",myPageDTO.getTotalCount());
			session.put("total_payment",myPageDTO.getPayment());
			session.put("message","");*/

			Iterator<MyPageDTO> iterator = myPageDTOs.iterator();
			if(!(iterator.hasNext())){
				myPageDTOs = null;
			}

		}else if(deleteFlg==1){
			//delete();
		}

		return SUCCESS;
	}


	public int getDeleteFlg() {
		return deleteFlg;
	}


	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}

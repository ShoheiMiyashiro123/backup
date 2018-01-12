package com.internousdev.login45.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.inernousdev.login45.dto.MyPageDTO;
import com.internousdev.login45.dao.DeleteDAO;
import com.internousdev.login45.dao.MyPageDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private String message = null;
	private int deleteFlg = 0;

	public ArrayList<MyPageDTO> myPageDTOs;

	public String execute() throws SQLException{

		if(deleteFlg==0){
			int item_transaction_id = Integer.parseInt(session.get("id").toString());
			String user_master_id = session.get("login_user_id").toString();

			System.out.println(item_transaction_id+", "+user_master_id);

			MyPageDAO myPageDAO = new MyPageDAO();
			myPageDTOs = myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);

			//System.out.println("ここまで実行済み "+myPageDTOs.size());

			/*for(int i=0;i<myPageDTOs.size();i++){
				MyPageDTO mP = myPageDTOs.get(i);
				System.out.println(mP.getId()+","+
						mP.getItemName()+mP.getPayment()+mP.getUserName()+mP.getTotalCount()+mP.getTotalPrice());
			}*/

			//System.out.println(myPageDTOs);

			Iterator<MyPageDTO> iterator = myPageDTOs.iterator();
			System.out.println(iterator.hasNext());
			if(!(iterator.hasNext())){
				myPageDTOs = null;
			}

		}else if(deleteFlg==1){
			delete();
		}

		return SUCCESS;
	}

	public String delete() throws SQLException{
		DeleteDAO deleteDAO = new DeleteDAO();
		int i = deleteDAO.deleteInfo(session.get("login_user_id").toString());
		switch(i){
			case 0:
				message="購入履歴がありません";
				break;
			default:
				message=i+"件消去されました";
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

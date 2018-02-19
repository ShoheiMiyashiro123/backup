package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.DeleteDAO;
import com.internousdev.EC1.dao.MyPageDAO;
import com.internousdev.EC1.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	//一時情報の保存場所
	public Map<String,Object> session;

	//購入履歴取得用のDAOクラスのインスタンス
	private MyPageDAO myPageDAO = new MyPageDAO();

	//購入履歴情報格納用のDTOクラス
	private List<List<MyPageDTO>> myPageDTOs;

	//メッセージ
	private String message;

	//削除フラグ(データ削除処理の実行をする)
	private String deleteFlg;

	public String execute() throws NumberFormatException, SQLException{

		//int id = Integer.parseInt(session.get("id").toString());
		String loginUserId = session.get("login_user_id").toString();

		if(deleteFlg==null){
			myPageDTOs = myPageDAO.getMyPageUserInfo(loginUserId);

			Iterator<List<MyPageDTO>> iterator = myPageDTOs.iterator();
			if(!(iterator.hasNext())){
				myPageDTOs = null;
			}
		}else if(deleteFlg.equals("1")){
			delete(loginUserId);
		}

		return SUCCESS;
	}

	public void delete(String loginUserId) throws SQLException{
		DeleteDAO deleteDAO = new DeleteDAO();
		int i = deleteDAO.delete(loginUserId);

		if(i>0){
			message = loginUserId+"さんの購入履歴を削除しました。";
		}else{
			message = "削除すべき履歴がありません。";
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<List<MyPageDTO>> getMyPageDTOs(){
		return myPageDTOs;
	}

	public void setMyPageDTOs(List<List<MyPageDTO>> myPageDTOs){
		this.myPageDTOs = myPageDTOs;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}


}

package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.DeleteDAO;
import com.internousdev.EC1.dao.MyPageDAO;
import com.internousdev.EC1.dto.LoginDTO;
import com.internousdev.EC1.dto.MyPageDTO;
import com.internousdev.EC1.util.IlegalCheck;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	//一時情報の保存場所
	private Map<String,Object> session;

	//購入履歴取得用のDAOクラスのインスタンス
	private MyPageDAO myPageDAO = new MyPageDAO();

	//購入履歴情報格納用のDTOクラス
	private List<List<MyPageDTO>> myPageDTOs;

	//メッセージ
	private String message;

	//削除フラグ(データ削除処理の実行をする)
	private String deleteFlg;

	public String execute() throws NumberFormatException, SQLException{

		//ログアウト後、ブラウザの"戻る"ボタンで
		//戻ってログイン状態のみでできることをできないようにする。
		if(IlegalCheck.ilegalCheck(session) == 0){
			return "ilegal";
		}

		String loginUserId = ((LoginDTO)session.get("loginUser")).getLoginId();


		if(deleteFlg==null){

			//過去の購入情報の履歴を取得
			myPageDTOs = myPageDAO.getMyPageUserInfo(loginUserId);

			//購入情報の履歴がない場合、
			//"myPageDTOs"の値をnullに入れ替える。
			Iterator<List<MyPageDTO>> iterator = myPageDTOs.iterator();
			if(!(iterator.hasNext())){
				myPageDTOs = null;
			}
		}else if(deleteFlg.equals("1")){

			//過去の購入情報の履歴を削除する。
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

	public Map<String, Object> getSession() {
		return session;
	}

}

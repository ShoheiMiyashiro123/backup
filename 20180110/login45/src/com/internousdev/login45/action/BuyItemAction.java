package com.internousdev.login45.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {
	private int stock;
	private int pay;

	public Map<String,Object> session;

	public String execute(){
		String[] payTerm= {"現金払い","クレジットカード"};

		session.put("stock", stock);
		session.put("pay", payTerm[pay-1]);

		//System.out.println(session.get("buyItem_price").getClass());
		System.out.println(session.get("buyItem_price"));
		int price = Integer.parseInt(session.get("buyItem_price").toString());

		session.put("total_price", price * stock);

		return SUCCESS;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

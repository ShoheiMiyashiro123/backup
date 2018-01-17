package com.internousdev.EC1.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	/**
	 * 購入数量
	 */
	private int stock;

	/**
	 * 支払方法
	 */
	private int pay;

	/**
	 * 購入情報
	 */
	public Map<String,Object> session;

	public String execute(){
		ArrayList<String> payment = new ArrayList<String>();

		payment.add("現金払い");
		payment.add("クレジットカード");

		int totalPrice = Integer.parseInt(session.get("buyItem_price").toString()) * stock;
		session.put("buyItem_totalPrice", totalPrice);
		session.put("buyItem_count",stock);
		session.put("buyItem_pay", payment.get(pay - 1));

		return SUCCESS;
	}

	public int getStock(){
		return stock;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public int getPay(){
		return pay;
	}

	public void setPay(int pay){
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
}



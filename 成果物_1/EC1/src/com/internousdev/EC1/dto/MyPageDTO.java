package com.internousdev.EC1.dto;

import java.util.Date;

public class MyPageDTO {

	/**
	 * 商品Id
	 */
	private int id;

	/**
	 * 購入Id
	 */
	private int buyId;

	/**
	 * 購入額
	 */
	private int totalPrice;

	/**
	 * 購入量
	 */
	private int totalCount;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * 支払方法
	 */
	private String payment;

	/**
	 * 購入日
	 */
	private Date insertDate;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public int getBuyId() {
		return buyId;
	}

	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}

}

package com.internousdev.EC1.dto;

public class UserBuyItemDTO {

	/**
	 * 商品ID
	 */
	private int buyItemTransactionId;

	/**
	 * 商品総価格
	 */
	private int buyItemTotalPrice;

	/**
	 * 商品総量
	 */
	private int buyItemCount;

	/**
	 * 商品支払区分
	 */
	private String buyItemPay;

	public int getBuyItemTransactionId() {
		return buyItemTransactionId;
	}

	public void setBuyItemTransactionId(int buyItemTransactionId) {
		this.buyItemTransactionId = buyItemTransactionId;
	}

	public int getBuyItemTotalPrice() {
		return buyItemTotalPrice;
	}

	public void setBuyItemTotalPrice(int buyItemTotalPrice) {
		this.buyItemTotalPrice = buyItemTotalPrice;
	}

	public int getBuyItemCount() {
		return buyItemCount;
	}

	public void setBuyItemCount(int buyItemCount) {
		this.buyItemCount = buyItemCount;
	}

	public String getBuyItemPay() {
		return buyItemPay;
	}

	public void setBuyItemPay(String buyItemPay) {
		this.buyItemPay = buyItemPay;
	}

}

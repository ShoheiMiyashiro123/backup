package com.internousdev.EC1.dto;

public class SearchDTO {

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * 商品画像URL
	 */
	private String itemImage;

	/**
	 * 商品価格
	 */
	private int itemPrice;

	/**
	 * 商品在庫数
	 */
	private int itemStock;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemImage(){
		return itemImage;
	}

	public void setItemImage(String itemImage){
		this.itemImage = itemImage;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

}

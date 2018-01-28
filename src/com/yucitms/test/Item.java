package com.yucitms.test;

public class Item implements java.io.Serializable {
	private int itemId;	
	private String item;	

	public Item() {}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
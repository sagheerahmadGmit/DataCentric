package com.shops;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StoreProducts {
	
	//variables
	int storeId;
	String storeName;
	String founded;
	int prodId;
	String prodName;
	double price;

	//getters and setters
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getFounded() {
		return founded;
	}
	public void setFounded(String founded) {
		this.founded = founded;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}

package com.shops;

//imports
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean @SessionScoped
public class Store {
	
	//Variables
	int storeId;
	String name;
	String founded;
	
	//Getters and setters
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String storeName) {
		this.name = storeName;
	}
	public String getFounded() {
		return founded;
	}
	public void setFounded(String founded) {
		this.founded = founded;
	}
}

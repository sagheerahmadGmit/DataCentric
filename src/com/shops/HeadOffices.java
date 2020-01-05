package com.shops;

//imports
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean @SessionScoped
public class HeadOffices {

	//Variables
	int storeId;
	String location;
	
	//getters and setters
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}

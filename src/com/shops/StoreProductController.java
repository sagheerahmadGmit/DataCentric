package com.shops;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.CommunicationsException;

@ManagedBean @SessionScoped
public class StoreProductController {
	
	//variables
	DAO dao;
	ArrayList<StoreProducts> storeProducts;
	ArrayList<StoreProducts> storeProducts2;
	
	//constructor
	public StoreProductController() {
		super();
		System.out.println("In Product Controller!");
		
		try { 
			dao = new DAO(); 
		}catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}
	
	//get the store products 
	public String loadStoreProduct(int sid) {
		
		System.out.println("In LoadStoreProduct!");

		try {
			storeProducts = dao.loadStoreProducts(sid);
		} catch (CommunicationsException e){
			FacesMessage message = new FacesMessage("Error: Mongo Database Offline!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		return "showStoreProducts.xhtml";

	}
	
	public String loadStoreProduct() {
		
		System.out.println("In LoadStoreProduct!");

		try {
			storeProducts2 = storeProducts;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "showStoreProducts.xhtml";

	}

	public ArrayList<StoreProducts> getStoreProducts() {
		return storeProducts2;
	}


}

package com.shops;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean @SessionScoped
public class StoreProductController {
	
	DAO dao;
	ArrayList<StoreProducts> storeProducts;
	ArrayList<StoreProducts> storeProducts2;
	
	public StoreProductController() {
		super();
		System.out.println("In Product Controller!");
		
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String loadStoreProduct(int sid) {
		
		System.out.println("In LoadStoreProduct!");

		try {
			storeProducts = dao.loadStoreProducts(sid);
		} catch (Exception e) {
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

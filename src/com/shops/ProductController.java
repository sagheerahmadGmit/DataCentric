package com.shops;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.CommunicationsException;
import com.shops.DAO;
import com.shops.Product;

@ManagedBean @SessionScoped
public class ProductController {
	
	//variables
	DAO dao;
	ArrayList<Product> products;
	
	//constructor
	public ProductController() {
		super();
		System.out.println("In Product Controller!");
		
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	//Load the products
	public String loadProducts() {
		
		System.out.println("In LoadProduct");
		
		try {
			products = dao.loadProducts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	//Delete a product
	public void delete(int pid) {
		
		System.out.println(pid);
		
		try {
			dao.deleteProduct(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

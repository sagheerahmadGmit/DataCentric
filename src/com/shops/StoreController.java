package com.shops;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.CommunicationsException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sun.jmx.snmp.daemon.CommunicationException;
import com.shops.Store;

@ManagedBean @SessionScoped
public class StoreController {

	//variables
	DAO dao;
	ArrayList<Store> stores;
	ArrayList<Product> products;

	//constructor
	public StoreController() {
		super();
		System.out.println("In Store Controller!");

		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Store> getStores() {
		return stores;
	}

	//Load all the stores 
	public String loadStores() {

		System.out.println("In LoadStores");

		try {
			stores = dao.loadStores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	//Add a store to  mysql
	public String addStore(Store store) {
		System.out.println(store.getName()); 
		try { 
			dao.addStore(store); 
		} catch(SQLIntegrityConstraintViolationException e) {
			//error handling
			System.out.println("Already Exists!");
			FacesMessage message = new FacesMessage("Error: Store already exists!");
			FacesContext.getCurrentInstance().addMessage(null, message); return null; 
		}catch (CommunicationsException e){ 
			FacesMessage message = new FacesMessage("Error: Database Offline!");
			FacesContext.getCurrentInstance().addMessage(null, message); return null;
		}catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}

		return "list_stores";
	}

	//Delete a store
	public void delete(int sid, String sName) {

		System.out.println(sid);
		try {
			dao.delete(sid);
		} catch (SQLException e) {
			//error handling
			FacesMessage message = 
					new FacesMessage("Error: Store " + sName + " has not been deleted from MYSQL DB, it contains Products.");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}

	}

}

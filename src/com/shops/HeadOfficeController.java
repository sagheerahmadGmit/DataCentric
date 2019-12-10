package com.shops;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean @SessionScoped
public class HeadOfficeController {
	
	MongoDAO mdao;
	ArrayList<HeadOffices> offices;
	
	public HeadOfficeController() {
		super();
		try {
			mdao = new MongoDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HeadOffices> getOffices() {
		return offices;
	}
	
	public ArrayList<HeadOffices> loadOffices() {
		if(mdao != null) {
			try {
				offices = mdao.loadOffices();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return offices;
	}

}

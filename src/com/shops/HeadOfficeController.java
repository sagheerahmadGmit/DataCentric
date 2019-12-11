package com.shops;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	
	public String addOffices(HeadOffices headOffice){

		try {
			mdao.addOffices(headOffice);	
			return "list_offices";
		}catch(Exception e){
			System.out.println("Already Exists!");
			FacesMessage message = new FacesMessage("Error: Store already exists!");
			FacesContext.getCurrentInstance().addMessage(null, message); 
		}
		
		return null;

	}

}

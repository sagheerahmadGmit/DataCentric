package com.shops;

//imports
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean @SessionScoped
public class HeadOfficeController {
	
	//variables
	MongoDAO mdao;
	ArrayList<HeadOffices> offices;
	
	//constructor
	public HeadOfficeController() {
		super();
		try {
			mdao = new MongoDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//Get offices
	public ArrayList<HeadOffices> getOffices() {
		return offices;
	}
	
	//return the offices if mdao is not empty
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
	
	//Add an office to the Mongo DB
	public String addOffices(HeadOffices headOffice){

		try {
			mdao.addOffices(headOffice);	
			return "list_offices";
		}catch(Exception e){
			//error Handling
			System.out.println("Already Exists!");
			FacesMessage message = new FacesMessage("Error: Store already exists!");
			FacesContext.getCurrentInstance().addMessage(null, message); 
		}
		
		return null;

	}

}

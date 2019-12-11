package com.shops;

import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDAO {
	
	String mongoDB = "storeHeadOfficeDB";
	String mongoCollection = "storeHeadOffice";
	
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public MongoDAO() throws Exception {
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase(mongoDB);
		collection = database.getCollection(mongoCollection);
	}
	
	public ArrayList<HeadOffices> loadOffices() throws Exception{

		ArrayList<HeadOffices> headList = new ArrayList<HeadOffices>();
		FindIterable<Document> offices = collection.find();

		for(Document docs:offices){
			HeadOffices o = new HeadOffices();
			o.setStoreId((int)(docs.get("_id")));
			o.setLocation((String)docs.get("location"));
			
			headList.add(o);
		}		
		//mongoClient.close();
		return headList;
	}
	
	public void addOffices(HeadOffices headOffice) {
		Document doc = new Document(); // the document that will be added.
		doc.append("_id", headOffice.getStoreId());
		doc.append("location", headOffice.getLocation());
		collection.insertOne(doc);

	}
	
}

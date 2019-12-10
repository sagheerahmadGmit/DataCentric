package com.shops;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shops.Product;
import com.shops.Store;

public class DAO {

	private DataSource mysqlDS;


	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/shops";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public ArrayList<Store> loadStores() throws Exception {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		myConn = mysqlDS.getConnection();

		String sql = "select * from store";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		ArrayList<Store> stores = new ArrayList<Store>();

		// process result set
		while (myRs.next()) {
			Store s = new Store();
			s.setStoreId(myRs.getInt("id"));
			s.setName(myRs.getString("name"));
			s.setFounded(myRs.getString("founded"));
			stores.add(s);
		}

		return stores;

	}

	public ArrayList<Product> loadProducts() throws Exception {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		myConn = mysqlDS.getConnection();

		String sql = "select * from product";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		ArrayList<Product> products = new ArrayList<Product>();

		// process result set
		while (myRs.next()) {
			Product p = new Product();
			p.setProdId(myRs.getInt("pid"));
			p.setStoreId(myRs.getInt("sid"));
			p.setProdName(myRs.getString("prodName"));
			p.setPrice(myRs.getDouble("price"));
			products.add(p);
		}

		return products;

	}
	
	public ArrayList<StoreProducts> loadStoreProducts(int sid) throws Exception {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		myConn = mysqlDS.getConnection();
		String sql = "select s.*, p.pid, p.prodname, p.price from store as s left join product as p on p.sid=s.id where id = " + sid;
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);

		ArrayList<StoreProducts> storeProducts = new ArrayList<StoreProducts>();

		// process result set
		while (myRs.next()) {
			StoreProducts sp = new StoreProducts();
			sp.setStoreId(myRs.getInt("id"));
			sp.setStoreName(myRs.getString("name"));
			sp.setFounded(myRs.getString("founded"));
			sp.setProdId(myRs.getInt("pid"));
			sp.setProdName(myRs.getString("prodName"));
			sp.setPrice(myRs.getDouble("price"));
			storeProducts.add(sp);
		}

		return storeProducts;

	}
	
	public void addStore(Store s) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into store values (?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, s.getStoreId());
		myStmt.setString(2, s.getName());
		myStmt.setString(3, s.getFounded());
		myStmt.execute();			
	}

	public void delete(int sid) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		myConn = mysqlDS.getConnection();
		String sql = "delete from store where id = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, sid);
		myStmt.execute();			
	}

	public void showProducts(int sid) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		myConn = mysqlDS.getConnection();
		String sql = "select * from product where sid = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, sid);
		myStmt.execute();			
	}

	public void deleteProduct(int pid) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		myConn = mysqlDS.getConnection();
		String sql = "delete from product where pid = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, pid);
		myStmt.execute();			
	}

}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import helper.DBConnection;

public class ybmoil {

	private int id;
	private String name;

	DBConnection conn = new DBConnection();

	PreparedStatement preparedstatement = null;
	Statement st = null;
	ResultSet rs = null;

	public ybmoil() {
	}

	public ybmoil(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ArrayList<ybmoil> getList() throws SQLException {
		ArrayList<ybmoil> list = new ArrayList<ybmoil>();
		ybmoil obj;
		Connection con = conn.connDB();
		try {
			
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM ybmoil");
			while (rs.next()) {
				obj = new ybmoil();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}

		return list;

	}
     public boolean addybmoil(String name) throws SQLException {
		
		String query = "INSERT INTO ybmoil"+ "(name) VALUES"+ "(?) ";
		boolean key = false;
		Connection con = conn.connDB();
		try {
			
			ResultSet rs = null;
			
			Statement st = con.createStatement();
			PreparedStatement preparedstatement = con.prepareStatement(query);
			preparedstatement.setString(1, name);
			preparedstatement.executeUpdate();
			 key = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		 
		if(key) 
			return true;
		else
			return false;
		    
			
	}
     
     public boolean deleteybmoil(int id) throws SQLException {

 		String query = "DELETE FROM ybmoil WHERE id = ? ";
 		boolean key = false;
 		Connection con = conn.connDB();
 		try {
 			
 			ResultSet rs = null;

 			Statement st = con.createStatement();
 			PreparedStatement preparedstatement = con.prepareStatement(query);
 			preparedstatement.setInt(1, id);

 			preparedstatement.executeUpdate();
 			key = true;

 		} catch (Exception e) {
 			e.printStackTrace();

 		}

 		if (key)
 			return true;
 		else
 			return false;

 	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Personel extends User {

	public Personel(int id, String tcno, String name, String password, String type) {
		super(id, tcno, name, password, type);

	}

	public Personel() {
	}

	public ArrayList<User> getMüsteriList() throws SQLException {
		ArrayList<User> list = new ArrayList<User>();
		Connection con = conn.connDB();
		PreparedStatement preparedstatement = null;
		Statement st = null;
		ResultSet rs = null;
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM personellistesi WHERE type='Müsteri'");

			while (rs.next()) {

				obj = new User(rs.getInt("İd"), rs.getString("tcno"), rs.getString("name"), rs.getString("password"),
						rs.getString("type"));
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

	public boolean addmüsteri(String tcno, String password, String name) throws SQLException {

		String query = "INSERT INTO personellistesi" + "(tcno,password,name,type) VALUES" + "(?,?,?,?) ";
		boolean key = false;
		try {
			Connection con = conn.connDB();
			ResultSet rs = null;

			Statement st = con.createStatement();
			PreparedStatement preparedstatement = con.prepareStatement(query);
			preparedstatement.setString(1, tcno);
			preparedstatement.setString(2, password);
			preparedstatement.setString(3, name);
			preparedstatement.setString(4, "Müsteri");

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

	public boolean deletemüsteri(int İd) throws SQLException {

		String query = "DELETE FROM personellistesi WHEREi İd = ? ";
		boolean key = false;
		try {
			Connection con = conn.connDB();
			ResultSet rs = null;

			Statement st = con.createStatement();
			PreparedStatement preparedstatement = con.prepareStatement(query);
			preparedstatement.setInt(1, İd);

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

}

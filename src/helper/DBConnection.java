package helper;
import java.sql.*;

public class DBConnection {
	Connection c = null ;
	
	public DBConnection() {}
	
	public Connection connDB() {
		try {
			this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3305/benzinlik?user=root&password=admin");
			return c;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return c;
	}

	
	

}

package OCM.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
	public static final String className = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/online-courses-management";
	public static final String username = "root";
	public static final String password = "";
	
	public static Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName(className);
		return DriverManager.getConnection(url, username, password);
	}
}
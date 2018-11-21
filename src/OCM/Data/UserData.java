package OCM.Data;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

import OCM.Model.User;
import OCM.Model.Role;
import OCM.utils.BcryptEncryption;

public final class UserData {
	private static InitData<User> i = new InitData<User>();

	private static User newUser(String iD, String email, String password, Role roleLevel, String fullName, Boolean gender, LocalDate dob,
			String telephone, String address, String bio, LocalDateTime joinedAt, Double balance, Long reputation,
			Integer penaltyCount) {
		return new User(iD.substring(2), email, password, roleLevel, fullName, gender, dob, telephone, address, bio, joinedAt, balance, reputation,
				penaltyCount);
	}
	
	public static ArrayList<User> getAllUser() throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
			
			// Prepare SELECT statement from connection.
			i.ps = i.db.prepareStatement("SELECT * FROM user");
			
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
			
			// Initialize the array
			i.arr = new ArrayList<User>();
			
			// For each result in rs, put into an ArrayList of type User.
			while(i.rs.next()) {
				i.t = newUser(
					i.rs.getString(1),
					i.rs.getString(2),
					i.rs.getString(3),
					Role.map(i.rs.getInt(4)),
					i.rs.getString(5),
					i.rs.getBoolean(6),
					i.rs.getDate(7).toLocalDate(),
					i.rs.getString(8),
					i.rs.getString(9),
					i.rs.getString(10),
					i.rs.getTimestamp(11).toLocalDateTime(),
					i.rs.getDouble(12),
					i.rs.getLong(13),
					i.rs.getInt(14)
				);
				i.arr.add(i.t);
			}
			
			// Return the ArrayList containing the list of users
			return i.arr;
		} finally {
			i.closeData();
		}
	}
	
	public static User getUserByID(String ID) throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
			
			// Prepare procedure call from connection.
			i.ps = i.db.prepareStatement("{ CALL find_user_by_id(?) }");
			
			// Bind parameter(s) to the prepared statement.
			i.ps.setString(1, ID);
			
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
			
			// For each result, make a new User object.
			i.t = newUser(
				i.rs.getString(1),
				i.rs.getString(2),
				i.rs.getString(3),
				Role.map(i.rs.getInt(4)),
				i.rs.getString(5),
				i.rs.getBoolean(6),
				i.rs.getDate(7).toLocalDate(),
				i.rs.getString(8),
				i.rs.getString(9),
				i.rs.getString(10),
				i.rs.getTimestamp(11).toLocalDateTime(),
				i.rs.getDouble(12),
				i.rs.getLong(13),
				i.rs.getInt(14)
				);
		} finally {
			i.closeData();
		}
		return i.t;
	}
	
	public static void insertUser(String email, String password, String roleLevel, String fullName, String gender, String dob,
			String telephone, String address, String bio) throws ClassNotFoundException, SQLException, ParseException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
			
			// Prepare procedure call from connection.
			i.ps = i.db.prepareCall("{ CALL insert_user(?,?,?,?,?,?,?,?,?) }");
			
			
			// Bind parameter(s) to the prepared statement.
			i.ps.setString(1, email);
			
			// Encryption before insertion.
			i.ps.setString(2, new BcryptEncryption().encrypt(password));
			i.ps.setInt(3, Integer.valueOf(roleLevel));
			i.ps.setString(4, fullName);
			i.ps.setBoolean(5,Boolean.valueOf(gender));
			
			// Convert java.util.Date to java.sql.Date from string value, because why not.
			i.ps.setDate(6, Date.valueOf(dob));
			
			i.ps.setString(7, telephone);
			i.ps.setString(8, address);
			i.ps.setString(9, bio);
			
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
			
		} finally {
			i.closeData();
		}
	}
	
	// TODO: Add custom exceptions for each testing stages, using custom exception classes and enum to round them up.
	public static Boolean login(String email, String password) throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
			
			// Prepare statement from connection.
			i.ps = i.db.prepareStatement("SELECT * FROM user WHERE email=?");
			
			// Bind parameter(s) to the prepared statement.
			i.ps.setString(1, email);
			
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
			
			// Check if email exists.
			if (!i.rs.next()) return false;
			
			// Check if password matches.
			if(!new BcryptEncryption().compare(password, i.rs.getString(3))) return false;
		} finally {
			i.closeData();
		}
		System.out.println("CONGRATULATIONS!!!1");
		return true;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		// UserData.insertUser("aaa@aaa.com", "123", "0", "BANANANAAAAA","1", "1999-03-01", "11111111", "i dunno", "meh.");
		//ArrayList<User> arr = UserData.getAllUser();
		//System.out.println(arr.get(1).getJoinedAt());
		UserData.login("aaa@aaa.com", "123");
		//LocalDate d = LocalDate.parse("2018-12-21", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		//System.out.println(d);
	}
	
}

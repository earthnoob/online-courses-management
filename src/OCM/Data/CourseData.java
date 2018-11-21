package OCM.Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;

import OCM.Model.Course;

public final class CourseData {
	private static InitData<Course> i = new InitData<Course>();
	
	private static Course newCourse(String courseID, String ownerID, String name, String category, String description, LocalDateTime createdAt,
			Double price, Long numberOfRegistrations) {
		return new Course(courseID.substring(2), ownerID.substring(2), name, category, description, createdAt, price, numberOfRegistrations);
	}
	
	public static ArrayList<Course> getAllCourse() throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
						
			// Prepare SELECT statement from connection.
			i.ps = i.db.prepareStatement("SELECT * FROM course");
						
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
			
			// Initialize the array.
			i.arr = new ArrayList<Course>();
			
			// For each result in rs, put into an ArrayList of type Course.
			while(i.rs.next()) {
				i.t = newCourse(
						i.rs.getString(1),
						i.rs.getString(2),
						i.rs.getString(3),
						i.rs.getString(4),
						i.rs.getString(5),
						i.rs.getTimestamp(6).toLocalDateTime(),
						Double.valueOf(i.rs.getDouble(7)),
						i.rs.getLong(8)
					);
				i.arr.add(i.t);
			}
		} finally {
			i.closeData();
		}
		
		// Return the array.
		return i.arr;
	}
	
	public static ArrayList<Course> getAllCoursesByOwnerID(String ID) throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
								
			// Prepare procedure call from connection.
			i.ps = i.db.prepareCall("{ CALL find_all_courses_by_user_id(?) }");
			
			// Bind parameter(s) to the prepared statement.
			i.ps.setString(1, ID);
								
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
					
			// Initialize the array.
			i.arr = new ArrayList<Course>();
			
			// For each result in rs, put into an ArrayList of type Course.
			while(i.rs.next()) {
				i.t = newCourse(
					i.rs.getString(1),
					i.rs.getString(2),
					i.rs.getString(3),
					i.rs.getString(4),
					i.rs.getString(5),
					i.rs.getTimestamp(6).toLocalDateTime(),
					Double.valueOf(i.rs.getDouble(7)),
					i.rs.getLong(8)
				);
				i.arr.add(i.t);
			}
		} finally {
			i.closeData();
		}
		
		// Return the array.
		return i.arr;
	}
	
	public static void insertCourse(String ownerID, String name, String category, String description, Double price) 
			throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
											
			// Prepare procedure call from connection.
			i.ps = i.db.prepareCall("{ CALL insert_course(?,?,?,?,?) }");
						
			// Bind parameter to the prepared statement.
			i.ps.setString(1, ownerID);
			i.ps.setString(2, name);
			i.ps.setString(3, category);
			i.ps.setString(4, description);
			i.ps.setDouble(5, price);
											
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
		} finally {
			i.closeData();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArrayList<Course> arr = CourseData.getAllCoursesByOwnerID("362409371188934485003945");
		System.out.println(arr.get(0).getName());
	}
}
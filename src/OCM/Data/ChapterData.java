package OCM.Data;

import java.sql.SQLException;
import java.util.ArrayList;

import OCM.Model.Chapter;

public final class ChapterData {
	private static InitData<Chapter> i = new InitData<Chapter>();
	
	public static Chapter newChapter(String chapterID, String courseID, Integer chapterNumber, String name, String description) {
		return new Chapter(chapterID.substring(3), courseID.substring(2), chapterNumber, name, description);
	}
	
	public static ArrayList<Chapter> getAllChaptersByCourseID(String ID) throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
											
			// Prepare procedure call from connection.
			i.ps = i.db.prepareCall("{ CALL find_all_chapters_by_course_id(?) }");
						
			// Bind parameter(s) to the prepared statement.
			i.ps.setString(1, ID);
											
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
								
			// Initialize the array.
			i.arr = new ArrayList<Chapter>();
			
			// For each result in rs, put into an ArrayList of type Chapter.
			while(i.rs.next()) {
				i.t = newChapter(
					i.rs.getString(1),
					i.rs.getString(2),
					i.rs.getInt(3),
					i.rs.getString(4),
					i.rs.getString(5)
				);
				i.arr.add(i.t);
			}
		} finally {
			i.closeData();
		}
		
		// Return the array.
		return i.arr;
	}
	
	public static void insertChapter(String courseID, String name, String description) throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
											
			// Prepare procedure call from connection.
			i.ps = i.db.prepareCall("{ CALL insert_chapter(?,?,?) }");
						
			// Bind parameter(s) to the prepared statement.
			i.ps.setString(1, courseID);
			i.ps.setString(2, name);
			i.ps.setString(3, description);
											
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
		} finally {
			i.closeData();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//ChapterData.insertChapter("314943208923831735656812", "Coming from JDBC", "This is an auto-generated chapter for a course from JDBC.");
		ArrayList<Chapter> arr = ChapterData.getAllChaptersByCourseID("314943208923831735656812");
		System.out.println(arr.get(0).getDescription());
	}
}

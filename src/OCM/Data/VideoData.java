package OCM.Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;

import OCM.Model.Video;

public final class VideoData {
	private static InitData<Video> i = new InitData<Video>();
	
	private static Video newVideo(String videoID, String chapterID, String name, LocalDateTime createdAt, Integer viewCount) {
		return new Video(videoID.substring(2), chapterID.substring(3), name, createdAt, viewCount);
	}
	
	public static ArrayList<Video> getAllVideosFromChapter(String chapterID) throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
												
			// Prepare SELECT statement from connection.
			i.ps = i.db.prepareCall("{ CALL find_all_videos_by_chapter_id(?) }");
							
			// Bind parameter(s) to the prepared statement.
			i.ps.setString(1, chapterID);
												
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
			
			// Initialize the array.
			i.arr = new ArrayList<Video>();
			
			// For each result in rs, put into an ArrayList of type Video.
			while(i.rs.next()) {
				i.t = newVideo(
					i.rs.getString(1),
					i.rs.getString(2),
					i.rs.getString(3),
					i.rs.getTimestamp(4).toLocalDateTime(),
					i.rs.getInt(5)
				);
				i.arr.add(i.t);
			}
			
		} finally {
			i.closeData();
		}
		
		// Return the array.
		return i.arr;
	}
	
	public static Video findVideoByID(String videoID) throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
															
			// Prepare SELECT statement from connection.
			i.ps = i.db.prepareCall("{ CALL find_all_videos_by_chapter_id(?) }");
										
			// Bind parameter(s) to the prepared statement.
			i.ps.setString(1, videoID);
															
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
			
			i.t = newVideo(
				i.rs.getString(1),
				i.rs.getString(2),
				i.rs.getString(3),
				i.rs.getTimestamp(4).toLocalDateTime(),
				i.rs.getInt(5)
				);
		} finally {
			i.closeData();
		}
		
		return i.t;
	}
	
	public static void insertVideo(String chapterID, String name) throws ClassNotFoundException, SQLException {
		try {
			// Connect to database using predefined configurations in the DBConnection class.
			i.db = DBConnection.connect();
										
			// Prepare procedure call from connection.
			i.ps = i.db.prepareCall("{ CALL insert_video(?,?) }");
					
			// Bind parameter(s) to the prepared statement.
			i.ps.setString(1, chapterID);
			i.ps.setString(2, name);
										
			// Execute query into a ResultSet.
			i.rs = i.ps.executeQuery();
		} finally {
			i.closeData();
		}
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// VideoData.insertVideo("029225049623848512863963", "HENLO FREN");
		ArrayList<Video> arr = VideoData.getAllVideosFromChapter("ch_029225049623848512863963");
		System.out.println(arr.get(0).getCreatedAt());
	}
}

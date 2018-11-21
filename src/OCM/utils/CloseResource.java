package OCM.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseResource {
	/**
	 * Closes the connection to the database.
	 * @param c
	 * @throws SQLException
	 */
	public static void closeConnection(Connection c) throws SQLException {
		if (c != null) c.close();
	}
	
	/**
	 * Closes the PreparedStatement object.
	 * @param ps
	 * @throws SQLException
	 */
	public static void closePreparedStatement(PreparedStatement ps) throws SQLException {
		if (ps != null) ps.close();
	}
	
	/**
	 * Closes the ResultSet object.
	 * @param rs
	 * @throws SQLException
	 */
	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) rs.close();
	}
}

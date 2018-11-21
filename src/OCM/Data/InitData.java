package OCM.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import OCM.utils.CloseResource;

public class InitData<T> {
	public Connection db = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public T t = null;
	public ArrayList<T> arr = null;
	
	public InitData() {}
	
	public void closeData() throws ClassNotFoundException, SQLException {
		CloseResource.closeConnection(db);
		CloseResource.closePreparedStatement(ps);
		CloseResource.closeResultSet(rs);
	}
}

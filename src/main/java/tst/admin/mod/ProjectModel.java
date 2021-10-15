package tst.admin.mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ProjectModel {
	private String connStr = "jdbc:mysql://192.168.3.40:3306/WarmLove?"
			+ "user=skydep&password=d3c8b2ka"
			+ "&characterEncoding=UTF-8";
	private Connection conn = null;
	private Statement stmt = null;
	
	public void connectMariaDB() throws SQLException, ClassNotFoundException {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	conn = DriverManager.getConnection(connStr);
    	if(conn == null)
    		throw new SQLException("connect error");
    }
	
	public void closeMariaDB() throws SQLException {
		if(conn != null)
			conn.close();
    }
	
	public ArrayList<HashMap<String, String>> lists(HashMap<String, String> params) throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");
		
		stmt = conn.createStatement();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "select id, title, `desc`, img, pay, createdDate, updatedDate from Project order by id desc";
		ResultSet result = stmt.executeQuery(sql);
		
		ArrayList<HashMap<String, String>> lists = new ArrayList<HashMap<String,String>>();
		if(result != null) {
			while (result.next()) {
				HashMap<String, String> tmp = new HashMap<String, String>();
				tmp.put("id", Integer.toString(result.getInt(1)));
				tmp.put("title", result.getString(2));
				tmp.put("desc", result.getString(3));
				tmp.put("img", result.getString(4));
				tmp.put("pay", Integer.toString(result.getInt(5)));
				Date createdDate = result.getDate(6);
				tmp.put("createdDate", dateFormat.format(createdDate));
				Date updatedDate = result.getDate(7);
				tmp.put("updatedDate", dateFormat.format(updatedDate));
				lists.add(tmp);
			}
		}
		return lists;
	}
}

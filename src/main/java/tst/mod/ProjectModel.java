package tst.mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectModel {
	private String connStr = "jdbc:mysql://192.168.3.40:3306/WarmLove?"
			+ "user=skydep&password=d3c8b2ka"
			+ "&useUnicode=true&characterEncoding=UTF-8";
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
	
	public ArrayList<HashMap> list() throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");

		stmt = conn.createStatement();
		ArrayList<HashMap> res = new ArrayList<HashMap>();
    	String proSql = "select `id`, `title`, `desc`, `pay` from Project";
    	ResultSet proResult = stmt.executeQuery(proSql);

    	if(proResult != null) {
			while (proResult.next()) {
				HashMap<String, String> tmp = new HashMap<>();
				tmp.put("projectId", Integer.toString(proResult.getInt(1)));
				tmp.put("title", proResult.getString(2));
				tmp.put("desc", proResult.getString(3));
				tmp.put("pay", Integer.toString(proResult.getInt(4)));
				res.add(tmp);
			}
		}
    	return res;
    }
}

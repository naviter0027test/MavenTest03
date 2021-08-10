package tst.mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;

public class DonateModel {
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
	
	public void add(HashMap<String, String> params) throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");
		Timestamp createdDate = new Timestamp(System.currentTimeMillis());

		stmt = conn.createStatement();
		String sql = "INSERT INTO Donate "
				+ "(`projectId`, `pay`, `name`, "
				+ "`address`, `status`, `payMode`, "
				+ "`atmCode`, `createdDate`, `updatedDate`) "
				+ "VALUES (?, ?, ?, ?, 0, ?, ?, ?, ?)";
    	PreparedStatement prepare = conn.prepareStatement(sql);

    	int projectId = Integer.parseInt((String) params.get("projectId"));
    	int pay = Integer.parseInt((String) params.get("pay"));
    	String name = (String) params.get("name");
    	String address = (String) params.get("address");
    	int payMode = Integer.parseInt((String) params.get("payMode"));
    	String atmCode = (String) params.get("atmCode");
    	prepare.setInt(1, projectId);
    	prepare.setInt(2, pay);
    	prepare.setString(3, name);
    	prepare.setString(4, address);
    	prepare.setInt(5, payMode);
    	prepare.setString(6, atmCode);
    	prepare.setTimestamp(7, createdDate);
    	prepare.setTimestamp(8, createdDate);
    	
    	prepare.executeUpdate();
	}
}

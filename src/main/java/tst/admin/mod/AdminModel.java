package tst.admin.mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;

public class AdminModel {
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
	
	public HashMap<String, String> checkPass(HashMap<String, String> params) throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");
		
		stmt = conn.createStatement();
		String account = (String) params.get("account");
		String password = (String) params.get("password");
		boolean res = false;
		String sql = "select id, account, password from admin where account = '"+ account+ "'";
		ResultSet result = stmt.executeQuery(sql);

		HashMap<String, String> adminData = new HashMap<String, String>();
    	if(result != null) {
			while (result.next()) {
				String tmpId = Integer.toString(result.getInt(1));
				String tmpAcc = result.getString(2);
				String tmpPass = result.getString(3);
				if(tmpAcc.equals(account) && tmpPass.equals(password)) {
					res = true;
					adminData.put("id", tmpId);
					adminData.put("account", tmpAcc);
				}
			}
		}

		return adminData;
	}
	
	public HashMap<String, String> getById(String id) throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");
		
		stmt = conn.createStatement();

		String sql = "select id, account, password from admin where id = '"+ id+ "'";
		ResultSet result = stmt.executeQuery(sql);

		HashMap<String, String> adminData = new HashMap<String, String>();
    	if(result != null) {
			while (result.next()) {
				String tmpId = Integer.toString(result.getInt(1));
				String tmpAcc = result.getString(2);
				String tmpPass = result.getString(3);
				adminData.put("id", tmpId);
				adminData.put("account", tmpAcc);
				adminData.put("password", tmpPass);
			}
		}

		return adminData;
	}
	
	public void passwordUpdate(String id, String passwordNew) throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");
		Timestamp createdDate = new Timestamp(System.currentTimeMillis());

		stmt = conn.createStatement();
		String sql = "update admin set password = ? where id = ?";
		PreparedStatement prepare = conn.prepareStatement(sql);
		prepare.setString(1, passwordNew);
		prepare.setString(2, id);
		
		prepare.executeUpdate();
	}
}

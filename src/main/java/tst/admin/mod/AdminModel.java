package tst.admin.mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public boolean checkPass(HashMap<String, String> params) throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");
		
		stmt = conn.createStatement();
		String account = (String) params.get("account");
		String password = (String) params.get("password");
		boolean res = false;
		String sql = "select account, password from admin where account = '"+ account+ "'";
		ResultSet result = stmt.executeQuery(sql);

    	if(result != null) {
			while (result.next()) {
				String tmpAcc = result.getString(1);
				String tmpPass = result.getString(2);
				if(tmpAcc.equals(account) && tmpPass.equals(password))
					res = true;
			}
		}

		return res;
	}
}

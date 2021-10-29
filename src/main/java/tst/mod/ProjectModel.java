package tst.mod;

import java.io.File;
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
	
	private String filePath = new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile()
			+"/webapps/upload";
	private String webPath = "/upload";
	
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
    	String proSql = "select `id`, `title`, `desc`, `img`, `pay` from Project";
    	ResultSet proResult = stmt.executeQuery(proSql);

    	if(proResult != null) {
			while (proResult.next()) {
				HashMap<String, String> tmp = new HashMap<>();
				tmp.put("projectId", Integer.toString(proResult.getInt(1)));
				tmp.put("title", proResult.getString(2));
				tmp.put("desc", proResult.getString(3));
				String imgPath = filePath+ "/"+ proResult.getString(4);
				File imgFile = new File(imgPath);
				if(imgFile.exists() == false)
					imgPath = "https://fakeimg.pl/150/";
				else
					imgPath = webPath+ "/"+ proResult.getString(4);
				tmp.put("img", imgPath);
				tmp.put("pay", Integer.toString(proResult.getInt(5)));
				res.add(tmp);
			}
		}
    	return res;
    }
	
	public HashMap<String, String> getById(int pid) throws SQLException {
		HashMap<String, String> res = new HashMap<String, String>();
		if(conn == null)
			throw new SQLException("not connect");

		String pidStr = Integer.toString(pid);
		stmt = conn.createStatement();
    	String proSql = "select `id`, `title`, `desc`, `pay`, `img` from Project where id = "+ pidStr;
    	ResultSet proResult = stmt.executeQuery(proSql);
    	boolean isData = false;
    	
    	if(proResult != null) {
			while (proResult.next()) {
				isData = true;
				res.put("id", Integer.toString(proResult.getInt(1)));
				res.put("title", proResult.getString(2));
				res.put("desc", proResult.getString(3));
				res.put("pay", Integer.toString(proResult.getInt(4)));
				res.put("img", proResult.getString(5));
			}
		}
    	if(isData == false)
    		res = null;
    	return res;
	}
}

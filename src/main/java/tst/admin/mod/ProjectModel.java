package tst.admin.mod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class ProjectModel {
	private String connStr = "jdbc:mysql://192.168.3.40:3306/WarmLove?"
			+ "user=skydep&password=d3c8b2ka"
			+ "&characterEncoding=UTF-8";
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
	
	public ArrayList<HashMap<String, String>> lists(HashMap<String, String> params) throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");
		
		stmt = conn.createStatement();
		int limitStart = 0;
		int offset = 10;
		if(params.containsKey("nowPage"))
			limitStart = offset * (Integer.parseInt((String) params.get("nowPage")) - 1);  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String sql = "select id, title, `desc`, img, pay, createdDate, updatedDate from Project order by id desc";
		sql += " limit "+ Integer.toString(limitStart)+ ", "+ Integer.toString(offset);
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
	
	public String listsAmount(HashMap<String, String> params) throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");
		
		stmt = conn.createStatement();
		String sql = "select count(id) from Project";
		
		ResultSet result = stmt.executeQuery(sql);
		String amount = "0";
		if(result != null) {
			while (result.next()) {
				int a = result.getInt(1);
				amount = Integer.toString(a);
			}
		}
		return amount;
	}
	
	public HashMap<String, String> getById(int id) throws SQLException {
		if(conn == null)
			throw new SQLException("not connect");
		
		stmt = conn.createStatement();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String sql = "select id, title, `desc`, img, pay, createdDate, updatedDate from Project"
				+ " where id = "+ Integer.toString(id)
				+ " order by id desc limit 0, 1";

		ResultSet result = stmt.executeQuery(sql);
		HashMap<String, String> tmp = new HashMap<String, String>();
		if(result != null) {
			if (result.next()) {
				tmp.put("id", Integer.toString(result.getInt(1)));
				tmp.put("title", result.getString(2));
				tmp.put("desc", result.getString(3));
				String imgPath = filePath+ "/"+ result.getString(4);
				File imgFile = new File(imgPath);
				if(imgFile.exists() == false)
					imgPath = "https://fakeimg.pl/150/";
				else
					imgPath = webPath+ "/"+ result.getString(4);
				tmp.put("img", imgPath);
				tmp.put("pay", Integer.toString(result.getInt(5)));
				Date createdDate = result.getDate(6);
				tmp.put("createdDate", dateFormat.format(createdDate));
				Date updatedDate = result.getDate(7);
				tmp.put("updatedDate", dateFormat.format(updatedDate));
			}
			else {
				tmp.put("id", Integer.toString(id));
				tmp.put("title", "");
				tmp.put("desc", "");
				tmp.put("img", "");
				tmp.put("pay", "");
				tmp.put("createdDate", "");
				tmp.put("updatedDate", "");
			}
		}
		return tmp;
	}
	
	public void add(HttpServletRequest req) throws Exception {	    
		if(conn == null)
			throw new SQLException("not connect");
		String title = (String) req.getParameter("title");
	    String desc = (String) req.getParameter("desc");
	    int pay = Integer.parseInt((String) req.getParameter("pay"));
	    Timestamp createdDate = new Timestamp(System.currentTimeMillis());
	    
	    stmt = conn.createStatement();
		String sql = "INSERT INTO Project "
				+ "(`title`, `desc`, `pay`, "
				+ "`createdDate`, `updatedDate`) "
				+ "VALUES (?, ?, ?, ?, ?)";
    	PreparedStatement prepare = conn.prepareStatement(sql);
    	prepare.setString(1, title);
    	prepare.setString(2, desc);
    	prepare.setInt(3, pay);
    	prepare.setTimestamp(4, createdDate);
    	prepare.setTimestamp(5, createdDate);
    	prepare.executeUpdate();
		
	    //以下是將上傳的圖檔存到指定位子
	    OutputStream out = null;
	    InputStream filecontent = null;
		File fileSaveDir = new File(filePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        try {
	        Part filePart = req.getPart("img");
	        String fileContentType = filePart.getContentType();
	        if(fileContentType.equals("image/jpeg") ||
	        	fileContentType.equals("image/gif") ||
	        	fileContentType.equals("image/png")) {
	        	
	        	String ext = ".jpg";
	        	if(fileContentType.equals("image/gif"))
	        		ext = ".gif";
	        	else if(fileContentType.equals("image/png"))
	        		ext = ".png";
        
		        //將上傳的檔名記錄至資料庫中
		        sql = "select id from Project "
		        		+ "where `title` = '" + title + "'"
		        		+ " and `desc` = '" + desc + "'"
		        		+ " and `pay` = " + Integer.toString(pay)
		        		;
		        ResultSet result = stmt.executeQuery(sql);
				int id = 0;
				if(result != null)
					if (result.next())
						id = result.getInt(1);
		        
				sql = "update Project set img = ? where id = ?";
				prepare = conn.prepareStatement(sql);
				String filename = "image_"+ Integer.toString(id)+ ext;
				prepare.setString(1, filename);
				prepare.setInt(2, id);
				prepare.executeUpdate();
				
				//將上傳的檔案存到指定地點
				out = new FileOutputStream(new File(filePath + File.separator
		                + filename));
		        filecontent = filePart.getInputStream();
		
		        int read = 0;
		        final byte[] bytes = new byte[1024];
		
		        while ((read = filecontent.read(bytes)) != -1) {
		            out.write(bytes, 0, read);
		        }
	        }
        } catch (FileNotFoundException fne) {
            throw fne;
        } catch (Exception e) {
        	throw e;
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
	}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}

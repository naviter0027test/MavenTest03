package tst.admin.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tst.admin.mod.AdminModel;
import tst.mod.DonateModel;

public class AdminLogin extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("admin/login.jsp").forward(req, res);        
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		HashMap<String, String> params = new HashMap<String, String>();
		String account = (String) req.getParameter("account");
		String password = (String) req.getParameter("password");
		params.put("account", account);
		params.put("password", password);

		AdminModel admin = new AdminModel();
		PrintWriter out = res.getWriter();
		
		try {
			admin.connectMariaDB();
			boolean checkResult = admin.checkPass(params);
			
			out.println("admin login doPost<br />");
			out.println("account"+ account+ "<br />");
			out.println("password"+ password + "<br />");
			if(checkResult)
				out.println("login success<br />");
			else
				out.println("login failed<br />");
			
			admin.closeMariaDB();
		} catch(SQLException e) {
			out.println(e.getMessage());
		} catch(ClassNotFoundException e) {
			out.println(e.getMessage());
		}
	}
}

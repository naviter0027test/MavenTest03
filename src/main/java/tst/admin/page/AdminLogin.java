package tst.admin.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tst.admin.mod.AdminModel;
import tst.mod.DonateModel;

public class AdminLogin extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		if(session.getAttribute("adminId") != null)
		{
			res.sendRedirect("admin-home");
		}
		else
			req.getRequestDispatcher("admin/login.jsp").forward(req, res);        
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		HashMap<String, String> params = new HashMap<String, String>();
		HttpSession session = req.getSession();
		String account = (String) req.getParameter("account");
		String password = (String) req.getParameter("password");
		params.put("account", account);
		params.put("password", password);

		AdminModel admin = new AdminModel();
		PrintWriter out = res.getWriter();
		
		try {
			admin.connectMariaDB();
			HashMap<String, String> adminData = admin.checkPass(params);
			
			//out.println("admin login doPost<br />");
			//out.println("account"+ account+ "<br />");
			//out.println("password"+ password + "<br />");
			if(adminData.containsKey("id")) {
				String id = adminData.get("id");
				session.setAttribute("adminId", id);
				out.println("login success<br />");
				res.sendRedirect("admin-home");
			}
			else {
				out.println("<meta http-equiv=\"refresh\" content=\"3; url=admin-login\">");
				out.println("login failed wait to redirect login page...<br />");
			}
			
			admin.closeMariaDB();
		} catch(SQLException e) {
			out.println(e.getMessage());
		} catch(ClassNotFoundException e) {
			out.println(e.getMessage());
		}
	}
}

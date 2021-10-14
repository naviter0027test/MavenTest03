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

public class AdminPass extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		if(session.getAttribute("adminId") == null) {
			res.sendRedirect("admin-login");
			return;
		}
		req.getRequestDispatcher("admin/password.jsp").forward(req, res);        
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		if(session.getAttribute("adminId") == null) {
			res.sendRedirect("admin-login");
			return;
		}
		AdminModel admin = new AdminModel();
		String adminId = (String) session.getAttribute("adminId");
		String passwordOld = req.getParameter("passwordOld");
		String password = req.getParameter("password");
		String passwordConfirm = req.getParameter("passwordConfirm");
		if(password.equals(passwordConfirm) == false) {
			out.println("<meta http-equiv='refresh' content='3; url=admin-pass'>");
			out.println("密碼與確認密碼輸入須一樣<br />");
		}
		try {
			admin.connectMariaDB();
			HashMap<String, String> adminData = admin.getById(adminId);
			String tmpPass = adminData.get("password");
			if(tmpPass.equals(passwordOld) == false) {
				out.println("<meta http-equiv='refresh' content='3; url=admin-pass'>");
				out.println("舊密碼輸入錯誤<br />");				
			}

			admin.passwordUpdate(adminId, password);
			admin.closeMariaDB();
			out.println("<meta http-equiv='refresh' content='3; url=admin-pass'>");
		} catch(SQLException | ClassNotFoundException e) {
			out.println(e.getMessage());
		}
//		out.println("passwordOld:"+ passwordOld+ "<br />");
//		out.println("password:"+ password+"<br />");
//		out.println("passwordConfirm:"+ passwordConfirm+ "<br />");
		out.println("密碼更新完成，等待跳轉...<br />");
	}
}

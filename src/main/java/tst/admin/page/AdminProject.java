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

import tst.admin.mod.ProjectModel;

public class AdminProject extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		ProjectModel projectModel = new ProjectModel();
		if(session.getAttribute("adminId") == null) {
			res.sendRedirect("admin-login");
			return;
		}
		HashMap<String, String> params = new HashMap<String, String>();
		try {
			projectModel.connectMariaDB();
			req.setAttribute("list", projectModel.lists(params));
			req.getRequestDispatcher("admin/project.jsp").forward(req, res);
		} catch (SQLException | ClassNotFoundException e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			projectModel.closeMariaDB();
		} catch (SQLException e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}

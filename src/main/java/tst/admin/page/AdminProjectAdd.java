package tst.admin.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tst.admin.mod.ProjectModel;

public class AdminProjectAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		ProjectModel projectModel = new ProjectModel();
		if(session.getAttribute("adminId") == null) {
			res.sendRedirect("admin-login");
			return;
		}
		req.getRequestDispatcher("admin/projectAdd.jsp").forward(req, res);
	}
}

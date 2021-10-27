package tst.admin.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tst.admin.mod.ProjectModel;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class AdminProjectEdit extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		ProjectModel projectModel = new ProjectModel();
		if(session.getAttribute("adminId") == null) {
			res.sendRedirect("admin-login");
			return;
		}
		int pid = 0;
		if(req.getParameter("pid") != null)
			pid = Integer.parseInt(req.getParameter("pid"));
		try {
			projectModel.connectMariaDB();
			HashMap<String, String> item = projectModel.getById(pid);
			req.setAttribute("item", item);
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
		
		req.getRequestDispatcher("admin/projectEdit.jsp").forward(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		if(session.getAttribute("adminId") == null) {
			res.sendRedirect("admin-login");
			return;
		}

		ProjectModel projectModel = new ProjectModel();
	}
}

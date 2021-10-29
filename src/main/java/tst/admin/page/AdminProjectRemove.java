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

public class AdminProjectRemove extends HttpServlet {
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
		
		try {
			if(req.getParameter("pid") == null)
				throw new Exception("pid must input");
			projectModel.connectMariaDB();
			projectModel.remove(req);
			
		} catch (SQLException | ClassNotFoundException e) {
			out.println(e.getMessage());
			e.printStackTrace();
		} catch ( Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			projectModel.closeMariaDB();
		} catch (SQLException e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
		
		out.println("<meta http-equiv='refresh' content='3; url=admin-project'>");
	    out.println("刪除完成，等待跳轉<br />");
	}
}

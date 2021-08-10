package tst.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tst.mod.DonateModel;
import tst.mod.ProjectModel;

public class PayStart extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		try {
			req.setAttribute("root", req.getContextPath());
			String pidStr = req.getParameter("projectId");
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("projectId", pidStr);
			params.put("name", (String) req.getParameter("name"));
			params.put("address", (String) req.getParameter("address"));
			params.put("payMode", req.getParameter("payMode"));
			params.put("atmCode", req.getParameter("atmCode"));

			ProjectModel projectModel = new ProjectModel();
			projectModel.connectMariaDB();
			
			int pid = Integer.parseInt(pidStr);
			HashMap<String, String> project = projectModel.getById(pid);
			if(project == null) {
				req.setAttribute("project", project);
				req.getRequestDispatcher("pay.jsp").forward(req, res);
			}
			else {
				params.put("pay", (String) project.get("pay"));
				DonateModel donateModel = new DonateModel();
				donateModel.connectMariaDB();
				donateModel.add(params);
				donateModel.closeMariaDB();
			}
			projectModel.closeMariaDB();

			out.println("sql success<br />");
		} catch (SQLException e) {
			e.printStackTrace();
			
			out.println("sql error<br />");
			out.println(e.getMessage());
			e.printStackTrace(out);
			return;
		} catch (ClassNotFoundException e) {
			out.println("mariadb not found driver<br />");
			out.println(e.getMessage());
			return;
		} catch (UnsupportedEncodingException e) {
			out.println("mariadb not found driver<br />");
			out.println(e.getMessage());
			return;
		} catch (Exception e) {
			throw e;
		}
        
	}
}

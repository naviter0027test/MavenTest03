package tst.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tst.mod.ProjectModel;

public class Faq extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		try {
			req.setAttribute("root", req.getContextPath());
			ProjectModel projectModel = new ProjectModel();
			projectModel.connectMariaDB();
			projectModel.closeMariaDB();
			req.getRequestDispatcher("faq2.jsp").forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
			
			out.println("sql error<br />");
			out.println(e.getMessage());
			return;
		} catch (ClassNotFoundException e) {
			out.println("mariadb not found driver<br />");
			out.println(e.getMessage());
			return;
		} catch (ServletException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
        
	}
}

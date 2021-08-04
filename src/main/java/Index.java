import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tst.mod.*;

public class Index extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		try {
			ProjectModel projectModel = new ProjectModel();
			projectModel.connectMariaDB();
			ArrayList<HashMap> list = projectModel.list();
			
			req.setAttribute("list", list);
			req.setAttribute("root", req.getContextPath());
			
			projectModel.closeMariaDB();
			req.getRequestDispatcher("home.jsp").forward(req, res);
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

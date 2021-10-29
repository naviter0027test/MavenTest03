package tst.admin.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tst.admin.mod.ProjectModel;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class AdminProjectAdd extends HttpServlet {
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
		req.getRequestDispatcher("admin/projectAdd.jsp").forward(req, res);
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
		
		try {
			projectModel.connectMariaDB();
			projectModel.add(req);
			projectModel.closeMariaDB();
			out.println("<meta http-equiv='refresh' content='3; url=admin-project'>");
		    out.println("儲存完成，等待跳轉<br />");
		} catch (ServletException | IOException | SQLException | ClassNotFoundException e) {
			out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}
		//Part filePart = req.getPart("img");
		//out.println(filePart.getContentType());
	}
}

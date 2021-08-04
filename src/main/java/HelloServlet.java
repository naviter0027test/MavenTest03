import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                  throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
 
        out.println(req.getServletPath());
        out.println("<br />");
        out.println(req.getRequestURI());
        out.println("<br />");
        out.println(req.getRequestURL());
        out.println("<br />");
        out.println(req.getContextPath());
        out.println("<br />");
        out.println(req.getQueryString());
        out.println("<br />");
    }
}
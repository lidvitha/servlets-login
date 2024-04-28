import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cookie</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Cookie</h2>");
        out.println("<form action=\"CookieServlet\" method=\"post\">");
        out.println("Cookie Name: <input type=\"text\" id=\"cookiename\" name=\"cookiename\" required><br><br>");
        out.println("Cookie Value: <input type=\"text\" id=\"cookievalue\" name=\"cookievalue\" required><br><br>");
        out.println("<input type=\"submit\" value=\"Add a Cookie\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cookiename");
        String cvalue = request.getParameter("cookievalue");
        Cookie ck = new Cookie(cname, cvalue);
        response.addCookie(ck);
        response.sendRedirect("ListCookie");
    }
}

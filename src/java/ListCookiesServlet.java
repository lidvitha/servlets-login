import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListCookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>List Cookies</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>List Cookies</h2>");
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            out.println("<table border='2'>");
            out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
            for (Cookie cookie : cookies) {
    if (!cookie.getName().equals("JSESSIONID")&& !cookie.getName().equals("Sharan")) {
        out.println("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>");
    }
}

            out.println("</table>");
        } else {
            out.println("<p>No cookies found</p>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}

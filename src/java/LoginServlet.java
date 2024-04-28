import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
HttpSession session = request.getSession();
String username = request.getParameter("username");
 
session.setAttribute("username", username);
Date loginTime = new Date();
session.setAttribute("login_time", loginTime.getTime());
out.println("<h2>Welcome " + username + "</h2>"); 
out.println("<b>Login time: </b>" + loginTime.toString());
out.println("<br>");
out.println("<b>Start time: </b>" + loginTime.toString());
out.println("<form action=\"LogoutServlet\" method=\"post\">");
out.println("<input type=\"submit\" value=\"Logout\">");
}
}
}


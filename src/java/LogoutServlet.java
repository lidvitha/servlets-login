import java.io.IOException; import java.io.PrintWriter; import java.util.Date;
import javax.servlet.ServletException; import javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse; import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
HttpSession session = request.getSession();
long logoutTime = new Date().getTime();
long loginTime = (long) session.getAttribute("login_time");
out.println("<h2>Thank you, " + session.getAttribute("username") + "!</h2>");
out.println("<p><b>Login Time:</b> " + new Date(loginTime).toString() + "</p>");
out.println("<p><b>Logout Time:</b> " + new Date(logoutTime).toString() + "</p>");

long durationInSeconds = (logoutTime - loginTime) / 1000;
long durationMinutes = durationInSeconds / 60;
long durationSeconds = durationInSeconds % 60;
out.println("<b>Duration:</b> " + durationMinutes + " minutes " + durationSeconds + " seconds");
} catch (Exception e) {
throw new ServletException(e);
}
}
}

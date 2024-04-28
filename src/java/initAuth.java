import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class initAuth extends HttpServlet {

    // Process requests
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String uname = request.getParameter("name");
            String pwd = request.getParameter("password");
            Enumeration e = getInitParameterNames();
            int flag = 0;
            while (e.hasMoreElements()) {
                String name = (String) e.nextElement();
                String value = getInitParameter(name);
                if (uname.equals(name) && pwd.equals(value)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                out.println("<h1>Login Successful</h1>");
            } else {
                out.println("<h1>Login Unsuccessful</h1>");
            }
        }
    }

    // GET request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // POST request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Servlet information
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

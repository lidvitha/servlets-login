import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class loginAuth extends HttpServlet {

    // Process requests
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String uname2 = request.getParameter("name");
            String pwd2 = request.getParameter("password");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/5f6";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            String q = "select * from login";
            ResultSet rs = st.executeQuery(q);
            int flag = 0;
            while (rs.next()) {
                String uname1 = rs.getString("Username");
                String pwd1 = rs.getString("Password");
                if (uname1.equals(uname2)) {
                    if (pwd2.equals(pwd1)) {
                        out.println("<h1>welcome " + uname2 + "</h1>");
                        flag = 1;
                        break;
                    } else {
                        out.println("<h1>wrong password</h1>");
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                out.println("<h1>User not found</h1>");
                response.sendRedirect("registration.html");
            }
        } catch (Exception e) {

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

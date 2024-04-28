<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
              try {
            /* TODO output your page here. You may use following sample code. */
             String uname2=request.getParameter("name");
                String pwd2=request.getParameter("password");
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/5f6";
                String username="root";
                String password="";
                Connection con = DriverManager.getConnection(url, username, password);
                Statement st=con.createStatement();
                String q="select * from login";
                ResultSet rs=st.executeQuery(q);
                int flag=0;                
                while(rs.next()){
                String uname1=rs.getString(1);
                String pwd1=rs.getString(2);
                if(uname1.equals(uname2)){

                if(pwd2.equals(pwd1)){
                    out.println("<h1>Login Successful</h1>");
                    flag=1;
                break;
                }
                else{
                out.println("<h1>wrong password</h1>"); flag=1;
                break;
                }
}
}
if(flag==0){
out.println("<h1>User not found</h1>");
response.sendRedirect("registration.html");
}
}
    catch(Exception e){
    }
        %>
    </body>
</html>

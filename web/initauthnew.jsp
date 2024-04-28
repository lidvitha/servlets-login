<%-- 
    Document   : initauthnew
    Created on : 24-Apr-2024, 10:20:24 pm
    Author     : lidvitha
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
              String uname=request.getParameter("uname");
            String pwd=request.getParameter("pwd");
            int flag=0;
             Enumeration e=getInitParameterNames();
          while(e.hasMoreElements())
          {
              String pname=(String)e.nextElement();
              String pvalue=getInitParameter(pname);
              if((pname.equals(uname)) && (pvalue.equals(pwd)))
              {
                  flag=1;
                  break;
              }
          }
          if(flag==1)
              out.println("<h2>Login Succesfull</h2>");
          else
              out.println("<h2>Login Attempt was Unsuccesfull</h2>");
            %>
    </body>
</html>

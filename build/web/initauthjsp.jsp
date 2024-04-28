<%-- 
    Document   : initauthjsp
    Created on : 15-Apr-2024, 11:14:35 pm
    Author     : lidvitha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP</title>
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
              out.println("<h2>Login Succesful</h2>");
          else
              out.println("<h2>Login Unsuccessful</h2>");
            %>
    </body>
</html>

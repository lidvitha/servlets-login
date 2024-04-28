<%-- 
    Document   : calc
    Created on : 15-Apr-2024, 11:38:21 pm
    Author     : lidvitha
--%>

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
           int a  = Integer.parseInt(request.getParameter("num1"));
            int b  = Integer.parseInt(request.getParameter("num2"));
            String op = request.getParameter("op");
            // Class.forName("com.mysql.jdbc.Driver");
             out.println("<h2>");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/5f6";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st=con.createStatement();
            String search = "";
            search+=request.getParameter("num1")+op+request.getParameter("num2");
            String q="select *from calculate";
            ResultSet rs=st.executeQuery(q);
            int flag=0;
            while(rs.next()){
                 String exp1=rs.getString(1);
                 int ans=rs.getInt(2);
                  if(search.equals(exp1)){
                       out.println("<h2>From The Database<br>"+search+"="+ans);
//                       out.println( "<h2>Result fetched from database</h2>");
                        flag=1;
                        break;
                     }
               }
             if(flag==0){
                    int ans=0;
              switch(op){
                case "+":ans=a+b;break;
                case "-":ans=a-b;break;
                case "*":ans=a*b;break;
                case "/":ans=a/b;break;
                case "%": ans=a%b;break;}
            String exp2=search;
            out.println("<h2>Performing Calculation<br></h2>"+a+op +b+"="+ans);
             st.executeUpdate("insert into calculate values('"+exp2+"','"+ans+"')");
             out.println("<br>");
            out.println("Updated in the Database ");  
            }}
             catch (Exception e)
            {}
           %>
    </body>
</html>

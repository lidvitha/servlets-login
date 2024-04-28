/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class Calculator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String number1=request.getParameter("num1");
            String number2=request.getParameter("num2");
            String op1=request.getParameter("op");
            String exp2=number1+op1+number2;
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/5f6";
            String username="root";
            String password="";
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st=con.createStatement();
            String q="select * from calculate";
           ResultSet rs=st.executeQuery(q);
            int flag=0;
                 while(rs.next()){
                 String exp1=rs.getString("exp");
                    int ans=rs.getInt(2);
             if(exp2.equals(exp1)){
        out.println("From database<br>"+exp2+"="+ans);
        flag=1;
        break;
    }
}
if(flag==0){
    int n1=Integer.parseInt(number1);
    int n2=Integer.parseInt(number2);
    int ans=0;
    switch(op1){
case "+":
ans=n1+n2;
break;
case "-":
ans=n1-n2;
break;
case "*":
ans=n1*n2;
break;
case "/":
ans=n1/n2;
break;
case "%":
    ans=n1%n2;
}
    String exp3=number1+op1+number2;
     out.println("By calculation<br>"+n1+op1+n2+"="+ans);
     st.executeUpdate("insert into calculate values('"+exp3+"','"+ans+"')");
     String q1="insert into calculate values('"+exp3+"','"+ans+"')";
      ResultSet rs1=st.executeQuery(q1);

        }
    } catch(Exception e)
    {}
}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

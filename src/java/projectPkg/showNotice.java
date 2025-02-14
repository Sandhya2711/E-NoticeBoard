/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bitub
 */
public class showNotice extends HttpServlet {

     Connection con;
    ResultSet rs;
    PreparedStatement ps;
    @Override
    public void init()
    {
         try
         {
             Class.forName("com.mysql.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3308/digitalnotice","root",""); 
             String sqlqr="select noticeid,title,message,uid,postdate,dept from notices where dept=?";
             ps=con.prepareStatement(sqlqr); 
         }catch(Exception e){e.printStackTrace();}
    }
    public void destroy()
    {
         try
         {
             con.close();
         }catch(Exception e){e.printStackTrace();}
    }
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
         String Dept=request.getParameter("dept");
        
         try
         {
            ps.setString(1,Dept);
            rs=ps.executeQuery();
            out.println("<html>");
            out.println("<body>");
            out.println("<h2>"+Dept+" Department Notices </h2>");
            out.println("<hr>");
            out.println("<table border=2>");
            while(rs.next()){
                String s1=rs.getString(1);//noticeid
                String s2=rs.getString(2);//title
                String s3=rs.getString(3);//msg
                String s4=rs.getString(4);//uid
                String s5=rs.getString(5);//date
                String s6=rs.getString(6);//dept
                out.println("<tr>");
                out.println("<td>Id</td>");
                out.println("<td>"+s1+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Title</td>");
                out.println("<td>"+s2+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Message</td>");
                out.println("<td>"+s3+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>PostedBy</td>");
                out.println("<td>"+s4+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Date</td>");
                out.println("<td>"+s5+"</td>");
                out.println("</tr>");
                 out.println("<tr>");
                out.println("<td>Department</td>");
                out.println("<td>"+s6+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td></td><td></td>");
                out.println("</tr><br>");
                        
            }
            out.println("</table>");
            out.println("<hr>");
            out.println("<a href=showDept>Dept-List</a>");
            out.println("<a href=studenthome.jsp>Home</a>");
            out.println("</body>");
            
            out.println("</html>");
            
         }
         catch(Exception e)
         {
             //e.printStackTrace();
             out.println(e);
         }
        
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

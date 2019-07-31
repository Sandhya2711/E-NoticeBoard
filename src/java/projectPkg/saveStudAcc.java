
package projectPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class saveStudAcc extends HttpServlet {

     Connection con;
    PreparedStatement ps;
    @Override
    public void init()
    {
         String sqlqr="insert into students values(?,?,?,?,?,'pending')";
         try
         {
             Class.forName("com.mysql.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3308/digitalnotice","root",""); 
             
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
        String uid=request.getParameter("uid");
        String pwd=request.getParameter("pwd");
        String name=request.getParameter("name");
        String branch=request.getParameter("branch");
        String sem=request.getParameter("sem");
        
        
         try
         {
            
            ps.setString(1, uid);
            ps.setString(2, pwd);
            ps.setString(3, name);
            ps.setString(4, branch);
            ps.setInt(5,Integer.parseInt(sem));
            ps.executeUpdate();
          
           // response.sendRedirect("/studregister?msg='Registered Successfully'");
            out.println("Account created");

         }
         catch(Exception e)
         {
            // response.sendRedirect("/studregister?msg='Registered Failed'");
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

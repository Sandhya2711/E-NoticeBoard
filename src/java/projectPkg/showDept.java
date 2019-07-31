
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

public class showDept extends HttpServlet {

    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    @Override
    public void init()
    {
         String sqlqr="select distinct(dept) from faculties where uid in(select uid from notices)";
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
        
         try
         {
            rs=ps.executeQuery();
             out.println("<html>");
            out.println("<body>");
            out.println("<h3>Department</h3>");
            while(rs.next())
            {
                String s1=rs.getString("dept");
                out.println("<a href='showNotice?dept="+s1+"'>"+s1+"</a><br>");
            }
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

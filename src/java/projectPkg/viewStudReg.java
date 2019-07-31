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


public class viewStudReg extends HttpServlet {

    Connection con;
    PreparedStatement ps;ResultSet rs;
    @Override
    public void init()
    {
         String sqlqr="select * from students where status='pending'";
         try
         {
             Class.forName("com.mysql.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3308/digitalnotice","root",""); 
             
             ps=con.prepareStatement(sqlqr); 
         }catch(Exception e){//e.printStackTrace();
         System.out.println(e);}
    }
    public void destroy()
    {
         try
         {
             con.close();
         }catch(Exception e){//e.printStackTrace();
             System.out.println(e);}
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
            out.println("<h3>Pending Accounts</h3>");
            out.println("<table border=2>");
            out.println("<tr>");
            out.println("<td>Id</td>");
            out.println("<td>Name</td>");
            out.println("<td>Branch</td>");
            out.println("<td>Sem</td>");
            out.println("</tr>");
            while(rs.next()){
                String s1=rs.getString("uid");
                String s2=rs.getString("uname");
                String s3=rs.getString("branch");
                String s4=rs.getString("sem");
                out.println("<tr>");
                out.println("<td>"+s1+"</td>");
                out.println("<td>"+s2+"</td>");
                out.println("<td>"+s3+"</td>");
                out.println("<td>"+s4+"</td>");
                out.println("<td><a href=enableStud?id="+s1+">Enable</a></td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("<a href=adminhome.jsp>Home</a>");
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

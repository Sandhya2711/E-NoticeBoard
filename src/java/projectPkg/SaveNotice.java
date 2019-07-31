
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author bitub
 */
public class SaveNotice extends HttpServlet {

     Connection con;
    PreparedStatement ps;
    @Override
    public void init()
    {
          
         String sqlqr="insert INTO `notices`( `title`, `message`, `uid`, `postdate`)VALUES (?,?,?,?)";
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
        
        HttpSession session=request.getSession();
        String uid=(String)session.getAttribute("hodId");
        
        java.util.Date dt= new java.util.Date();
         long val=dt.getTime();
         java.sql.Date postDate=new java.sql.Date(val);
         
        String title=request.getParameter("title");
        String msg=request.getParameter("msg");
        
        
        
         try
         {
            
            ps.setString(1,title);
            ps.setString(2,msg);
            ps.setString(3,uid);
            ps.setDate(4,postDate);
            ps.executeUpdate();
          
           // out.println("Notice stored");
            response.sendRedirect("noticepost.jsp");

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


package projectPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class verifyUser extends HttpServlet {

     Connection con;
    PreparedStatement ps;ResultSet rs;
    @Override
    public void init()
    {
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String id=context.getInitParameter("uid");
        String pwd=context.getInitParameter("pwd");
        
         try
         {
             //Class.forName("com.mysql.jdbc.Driver");
             // con=DriverManager.getConnection("jdbc:mysql://localhost:3308/digitalnotice","root",""); 
             Class.forName(driver);
             con=DriverManager.getConnection(url,id,pwd);
             
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
    
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
       String userId=req.getParameter("uid");
       String password=req.getParameter("pwd");
       
       String utype=req.getParameter("utype");
       String savePwd=req.getParameter("save");
       String msg=null;
       
       ServletConfig config=getServletConfig();
       String adminId=config.getInitParameter("adminId");
       String adminPwd=config.getInitParameter("adminPwd");
       
       
       if(utype.equals("Admin"))
       {
           if(userId.equals(adminId)&& password.equals(adminPwd))    
           {
               //to store data in cookie
               if(savePwd!=null)
               {
                Cookie c1=new Cookie("uid",userId);
                Cookie c2=new Cookie("pwd",password);
                c1.setMaxAge(60*60*24*7);
                c2.setMaxAge(60*60*24*7);
                res.addCookie(c1);
                res.addCookie(c2);}
               res.sendRedirect("adminhome.jsp");
           }
           else
           {
               msg="invalid Admin";
           }
       }
       else if(utype.equals("HOD"))
       {
           
           String qr="select * from faculties where uid=? and password=? and status='activated'";
           try
           {
               ps=con.prepareStatement(qr);
               ps.setString(1, userId);
               ps.setString(2, password);
               rs=ps.executeQuery();
               if(rs.next())
               {
                   if(savePwd!=null)
                   {
                       Cookie c1=new Cookie("uid",userId);
                       Cookie c2=new Cookie("pwd",password);
                       c1.setMaxAge(60*60);
                       c2.setMaxAge(60*60);
                       res.addCookie(c1);
                       res.addCookie(c2);
                       
                   }
                   HttpSession session=req.getSession();
                   session.setAttribute("hodId", userId);
                   session.setAttribute("dept",rs.getString("dept"));
                   
                   res.sendRedirect("facultyHome.jsp");
               }
               else
               {
                   res.sendRedirect("login.jsp");
               }
           }catch(Exception e){e.printStackTrace();}
       }
       else if(utype.equals("Student"))
       {
            String qr="select * from students where uid=? and password=? and status='activated'";
           try
           {
               ps=con.prepareStatement(qr);
               ps.setString(1, userId);
               ps.setString(2, password);
               rs=ps.executeQuery();
               if(rs.next())
               {
                    if(savePwd!=null)
                   {
                       Cookie c1=new Cookie("uid",userId);
                       Cookie c2=new Cookie("pwd",password);
                       c1.setMaxAge(60*60);
                       c2.setMaxAge(60*60);
                       res.addCookie(c1);
                       res.addCookie(c2);
                       
                   }
                    
                   HttpSession session=req.getSession();
                   session.setAttribute("studId", userId);
                   
                   res.sendRedirect("studHome.jsp");
               }
               else
               {
                   res.sendRedirect("login.jsp");
               }
           }catch(Exception e){e.printStackTrace();}   
       }
        
       //PrintWriter out=res.getWriter();
       //out.println("<h2>"+msg+"</h2>");
       
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
    }

   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

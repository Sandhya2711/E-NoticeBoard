<%@page import="java.sql.* "%>
<%@page import="javax.servlet.ServletContext" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
       ServletContext context=getServletContext();
       String driver=context.getInitParameter("driver");
       String url=context.getInitParameter("url");
       String uid=context.getInitParameter("uid");
       String pwd=context.getInitParameter("pwd");
       
       Class.forName(driver);
       Connection con=DriverManager.getConnection(url, uid,"");
       String sql="select * from students";
       PreparedStatement ps=con.prepareStatement(sql);
       ResultSet rs=ps.executeQuery();
%>
<%@include file="./adminheader.jsp"%>
	 
	<div class="contact_info_container" margin-left="400px">
            <br><br><br><br><br>		
            <div class="container">
                            <h1>Student List</h1>
             </div>
            <div>
            <table style='{border:"3";width:"3";cellspacing:"5";cellpadding:"6";margin:"100";}'>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Password</th>
                    <th>Name</th>
                    <th>Branch</th>
                    <th>Sem</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
<%
        while(rs.next()){
        String s1=rs.getString(1);
        String s2=rs.getString(2);
        String s3=rs.getString(3);
        String s4=rs.getString(4);
        String s5=rs.getString(5);
        String s6=rs.getString(6);
%>
                <tr>
                    <td><% out.println(s1); %></td>
                    <td><% out.println(s2); %></td>
                    <td><% out.println(s3); %></td>
                    <td><% out.println(s4); %></td>
                    <td><% out.println(s5); %></td>
                    <td><% out.println(s6); %></td>
                </tr>
<%
    }
      con.close();
%>
            </tbody>
            
        </table>
        </div>  
	</div>
    <br><br><br>
	<!-- Footer -->
<%@include file="./footer.jsp"%>
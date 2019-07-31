<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   String hodId=(String)session.getAttribute("hodId");
   if(hodId==null)
   {
       response.sendRedirect("login.jsp");
   }
%>
<%@include file="./HODheader.jsp"%>
	 
	<div class="contact_info_container" margin-left="400px">
            <br><br><br><br><br>		
            <div class="container">
                            <h1>Welcome <%=hodId%></h1>
                            
                        </div>
	</div>
    <br><br><br>
	<!-- Footer -->

	<%@include file="./footer.jsp"%>
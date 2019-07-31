
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     String v1="",v2="";
     Cookie ck[]=request.getCookies();
     if(ck!=null)
     {
       for(Cookie c:ck)
       {
          String s1=c.getName();
          if(s1.equals("uid"))
          {
            v1=c.getValue();
          }
          else if(s1.equals("pwd"))
          {
            v2=c.getValue();        
          }
        }
}
%>
<%@include file="./header.jsp"%>
	 
	<div class="contact_info_container" margin-left="400px">
			<div class="container">
				<div class="row">
                                    <br><br><br><br>
					<!-- Contact Form -->
                                       
					<div >
						<div class="contact_form" >
                                                        
                                                    <div class="contact_info_title"><br><br><br><br><br><br><h2>LogIn Form</h2></div><br><br>
							<form action="verifyUser" method="get" class="comment_form">
								
									<div class="form_title">UserId</div>
									<input type="text" class="comment_input" required="required" name="uid" value="<%=v1%>">
                                                               <br><br>
								
									<div class="form_title">Password</div>
                                                                        <input type="password" class="comment_input" required="required" name="pwd" value="<%=v2%>">
                                                                <br><br>
								
									<div class="form_title">UserType</div>
                                                                        <select name="utype">
                                                                            <option>Admin</option>
                                                                            <option>HOD</option>
                                                                            <option>Student</option>
                                                                        </select>
                                                                <br><br>
                                                                <div class="form_title">Remember Password &nbsp;&nbsp;
									<input type="checkbox" class="comment_input" value="yes" name="save"></div>
                                                                <br><br>
								
									<button type="submit" class="comment_button trans_200">Login</button>
								
							</form>
						</div>
					</div>
                                        
					
				</div>
			</div>
		</div>
	</div>
    <br><br><br>
	<!-- Footer -->

	<%@include file="./footer.jsp"%>
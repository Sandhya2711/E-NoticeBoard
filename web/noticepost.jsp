<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   String hodId=(String)session.getAttribute("hodId");
   String hodDept=(String)session.getAttribute("dept");
   if(hodId==null)
   {
       response.sendRedirect("login.jsp");
   }
%>
<%@include file="./HODheader.jsp"%>
	<div class="contact_info_container" margin-left="400px">		
   
            <div class="contact">    
            <div class="contact_info_container">
			<div class="container">
				<div class="row">

					<!-- Contact Form -->
					<div class="col-lg-6">
						<div class="contact_form">
                                                    <div class="contact_info_title"><h2>Notice Form</h2></div>
							<form action="SaveNotice" class="comment_form" method="post">
								
								<div>
									<div class="form_title">Title</div>
									<input type="text" name="title" class="comment_input" required="required">
                                                                </div>
								<div>
									<div class="form_title">Message</div>
									<textarea  name="msg" class="comment_input comment_textarea" required="required" ></textarea>
                                                                </div>
								<div>
									<button type="submit" class="comment_button trans_200">Post notice</button>
                                                                </div>
							</form>
						</div>
					</div>
                                </div>
                        </div>
	     </div>
        </div>
    <br><br><br>
   <%@include file="./HODheader.jsp"%>	
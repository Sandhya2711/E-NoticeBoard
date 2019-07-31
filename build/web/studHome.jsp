<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession ses=request.getSession();
String studId=(String)ses.getAttribute("studId");
%>
<%@include file="./studheader.jsp" %>

	<!-- Menu -->

	<div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
		<div class="menu_close_container"><div class="menu_close"><div></div><div></div></div></div>
		<div class="search">
			<form action="#" class="header_search_form menu_mm">
				<input type="search" class="search_input menu_mm" placeholder="Search" required="required">
				<button class="header_search_button d-flex flex-column align-items-center justify-content-center menu_mm">
					<i class="fa fa-search menu_mm" aria-hidden="true"></i>
				</button>
			</form>
		</div>
		<nav class="menu_nav">
<!--			<ul class="menu_mm">
				<li class="menu_mm"><a href="adminhome.jsp">Home</a></li>
				<li class="menu_mm"><a href=#>Create HOD Account</a></li>
				<li class="menu_mm"><a href=#>View Notice</a></li>
				<li class="menu_mm"><a href="index.jsp">logout</a></li>
				
				<li class="menu_mm"><a href="contact.html">Contact</a></li>
			</ul>-->
		</nav>
	</div>
	 
	<div class="contact_info_container" margin-left="400px">
            <br><br><br><br><br>		
            <div class="container">
                            <h1>Welcome <%=studId %></h1>
                            
                        </div>
	</div>
    <br><br><br>
	<!-- Footer -->

	<%@include file="./footer.jsp" %>
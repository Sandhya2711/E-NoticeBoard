
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./header.jsp"%>
	 
	<div class="contact_info_container" margin-left="400px">
			<div class="container">
				<div class="row">
                                    <br><br><br><br>
					<!-- Contact Form -->
                                       
					<div >
						<div >
                                                        
                                                    <div class="contact_info_title"><br><br><br><br><br><br><h2>Student Register Form</h2></div><br><br>
							<form action="saveStudAcc" class="comment_form">
								
									<div class="form_title">UserName</div>
									<input type="text" class="comment_input" required="required" name="uid">
                                                               <br><br>
								
									<div class="form_title">Password</div>
									<input type="password" class="comment_input" required="required" name="pwd" >
                                                                <br><br>
								
									 <div class="form_title">Name</div>
	  			                                        <input type="name"  required="required" name="name">
                                                                <br><br> 
                                                  <div class="form_title">Branch</div>
                                                       <select name="branch">
                                                        <option>Computer Science</option>
                                                         <option>Information Technology</option>
                                                         <option>Civil</option>
                                                         <option>Electrical</option>
                                                           <option>Mechanical</option>
                                                       </select>                                                             
                                            <br><br> 
                                             <div class="form_title">Sem</div>
                                                       <select name="sem">
                                                        <option>1</option>
                                                         <option>2</option>
                                                         <option>3</option>
                                                         <option>4</option>
                                                           <option>5</option>
                                                           <option>6</option>
                                                           <option>7</option>
                                                           <option>8</option>
                                                       </select>                                                             
                                            <br><br> 
                                            <div>
			                     <button type="submit" class="comment_button trans_200">Register</button>
	                        	    </div>
								
									
								
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
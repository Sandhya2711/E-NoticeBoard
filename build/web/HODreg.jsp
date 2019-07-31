<%@include file="./adminheader.jsp"%>
	<div class="contact_info_container" margin-left="400px">
            <br><br><br><br><br>
			<div class="container">
                            <h2>HOD Register</h2>
                            <div>
                            <form action="saveHODAcc" method="get" >
                                <div class="form_title">UserId</div>
		         		<input type="text"  required="required" name="uid">
                                        <br><br>
								
                                <div class="form_title">Password</div>
	  			    <input type="password"  required="required" name="pwd">
                                    <br><br>
                                <div class="form_title">Name</div>
	  			    <input type="name"  required="required" name="name">
                                    <br><br> 
                                <div class="form_title">Department</div>
                                          <select name="dept">
                                           <option>Exam</option>
                                          <option>Sports</option>
                                          <option>Culturer</option>
                                          <option>English</option>
                                          <option>IT</option>
                                          <option>Mechanical</option>
                                           </select>                                                             
                                            <br><br> 
                                            <div>
			                     <button type="submit" class="comment_button trans_200">Create Account</button>
	                        	    </div>
                            </form>
                            </div>
                            
                        </div>
	</div>
    <br><br><br>
	<!-- Footer -->

	<%@include file="./footer.jsp"%>
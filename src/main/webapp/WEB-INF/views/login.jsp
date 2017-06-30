<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 import="com.qa.models.Customer"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">

  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Online Shopping </title>
    <link rel="stylesheet" href="css/temp.css">
    <link rel="stylesheet" href="css/form.css">
  </head>
  <body>
    
    <%!
  		Customer c;
  	%>
  	
  	<%
 		c = (Customer) session.getAttribute("logged_in_customer");
  		if (c.getFirstName() != null) {
 	 %>
<%--  	 	<jsp:include page="nav_bar_loggedin.jsp" /> --%>
 	 	<jsp:include page="temp_head_in.jsp" />
 	 <%
  		}
  		else
  		{
 	 %>
<%-- 		<jsp:include page="nav_bar_loggedout.jsp" /> --%>
			<jsp:include page="new_temp_head.jsp" />
	<%
  		}
	%>

	<div class="callout large" id="body">
		<div class="row column" style="text-align:center">


			<div class="medium-6">
				<h3>Please login using your stored credentials</h3>

				<form action="loginProcess" method="post" class="val">

					<p>${alert}</p>
					<label>Email ID * </label> 
					<input type="text" placeholder="Enter Email" name="email" id="email" required="required" /> 
					<label>Password * </label> 
					<input type="password" placeholder="Enter Password" name="password" id="password" required="required" /> 
					<br><br> <input type="submit" class="button expanded" value="Login">

				</form>
			</div>

			<div class="medium-6">

				<p>New Customer?</p>
				<a href="/register" class="button large expanded">Register</a>

			</div>


		</div>
	</div>


	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="js/elsevier.js"></script>
	<script>
		$(document).foundation();
	</script>
<%--   <jsp:include page="footer.jsp"/> --%>
		<jsp:include page="new_temp_footer.jsp" />
</body>
</html>



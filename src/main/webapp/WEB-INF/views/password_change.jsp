<!doctype html>
<%@page import="com.qa.models.Customer"%>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Online Shopping</title>
<link rel="stylesheet" href="css/temp.css">
<link rel="stylesheet" href="css/form.css">
</head>
<body>

	<%!Customer c;%>

	<%
		c = (Customer) session.getAttribute("logged_in_customer");
		if (c.getFirstName() != null) {
	%>
	<%--  	 	<jsp:include page="nav_bar_loggedin.jsp" /> --%>
	<jsp:include page="temp_head_in.jsp" />

	<div class="callout large" id="body">
		<div class="row column text-center">

			<h3>
				You have logged in as
				<%=c.getFirstName()%></h3>
		</div>


		<div class="row column">

			<form action="/updatePassword" method="post" class="val">
				<div class="medium-6">
					<h3>Account details</h3>


					<label>Type In New Password * </label> <input type="password"
						placeholder="Enter New Password" name="password" id="password"
						value="" />

				</div>



				<input type="submit" class="button create account"
					value="Update Password">

			</form>



		</div>
	</div>
	<%
		} else {
	%>
	<%-- 		<jsp:include page="nav_bar_loggedout.jsp" /> --%>
	<jsp:include page="new_temp_head.jsp" />

	<h2>Please login to view this page.</h2>
	<%
		}
	%>



	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="js/elsevier.js"></script>
	<script>
		$(document).foundation();
	</script>

	<%--    <jsp:include page="footer_loggedin.jsp"/> --%>
	<jsp:include page="temp_foot_in.jsp" />
</body>
</html>



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

	<%--     <jsp:include page="nav_bar_loggedin.jsp" /> --%>
	<jsp:include page="temp_head_in.jsp" />

	<%
		} else {
	%>
	<%--     	<jsp:include page="nav_bar_loggedout.jsp" /> --%>
	<jsp:include page="new_temp_head.jsp" />
	<%
		}
	%>

	<%
		if (c.getFirstName() != null) {
	%>

	<div class="callout large" id="body" style="text-align:center">
		<div class="row column text-center">

			<h3>
				You have logged in as
				<%=c.getFirstName()%></h3>
		</div>


		<div class="row column">

			<form action="/updateProfile" method="post" class="val">
				<div class="medium-6">
					<h3>Account details</h3>


					<label>Firstname * </label> <input type="text"
						placeholder="Enter firstname" name="firstName" id="firstName"
						value="<%=c.getFirstName()%>" /> <label>Lastname * </label> <input
						type="text" placeholder="Enter lastname" name="lastName"
						id="lastName" value="<%=c.getLastName()%>" /> <label>Email
						ID * </label> <input type="text" placeholder="Enter email" name="email"
						id="email" value="<%=c.getEmail()%>" required="required" />

				</div>



				<br><input type="submit" class="button create account"
					value="Update Account">

			</form>

		</div>

	</div>

	<%
		} else {
	%>

	Please login to see this page.

	<%
		}
	%>

	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="js/elsevier.js"></script>
	<script>
		$(document).foundation();
	</script>

	<%
		c = (Customer) session.getAttribute("logged_in_customer");
		if (c.getFirstName() != null) {
	%>
	<%--  	 	<jsp:include page="footer_loggedin.jsp" /> --%>
	<jsp:include page="temp_foot_in.jsp" />
	<%
		} else {
	%>
	<%-- 		<jsp:include page="footer.jsp" /> --%>
	<jsp:include page="new_temp_footer.jsp" />
	<%
		}
	%>


</body>
</html>



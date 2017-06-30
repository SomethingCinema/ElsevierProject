<!doctype html>
<%@page import="com.qa.models.Customer"%>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="refresh" content="1; url=/" />
<title>Online Shopping</title>
<link rel="stylesheet" href="css/temp.css">
</head>
<body>

	<%!Customer c;%>


	<%
		c = (Customer) session.getAttribute("logged_in_customer");
		if (c.getFirstName() != null) {
	%>


	<%--     <jsp:include page="nav_bar_loggedin.jsp" /> --%>
	<jsp:include page="temp_head_in.jsp" />

	<div class="callout large">
		<div class="row column text-center">

			<h3>
				You have logged in as
				<%=c.getFirstName()%></h3>
		</div>
	</div>

	<%
		} else {
	%>

	<%--     <jsp:include page="nav_bar_loggedout.jsp" /> --%>
	<jsp:include page="new_temp_head.jsp" />

	<h3>Please login to view this page.</h3>


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
		}
	%>

</body>
</html>



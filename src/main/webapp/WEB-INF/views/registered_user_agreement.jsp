<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.qa.models.Customer"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Online Shopping</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/form.css" type="text/css">
</head>
<body>

	<%!Customer c;%>

	<%
		c = (Customer) session.getAttribute("logged_in_customer");
		if (c.getFirstName() != null) {
	%>
	<jsp:include page="nav_bar_loggedin.jsp" />
	<%
		} else {
	%>
	<jsp:include page="nav_bar_loggedout.jsp" />
	<%
		}
	%>

	<div class="callout large">
		<div class="row column">

			<!-- Trigger/Open The Modal -->
			<button id="myBtn">Open Modal</button>

			<!-- The Modal -->
			<div id="myModal" class="modal">

				<!-- Modal content -->
				<div class="modal-content">
					<span class="close">&times;</span>
					<p>Some text in the Modal..</p>
				</div>

			</div>


		</div>
	</div>


	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="js/elsevier.js"></script>
	<script>
		$(document).foundation();
	</script>

	<jsp:include page="footer.jsp" />
</body>
</html>



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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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

			<form action="/registerProcess" method="post" class="val">
				<div class="medium-6">
					<h3>Create an account</h3>


					<p>${alert}</p>
					<label>First Name * </label> <input type="text" required
						pattern="[a-zA-Z]+" placeholder="Enter First Name"
						name="firstName" id="firstName" required="required" /> <label>Last
						Name * </label> <input type="text" required pattern="[a-zA-Z]+"
						placeholder="Enter Last Name" name="lastName" id="lastName" /> <label>Email
						ID * </label> <input type="text" placeholder="Enter Email" name="email"
						id="email" required="required" /> <label>Password * </label> <input
						type="password" required
						pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
						placeholder="Enter Password (must have uppercase, lowercase, and number)"
						name="password" id="password"
						title="Must have uppercase, lowercase, and number" />

				</div>

				<div class="medium-6">


					<input type="checkbox" name="agreement" required /> I have read
					and understood the <a href="#"
						onclick="document.getElementById('id01').style.display='block'">Registered
						User Agreement </a> and agree to be bound by all of its terms.

				</div>

				<input type="submit" class="button create account"
					value="Create Account">

			</form>


			<div id="id01" class="w3-modal w3-animate-opacity">
				<div class="w3-modal-content">
					<div class="w3-container">
						<span
							onclick="document.getElementById('id01').style.display='none'"
							class="w3-button w3-display-topright">&times;</span>
						<p>By registering for an account with Holy Crud Booksellers,
							you agree to follow our terms of service.</p>
						<p>With a HCB account, you are ensured the raddest experience
							ever and will have the best time. By clicking the links, you
							hereby give HCB your soul and will never actually receive the
							books you click on. We are so glad that you chose to go with our
							bookstore!</p>
					</div>
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



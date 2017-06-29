<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Online Shopping</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<%!
  		Customer c;
  	%>
  	
  	<%
 		c = (Customer) session.getAttribute("logged_in_customer");
  		if (c.getFirstName() != null) {
 	 %>
 	 	<jsp:include page="nav_bar_loggedin.jsp" />
 	 <%
  		}
  		else
  		{
 	 %>
		<jsp:include page="nav_bar_loggedout.jsp" />
	<%
  		}
	%>

	<div class="callout large">
	
		<div class="row column text-center">
			<div class="medium-6 columns22">
				<h3>Don't have an account? Register here!</h3>
				<p>${alertRegister}</p>
				<form action="/registerThroughCheckout" method="post" class="val">
					<input type="hidden" name="order_total" value="${order_total}" /> 
					<input type="hidden" name="book_counts" value="${book_counts}" /> 
				
					<label>First Name * </label>
		            <input type="text" placeholder="Enter First Name" name="firstName" id="firstName"/> 
		            <label>Last Name * </label>
		            <input type="text" placeholder="Enter Last Name" name="lastName" id="lastName"/> 
		            <label>Email ID * </label>
		            <input type="text" placeholder="Enter Email" name="email" id="email"/> 
		            <label>Password * </label>
					<input type="password" placeholder="Enter Password" name="password" id="password"/>
            		<input type="submit" class="button expanded" value="Register" />		
            
		            <div class="medium-6">
		           
			         	 <input type="checkbox" name="agreement"  required/> I have read and understood the 
			         	 <a href="/registered_user_agreement">Registered User Agreement </a> and agree to be bound by all of its terms. 
		         
		            </div>
      		
      		
				</form>
			</div>
		</div>
		
		<div class="row column text-center">
			<div class="medium-6 columns22">
				<h3>Already have an account? Login here!</h3>
				<p>${alertLogin}</p>
				<form action="/loginThroughCheckout" method="post" class="val">
					<input type="hidden" name="order_total" value="${order_total}" /> 
					<input type="hidden" name="book_counts" value="${book_counts}" /> 
					
					
					<label>Email ID * </label> 
					<input type="text" placeholder="Enter email" name="email" id="email" /> 
					<label>Password * </label> 
					<input type="password" placeholder="Enter Password" name="password" id="password" /> 
					<input type="submit" class="button expanded" value="Login" />
				</form>
			</div>
		</div>
	</div>

	<br />
	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="js/elsevier.js"></script>
	<script>
		$(document).foundation();
	</script>

	<jsp:include page="footer.jsp" />
</body>
</html>



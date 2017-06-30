<!doctype html>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qa.models.Book"%>
<%@page import="com.qa.models.Customer"%>
<html class="no-js" lang="en">


<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Shopping Cart | Week 3</title>
<link rel="stylesheet" href="css/style.css">


</head>
<body>




	<%
		double orderTotal = (Double) request.getAttribute("order_total");
		Customer c;
	%>

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

	<br>
	<!-- You can now combine a row and column if you just need a 12 column row -->
	<div class="row columns">
		<nav aria-label="You are here:" role="navigation">
			<ul class="breadcrumbs">

				<li><a href="/">Home</a></li>
				<li><span class="show-for-sr">Current: </span> Payment Details
				</li>
			</ul>
		</nav>
	</div>
	<form action="/completePayment" method="post">

		<div class="row">

			<div class="medium-6 columns">

				<h2>Payment Details</h2>
				<h3>Billing Address</h3>
				<div class="row small-up-shiping">
					<div class="column">
						<!--  <input type="checkbox" class="ba" checked="checked" /> Different from shipping address -->
					</div>

					<div class="columns">
						<label> First Name * </label> <input type="text" name="firstName"
							id="firstName" size="30" />
					</div>
					<div class="columns">
						<label> Last Name * </label> <input type="text" name="lastName"
							id="lastName" size="30" />
					</div>

					<div class="column">
						<label> Address 1 * </label> <input type="text"
							name="addressLine1" id="addressLine1" size="30" />
					</div>
					<div class="column">
						<label> Address 2 </label> <input type="text" name="addressLine2"
							id="addressLine2" size="30" />
					</div>
					<div class="column">
						<label> City * </label> <input type="text" name="city" id="city"
							size="30" />
					</div>
					<div class="column">
						<label> Credit Card Number * </label> <input type="text" name="cc"
							id="cc" size="30" />
					</div>


					<!--
          <div class="column">
            <input type="checkbox" name="same" id="same"/> My billing and shipping address are the same
          </div> -->

				</div>

				<div class="row small-up-4">

					<div class="column"></div>

				</div>

				<hr>

			</div>
			<div class="medium-6 large-5 columns">
				<h3>Order Summary</h3>
				<p></p>

				<div class="row">
					<div class="small-3 columns">
						<label for="middle-label" class="middle">Cart Total</label>
					</div>
					<div class="small-3 columns">

						<label for="middle-label" class="middle" id="cart_total_label">$<%=orderTotal%></label>
					</div>

				</div>

				<div class="row">
					<div class="small-3 columns">
						<label for="middle-label" class="middle">VAT </label>
					</div>
					<div class="small-3 columns">
						<label for="middle-label" class="middle">Applicable Tax </label>
					</div>

				</div>

				<div class="row">
					<div class="small-3 columns">
						<label for="middle-label" class="middle">Order Total </label>
					</div>
					<div class="small-3 columns">

						<label for="middle-label" class="middle" id="order_total_label">$<%=orderTotal%></label>
					</div>
				</div>


				<input type="hidden" name="order_total" value="<%=orderTotal%>" />
				<input type="submit" class="button large expanded" value="Checkout" />

			</div>


		</div>
	</form>
	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="js/elsevier.js"></script>
	<script src="js/update_cart.js"></script>

	<script src="js/validations.js"></script>
	<script>
		$(document).foundation();
	</script>



	<jsp:include page="footer_loggedin.jsp" />
</body>

</html>



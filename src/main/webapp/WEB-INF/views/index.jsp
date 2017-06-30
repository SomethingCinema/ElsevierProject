<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.qa.models.Book"%>
<%@page import="com.qa.models.Customer"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Online Shopping</title>
<link rel="stylesheet" href="css/style.css" />
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
	<%-- 		<jsp:include page="nav_bar_loggedout.jsp" /> --%>
	<jsp:include page="new_temp_head.jsp" />
	<%
		}
	%>



<div id="body">
	<div class="row column text-center">
		
			<h2>
				Our Newest Books


				<%
				Iterable<Book> books = (Iterable<Book>) session.getAttribute("books");
			%>


			</h2>
			<hr>
		</div>

		<div class="row small-up-2 medium-up-3 large-up-4">

			<%
				for (Book book : books) {
			%>
			<div class="column">
				<fmt:setLocale value="en_US" scope="session" />

				<a href="/bookDetails?bookId=<%=book.getBookId()%>"><img
					class="thumbnail" src="<%=book.getBookImage()%>"
					style="height: 250px; width: auto;"></a>
				<h5 style="height: 50px; overflow: hidden; text-overflow: ellipses;"><%=book.getTitle()%></h5>
				<p>
					<fmt:formatNumber type="currency" value="<%=book.getPrice()%>"></fmt:formatNumber>
				</p>
				<a href="/bookDetails?bookId=<%=book.getBookId()%>"
					class="button expanded">View book details</a>
				<!--  a href="/addToCart?bookId=" class="button expanded">Add to Cart</a>-->
			</div>
	</div>
			<%
				}
			%>
		</div>

	<hr>

	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="js/elsevier.js"></script>
	<script>
		$(document).foundation();
	</script>

	<%
		c = (Customer) session.getAttribute("logged_in_customer");
		if (c.getFirstName() != null) {
	%>
	<jsp:include page="footer_loggedin.jsp" />
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

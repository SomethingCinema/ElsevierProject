<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.qa.models.Customer" pageEncoding="ISO-8859-1"%>
<%@page import="com.qa.models.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/temp.css" />
<title>Contact</title>
</head>
<body>

	<%!Customer c;%>

	<%
		c = (Customer) session.getAttribute("logged_in_customer");
		if (c.getFirstName() != null) {
	%>
	<%--  	 	<jsp:include page="nav_bar_loggedin.jsp" /> --%>
	<jsp:include page="temp_head_in.jsp" />
	<%
		} else {
	%>
	<%-- 		<jsp:include page="nav_bar_loggedout.jsp" /> --%>
	<jsp:include page="new_temp_head.jsp" />
	<%
		}
	%>



	<div id="body">
		<div style="text-align: center">
			<h1>Contact Something Books</h1>

			<div id="contact-info">
				<b>Phone:</b> 215-200-5000 <br> <b>Email:</b>
				samantha@elsevier.com <br> <b>Address:</b> 1600 John F. Kennedy
				Boulevard <br> Philadelphia PA <br> 19103 <br>
			</div>
		</div>

		<br> <br>
		<center>
			<iframe width="600" height="450" align="middle" frameborder="0"
				style="border: 0; float: center;"
				src="https://www.google.com/maps/embed/v1/place?key=AIzaSyACjIrMt05daQAw5oEbeEYQUaDF-Jy2pEc&q=1600+John+F+Kennedy+Boulevard,Philadelphia,Pennsylvania">
			</iframe>
		</center>
	</div>



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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.qa.models.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/temp.css">
<title>Thank you</title>
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

		<h1>Order completed</h1>
		<p>Thank you for your order!</p>
	</div>

	<%-- 	<jsp:include page="footer_loggedin.jsp"/> --%>
	<jsp:include page="temp_foot_in.jsp" />
</body>
</html>
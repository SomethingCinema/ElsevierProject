<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.qa.models.Customer" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/temp.css">
<title>About Us</title>
</head>
<body>

	<%!Customer c;%>

	<%
		c = (Customer) session.getAttribute("logged_in_customer");
		if (c.getFirstName() != null) {
	%>
<%-- 	<jsp:include page="nav_bar_loggedin.jsp" /> --%>
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

		<h2 class="intro">
			Meet our highly talented team of developers who bring their unique
			skills to allow us to meet the needs of our customers while staying
			ahead of our Competitors!!!
			</h3>
			<div class="team-content">
				<div class="mem1">
					<h3>
						<b>Alexa Hojczyk :</b><i>Scrum Master/Designer/Developer</i>
					</h3>
					<a href="mailto:a.hojczyk@elsevier.com">a.hojczyk@elsevier.com</a>
				</div>
				<div class="mem2">
					<h3>
						<b>Danielle Walsh:</b><i>Mathematician/Strategist/Developer</i>
					</h3>
					<a href="mailto:d.walsh@elsevier.com">d.walsh@elsevier.com</a>
				</div>
				<div class="mem3">
					<h3>
						<b>Eberechi Akoma:</b><i>Tester/Content Developer/Developer</i>
					</h3>
					<a href="mailto:e.akoma@elsevier.com">e.akoma@elsevier.com</a>
				</div>
				<div class="mem4">
					<h3>
						<b>Grace Alfieri :</b><i>UX/Content Developer/Developer</i>
					</h3>
					<a href="mailto:g.alfieri@elsevier.com">g.alfieri@elsevier.com</a>
				</div>
				<div class="mem5">
					<h3>
						<b>Rebecca Poch :</b><i>Admin/Content Developer/Developer</i>
					</h3>
					<a href="mailto:r.poch@elsevier.com">r.poch@elsevier.com</a>
				</div>
				<div class="mem6">
					<h3>
						<b>Samantha Rogers :</b><i>Content Developer/Project Manager</i>
					</h3>
					<a href="mailto:s.rogers.1@elsevier.com">s.rogers.1@elsevier.com</a>
				</div>
			</div>
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
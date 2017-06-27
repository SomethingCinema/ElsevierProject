<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/style.css">
	<title>Contact</title>
</head>
<body>

<jsp:include page="nav_bar_loggedout.jsp" />
	
<h1>Contact Something Books</h1>

<div id="contact-info">
	<b>Phone:</b> 215-200-5000 <br>
	<b>Email:</b> samantha@elsevier.com <br>
	<b>Address:</b>	1600 John F. Kennedy Boulevard <br>
	Philadelphia PA <br>
	19103 <br>
</div>
		
	
	<iframe
  		width="600"
	  	height="450"
	  	frameborder="0" style="border:0"
	  	src="https://www.google.com/maps/embed/v1/place?key=AIzaSyACjIrMt05daQAw5oEbeEYQUaDF-Jy2pEc&q=1600+John+F+Kennedy+Boulevard,Philadelphia,Pennsylvania">
	</iframe>
	
	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/elsevier.js"></script>
    <script>
      $(document).foundation();
    </script>
</body>
</html>
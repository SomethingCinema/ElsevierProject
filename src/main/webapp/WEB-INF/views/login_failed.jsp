<!doctype html>
<%@page import="com.qa.models.Customer"%>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Online Shopping </title>
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
        <h1> Login failed </h1>
        
        <a href="/login" class="button large"> Click here to try again </a>
      
      </div>
    </div>
    
   
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/elsevier.js"></script>
    <script>
      $(document).foundation();
    </script>
    
    <jsp:include page="footer.jsp"/>
  </body>
</html>


    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>


<%@page import="com.qa.models.Customer"%>
<%@page import="com.qa.models.Order"%>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Order History</title>
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
    
    <%
 	 if (c.getFirstName() != null) {
  	%>
  
      findCustomerOrderHistory(c).toString();
  
  
  	 <%
      }
      else
      {
      %>
      
      <h3>Please login to view this page.</h3>

       <%
       }
       %>
  
  
     <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/elsevier.js"></script>
    <script>
      $(document).foundation();
    </script> 
    
    <jsp:include page="footer.jsp"/>
  </body>
</html>
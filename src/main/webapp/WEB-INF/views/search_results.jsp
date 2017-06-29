<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.qa.models.Book"%>
<%@page import="com.qa.models.Customer"%>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Online Shopping</title>
    <link rel="stylesheet" href="css/style.css"/>
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
	
	
	 <div class="row column text-center">
      <h2>Search results
      
      
      <%
         Iterable<Book> results = (Iterable<Book>) request.getAttribute("results");
          
      %>
      
      
      </h2>
      <hr>
    </div>

    <div class="row small-up-2 medium-up-3 large-up-4">
    
    <%
    if(!results.iterator().hasNext()){
    	%>
    	<h3>No search results</h3>
    	<h3>${alert}</h3>
    	<% 
    
    }
    else {
	    for(Book book: results)
	    {
      
   
    %>
      <div class="column">
      
        <a href="/bookDetails?bookId=<%=book.getBookId()%>"><img class="thumbnail" src="<%=book.getBookImage()%>" style="height:250px; width:auto;"></a>
        <h5  style="height: 50px; overflow: hidden; text-overflow: ellipses;"><%= book.getTitle()%></h5>
        <p><fmt:formatNumber type="currency" value="<%=book.getPrice()%>"></fmt:formatNumber></p>
        <a href="/bookDetails?bookId=<%=book.getBookId()%>" class="button expanded">View book details</a>
        <!--  a href="/addToCart?bookId=" class="button expanded">Add to Cart</a>-->
      </div>
    
    <%
   	 	}
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
  		}
  		else
  		{
 	 %>
		<jsp:include page="footer.jsp" />
	<%
  		}
	%>
 
     
  </body>
</html>

<!doctype html>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.qa.models.Book"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Online Shopping</title>
    <link rel="stylesheet" href="css/style.css"/>
  </head>
  <body>

    <!-- Start Top Bar -->
    <!--  
    <div class="top-bar">
      <div class="top-bar-left">
        <ul class="menu">
          <li class="menu-text" style="color:red">Online Shopping</li>
          <li><a href="/">Home</a></li>
          
        </ul>
      </div>
      <div class="top-bar-right">
        
             <ul class="dropdown menu" data-dropdown-menu>
            
            <li class="has-submenu">
              <a href="/viewCart"><img src="images/cart.jpg" width="50" height="50"/></a>
              <ul class="submenu menu vertical" data-submenu>
                <li><a href="/viewCart"><img src="images/cart.jpg" width="50" height="50"/> View Cart </a></li>
                <tr><a href="/register">Register</a><a href="/login">Login</a></tr>
              </ul>
            </li>
            <li><a href="/about_us">About Us</a></li>
            <li><a href="/contact">Contact</a></li>
          </ul>
          
      </div>
    </div> -->
    <!-- End Top Bar -->

    <jsp:include page="nav_bar_loggedout.jsp" />
    
    <div class="row column text-center">
      <h2>Our Newest Books
      
      
      <%
         Iterable<Book> books = (Iterable<Book>) session.getAttribute("books");
          
      %>
      
      
      </h2>
      <hr>
    </div>

    <div class="row small-up-2 large-up-4">
    
    <%
    
    for(Book book: books)
    {
      
   
    %>
      <div class="column">
      
        <a href="/bookDetails?bookId=<%=book.getBookId()%>"><img class="thumbnail" src="<%=book.getBookImage()%>"></a>
        <h5><%= book.getTitle()%></h5>
        <p><fmt:formatNumber type="currency" value="<%=book.getPrice()%>"></fmt:formatNumber></p>
        <a href="/bookDetails?bookId=<%=book.getBookId()%>" class="button expanded">View book details</a>
        <!--  a href="/addToCart?bookId=" class="button expanded">Add to Cart</a>-->
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
  </body>
</html>

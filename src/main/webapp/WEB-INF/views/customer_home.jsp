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
  %>
    
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
            <li id="cart_items"></li>
            
            <li><a href="/profile">Personal Details</a></li>
            <li><a href="#">Address Book</a></li>
            <li><a href="#">Change Password </a></li>
            <li><a href="#">Order History </a></li>
             <li><a href="/logout">Logout</a></li>
            <li class="has-submenu">
              <a href="/viewCart"> <img src="images/cart.jpg" width="50" height="50"/></a>
              <ul class="submenu menu vertical" data-submenu>
                <li><a href="/viewCart"><img src="images/cart.jpg" width="50" height="50"/></a></li>
               
              </ul>
            </li>
            
          </ul>
          
      </div>
    </div> -->
    <!-- End Top Bar -->
    
    <jsp:include page="nav_bar_loggedin.jsp" />

    <div class="callout large">
      <div class="row column text-center">
         
        <h3>You have logged in as <%=c.getFirstName() %></h3>
       </div>
    </div>
    
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


    
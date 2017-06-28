<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Online Shopping </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/form.css" type="text/css">
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
            <li id="cart_items"></li>
            <li class="has-submenu">
              <a href="/viewCart"> <img src="images/cart.jpg" width="50" height="50"/></a>
              <ul class="submenu menu vertical" data-submenu>
                <li><a href="/viewCart"><img src="images/cart.jpg" width="50" height="50"/> View Cart </a></li>
                <tr><a href="/register">Register</a><a href="/login">Login</a></tr>
              </ul>
            </li>
            <li><a href="/about_us">About Us</a></li>
            <li><a href="#">Contact</a></li>
          </ul>
          
      </div>
    </div> -->
    <!-- End Top Bar -->
    
    <jsp:include page="nav_bar_loggedout.jsp" />

   <% request.getSession().invalidate();

		if(session!=null){
   			session=null;
		}

		 request.getSession().setAttribute("name", null); //it just assigns null to attribute

 			response.sendRedirect("/");
 	%>
    
   
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/elsevier.js"></script>
    <script>
      $(document).foundation();
    </script>
    
  <jsp:include page="footer.jsp"/>
  </body>
</html>


    
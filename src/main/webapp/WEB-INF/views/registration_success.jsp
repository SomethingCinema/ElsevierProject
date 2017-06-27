<!doctype html>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Online Shopping </title>
    <link rel="stylesheet" href="css/style.css">
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
    </div>
    -->
    <!-- End Top Bar -->
    
    <jsp:include page="nav_bar_loggedout.jsp" />

    <div class="callout large">
      <div class="row column text-center">
        <h1>Registration Success </h1>
        
        <a href="/login" class="button large"> Click here to login </a>
      
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


    
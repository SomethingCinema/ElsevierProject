<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/login.css">
</head>
<!-- Start Top Bar -->
    <div class="top-bar">
      <div class="top-bar-left">
        <ul class="menu">
           <li><a href="/"><img class="logo" src="images/HCB.png" width="335" height="75" hspace="20"/></a></li>
          
        </ul>
      </div>
      <div class="top-bar-right"> 
        
            <ul class="dropdown menu" data-dropdown-menu>
            
            <li><input type="text" name="search" id="search" placeholder="Search.."><li>   
            <li id="cart_items"></li>
            
            <li><a href="/profile">Personal Details</a></li>
            <li><a href="/addressBook">Address Book</a></li>
            <li><a href="/changePassword">Change Password </a></li>
            <li><a href="#">Order History </a></li>
             <li><a href="/logout">Logout</a></li>
            <li class="has-submenu">
              <a href="/viewCart"> <img src="images/cart.png" width="50" height="50"/></a>
              <ul class="submenu menu vertical" data-submenu>
                <li><a href="/viewCart"><img src="images/cart.png" width="50" height="50"/></a></li>
               
              </ul>
            </li>
            
          </ul>
          
      </div>
    </div>
    <!-- End Top Bar -->
<script type="text/javascript">
    document.getElementById("search").onsubmit = function() {
        window.location = "http://www.google.com/search?q=site:yoursitename.com " + document.getElementById("search").value;
        return false;
    }
</script>
</html>

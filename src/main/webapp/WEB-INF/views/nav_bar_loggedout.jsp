<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/hover.css">
</head>
<!-- <div class="top-bar foundation-5-top-bar">
  <div class="top-bar-title">
    <strong>Holy CRUD Booksellers</strong>
  </div>
    <div class="top-bar-left">
      <ul class="menu">
        <li><a href="/about_us">About Us</a></li>
        <li><a href="/contact">Contact</a></li>
        <li><a href="/register">Register</a></li>
        <li><a href="/login">Login</a></li>
      </ul>
    </div>
    <div class="top-bar-right">
      <ul class="menu">
        <li><input type="search" placeholder="Search"></li>
        <li><button type="button" class="button">Search</button></li>
      </ul>
    </div>
  </div>
</div> -->

<!-- Start Top Bar -->
    <div class="top-bar">
      <div class="top-bar-left">
        <ul class="menu">
          <li class="menu-text" style="color:black"><a href="/">Something Books</a></li>
          
        </ul>
      </div>
      <div class="top-bar-right">
      
       <ul class="menu">
        <li><input type="search" placeholder="Search"></li>
        <li><button type="button" class="button">Search</button></li>
      </ul>
        
             <ul class="dropdown menu" data-dropdown-menu>
            
            <li class="has-submenu">
              <a href="/viewCart"><img src="images/cart.png" width="50" height="50"/></a>
              <ul class="submenu menu vertical" data-submenu>
                <li><a href="/viewCart"><img src="images/cart.png" width="50" height="50"/></a></li>
                <tr><a href="/register">Register</a><a href="/login">Login</a></tr>
              </ul>
            </li>
            	<li><a href="/about_us">About Us</a></li>
            	<li><a href="/contact">Contact</a></li>
          </ul>
          
      </div>
    </div>
<!-- End Top Bar -->
</html>
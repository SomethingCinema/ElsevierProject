<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/logout.css">
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
    <div class="top-bar" style="height:160px">
      <div class="top-bar-left">
        <ul class="menu">
          <li><a href="/"><img class="logo" src="images/HCB.png" width="315" height="auto" hspace="0"/></a></li>
          
        </ul>
      </div>
      <div class="top-bar-right">
      
 <!--       <ul class="menu">
        <li><input type="search" placeholder="Search"></li>
        <li><button type="button" class="button">Search</button></li>
      </ul> -->
        
            <ul class="dropdown menu" data-dropdown-menu>
            
				<li>
	            <form action="/search" method="get">
	            	<input type="hidden" name="type" value="title"/>
	            	<input type="text" name="search" id="search" placeholder="Search.."/>
	            	<input type="submit" value="Search"/>
	           	</form>
	           	</li>
           	
           	<li><a id="hover-link" href="/allBooks">Browse</a></li>
            <li><a id="hover-link" href="/about_us">About Us</a></li>
            <li><a id="hover-link" href="/contact">Contact</a></li>
            <li><a href="/viewCart"><img src="images/cart.png" width="50" height="50"/></a></li>
            <li><a href="/register">Register</a>
            <li><a href="/login">Login</a></li>
             
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
<!doctype html>
<%@page import="com.qa.models.Customer"%>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Online Shopping </title>
    <link rel="stylesheet" href="css/temp.css">
    <link rel="stylesheet" href="css/form.css">
  </head>
  <body>
  
  <%!
  
  Customer c;
  
  %>
  
  
  <%
 		c = (Customer) session.getAttribute("logged_in_customer");
 	 if (c.getFirstName() != null) {
  %>
    
    <!-- Start Top Bar -->
    <!--  
    <div class="top-bar">
      <div class="top-bar-left">
        <ul class="menu">
          <li class="menu-text" style="color:red">Online Shopping</li>
          <li><a href="#">Home</a></li>
          
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
    </div>  -->
    <!-- End Top Bar -->
    
<%--     <jsp:include page="nav_bar_loggedin.jsp" /> --%>
    <jsp:include page="temp_head_in.jsp" />
    
    <%
 	 }
 	 else
 	 {
    %> 
    
<%--     <jsp:include page="nav_bar_loggedout.jsp" /> --%>
    <jsp:include page="new_temp_head.jsp" />
    
    <%
    }
    %>
    
    <%
 	 if (c.getFirstName() != null) {
  	%>
       
       <div class="row" id="body">
        
       
        <div class="large-6 columns">
           <h3> Billing Address </h3>
                <p>${alert }</p>
              <form action="/updateAddress" method="post" class="val">
               <label>Address Line 1 * </label>
               <input type="text" required pattern="^[0-9a-zA-Z. ]+$" placeholder="Enter AddressLine2" name="addressLine1" id="addressLine1"/> 
               <label>Address Line 2  </label>
               <input type="text" placeholder="Enter Address Line 2" name="addressLine2" id="addressLine2"/> 
               <label>City * </label>
                <input type="text" required pattern="[a-zA-Z]+" placeholder="Enter City" name="city" id="city"/> 
                  <label>Postal Code * </label>
                <input type="text" required pattern="(\d{5}([\-]\d{4})?)" placeholder="Enter Postcode (XXXXX)" name="postcode" id="postcode"/> 
                
                
                  <label>State * </label>
                <input type="text" required pattern="[a-zA-Z]+" placeholder="Enter State" name="state" id="state"/> 
                
                
                  <label>Country * </label>
                <input type="text" required pattern="[a-zA-Z]+" placeholder="Enter Country" name="country" id="county"/> 
                
                
                  <label>Phone Number * </label>
                <input type="text" required pattern="\d{3}[\-]\d{3}[\-]\d{4}" placeholder="Enter Phone Number (XXX-XXX-XXXX)" name="phoneNumber" id="phoneNumber"/> 
                
                 
                <input type="hidden" name="addressType" id="addressType" value="billing"/> 
                
                
                <input type="submit" class="button create account" value="Update Billing Address">
               </form>
            </div>
            
          
               <div class="medium-6 columns">
                <h3> Shipping Address </h3>
                
                <input type="checkbox" class="ba" checked="checked" /> Different from billing address
                
              <form action="/updateAddress" method="post" class="val">
               <label>Address Line1 * </label>
               <input type="text" required pattern="^[0-9a-zA-Z. ]+$" placeholder="Enter AddressLine2" name="addressLine1" id="addressLine1" class="tex"/> 
               <label>Address Line 2 </label>
               <input type="text" placeholder="Enter Address Line 2" name="addressLine2" id="addressLine2" class="tex"/> 
               <label>City * </label>
                <input type="text" required pattern="[a-zA-Z]+" placeholder="Enter City" name="city" id="city" class="tex"/> 
                  <label>Postal Code * </label>
                <input type="text" required pattern="(\d{5}([\-]\d{4})?)" placeholder="Enter Postcode (XXXXX)" name="postcode" id="postcode" class="tex"/> 
                
                
                  <label>State * </label>
                <input type="text" required pattern="[a-zA-Z]+" placeholder="Enter State" name="state" id="state" class="tex"/> 
                
                
                  <label>Country * </label>
                <input type="text" required pattern="[a-zA-Z]+" placeholder="Enter Country" name="country" id="county" class="tex"/> 
                
                
                  <label>Phone Number * </label>
                <input type="text" required pattern="\d{3}[\-]\d{3}[\-]\d{4}" placeholder="Enter Phone Number (XXX-XXX-XXXX)" name="phoneNumber" id="phoneNumber" class="tex"/> 
                
                 
                <input type="hidden" name="addressType" id="addressType" value="shipping"/> 
                
                
                <input type="submit" class="button create account" value="Update Shipping Address">
               </form>
            </div>
             
     
      </div>
      
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
    <script src="js/elsevier2.js"></script>
    <script>
      $(document).foundation();
    </script>
    
<%--     <jsp:include page="footer_loggedin.jsp"/> --%>
	<jsp:include page="temp_foot_in.jsp" />
  </body>
</html>


    
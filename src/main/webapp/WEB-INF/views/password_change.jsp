<!doctype html>
<%@page import="com.qa.models.Customer"%>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Online Shopping </title>
    <link rel="stylesheet" href="css/style.css">
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
    
   
    <jsp:include page="nav_bar_loggedin.jsp" />

    <div class="callout large">
      <div class="row column text-center">
        
        <h3>You have logged in as <%=c.getFirstName() %></h3>
       </div>
       
       
       <div class="row column">
        
        <form action="/updatePassword" method="post" class="val">
        <div class="medium-6">
           <h3> Account details </h3>
                
                 
               <label>Type In New Password * </label>
               <input type="password" placeholder="Enter New Password" name="password" id="password" value=""/> 
                
            </div>
            
          
      		
      		<input type="submit" class="button create account" value="Update Password">
              
              </form>
    
      
      
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


    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.qa.models.Customer" pageEncoding="ISO-8859-1"%>
<%@page import="com.qa.models.Book"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Foundation | Welcome</title>
<link rel="stylesheet" href="css/temp.css">





</head>
<body>

	<%!Book book;
	Customer c;%>


	<%
		if (request.getAttribute("book") != null) {
			book = (Book) request.getAttribute("book");
		}
		if (c != null) {
			c = (Customer) session.getAttribute("logged_in_customer");
			if (c.getFirstName() != null) {
	%>


	<%-- 	<jsp:include page="nav_bar_loggedin.jsp" /> --%>
	<jsp:include page="temp_head_in.jsp" />

	<%
		}
		} else {
	%>
	<%-- 	<jsp:include page="nav_bar_loggedout.jsp" /> --%>
	<jsp:include page="new_temp_head.jsp" />
	<%
		}
	%>

	<br>
	<!-- You can now combine a row and column if you just need a 12 column row -->
<div id="body">
	<!--  <div class="row columns">
		<nav aria-label="You are here:" role="navigation">
			<ul class="breadcrumbs">
				<li><a href="/">Home</a></li>
				<li><span class="show-for-sr">Current: </span> Book Details</li>
			</ul>
		</nav>
	</div> -->
	
		<div class="row">
			<div class="medium-6 columns">
				<img class="thumbnail" src="<%=book.getBookImage()%>" style="width: 250px; height:auto" />
				<div class="row small-up-4">
					<div class="column">
						eBook ISBN :
						<%=book.geteBookISBN()%>
					</div>
					<div class="column">
						Print book ISBN
						<%=book.getPaperISBN()%>
					</div>
					<div class="column">

						<fmt:setLocale value="en_US" scope="session" />

						Price :
						<fmt:formatNumber type="currency" value="<%=book.getPrice()%>" />
					</div>
					<div class="column">
						Published On
						<%=book.getPublishedDate()%>
					</div>

				</div>
			</div>
			<div class="medium-6 large-5 columns">
				<h3><%=book.getTitle()%></h3>
				<h4>
					By:
					<%=book.getBookauthor()%></h4>
				<p><%=book.getDescription()%></p>


				<form action="/addToCart" method="post">

					<label>Select the format <select required>
							<option value="">-- Select --</option>
							<option value="print">Paperback</option>
							<option value="eBook">eBook</option>
							<option value="printAndeBook">PrintBook & eBook</option>
					</select>
					</label>
					<%-- <a href="/addToCart?bookId=<%=book.getBookId()%>" class="button large expanded">Add to Cart</a> --%>
					<input type="hidden" name="bookId" value="<%=book.getBookId()%>" />
					<button id="addToCart" class="button large expanded">Add
						to Cart</button>
				</form>

				<!-- <div class="small secondary expanded button-group">
            <a class="button">Facebook</a>
            <a class="button">Twitter</a>
            <a class="button">Yo</a>
          </div> -->
			</div>
		</div>
	</div>
	<!--  
    <div class="column row">
      <hr>
      <ul class="tabs" data-tabs id="example-tabs">
        <li class="tabs-title is-active"><a href="#panel1" aria-selected="true">Reviews</a></li>
        <li class="tabs-title"><a href="#panel2">Similar Products</a></li>
      </ul>
      <div class="tabs-content" data-tabs-content="example-tabs">
        <div class="tabs-panel is-active" id="panel1">
          <h4>Reviews</h4>
          <div class="media-object stack-for-small">
            <div class="media-object-section">
              <img class="thumbnail" src="http://placehold.it/200x200">
            </div>
            <div class="media-object-section">
              <h5>Mike Stevenson</h5>
              <p>I'm going to improvise. Listen, there's something you should know about me... about inception. An idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It can grow to define or destroy you.</p>
            </div>
          </div>
          <div class="media-object stack-for-small">
            <div class="media-object-section">
              <img class="thumbnail" src="http://placehold.it/200x200">
            </div>
            <div class="media-object-section">
              <h5>Mike Stevenson</h5>
              <p>I'm going to improvise. Listen, there's something you should know about me... about inception. An idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It can grow to define or destroy you</p>
            </div>
          </div>
          <div class="media-object stack-for-small">
            <div class="media-object-section">
              <img class="thumbnail" src="http://placehold.it/200x200">
            </div>
            <div class="media-object-section">
              <h5>Mike Stevenson</h5>
              <p>I'm going to improvise. Listen, there's something you should know about me... about inception. An idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It can grow to define or destroy you</p>
            </div>
          </div>
          <label>
            My Review
            <textarea placeholder="None"></textarea>
          </label>
          <button class="button">Submit Review</button>
        </div>
        <div class="tabs-panel" id="panel2">
          <div class="row medium-up-3 large-up-5">
            <div class="column">
              <img class="thumbnail" src="http://placehold.it/350x200">
              <h5>Other Product <small>$22</small></h5>
              <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
              <a href="#" class="button hollow tiny expanded">Buy Now</a>
            </div>
            <div class="column">
              <img class="thumbnail" src="http://placehold.it/350x200">
              <h5>Other Product <small>$22</small></h5>
              <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
              <a href="#" class="button hollow tiny expanded">Buy Now</a>
            </div>
            <div class="column">
              <img class="thumbnail" src="http://placehold.it/350x200">
              <h5>Other Product <small>$22</small></h5>
              <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
              <a href="#" class="button hollow tiny expanded">Buy Now</a>
            </div>
            <div class="column">
              <img class="thumbnail" src="http://placehold.it/350x200">
              <h5>Other Product <small>$22</small></h5>
              <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
              <a href="#" class="button hollow tiny expanded">Buy Now</a>
            </div>
            <div class="column">
              <img class="thumbnail" src="http://placehold.it/350x200">
              <h5>Other Product <small>$22</small></h5>
              <p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
              <a href="#" class="button hollow tiny expanded">Buy Now</a>
            </div>
          </div>
        </div>
      </div>
    </div>
-->




	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="js/elsevier.js"></script>
	<script>
		$(document).foundation();
	</script>


	<%
		if (c != null) {
			c = (Customer) session.getAttribute("logged_in_customer");
			if (c.getFirstName() != null) {
	%>
	<%--  	 	<jsp:include page="footer_loggedin.jsp" /> --%>
	<jsp:include page="temp_foot_in.jsp" />
	<%
		}
		} else {
	%>
	<%-- 	<jsp:include page="footer.jsp" /> --%>
	<jsp:include page="new_temp_footer.jsp" />
	<%
		}
	%>
</body>
</html>




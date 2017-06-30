<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="user-scalable=0, width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Holy CRUD Booksellers</title>
<link rel="stylesheet" type="text/css" href="css/temp.css">
<!-- 	<link rel="stylesheet" type="text/css" href="css/mobile.css"> -->
<!-- 	<script type='text/javascript' src='js/mobile.js'></script> -->
</head>
<div id="header">
	<h1>
		<a href="/"><img class="logo" src="images/HCB.png" /></a>
	</h1>
	<div id="search">
			<form action="/search" method="get" style="float:right;">
				<input type="hidden" name="type" value="title" /> <input type="text"
					name="search" id="search" placeholder="Search.." /> <input
					type="submit" value="Search" />
			</form>
	</div>
	<ul id="navigation">
		<li><a href="/allBooks">All Books</a></li>
		<li id="drop"><a href="/about_us">About Us</a>
			<ul>
				<li><a href="/contact">Contact</a></li>
			</ul>
		</li>
		<li><a href="/viewCart">Shopping Cart</a></li>
		<li id="drop"><a href="/profile">Profile</a>
			<ul>
				<li><a href="/changePassword">Password</a>
			</ul>
		</li>
		<li><a href="/logout">Logout</a></li>
	</ul>
</div>
</html>

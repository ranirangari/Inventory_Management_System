<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>IMS</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<link href="assets/img/ims4.jpg" rel="icon">
<link href="assets/img/ims4.jpg" rel="ims4">


<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Raleway:400,700,900|Lato:400,900"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="assets/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="assets/lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="assets/lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
<link href="assets/lib/hover/hoverex-all.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- =======================================================
    Template Name: Solid
    Template URL: https://templatemag.com/solid-bootstrap-business-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>

	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">GROCERY MANAGEMENT
					SYSTEM</a>
			</div>
			<div class="navbar-collapse collapse navbar-right">
				<ul class="nav navbar-nav">
					<li><a href="home.jsp">Home</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">User<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="adduser.jsp">Add User</a></li>
							<li><a href="MainController?page=allUser">All Users</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Item<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="ItemController?page=gotoaddItem">Add Item</a></li>
							<li><a href="ItemController?page=allItem">All Items</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Category<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="addcategory.jsp">Add Category</a></li>
							<li><a href="CategoryController?page=allCategory">All Categories</a></li>


						</ul>
					<li><a href="MainController?page=logout">Log Out</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
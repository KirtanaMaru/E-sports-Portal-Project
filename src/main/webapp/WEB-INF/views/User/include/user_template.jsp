<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User : Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="<spring:url value='/ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'/>"></script>

<link rel="stylesheet" href="<spring:url value='/css/admin_style.css'/>"
	type="text/css" />
<style>
.imagecss1{
margin: 24px;
   box-shadow: 0 0 5px black;
   padding: 20px;
   background:
		linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.3)),url("https://assets.architecturaldigest.in/photos/60004df01626622a53c5f583/16:9/w_2560%2Cc_limit/Staidum-1366x768.jpg");
   background-origin: content-box;
   background-repeat: no-repeat;
   background-size: cover;
   text-shadow: 0 1px white;
   }
</style>
<script>
	$("#sidenavToggler")
			.click(
					function(e) {
						e.preventDefault();
						$("body").toggleClass("sidenav-toggled");
						$(".navbar-sidenav .nav-link-collapse").addClass(
								"collapsed");
						$(
								".navbar-sidenav .sidenav-second-level, .navbar-sidenav .sidenav-third-level")
								.removeClass("show");
					});
</script>
<script type="text/javascript"
	src="<spring:url value='/js/admin_dashboard.js'/>"></script>
	
</head>

<body class="fixed-nav sticky-footer bg-light imagecss1" styleid="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="<spring:url value='/User/Dashboard'/>"><img
			class="brand" src='<spring:url value="/logoesport.png"/>' height=40px></a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link"
					href="<spring:url value='/User/Dashboard'/>"> <i
						class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Profile"><a class="nav-link nav-link-collapse collapsed"
					data-toggle="collapse" href="#user" data-parent="#exampleAccordion">
						<i class="fa fa-fw fa-sitemap"></i> <span class="nav-link-text">Profile</span>
				</a>
					<ul class="sidenav-second-level collapse" id="user">
						<li><a href="<spring:url value='/User/myprofile'/>"> <i
								class="fa fa-fw fa-link"></i> My Profile
						</a></li>
						<li><a href="<spring:url value='/User/addQualifaction'/>">
								<i class="fa fa-fw fa-link"></i> Add Qualification
						</a></li>
						<li><a href="<spring:url value='/User/addCertification'/>">
								<i class="fa fa-fw fa-link"></i> Add Certificate
						</a></li>
						<li><a href="<spring:url value='/User/changepassword'/>">
								<i class="fa fa-fw fa-link"></i> Change Password
						</a></li>
					



					</ul></li>


				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Sport Action"><a
					class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
					href="#sport" data-parent="#exampleAccordion"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">Sport
							Action</span>
				</a>
					<ul class="sidenav-second-level collapse" id="sport">

						<li><a href="<spring:url value='/User/findSports'/>"> <i
								class="fa fa-fw fa-link"></i> Find Sport
						</a></li>

						<li><a href="<spring:url value='/User/showmyapplications'/>"> <i
								class="fa fa-fw fa-link"></i> Application
						</a></li>

						



					</ul></li>

				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Shopping"><a
					class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
					href="#shopping" data-parent="#exampleAccordion"> <i
						class="fa fa-briefcase" aria-hidden="true"></i> <span
						class="nav-link-text">Shopping</span>
				</a>
					<ul class="sidenav-second-level collapse" id="shopping">

						<li><a href="<spring:url value='/User/shopping'/>"> <i
								class="fa fa-fw fa-link"></i> Shopping
						</a></li>

						<li><a href="<spring:url value='/User/shopingHistory'/>">
								<i class="fa fa-fw fa-link"></i> Shopping History
						</a></li>

					



					</ul></li>
					
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Academy Details"><a class="nav-link"
					href="<spring:url value='/User/showAcademy'/>"> <i
						class="fa fa-fw fa-link"></i> <span class="nav-link-text">Academy
							Details</span>
				</a></li>
				
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Injury Preduction"><a class="nav-link"
					href="<spring:url value='/User/injuryPreduction'/>"> <i
						class="fa fa-briefcase" aria-hidden="true"></i> <span class="nav-link-text">Injury Prediction</span>
				</a></li>
					
			</ul>

			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				
					
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown"
					href="#" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fa fa-fw fa-bell"></i> <span
						class="d-lg-none">Alerts <span
							class="badge badge-pill badge-warning">6 New</span>
					</span> <span class="indicator text-warning d-none d-lg-block"> <i
							class="fa fa-fw fa-circle"></i>
					</span>
				</a>
					<div class="dropdown-menu" aria-labelledby="alertsDropdown">
						<h6 class="dropdown-header">New Alerts:</h6>
						<c:forEach var="e" items="${sessionScope.eventList}">
						
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <span class="text-success">
								<strong> <i class="fa fa-long-arrow-up fa-fw"></i>
								${e.title}
							</strong>
						</span> <span class="small float-right text-muted">${e.date}</span>
							<div class="dropdown-message small">
							${e.location}
							</div>
						</a>
						</c:forEach>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item small" href="#">View all alerts</a>
					</div></li>
				<li class="nav-item">
					<form class="form-inline my-2 my-lg-0 mr-lg-2">
						<div class="input-group">
							<input class="form-control" type="text"
								placeholder="Search for..."> <span
								class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
					</form>
				</li>
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
				</a></li>
			</ul>
		</div>
	</nav>
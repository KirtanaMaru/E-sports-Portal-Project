
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>E-Sport: login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="<spring:url value='/css/index.css'/>" />
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<style>
.imgxss2 {
	background:
		linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.3)),url("https://assets.architecturaldigest.in/photos/60004df01626622a53c5f583/16:9/w_2560%2Cc_limit/Staidum-1366x768.jpg");
	background-origin: content-box;
	background-repeat: no-repeat;
	background-size: cover;
	z-index: 1;
}

.heading {
	margin-top: 15%;
	margin-left: 30%;
	font-stretch: 10px;
	letter-spacing: 10px;
	font-size: 48px;
	text-transform: uppercase;
}

.card01 {
	margin-top: 5%;
	margin-left: 15%;
	font-stretch: 5px;
	font-size: 18px ;
	
	color:white;
	
}
</style>
</head>
<body>
	<div class="card card0 border-0 imgxss2">
		<div class="row d-flex">
			<div class="col-lg-8">
				<div class="card1 pb-5">
					<div class="row">
						<h2 class="heading" style="color: white;">Sport Management</h2>
					</div>
					<div class="row">
						<div class="col card01">
							<p>
								<i class='fas fa-arrow-alt-circle-right'
									style='font-size: 28px; color:04F904'></i><b> Duration: 3
								Years Degree Program</b>
							</p>
							<p>
								<i class='fas fa-arrow-alt-circle-right'
									style='font-size: 28px; color: 04F904'></i> <b>Eligibility: 12th Pass(Any Stream)
							</b></p>
							<p>
								<i class='fas fa-arrow-alt-circle-right'
									style='font-size: 28px; color: 04F904'></i><b>Shop for sport Equipment
							</b></p>
							<p>
								<i class='fas fa-arrow-alt-circle-right'
									style='font-size: 28px; color: 04F904'></i> <b>Backed by TMV University
							</b></p>
						</div>
						<div class="col card01">
							<p>
								<i class='fas fa-arrow-alt-circle-right'
									style='font-size: 28px; color: 04F904'></i><b> Duration: 3
								Years Degree Program</b>
							</p>
							<p>
								<i class='fas fa-arrow-alt-circle-right'
									style='font-size: 28px; color: 04F904'></i> <b>Apply For Sport Tournament
							</b></p>
							<p>
								<i class='fas fa-arrow-alt-circle-right'
									style='font-size: 28px; color: 04F904'></i><b>Find Sport Tournament
							</b></p>
							<p>
								<i class='fas fa-arrow-alt-circle-right'
									style='font-size: 28px; color: 04F904'></i> <b>Injury Recovery Prediction Time
							</b></p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="card2 card border-0 px-4 py-5">
					<div class="row mb-4 px-3">
						<h7
							style="color: red; background-color: white; margin-right: 50px; margin-left: 50px;">${requestScope.error}</h7>
					</div>
					<div class="row px-3 mb-4">
						<h1>SIGN UP</h1>

					</div>
					<form action='<spring:url value="/signup"/>' method="post">
					<div class="row px-3">
							<label class="mb-1">
								<h6 class="mb-0 text-sm">Full Name</h6>
							</label> <input class="mb-4" type="text" name="name"
								placeholder="Enter Your Full Name">
						</div>
						<div class="row px-3">
							<label class="mb-1">
								<h6 class="mb-0 text-sm">Email Address</h6>
							</label> <input class="mb-4" type="text" name="email"
								placeholder="Enter a valid email address">
						</div>
						<div class="row px-3">
							<label class="mb-1">
								<h6 class="mb-0 text-sm">Password</h6>
							</label> <input class="mb-4" type="password" name="password"
								placeholder="Enter Password">
						</div>
						<div class="row px-3">
							<label class="mb-1">
								<h6 class="mb-0 text-sm">Confirm Password</h6>
							</label> <input type="password" name="cpassword"
								placeholder="Confirm password">
						</div>
						<div class="row px-3 mb-4">
							<a href='<spring:url value="forget_Password"/>' class="ml-auto mb-0 text-sm">Forgot Password?</a>
						</div>
						<div class="row mb-3 px-3">
							<button type="submit" class="btn btn-blue text-center">Sign Up</button>
						</div>
					</form>
					<div class="row mb-4 px-3">
						<small class="font-weight-bold">Already Have an Account? <a
							href='<spring:url value="/"/>'
							class="text-danger ">Login</a></small>
					</div>
				</div>
			</div>
		</div>
		<div class="bg-blue py-4">
			<div class="row px-3">
				<small class="ml-4 ml-sm-5 mb-2">E-Sport Portal &copy; 2023.
					All rights reserved.</small>
				<div class="social-contact ml-4 ml-sm-auto">
					<span class="fa fa-facebook mr-4 text-sm"></span> <span
						class="fa fa-google-plus mr-4 text-sm"></span> <span
						class="fa fa-linkedin mr-4 text-sm"></span> <span
						class="fa fa-twitter mr-4 mr-sm-5 text-sm"></span>
				</div>
			</div>
		</div>
	</div>
</body>
<html>
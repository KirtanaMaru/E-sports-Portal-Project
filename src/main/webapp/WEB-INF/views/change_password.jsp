<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>E-Sport: Forget Password</title>
  <link rel="stylesheet" href="./style.css">
  <style>
  .container{
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
</style></style>

</head>
<body>
<!-- partial:index.partial.html -->
<div id="container" class="container">
		<!-- FORM SECTION -->
				<form action='<spring:url value="/signup"/>' method="post">
		<div class="row">
			<!-- SIGN UP -->
	
			<div class="col align-items-center flex-col sign-up">
				<div class="form-wrapper align-items-center">
					<div class="form sign-up">
						<h3 style="color:red;">${requestScope.error}</h3>
						<div class="input-group">
							<i class='bx bxs-user'></i>
							<input type="text" name="name" placeholder="Username">
						</div>
						<div class="input-group">
							<i class='bx bx-mail-send'></i>
							<input type="email" name="email" placeholder="Email">
						</div>
						<div class="input-group">
							<i class='bx bxs-lock-alt'></i>
							<input type="password" name="password" placeholder="Password">
						</div>
						<div class="input-group">
							<i class='bx bxs-lock-alt'></i>
							<input type="password" name="cpassword" placeholder="Confirm password">
						</div>
						<button>
							Sign up
						</button>
						
						<p>
							<span>
								Already have an account?
							</span>
							<b onclick="toggle()" class="pointer">
								Sign in here
							</b>
						</p>
					</div>
				</div>
			</form>
			</div>
			<!-- END SIGN UP -->
			
			<!-- SIGN IN -->
			<div class="col align-items-center flex-col sign-in">
				<div class="form-wrapper align-items-center">
			
				<form action='<spring:url value="/changePassowrd"/>' method="post">
					<div class="form sign-in">
						<h3 style="color:red;">${requestScope.error}</h3>
						<div class="input-group">
							<i class='bx bxs-user'></i>
							<input type="password" name="npassword" placeholder="Enter New Password">
						</div>
						
					
						<div class="input-group">
							<i class='bx bxs-lock-alt'></i>
							<input type="password" name="cpassword" placeholder="Confirm Password">
						</div>
						<button>
							Update Password
						</button>
						
						<p>
							<span>
								Don't have an account?
							</span>
							<b onclick="toggle()" class="pointer">
								Sign up here
							</b>
						</p>
					</div>
					</form>
				</div>
				
				<div class="form-wrapper">
		
				</div>
			</div>
			<!-- END SIGN IN -->
		</div>
		<!-- END FORM SECTION -->
		<!-- CONTENT SECTION -->
		<div class="row content-row">
			<!-- SIGN IN CONTENT -->
			<div class="col align-items-center flex-col">
				<div class="text sign-in">
					<h2>
						Welcome
					</h2>
	
				</div>
				<div class="img sign-in">
		
				</div>
			</div>
			<!-- END SIGN IN CONTENT -->
			<!-- SIGN UP CONTENT -->
			<div class="col align-items-center flex-col">
				<div class="img sign-up">
				
				</div>
				<div class="text sign-up">
					<h2>
						Join with us
					</h2>
	
				</div>
			</div>
			<!-- END SIGN UP CONTENT -->
		</div>
		<!-- END CONTENT SECTION -->
	</div>
<!-- partial -->
  <script  src="./script.js"></script>

</body>
</html>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- font awesome style -->

<!-- Custom styles for this template -->
<link href='<spring:url value="/css/style.css"/>' rel="stylesheet" />
<!-- responsive style -->

<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Shopping</a></li>
			<li class="breadcrumb-item active">Shopping</li>
			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/User/Dashboard"/>'>Back</a></li>
		</ol>
		<section class="product_section layout_padding">
		<div class="container">
			<div class="heading_container heading_center">
			
				<h2>Our <span>products</span></h2>
					
					<form action='<spring:url value="/User/searchCat"/>' method="post">
					<div class="row">
					<div class="col col-4">
					<select class="form-control" name="category" type="text">
					<c:forEach var="cat" items="${sessionScope.catList}">
					<option value="${cat}"> ${cat}</option>
					</c:forEach>
					</select>
					</div>
					<div class="col col-4">
					<button class="btn btn-danger">Filter</button>
					</div>
					</form>
					</div>
			</div>
<div class="row">
				<c:forEach var="prod" items="${sessionScope.productList}">
					<div class="col-sm-6 col-md-4 col-lg-4">
						<div class="box">
							<div class="option_container">
								<div class="options">
									<a href='<spring:url value="/User/productd?pid=${prod.id}"></spring:url>' class="option1"> ${prod.name} </a> 
									
								<a
									href='<spring:url value="/User/buy?pid=${prod.id}"/>'
									class="option2"> Buy</a>

								
								</div>
							</div>
							<div class="img-box">
								<img src="data:image/jpeg;base64,${prod.imgUtility}" alt="">
							</div>
							<div class="detail-box">
								<h5>${prod.name}</h5><br>
								<h6>${prod.price}</h6>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
		
		</div>
	</section>
<!-- jQery -->
	<script src='<spring:url value="/js/jquery-3.4.1.min.js"/>'></script>
	<!-- popper js -->
	<script src='<spring:url value="/js/popper.min.js"/>'></script>
	<!-- bootstrap js -->
	<script src='<spring:url value="/js/bootstrap.js"/>'></script>
	<!-- custom js -->
	<script src='<spring:url value="/js/custom.js"/>'></script>

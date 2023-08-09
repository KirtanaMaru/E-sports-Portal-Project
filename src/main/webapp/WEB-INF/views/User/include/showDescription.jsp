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

<section style="background-color: white;">
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-5">
				<div class="thumbnail">
					<img style="margin-left: 18%;"
						src="data:image/jpeg;base64,${sessionScope.product.imgUtility } "
						class="img-responsive" alt="" height=450px width=350px>

					<div class="caption">
						<div class="row buttons">




							<a class="btn col-sm-4 col-sm-offset-1 btn-lg"
								href="<spring:url value="/User/buy?pid=${sessionScope.product.id}"/>"
								style="margin-left: 22%;
								background-color: #fb641b; color: #fff; font-size: 1em;">
								<i class="fa fa-bolt" style="font-size: 1.2em;"></i> BUY NOW
							</a>
						</div>

					</div>
				</div>

			</div>


			<div class="col-sm-7 desc">

				<div>



					<h4>${sessionScope.product.name}</h4>

					<div class="row"></div>

					<div>
						<h3>Rs ${sessionScope.product.price}</h3>
					</div>

					<div>

						<h5>
							<span class="glyphicon glyphicon-calendar"></span> EMIs from <strong>Rs
								${sessionScope.product.price}/month </strong><a href="">View Plans <i
								class="fa fa-chevron-right"></i></a>
						</h5>

						<h5>
							<span class="glyphicon glyphicon-tag"></span><strong>
								Bank Offer</strong> 5% Instant Discount on Visa Cards for First 3 Online
							Payments. <a href="">T&C</a>
						</h5>

						<h5>
							<span class="glyphicon glyphicon-tag"></span><strong>
								Bank Offer</strong> Extra 5% off* with Axis Bank Buzz Credit Card. <a
								href="">T&C</a>
						</h5>

					</div>

					<br>
					<div class="row">
						<!-- <div class="col-sm-3">
							<a class="btn btn-default btn-block"><i class="fa fa-apple"
								style="font-size: 25px;"></i></a>
						</div> -->
						<div class="col-sm-9">

							<h5>
								Brand Warranty of ${sessionScope.product.warrenty} month(s)
								<!-- <a href="">Know More</a> -->
							</h5>
						</div>
					</div>
					<br> <br> <br> <br>



				</div>
				<br> <br>

				<div class="container col-xs-12" style="margin-top: 50px;">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="col-sm-12">
								<h3>PRODUCT DESCRIPTION</h3>
								<p>${sessionScope.product.description}</p>

							</div>

						</div>
						<hr>
						<div class="panel-body">
							<div class="col-sm-12">



								<!-- Specifications
			String color, String size, String type, String sleeve, String idealFor,
			String pattern, String modelName, String material, String occasion				 -->

								<div class="panel panel-default" id="specifications">
									<div class="panel-heading" style="background-color: #fff;">
										<h3>Other Details</h3>
									</div>

									<div class="panel-body">



										<table class="table table-default">
											<tbody>
												<tr>
													<td class="col-sm-4">Dimensions</td>
													<td class="col-sm-8">${sessionScope.product.dimension}</td>
												</tr>
												<tr>
													<td class="col-sm-4">Color</td>
													<td class="col-sm-8"><input type="color"
														value="${sessionScope.product.color}"></td>
												</tr>
												<tr>
													<td class="col-sm-4">Type</td>
													<td class="col-sm-8">${sessionScope.product.category}</td>
												</tr>

												<tr>
													<td class="col-sm-4">Weight</td>
													<td class="col-sm-8">${sessionScope.product.weight}</td>
												</tr>


											</tbody>

										</table>

									</div>

									<div class="panel-footer"></div>
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br> <br>
</section>

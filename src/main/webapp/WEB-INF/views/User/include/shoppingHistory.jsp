
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Shopping</a></li>
			<li class="breadcrumb-item active">Shopping History</li>
			<li class="breadcrumb-item">
			<a class="btn btn-primary right" href='<spring:url value="/User/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>My Order  List</h2>
		</div>

<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Product Image</th>
							<th scope="col">Product Name</th>
						
							<th scope="col">Status</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="prod" items="${sessionScope.orderList}">
							<tr>
								<td scope="row">${prod.id}</td>
								<td><img src="data:image/jpeg;base64,${prod.prod.imgUtility}" height=100px width=100px/></td>
								<td>${prod.prod.name}</td>
							<td>${prod.status}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
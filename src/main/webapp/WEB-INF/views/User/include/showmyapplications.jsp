<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Sport Action</a></li>
			<li class="breadcrumb-item active">My Applications</li>
			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/User/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>My Applications</h2>
		</div>

		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${sessionScope.message}</h3>
		<div class="container mt-3">
	
<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Game</th>
							<th scope="col">Date</th>
							<th scope="col">Price</th>
							<th scope="col">Image</th>
							<th scope="col">Location</th>
							<th scope="col">Status</th>
							
						</tr>
					</thead>
					<tbody>
					<%int sr=0; %>
						<c:forEach var="a" items="${sessionScope.aList}">
							<tr>
								<td> ${sr=sr+1} </td>
								<td scope="row">${a.event.sport}</td>
								<td scope="row">${a.event.date}</td>
								<td scope="row">${a.event.price}</td>
									
								<td><img src="data:image/jpeg;base64,${a.event.imgUtility}" height=100px width=100px/></td>
							<td scope="row">${a.event.location}</td>
							<td scope="row">${a.status}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

	</div>
</div>
</div>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Sport Action</a></li>
			<li class="breadcrumb-item active">Pending Applications</li>
			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/Manager/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Pending Applications</h2>
		</div>

		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
	
<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Name</th>
							<th scope="col">Acadmic Details</th>
							<th scope="col">Certifactions</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
							
						</tr>
					</thead>
					<tbody>
					<%int sr=0; %>
						<c:forEach var="a" items="${sessionScope.applications}">
							<tr>
								<td> ${sr=sr+1} </td>
								<td scope="row">${a.user.name}</td>
								<td scope="row"><a href='<spring:url value="/Manager/showUserAcadmic?uid=${a.user.id}"/>'><button class="btn btn-primary">Check Details</button></a></td>
									<td scope="row"><a href='<spring:url value="/Manager/showUserCertificate?uid=${a.user.id}"/>'><button class="btn btn-primary">Check Details</button></a></td>
								<td scope="row">${a.status}</td>
									<td scope="row"><a href='<spring:url value="/Manager/accept?aid=${a.id}"/>'><button class="btn btn-primary">Accept</button></a>
									<a href='<spring:url value="/Manager/reject?aid=${a.id}"/>'><button class="btn btn-danger">Reject</button></a>
									</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

	</div>
</div>
</div>

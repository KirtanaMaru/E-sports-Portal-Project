<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Sport Action</a></li>
			<li class="breadcrumb-item active">USer Certificate</li>
			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/Manager/sportApplications"/>'>Back</a></li>
		</ol>

<div class="alert alert-primary text-center" role="alert">
			<h2>User Certificate List</h2>
		</div>

<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Game</th>
							<th scope="col">Status</th>
							<th scope="col">Date</th>
							<th scope="col">Image</th>
						</tr>
					</thead>
					<tbody>
					<%int sr=0; %>
						<c:forEach var="crtify" items="${sessionScope.userCertificateList}">
							<tr>
								<td> ${sr=sr+1} </td>
								<td scope="row">${crtify.game}</td>
								<td scope="row">${crtify.status}</td>
								<td scope="row">${crtify.date}</td>
								<td><img src="data:image/jpeg;base64,${crtify.imgUtility}" height=100px width=100px/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

	</div>
</div>
</div>

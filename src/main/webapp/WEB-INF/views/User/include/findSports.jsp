
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">Sport Actions</li>
		</ol>
		<c:forEach var="e" items="${sessionScope.eventList}">
		<div class="row">
			<div class="col col-4">
				<img style="height: 90%; width: 100%;"
					src="data:image/jpeg;base64,${e.imgUtility}" >
			</div>
			<div class="col col-4">
				<h2>${e.title}</h2>
				<h2>${e.location}</h2>
				<h2>${e.date}</h2>
				<h2>Sport: ${e.sport}</h2>
				<h2>Contact:${e.mobile}</h2>
				<center><a href='<spring:url value="/User/applySport?eid=${e.id}"/>'> <button class="btn btn-primary">Apply</button></a></center>
			</div>
			<div class="col col-4">
				<iframe style="margin-right:100px;"
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3768.3542850683616!2d77.32206421482351!3d19.179722187028496!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bd1d6fbe138ad81%3A0x9e88bbe86ec52250!2sMGM&#39;s%20College%20Of%20Engineering!5e0!3m2!1sen!2sin!4v1670179680647!5m2!1sen!2sin"
					width="400" height="300" style="border: 0;" allowfullscreen=""
					loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
			</div>
		</div>
<hr>
</c:forEach>

	</div>
</div>




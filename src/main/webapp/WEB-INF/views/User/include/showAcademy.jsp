
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">My Dashboard</li>
		</ol>
		<c:forEach var="ad" items="${sessionScope.clgList}">
		<div class="row">
			<div class="col col-4">
				<img style="height: 90%; width: 100%;"
					src="data:image/jpeg;base64,${ad.imgUtility}" >
			</div>
			<div class="col col-4">
				<h2>${ad.name}</h2>
				<p>${ad.location}</p>
				<p>Established:${ad.established}<p>
				<p>Sport: ${ad.sport}<p>
				<p>Chairman:${ad.chairman}<p>
				<p>contact Us:${ad.mobile}<p>
			</div>
			<div class="col col-4">
				${ad.map}
			</div>
		</div>
<hr>
</c:forEach>

	</div>
</div>




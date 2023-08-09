<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script>
function myFunction() {
	today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //As January is 0.
	var yyyy = today.getFullYear();

	if(dd<10) dd='0'+dd;
	if(mm<10) mm='0'+mm;
	v=(yyyy+'-'+mm+'-'+dd);
  var x = document.getElementById("date").max=v;
  
}
</script>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Profile</a></li>
			<li class="breadcrumb-item active">Add Certifications</li>
			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/User/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>My Credentials</h2>
		</div>

		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${sessionScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post"  enctype="multipart/form-data">
					<fieldset>
						<div class="row">
							<div class="col-lg-4 panel">
								<h2>Add your Certifactions</h2>
							</div>
						</div>
						<hr>

						<div class="col-lg-4 panel panel-heading"
							style="display: none; color: red" id="contact_error"></div>
			</div>
			<div class="row form-group">
				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						Game</label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="game"
							name="game" class="form-control text-center" type="text" />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						Date of Certification </label>
					<div class="input-group">
						<input id="date" name="date" class="form-control text-center"
							type="date" onclick="myFunction()" max/>
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						Status </label>
					<div class="input-group">
						<select name="status" type="text" class="form-control text-center">
							<option value="Winner">Winner</option>
							<option value="Runner">Runner</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<label class="col control-label text-center" for="mobile">
					Certification Image(JPEG/PNG)</label>
				<div class="input-group">
					<input id="image" name="image" class="form-control text-center"
						type="file" />
				</div>
			</div>
			<br>
			<div class="form-group row">
				<div class="col-md-8 text-center">
					<input type="submit" id="save" value="Add" name="save"
						class="btn btn-large btn-success">
					<button class="btn btn-large btn-danger" type="reset">Cancel</button>
				</div>
			</div>
			</fieldset>
			</form>
		</div>
<div class="alert alert-primary text-center" role="alert">
			<h2>Availabe Certificate List</h2>
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

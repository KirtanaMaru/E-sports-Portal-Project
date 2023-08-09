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
  var x = document.getElementById("date").min=v;
  
}
</script>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Sport Action</a></li>

			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/Manager/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Add New Sport Event</h2>
		</div>

		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${sessionScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post" enctype="multipart/form-data">
					<fieldset>
						<div class="row">
							<div class="col-lg-4 panel">
								<h2>Add Event Details</h2>
							</div>
						</div>
						<hr>

						<div class="col-lg-4 panel panel-heading"
							style="display: none; color: red" id="contact_error"></div>
			</div>
			<div class="row form-group">
				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						Title</label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="title"
							name="title" class="form-control text-center" type="text" />
					</div>
				</div>
				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						Location</label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="location"
							name="location" class="form-control text-center" type="text" />
					</div>
				</div>
				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						Sport</label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="sport"
							name="sport" class="form-control text-center" type="text" />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						Date</label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="date"
							name="date" class="form-control text-center" type="date" onclick="myFunction()" min />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						Price</label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="price"
							name="price" class="form-control text-center" type="text" />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						Contact No</label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="mobile"
							name="mobile" class="form-control text-center" type="text" />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
					Map </label>
					<div class="input-group">
						<input id="map" name="map" class="form-control text-center"
							type="text" />
					</div>
				</div>

			</div>
			<div class="col-lg-12">
				<label class="col control-label text-center" for="mobile">
					 Image(JPEG/PNG)</label>
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
		
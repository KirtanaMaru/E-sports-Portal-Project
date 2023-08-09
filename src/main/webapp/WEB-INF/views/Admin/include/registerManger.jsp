<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Sport Management</a></li>

			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/Admin/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Add Sport Coordinators</h2>
		</div>

		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${sessionScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post" enctype="multipart/form-data">
					<fieldset>
						
						<div class="col-lg-4 panel panel-heading"
							style="display: none; color: red" id="contact_error"></div>
			</div>
			<div class="row form-group">
				<div class="col-lg-12">
					<label class="col control-label text-center" for="first_name">
						Name</label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="name"
							name="name" class="form-control text-center" type="text" />
					</div>
				</div>
				<div class="col-lg-12">
					<label class="col control-label text-center" for="first_name">
						Email</label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="email"
							name="email" class="form-control text-center" type="text" />
					</div>
				</div>
				
			</div>
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
		
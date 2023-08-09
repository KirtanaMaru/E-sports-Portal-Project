<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Profile</a></li>
			<li class="breadcrumb-item active">Player Qualifaction</li>
			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/Manager/sportApplications"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Player Qualifaction</h2>
		</div>

		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.success}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post">
					<fieldset>
						<div class="row">
							<div class="col-lg-4 panel">
								<h2>High School Detials</h2>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-lg-4 panel">
								<h3>SSC Details</h3>
							</div>
						</div>
						<div class="col-lg-4 panel panel-heading"
							style="display: none; color: red" id="contact_error"></div>
			</div>
			<div class="row form-group">
				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						SSC School Name </label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="name1"
							name="name1" value="${sessionScope.u.sscDetails.name1}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						SSC Passout Year </label>
					<div class="input-group">
						<input id="pyear1" name="pyear1"
							value="${sessionScope.u.sscDetails.pyear1}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						SSC percentage/Grade </label>
					<div class="input-group">
						<input id="grade1" name="grade1"
							value="${sessionScope.u.sscDetails.grade1}"
							class="form-control text-center" type="text"  readonly/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 panel">
					<h3>HSC Details</h3>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						HSC School Name </label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="name"
							name="name" value="${sessionScope.u.hscDetails.name}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						HSC Passout Year </label>
					<div class="input-group">
						<input id="pyear" name="pyear"
							value="${sessionScope.u.hscDetails.pyear}"
							class="form-control text-center" type="text"  readonly/>
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						HSC Marks/Gread </label>
					<div class="input-group">
						<input id="grade" name="grade"
							value="${sessionScope.u.hscDetails.grade}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>
			</div>

			<hr>
			<div class="row">
				<div class="col-lg-4 panel">
					<h3>Graduation Details</h3>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						Graduation College Name </label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="name2"
							name="name2" value="${sessionScope.u.gDetails.name2}"
							class="form-control text-center" type="text"  readonly/>
					</div>
				</div>
				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						Graduation Type </label>
					<div class="input-group">
						<input id="type" name="type"
							value="${sessionScope.u.gDetails.type}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>
				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						Graduation Passout Year </label>
					<div class="input-group">
						<input id="pyear2" name="pyear2"
							value="${sessionScope.u.gDetails.pyear2}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						Graduation Marks/Gread </label>
					<div class="input-group">
						<input id="grade2" name="grade2"
							value="${sessionScope.u.gDetails.grade2}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-lg-4 panel">
					<h3>Post Graduation Details</h3>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-lg-4">
					<label class="col control-label text-center" for="first_name">
						Post Graduation College Name </label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="name3"
							name="name3" value="${sessionScope.u.pgDetails.name3}"
							class="form-control text-center" type="text"  readonly/>
					</div>
				</div>
				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						Post Graduation Type </label>
					<div class="input-group">
						<input id="type2" name="type2"
							value="${sessionScope.u.pgDetails.type2}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>
				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						Post Graduation Passout Year </label>
					<div class="input-group">
						<input id="pyear3" name="pyear3"
							value="${sessionScope.u.pgDetails.pyear3}"
							class="form-control text-center" type="text" readonly />
					</div>
				</div>

				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						Post Graduation Marks/Gread </label>
					<div class="input-group">
						<input id="grade3" name="grade3"
							value="${sessionScope.u.pgDetails.grade3}"
							class="form-control text-center" type="text" readonly/>
					</div>
				</div>
			</div>
			
			</div>
			</fieldset>
			</form>
		</div>


	</div>
</div>
</div>

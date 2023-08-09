<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.col-lg-8 label{
        display: inline-block;
        width: 200px;
        text-align:center;
      }</style>

<div class="content-wrapper" align="center">
	<div class="container-fluid" >
		<ol class="breadcrumb" align="center">
			<li class="breadcrumb-item"><a href="#">Injury Prediction</a></li>
			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/User/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Injury Recovery Prediction</h2>
		</div>

		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post" enctype="multipart/form-data">
					<fieldset>
						<div class="row">
							<div class="col-lg-12 panel">
								<h2>Injury Prediction Form( Please provide Correct Input To
									get Accurate Prediction)</h2>
							</div>
						</div>
						<hr>

						<div class="col-lg-4 panel panel-heading"
							style="display: none; color: red" id="contact_error"></div>
			</div>
			<div class="row form-group" >
				<div class="col-lg-8" >
					<label class="col control-label text-center" for="first_name">
						Age </label>
					<div class="input-group">
						<i class="glyphicon glyphicon-user"></i> <input id="age"
							name="age" class="form-control text-center" type="number" required/>
					</div>
				</div>

				<div class="col-lg-8">
					<label class="col control-label text-center" for="mobile" text>
						Weight(KG)</label>
					<div class="input-group">
						<input id="weight" name="weight" class="form-control text-center"
							type="text"  required/>
					</div>
				</div>
				<div class="col-lg-8">
					<label class="col control-label text-center" for="mobile">
						Height (feet)</label>
					<div class="input-group">
						<input id="height" name="height" class="form-control text-center"
							type="text"  required/>
					</div>
				</div>
				
				<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						${requestScope.message1}</label>
									</div>

				<div class="col-lg-8">
					<label class="col control-label text-center" for="mobile">
						Blood Group</label>
					<div class="input-group">
						<select name="blood" type="text" class="form-control text-center">
							<option value="A+">( A + )</option>
							<option value="A-">( A - )</option>
							<option value="B+">( B + )</option>
							<option value="B-">( B - )</option>
							<option value="O+">( O + )</option>
							<option value="O-">( O - )</option>
							<option value="AB+">( AB + )</option>
							<option value="AB-">( AB - )</option>
						</select>
					</div>
				</div>
<div class="col-lg-4">
					<label class="col control-label text-center" for="mobile">
						${requestScope.message2}</label>
									</div>
				<div class="col-lg-8">
					<label class="col control-label text-center" for="mobile">
						Blood Pressure (mm Hg)</label>
					<div class="input-group">
						<input id="bp" name="bp" class="form-control text-center"
							type="text"  required />
					</div>
				</div>
				
				<div class="col-lg-8">
					<label class="col control-label text-center" for="mobile">
						Do you have Sugar</label>
					<div class="input-group">
						<select name="suger" type="text" class="form-control text-center">
							<option value="Yes">Yes</option>
							<option value="No">No</option>
						</select>
					</div>
				</div>
				<div class="col-lg-8">
					<label class="col control-label text-center" for="mobile">
						Type of Bleeding if any</label>
					<div class="input-group">
						<select name="blooding" type="text" class="form-control text-center">
							<option value="no">No Bleeding</option>
							<option value="swelling">Swelling</option>
							<option value="internal">Internal Bleeding</option>
							<option value="external">External Bleeding</option>
						</select>
					</div>
				</div>
				<div class="col-lg-8">
					<label class="col control-label text-center" for="mobile" style="text-align: center">
						Gender</label>
					<div class="input-group">
						<select name="gender" type="text" class="form-control text-center">
							<option value="male">Male</option>
							<option value="female">Female</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<label class="col control-label text-center" for="mobile">
				Add Image of injury(JPEG/PNG)</label>
				<div class="input-group">
					<input id="image" name="image" class="form-control text-center"
						type="file" />
				</div>
			</div>
			<br>
			<div class="form-group row">
				<div class="col-md-8 text-center">
					<input type="submit" id="save" value="Check Preduction"
						class="btn btn-large btn-success">
					<button class="btn btn-large btn-danger" type="reset">Cancel</button>
				</div>
			</div>
			</fieldset>
			</form>
		</div>


	</div>
</div>
</div>

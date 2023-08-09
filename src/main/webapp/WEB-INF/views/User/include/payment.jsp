<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- font awesome style -->

<!-- Custom styles for this template -->
<link href='<spring:url value="/css/style.css"/>' rel="stylesheet" />
<!-- responsive style -->

<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Shopping</a></li>
			<li class="breadcrumb-item active">Shopping</li>
			<li class="breadcrumb-item"><a class="btn btn-primary rightside"
				href='<spring:url value="/User/Dashboard"/>'>Back</a></li>
		</ol>
 <div class="col-lg-7">
                                    <form action='<spring:url value="/User/pay"/>' method="post" class="form">
                                        <div class="row">
                                            <div class="col-12">
                                                <div class="form__div">
                                                    <input type="text" name="cardNo" class="form-control" placeholder=" ">
                                                    <label for="" class="form__label">Card Number</label>
                                                </div>
                                            </div>

                                            <div class="col-6">
                                                <div class="form__div">
                                                    <input type="text" name="expDate" class="form-control" placeholder=" ">
                                                    <label for="" class="form__label">MM / yy</label>
                                                </div>
                                            </div>

                                            <div class="col-6">
                                                <div class="form__div">
                                                    <input type="password" name="cvv" class="form-control" placeholder=" ">
                                                    <label for="" class="form__label">cvv code</label>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="form__div">
                                                    <input type="text" name="name" class="form-control" placeholder=" ">
                                                    <label for="" class="form__label">name on the card</label>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <button class="btn btn-primary w-100">Sumbit</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
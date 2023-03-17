<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="../css/styles.css" />
<title>View Booking</title>
</head>

<body style="background-color: white;">
	<c:if test="${sessionScope.user == null }">
		<jsp:include page="/resources/views/access_denied.jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.user != null }">
		<!-- header -->
		<jsp:include page="/resources/views/header.jsp"></jsp:include>

		<div class="container-fluid">
			<div class="row">
				<!-- left side -->
				<div class="row-left col-sm-2"
					style="background-color: #F8F9FA; border-right: 2px solid #DEE2E6;">
					<jsp:include page="/resources/views/dashboard.jsp"></jsp:include>
				</div>

				<!-- right side -->
				<div class="row-right col-sm-10" style="background-color: white">
					<div class="container1" style="margin-top: 50px;">
						<h1>View Booking</h1>
						<hr>
					</div>
					<div class="container2 ">
						<div class="a" style="background-color: #F8F9FA; font-size: 20px;">
							<div>
								<p style="margin-left: 15px; padding-top: 10px;">Information
									Booking</p>
							</div>
							<hr>
						</div>
						<form action="" method="post">

							<!-- add fullname -->
							<%-- <p class="col-2" style="color: #4CAF50">${message}</p>	 --%>
							<div class="form-group row">
								&emsp; <label for="bookingname" class="col-3 col-form-label">Booking
									office name </label><br>
								<div class="col-5">
									<input id="bookingname" name="bookingname"
										placeholder="Enter booking office name "
										class="form-control here" value="${bookingOffice.officeName}"
										required="required" type="text" readonly="readonly">
								</div>
							</div>
							<!-- trip -->
							<div class="form-group row">
								&emsp; <label for="trip" class="col-3 col-form-label">Trip
								</label><br>
								<div class="col-5">
									<input id="trip" name="trip" placeholder="Trip "
										class="form-control here" value="${bookingOffice.officeName}"
										required="required" type="text" readonly="readonly">
								</div>
							</div>
							<!-- phone number -->
							<div class="form-group row">
								&emsp; <label for="phonenumber" class="col-3 col-form-label">Phone
									number </label><br>
								<div class="col-5">
									<input id="phonenumber" name="phonenumber"
										placeholder="Enter phone number" class="form-control here"
										value="${bookingOffice.officePhone}" required="required"
										type="text" readonly="readonly">
								</div>
							</div>
							<!-- Place -->
							<div class="form-group row">
								&emsp; <label for="place" class="col-3 col-form-label">Place
								</label><br>
								<div class="col-5">
									<input id="place" name="place" placeholder="Place"
										class="form-control here" value="${bookingOffice.officePlace}"
										required="required" type="text" readonly="readonly">
								</div>
							</div>

							<!-- Price -->
							<div class="form-group row">
								&emsp; <label for="price" class="col-3 col-form-label">Price<span
									style="font-weight: bold">(VND)</span>

								</label><br>
								<div class="col-5">
									<input id="price" name="price" placeholder="Enter price"
										class="form-control here" value="${bookingOffice.officePrice}"
										required="required" type="text" readonly="readonly">
								</div>
							</div>
							<!-- Contract deadline -->
							<div class="form-group row">
								&emsp; <label for="deadline" class="col-3 col-form-label">Contract
									deadline </label><br>
								<p class="col-2 col-form-label">From date</p>
								<div class="col-3">
									<input id="from" name="from" placeholder="From date"
										class="form-control here"
										value="${bookingOffice.startContractDeadline}"
										required="required" type="text" readonly="readonly">
								</div>
								<br>

							</div>
							<div class="form-group row">
								&emsp;<label for="deadline" class="col-3 col-form-label"><span
									style="color: red; font-weight: bold"></span> </label><br>
								<p class="col-2 col-form-label">To date</p>
								<div class="col-3">
									<input id="to" name="to" placeholder="To date"
										class="form-control here"
										value="${bookingOffice.endContractDeadline}"
										required="required" type="text" readonly="readonly">
								</div>
							</div>

							<div class="form-group ">
								<div class=" col-8">
									<!-- button back -->
									<button name="submit" type="reset" class="btn btn-primar"
										style="background-color: #57B8D5; border: 1px solid #EAEAEA; color: white"
										onclick="history.back()">
										<i class="bi bi-backspace"></i> Back
									</button>
								</div>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
		<style>
.form-group {
	font-weight: bold;
}

body {
	background-color: #F5F5F5;
	font-family: Sans-serif;
}

.container2 {
	border: 1px solid #e8e8e8;
	border-radius: 4px;
	/* padding-left: 10px; */
	margin-bottom: 1px;
}
</style>

	</c:if>


</body>

</html>
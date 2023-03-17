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
<title>Add Trip</title>
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
						<h1>Add Trip</h1>
						<hr>
					</div>
					<div class="container2 ">
						<div class="a" style="background-color: #F8F9FA; font-size: 20px;">
							<div>
								<p style="margin-left: 15px; padding-top: 10px;">Information
									Trip</p>
							</div>
							<hr>
						</div>
						<form
							action="${pageContext.request.contextPath}/addTripController"
							method="post">

							<!-- add Destination -->
							<p class="col-2" style="color: #4CAF50">${message1}</p>
							<div class="form-group row">
								&emsp;<label for="destination" class="col-3 col-form-label">Destination
									<span style="color: red; font-weight: bold">(*)</span>
								</label><br>
								<div class="col-5">
									<input id="destination" name="destination"
										placeholder="Enter destination " class="form-control here"
										required="required" type="text">
								</div>
							</div>
							<!-- Departure time -->
							<div class="form-group row">
								&emsp;<label for="time" class="col-3 col-form-label">Departure
									time <span style="color: red; font-weight: bold">(*)</span>
								</label><br>
								<div class="col-5">
									<input id="time" name="time" placeholder=" "
										class="form-control here" required="required" type="time">
								</div>
							</div>

							<!-- Driver -->
							<div class="form-group row">

								&emsp;<label for="color" class="col-3 col-form-label">Driver
									<span style="color: red; font-weight: bold">(*)</span>

								</label><br>
								<div class="col-5">
									<input id="driver" name="driver" placeholder="Enter driver "
										class="form-control here" required="required" type="text">
								</div>
							</div>
							<!-- Car type -->
							<div class="form-group row">

								&emsp;<label for="type" class="col-3 col-form-label">Car
									type <span style="color: red; font-weight: bold">(*)</span>
								</label><br>
								<div class="col-5">
									<input id="type" name="type" placeholder="Enter car type "
										class="form-control here" required="required" type="text">
								</div>
							</div>
							<!-- Maximum online ticket number-->
							<div class="form-group row">

								&emsp;<label for="number" class="col-3 col-form-label">Maximum
									online ticket number <span
									style="color: red; font-weight: bold">(*)</span>
								</label><br>
								<div class="col-5">
									<input id="number" name="number" placeholder="0 "
										class="form-control here" required="required" type="number">
								</div>
							</div>
							<!-- Departure date -->
							<div class="form-group row">

								&emsp;<label for="deadline" class="col-3 col-form-label">Departure
									date <span style="color: red; font-weight: bold">(*)</span>
								</label><br>

								<div class="col-5">
									<input id="date" name="date" placeholder="dd/mm/yyy"
										class="form-control here" required="required" type="date">
								</div>
								<br>
							</div>
							<div class="form-group " style="padding-left: 150px">
								<div class=" col-8">
									&emsp;
									<!-- button reset -->
									<button name="submit" type="reset" class="btn btn-primar"
										style="background-color: #F0AD4E; border: 1px solid #EAEAEA; color: white">
										<i class="bi bi-x-circle"></i> Reset
									</button>
									&emsp;
									<!-- button submit -->
									<button name="submit" type="submit" class="btn btn-primar"
										style="background-color: #5CB85C; border: 1px solid #EAEAEA; color: white">
										<i class="bi bi-plus-circle"></i> Add
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
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
<title>Add Ticket</title>
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
					<h1>Add Ticket</h1>
					<hr>
				</div>
				<div class="container2 ">
					<div class="a" style="background-color: #F8F9FA; font-size: 20px;">
						<div>
							<p style="margin-left: 15px; padding-top: 10px;">Information
								Ticket</p>
						</div>
						<hr>
					</div>
					<form action="${pageContext.request.contextPath}/AddTicketController" method="post">

						<!-- add Customer -->
						<p class="col-12" style="color: #4CAF50">${message}</p>
						<p class="col-12" style="color: red">${mess}</p>
						<div class="form-group row">
							&emsp;<label for="customer" class="col-3 col-form-label">Customer
								<span style="color: red; font-weight: bold">(*)</span>
							</label><br>
							<div class="col-5">
								<input id="customer" name="customer"
									placeholder="Enter customer name " class="form-control here"
									required="required" type="text">
							</div>
						</div>
						<!-- Booking time -->
						<div class="form-group row">

							&emsp;<label for="time" class="col-3 col-form-label">Booking
								time <span style="color: red; font-weight: bold">(*)</span>
							</label><br>
							<div class="col-5">
								<input id="time" name="time" placeholder=" "
									class="form-control here" required="required" type="time">
							</div>
						</div>
						<!-- Trip -->
						<div class="form-group row">

							&emsp;<label for="trip" class="col-3 col-form-label">Trip
								<span style="color: red; font-weight: bold">(*)</span>
							</label><br>
							<div class="col-5">
								<select class="form-control mr-sm" name="trip" id="trip"
									style="border: 1px solid #e8e8e8; border-radius: 5px;">
									<option value="1" ${trip == 1?"selected":""}>Ca Mau</option>
									<option value="2" ${trip == 2?"selected":""}>Ha Giang</option>
                                    <option value="3" ${trip == 3?"selected":""}>Phu Quoc</option>

								</select>
							</div>
						</div>
						<!-- License plate -->
						<div class="form-group row">

							&emsp;<label for="license" class="col-3 col-form-label">License
								plate <span style="color: red; font-weight: bold">(*)</span>
							</label><br>
							<div class="col-5">
								<input id=license name="license"
									placeholder="Enter license " class="form-control here"
									required="required" type="text">
							</div>
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
	

	 </c:if>

</body>
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
	margin-bottom: 1px;
}
</style>
</html>
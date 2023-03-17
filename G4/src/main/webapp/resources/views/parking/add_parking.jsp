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
<title>Add Parking</title>
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
			<div class="row-left col-sm-2" style="background-color: #F8F9FA;">
				<jsp:include page="/resources/views/dashboard.jsp"></jsp:include>
			</div>

			<!-- right side -->
			<div class="row-right col-sm-10" style="background-color: white">
				<div class="container1" style="margin-top: 50px;">
					<h1>Add Parking Lot</h1>
					<hr>
				</div>
				<div class="container2 ">
					<div class="a" style="background-color: #F8F9FA; font-size: 20px;">
						<div>
							<p style="margin-left: 15px; padding-top: 10px;">Information
								Parking</p>
						</div>
						<hr>
					</div>
					<form action="AddParking" method="post">
						<!-- add booking office name -->
						<p class="col-2" style="color: #4CAF50">${message}</p>
						<div class="form-group row">
							&emsp; <label for="parking" class="col-3 col-form-label">Parking
								name <span style="color: red; font-weight: bold">(*)</span>
							</label><br>
							<div class="col-5">
								<input id="parking" name="parking"
									placeholder="Enter booking parking name "
									class="form-control here" required="required" type="text">
							</div>
						</div>
						<!-- Place -->
						<div class="form-group row">
							&emsp; <label for="place" class="col-3 col-form-label">Place
								<span style="color: red; font-weight: bold">(*)</span>
							</label><br>
							<div class="col-5">
								<select class="form-control mr-sm" name="listA" id="listA"
									style="border: 1px solid #e8e8e8; border-radius: 5px;">
									<option value="Ha Dong" name="hadong">Ha Dong</option>
									<option value="Cau Giay" name="caugiay">Cau Giay</option>

								</select>
							</div>
						</div>
						<!-- Area -->
						<div class="form-group row">
							&emsp; <label for="area" class="col-3 col-form-label">Area<span
								style="font-weight: bold">(m2)</span> <span
								style="color: red; font-weight: bold">(*)</span>
							</label><br>
							<div class="col-5">
								<input id="area" name="area" placeholder="Enter area"
									class="form-control here" required="required" type="text">
							</div>
						</div>
						<!-- Price -->
						<div class="form-group row">
							&emsp; <label for="price" class="col-3 col-form-label">Price<span
								style="font-weight: bold">(VND)</span> <span
								style="color: red; font-weight: bold">(*)</span>
							</label><br>
							<div class="col-5">
								<input id="price" name="price" placeholder="Enter price"
									class="form-control here" required="required" type="text">
							</div>
						</div>
 
						<div class="form-group" style="padding-left: 150px">
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
	<!-- script bootstrap template -->
	</c:if>


</body>

</html>
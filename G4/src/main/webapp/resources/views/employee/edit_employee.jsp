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
<title>Employee Profile</title>
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
						<h1>Employee Profile</h1>
						<hr>
					</div>
					<div class="container2 ">
						<div class="a" style="background-color: #F8F9FA; font-size: 20px;">
							<div>
								<p style="margin-left: 15px; padding-top: 10px;">Information
									Employee</p>
							</div>
							<hr>
						</div>
						<form action="${pageContext.request.contextPath}/editEmployee"
							method="post">
							<input readonly="readonly" hidden="hidden" id="id" name="id"
								value="${e.employeeId}">
							<!-- add full name -->
							<p class="col-12" style="color: red">${err}</p>
							<p class="col-12" style="color: #4CAF50">${message}</p>
							<div class="form-group row">
								&emsp;<label for="fullname" class="col-3 col-form-label">Full
									name </label>
								<div class="col-5">
									<input id="fullname" name="fullname"
										placeholder="Enter full name " class="form-control here"
										required="required" type="text" value="${e.employeeName}">
								</div>
							</div>
							<!-- phone number -->
							<div class="form-group row">
								&emsp;<label for="phonenumber" class="col-3 col-form-label">Phone
									number </label>
								<div class="col-5">
									<input id="phonenumber" name="phonenumber"
										placeholder="Enter phone number" class="form-control here"
										required="required" type="text" value="${e.employeePhone}"
										readonly="readonly">
								</div>
							</div>
							<!-- Date of birth -->
							<div class="form-group row">

								&emsp;<label for="dob" class="col-3 col-form-label">Date
									of birth </label>
								<div class="col-5">
									<input id="dob" name="dob" placeholder="dd/mmm/yyyy"
										class="form-control here" required="required" type="date"
										value="${e.employeeBirthdate }" readonly="readonly">
								</div>
							</div>
							<!-- Sex -->
							<div class="form-group row">

								&emsp;<label for="sex" class="col-3 col-form-label">Sex
								</label>
								<div class="col-5">
									<input type="radio" name="gender" value="M"
										${e.sex == 'M'?"checked":""}> Male &emsp;<input
										type="radio" name="gender" value="F"
										${e.sex == 'F'?"checked":""}>Female
								</div>
							</div>
							<!-- Address -->
							<div class="form-group row">
								&emsp;<label for="address" class="col-3 col-form-label">Address
								</label>
								<div class="col-5">
									<input id="address" name="address" placeholder="Enter address"
										class="form-control here" required="required" type="text"
										value="${e.employeeAddress }">
								</div>
							</div>
							<!-- Email -->
							<div class="form-group row">

								&emsp;<label for="email" class="col-3 col-form-label">Email
								</label><br>
								<div class="col-5">
									<input id="email" name="email" placeholder="Enter Email"
										class="form-control here" required="required" type="text"
										value="${e.employeeEmail }">
								</div>
							</div>
							<!-- Account -->
							<div class="form-group row">

								&emsp;<label for="account" class="col-3 col-form-label">Account
								</label>
								<div class="col-5">
									<input id="account" name="account" placeholder="Enter account"
										class="form-control here" required="required" type="text"
										readonly="readonly" value="${e.account }">
								</div>
							</div>
							<!-- Department -->
							<div class="form-group row">
								&emsp;<label for="department" class="col-3 col-form-label">Department
								</label>
								<div class="col-5">
									<select class="form-control mr-sm" name="department"
										id="department"
										style="border: 1px solid #e8e8e8; border-radius: 5px;">
										<option value="Employee"
											${e.department == 'Employee'?"selected":""}>Employee</option>
										<option value="Parking"
											${e.department == 'Parking'?"selected":""}>Parking</option>
										<option value="Service"
											${e.department == 'Service'?"selected":""}>Service</option>

									</select>
								</div>
							</div>
							<div class="form-group row">
								&emsp;<label for="password" class="col-3 col-form-label">Change
									Password </label>
								<div class="col-5">
									<a
										href="${pageContext.request.contextPath}/changePassword?account=${e.account}"
										style="text-decoration: none">Change Password</a>
								</div>
							</div>
							<div class="form-group row " style="padding-left: 150px">
								<div class=" col-8">
									<!-- button back -->
									<button name="submit" type="reset" class="btn btn-primar"
										style="background-color: #57B8D5; border: 1px solid #EAEAEA; color: white"
										onclick="history.back()">
										<i class="bi bi-backspace"></i> Back
									</button>
									&emsp;
									<!-- button reset -->
									<button name="submit" type="reset" class="btn btn-primar"
										style="background-color: #F0AD4E; border: 1px solid #EAEAEA; color: white">
										<i class="bi bi-x-circle"></i> Reset
									</button>
									&emsp;
									<!-- button submit -->
									<button name="submit" type="submit" class="btn btn-primar"
										style="background-color: #5CB85C; border: 1px solid #EAEAEA; color: white"
										onclick="Update()">
										<i class="bi bi-plus-circle"></i> Update
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
		<script type="text/javascript">
			function Update() {
				alert("Are you sure about this change?");
			}
		</script>

	</c:if>


</body>

</html>
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
<title>Change password</title>
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
						<h1>Change password</h1>
						<hr>
					</div>
					<div class="container2 ">

						<form action="${pageContext.request.contextPath}/changePassword"
							method="post">
							<input readonly="readonly" hidden="hidden" id="id" name="id"
								value="${e.employeeId}">
							<p class="col-12" style="color: red">${err}</p>
							<p class="col-12" style="color: #4CAF50">${message}</p>
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
							<!-- Old Password -->
							<div class="form-group row">

								&emsp;<label for="password" class="col-3 col-form-label">Old
									Password </label>
								<div class="col-5">
									<input id="password" name="oldpassword"
										placeholder="Enter old password" class="form-control here"
										required="required" type="password" value="${oldpassword}">
								</div>
							</div>
							<!-- New Password -->
							<div class="form-group row">
								&emsp;<label style="margin-top: 24px" for="password"
									class="col-3 col-form-label">New Password </label>
								<div class="col-5">
									<small style="font-size: 12px; font-style: italic">The
										password must have at least 6 characters, including uppercase
										,lowercase and number.</small> <input id="password" name="newpassword"
										placeholder="Enter new password" class="form-control here"
										required="required" type="password" value="${newpassword}">
								</div>
							</div>
							<!-- Confirm Password -->
							<div class="form-group row">

								&emsp;<label for="password" class="col-3 col-form-label">Confirm
									Password </label>
								<div class="col-5">
									<input id="password" name="confirmpassword"
										placeholder="Confirm new password" class="form-control here"
										required="required" type="password" value="${confrimpassword}">
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
									<!-- button submit -->
									<button name="submit" type="submit" class="btn btn-primar"
										style="background-color: #5CB85C; border: 1px solid #EAEAEA; color: white"
										onclick="Update()">
										<i class="bi bi-gear-fill"></i> Change
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
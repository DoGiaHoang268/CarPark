<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<!-- Bootstrap CSS -->
</head>

<body>
	<jsp:include page="/resources/views/header.jsp"></jsp:include>

	<div class="container-fluid"
		style="margin-top: 100px; margin-bottom: 200px">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
					<div class="login-title">
						<p style="font-size: 24px; text-align: left;">Sign In</p>
						<p style="color: red">${message}</p>
						<hr>
					</div>
					<div class="login-form mt-4">
						<form action="${pageContext.request.contextPath}/login" method="post" name="login-form">
							<div class="form-row">
								<div class="form-group col-md-12">
									<input id="user" name="user" placeholder="Username"
										class="form-control" type="text" value="${username}">
								</div>
								<div class="form-group col-md-12">
									<input type="password" class="form-control" id="password"
										name="password" placeholder="Password" value="${password}">
								</div>
								<div class="form-group col-md-12" style="text-align: left;">
									<input type="checkbox" name="remember" />Remember me <br>
								</div>
								<div class="form-group col-md-12">
									<button type="submit" class="btn btn-block"
										style="background-color: #1C9EE3; color: white;">Login</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>


</html>
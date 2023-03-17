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
<title>Home</title>
</head>
<body>
	<!-- header -->
	<jsp:include page="/resources/views/header.jsp"></jsp:include>
	<div class="container-fluid">
		<c:if test="${sessionScope.user!=null }">
			<div class="row">
				<!-- left side -->
				<div class="row-left col-sm-2"
					style="background-color: #F8F9FA; border-right: 2px solid #DEE2E6;">
					<jsp:include page="/resources/views/dashboard.jsp"></jsp:include>
				</div>

				<!-- right side -->
				<div class="row-right col-sm-10" style="background-color: white">
					<p style="text-align: center; font-size: 50px">Welcome to car
						park</p>
				</div>
			</div>
		</c:if>
		<c:if test="${sessionScope.user==null }">
			<div class="" style="background-color: white">
				<p style="text-align: center; font-size: 50px">Welcome to car
					park</p>
			</div>
		</c:if>
	</div>
</body>
</html>
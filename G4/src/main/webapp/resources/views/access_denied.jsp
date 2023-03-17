<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Access Denied</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
	<div class="w3-display-middle">
		<h1 class="w3-jumbo w3-animate-top w3-center">
			<code>Access Denied!</code>
		</h1>
		<hr>
		<h3 class="w3-center w3-animate-right">You need Login 
			to view this site.</h3>
		<h3 class="w3-center w3-animate-zoom"></h3>
		<h6 class="w3-center w3-animate-zoom">Error code: 403 forbidden</h6>
	</div>
</body>
</html>
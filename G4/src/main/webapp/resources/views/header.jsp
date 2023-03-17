<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
	<c:if test="${sessionScope.user==null}">
		<nav class="navbar navbar-expand-sm navbar-light bg-light"
			style="border-bottom: 2px solid #DEE2E6;">
			<a class="navbar-brand" href="#"
				style="font-size: 24px; font-weight: bold; text-decoration: none">Car<i
				class="bi bi-car-front"></i>Park

			</a>
			<div class="collapse navbar-collapse" id="collapsibleNavId">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				</ul>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/logout"> <i
					class="bi bi-box-arrow-right"></i> Login
				</a>
			</div>
		</nav>
	</c:if>
	<c:if test="${sessionScope.user!=null}">
		<nav class="navbar navbar-expand-sm navbar-light bg-light"
			style="border-bottom: 2px solid #DEE2E6;">
			<a id="navbar" class="navbar-brand"
				href="${pageContext.request.contextPath}/resources/views/home.jsp"
				style="font-size: 20px; color: #737373; text-decoration: none">
				${title} </a>
			<div class="collapse navbar-collapse" id="collapsibleNavId">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				</ul>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/editEmployee?account=${user.account}">Hello
					${user.account}</a>&emsp; <a style="text-decoration: none"
					href="${pageContext.request.contextPath}/logout"> Logout <i
					class="bi bi-box-arrow-right"></i></a>
			</div>


		</nav>
	</c:if>
</body>
</html>
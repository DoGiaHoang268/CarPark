
<%@page import="java.util.ArrayList"%>
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
<title>List Parking</title>
</head>

<body style="background-color: white;">
	<c:if test="${sessionScope.user == null }">
		<jsp:include page="/resources/views/access_denied.jsp"></jsp:include>
	</c:if>

	<c:if test="${sessionScope.user != null }">
	<jsp:include page="/resources/views/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<!-- left side -->
			<div class="row-left col-sm-2" style="background-color: #F8F9FA;">
				<jsp:include page="/resources/views/dashboard.jsp"></jsp:include>
			</div>
			<!-- right side -->
			<div class="row-right col-sm-10" style="background-color: white">
				<div class="container1">
					<div style="padding-bottom: 50px; margin-top: 50px;">
						<div style="float: left;">
							<h1>List Parking Lot</h1>
						</div>
						<div class="" style="float: right; padding-right: 20px;">
							<form class="form-inline" action="SearchParking">
								<!-- icon -->
								<div class="form-control mr-sm"
									style="border: 1px solid #e8e8e8; border-radius: 2px; background-color: #EAEAEA">
									<i class="bi bi-search"></i>
								</div>
								<!-- search box -->
								<input class="form-control mr-sm" type="search"
									placeholder="Search" aria-label="Search" name="search">
								<!-- label filter by -->
								<div class="form-control mr-sm"
									style="border: 1px solid #e8e8e8; border-radius: 2px; background-color: #EAEAEA; margin-left: 7px;">
									<i class="bi bi-funnel-fill"></i> Filter By
								</div>
								<!-- select -->
								<div>
									<select class="form-control mr-sm" name="filterSearch" id="listE"
										style="border: 1px solid #e8e8e8; border-radius: 5px;">
										<option value="all">-All-</option>
										<option value="parkName">Park Name</option>
										<option value="parkPlace" >Park Place</option>
										<option value="parkArea">Park Area</option>
										<option value="parkPrice" >Park Price</option>
										<option value="parkStatus" >Park Status</option>
									</select>
								</div>
								<!-- btn search -->
								<button class="btn"
									style="border: 1px solid #e8e8e8; border-radius: 5px; background-color: #55C2DA; color: white; margin-left: 7px;"
									type="submit">Search</button>
							</form>
						</div>

					</div>

					<hr>
				</div>
				<div class="container2 ">
					<div class="a" style="background-color: #F8F9FA; font-size: 20px;">
						<div>
							<p style="margin-left: 15px; padding-top: 10px;">
						</div>

						<hr>
					</div>
					<form action="">

						<p class="col-2" style="color: #4CAF50">${message}</p>
						<!-- table -->
						<%-- <p class="col-2" style="color: #4CAF50">${message}</p> --%>
						<div class="table1"
							style="margin-left: 20px; margin-bottom: 20px; width: 98%;">
							<table class="table">
								<thead>
									<tr>
										<th>Id</th>
										<th>Parking lot</th>
										<th>Place</th>
										<th>Area</th>
										<th>Price</th>
										<th>Status</th>
										<th>Action</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${parking}" var="x"> 
									<tr>
										<td>${x.parkId}</td>
										<td>${x.parkName}</td>
										<td>${x.place}</td>
										<td>${x.parkArea}</td>
										<td>${x.price}</td>
										<td>${x.status}</td>
										<td><a
											href="/G4/EditParking?parkId=${x.parkId}"><i
												class="bi bi-pencil-square"></i></i> Edit</a>&emsp; <a href="/G4/DeleteParking?parkId=${x.parkId}"><i
												class="bi bi-trash-fill"></i> Delete</a></td>

									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</form>
				</div>
				<!-- navigation -->
				<div class="navigation">
					<nav>
						<ul class="pagination">
							<c:forEach begin="1" end="${endP}" var="p">
								<li class="page-item"><a class="page-link" href="/G4/ViewParking?index=${p}">${p}</a></li>
							</c:forEach>
						</ul>
					</nav>
				</div>

			</div>
		</div>

	</div>
	<style>
.table, td, th {
	border: 1px solid #e8e8e8;
	border-radius: 3px;
	border-collapse: collapse;
}

tbody tr:nth-child(odd) {
	background-color: #F8F9FA;
}

.navigation {
	margin-top: 20px;
}

.container2 {
	border: 1px solid #e8e8e8;
	border-radius: 4px;
	/* padding-left: 10px; */
	margin-bottom: 1px;
}

body {
	background-color: #F5F5F5;
	font-family: Sans-serif;
}
</style>
	<script type="text/javascript">
		function Delete() {
			alert("Are you sure about deleted?");
		}
	</script>
	</c:if>

</body>

</html>
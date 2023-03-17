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
<title>List Ticket</title>
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
				<div class="row-left col-sm-2"
					style="background-color: #F8F9FA; border-right: 2px solid #DEE2E6;">
					<jsp:include page="/resources/views/dashboard.jsp"></jsp:include>
				</div>
				<!-- right side -->
				<div class="row-right col-sm-10" style="background-color: white">
					<div class="container1">
						<div style="padding-bottom: 50px; margin-top: 50px;">
							<div style="float: left;">
								<h1>List Ticket</h1>
							</div>
							<div class="" style="float: right; padding-right: 20px;">
								<form class="form-inline"
									action="${pageContext.request.contextPath}/SearchTicketController?sindex=1">
									<!-- icon -->
									<div class="form-control mr-sm"
										style="border: 1px solid #e8e8e8; border-radius: 2px; background-color: #EAEAEA">
										<i class="bi bi-search"></i>
									</div>
									<!-- search box -->
									<input class="form-control mr-sm" type="search"
										placeholder="Search" aria-label="Search" name="search"
										value="${save}">
									<!-- label filter by -->
									<div class="form-control mr-sm"
										style="border: 1px solid #e8e8e8; border-radius: 2px; background-color: #EAEAEA; margin-left: 7px;">
										<i class="bi bi-funnel-fill"></i> Filter By
									</div>
									<!-- select -->
									<div>
										<select class="form-control mr-sm" name="select" id="select"
											style="border: 1px solid #e8e8e8; border-radius: 5px;">
											<option value="0" ${select== 0?"selected":""}>-All-</option>
											<option value="1" ${select== 1?"selected":""}>Ticket
											</option>
											<option value="2" ${select== 2?"selected":""}>Booking
												Time</option>
											<option value="3" ${select== 3?"selected":""}>Custumer
												Name</option>
											<option value="4" ${select== 4?"selected":""}>License
												Plate</option>
											<option value="5" ${select== 5?"selected":""}>Trip</option>
										</select>
									</div>
									<div class="form-control mr-sm">
										<input type="date"></input>
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
						<form
							action="${pageContext.request.contextPath}/SearchTicketController">
							<!-- table -->
							<%-- <p class="col-2" style="color: #4CAF50">${message}</p> --%>
							<div class="table1"
								style="margin-left: 20px; margin-bottom: 20px; width: 98%;">
								<table class="table">
									<thead>
										<tr>
											<th>No</th>
											<th>Trip</th>
											<th>License plate</th>
											<th>Customer</th>
											<th>Booking time</th>
											<th>Action</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listT}" var="t">
											<tr>
												<td>${t.ticketId}</td>
												<td>${t.destination}</td>
												<td>${t.licensePlate}</td>
												<td>${t.customerName}</td>
												<td>${t.bookingTime}</td>
												<td><a
													href="${pageContext.request.contextPath}/DeleteTicketController?licenseplate=${x.ticketId}"
													onclick="Delete()"><i class="bi bi-trash-fill"></i>
														Delete</a></td>

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
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath}/SearchTicketController?index=${p}&search=${save}">${p}</a></li>
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
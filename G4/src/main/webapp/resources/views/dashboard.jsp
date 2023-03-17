<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>Dash board</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
</head>
<body>
	<!------------------------------------Employee---------------------------------------------------->
	<c:if test="${sessionScope.user.department=='Employee'}">
		<p style="color: #027DFF">
			<i class="bi bi-speedometer2"></i> DashBoard
		</p>
		<hr>
		<!-- Employee Manager  -->
		<div class="sidenav">
			<button class="dropdown-btn" type="button" style="color: #027DFF"
				onclick="employee()">
				<i class="bi bi-graph-up"></i> Employee Manager

			</button>
			<div class="dropdown-container" style="font-size: 15px">
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/listEmployee"><i
					class="bi bi-list-ul"></i> Employee List </a>
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/addEmployee"><i
					class="bi bi-plus-square"></i> Add Employee </a>
			</div>
		</div>
	</c:if>
	<!------------------------------------Parking---------------------------------------------------->
	<c:if test="${sessionScope.user.department=='Parking' }">
		<a> <i class="bi bi-speedometer2"></i> Car park manager
		</a>
		<hr>
		<!-- Booking office manager  -->
		<div class="sidenav">
			<button class="dropdown-btn" type="button" style="color: #027DFF"
				onclick="booking()">
				<i class="bi bi-cart-plus"></i> Booking office manager
			</button>

			<div class="dropdown-container" style="font-size: 15px">
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/ListBooking"><i
					class="bi bi-list-ul"></i> Booking office List </a>
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/resources/views/booking/add_booking.jsp"><i
					class="bi bi-plus-square"></i> Add Booking office </a>
			</div>
		</div>
		<hr>
		<!-- Parking lot manager  -->
		<div class="sidenav">
			<button class="dropdown-btn" type="button" style="color: #027DFF"
				onclick="parking()">
				<i class="bi bi-geo-alt"></i> Parking lot manager
			</button>

			<div class="dropdown-container" style="font-size: 15px">
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/ListParking"><i
					class="bi bi-list-ul"></i> Parking lot List </a>
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/AddParking"><i
					class="bi bi-plus-square"></i> Add Parking lot </a>
			</div>
		</div>
		<hr>
		<!-- Car manager  -->
		<div class="sidenav">
			<button class="dropdown-btn" type="button" style="color: #027DFF"
				onclick="car()">
				<i class="bi bi-car-front-fill"></i> Car manager
			</button>

			<div class="dropdown-container" style="font-size: 15px">
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/ListCarController"><i
					class="bi bi-list-ul"></i> Car List </a>
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/resources/views/car/add_car.jsp"><i
					class="bi bi-plus-square"></i> Add Car</a>
			</div>
		</div>
	</c:if>
	<!------------------------------------Service---------------------------------------------------->
	<c:if test="${sessionScope.user.department=='Service' }">
		<!-- Trip manager -->
		<div class="sidenav">
			<button class="dropdown-btn" type="button" style="color: #027DFF"
				onclick="trip()">
				<i class="bi bi-airplane"></i> Trip manager
			</button>

			<div class="dropdown-container" style="font-size: 15px">
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/listTrip"><i
					class="bi bi-list-ul"></i> Trip List </a>
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/resources/views/trip/add_trip.jsp"><i
					class="bi bi-plus-square"></i> Add Trip</a>
			</div>
		</div>
		<hr>
		<!-- Ticket manager -->
		<div class="sidenav">
			<button class="dropdown-btn" type="button" style="color: #027DFF"
				onclick="ticket()">
				<i class="bi bi-ticket-detailed"></i> Ticket manager
			</button>

			<div class="dropdown-container" style="font-size: 15px">
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/ListTicketController"><i
					class="bi bi-list-ul"></i> Ticket List </a>
				<hr>
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/resources/views/ticket/add_ticket.jsp"><i
					class="bi bi-plus-square"></i> Add Ticket</a>
			</div>
		</div>

	</c:if>
	<script>
		function employee() {
			document.getElementById("navbar").innerHTML = " <i class='bi bi-people-fill'></i> Employee";
		}
		function booking() {
			document.getElementById("navbar").innerHTML = " <i class='bi bi-cart-plus'></i> Booking Office";
		}
		function parking() {
			document.getElementById("navbar").innerHTML = " <i class='i bi-geo-alt'></i> Parking lot";
		}
		function car() {
			document.getElementById("navbar").innerHTML = " <i class='bi bi-car-front-fill'></i> Car";
		}
		function trip() {
			document.getElementById("navbar").innerHTML = " <i class='bi bi-airplane'></i> Trip";
		}

		function ticket() {
			document.getElementById("navbar").innerHTML = " <i class='bi bi-ticket-detailed'> Ticket";
		}
	</script>


	<script>
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var dropdownContent = this.nextElementSibling;
				if (dropdownContent.style.display === "block") {
					dropdownContent.style.display = "none";
				} else {
					dropdownContent.style.display = "block";
				}
			});
		}
	</script>
</body>
<style>
.dropdown-container {
	display: none;
	padding-left: 8px;
}

.sidenav a, .dropdown-btn {
	padding: 1px 5px 1px 1px;
	text-decoration: none;
	display: block;
	border: none;
	background: none;
	width: 100%;
	text-align: left;
}

.dropdown-btn:focus {
	outline: none
}
</style>
</html>
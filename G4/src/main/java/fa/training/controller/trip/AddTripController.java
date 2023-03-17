package fa.training.controller.trip;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.TripDao;

@WebServlet("/addTripController")
public class AddTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/resources/views/trip/add_trip.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		TripDao dao = new TripDao();
		String destination = request.getParameter("destination");
		String departureTime = request.getParameter("time");
		String driver = request.getParameter("driver");
		String carType = request.getParameter("type");
		String maximumOnlineTicketNumber = request.getParameter("number");
		String depatureDate = request.getParameter("date");
		dao.addNewTrip(destination, departureTime, driver, carType, maximumOnlineTicketNumber, depatureDate);
		request.setAttribute("message1", "Add successfully");
		request.getRequestDispatcher("/resources/views/trip/add_trip.jsp").forward(request, response);
	}

}

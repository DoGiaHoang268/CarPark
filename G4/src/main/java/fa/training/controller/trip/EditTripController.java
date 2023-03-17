package fa.training.controller.trip;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.TripDao;

import fa.training.entity.Trip;

@WebServlet("/EditTrip")
public class EditTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tripId = request.getParameter("tripId");
		TripDao dao = new TripDao();
		Trip t = dao.getTripByTripId(tripId);
		HttpSession session = request.getSession();
		session.setAttribute("t", t);
		request.getRequestDispatcher("/resources/views/trip/edit_trip.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tripId = request.getParameter("tripId");
		String destination = request.getParameter("destination");
		String departureTime = request.getParameter("time");
		String driver = request.getParameter("driver");
		String carType = request.getParameter("type");
		String maximumOnlineTicketNumber = request.getParameter("number");
		String depatureDate = request.getParameter("date");	
		TripDao dao = new TripDao();
		HttpSession session = request.getSession();
		dao.updateTripByTripId(destination, departureTime, driver, carType, maximumOnlineTicketNumber, depatureDate, tripId);
		Trip trip = dao.getTripByTripId(tripId);
		session.setAttribute("t", trip);
		request.setAttribute("message", "Update succesfully !");
		request.getRequestDispatcher("/resources/views/trip/edit_trip.jsp").forward(request, response);
	}

}

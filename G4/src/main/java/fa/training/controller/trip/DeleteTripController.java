package fa.training.controller.trip;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.TicketDao;
import fa.training.dao.TripDao;
import fa.training.entity.Ticket;
import fa.training.entity.Trip;

@WebServlet("/deleteTrip")
public class DeleteTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tripId = request.getParameter("tripId");
		TripDao dao = new TripDao();

		// delete contents by id
		dao.deleteTripByTripId(tripId);

		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int count = dao.getTotalTrip();
		// 5 contents on page list
		int endPage = count / 5;
		if (count % 5 != 0) {
			endPage++;
		}
		List<Trip> listT = dao.pagingTrip(index);
		HttpSession session = request.getSession();
		session.setAttribute("listT", listT);
		session.setAttribute("end", endPage);
		request.setAttribute("message", "Delete succesfully !");
		request.getRequestDispatcher("/resources/views/trip/list_trip.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}

package fa.training.controller.trip;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.TripDao;
import fa.training.entity.Trip;


@WebServlet("/listTrip")
public class ListTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String indexPage = request.getParameter("index");
				TripDao dao = new TripDao();
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
				request.getRequestDispatcher("/resources/views/trip/list_trip.jsp").forward(request, response);
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

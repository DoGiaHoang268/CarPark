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
import fa.training.entity.*;

@WebServlet("/SearchTrip")
public class SearchTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String txtSearch = request.getParameter("search");
		String indexPage = request.getParameter("sindex");
		String date = request.getParameter("date");
		
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		TripDao dao = new TripDao();
		List<Trip> listT;
		HttpSession session = request.getSession();
		int count = dao.countPageSearchAll(txtSearch);
		// 5 content after search on page
		int pageSize = 5;
		int endPage = count / pageSize;
		if (count % pageSize != 0) {
			endPage++;
		}
		if (date == null) {
			listT = dao.search(txtSearch, index, pageSize);
			session.setAttribute("listT", listT);
		} else 
		{
			listT = dao.searchByDepartureDate(txtSearch, index, pageSize);
			session.setAttribute("listT", listT);
		}
		listT = dao.search(txtSearch, index, pageSize);
		session.setAttribute("listT", listT);
		session.setAttribute("save", txtSearch);
		session.setAttribute("endP", endPage);
		request.getRequestDispatcher("/resources/views/trip/search_trip.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}

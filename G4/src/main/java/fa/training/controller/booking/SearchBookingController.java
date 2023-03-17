package fa.training.controller.booking;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.BookingDao;
import fa.training.entity.BookingOffice;

@WebServlet("/SearchBooking")
public class SearchBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String textSearch = request.getParameter("search");
		String filterSearch = request.getParameter("filterSearch");
		BookingDao dao = new BookingDao();
		if (filterSearch.equals("all")) {

			System.out.println(filterSearch);
			System.out.println(textSearch);
			if (textSearch == null) {
				textSearch = "";
			}
			int count = dao.getTotalSearchContent(textSearch);
			String indexPage = request.getParameter("index");
			if (indexPage == null) {
				indexPage = "1";
			}
			int index = Integer.parseInt(indexPage);
			int endPage = count / 5;
			if (count % 5 != 0) {
				endPage++;
			}
			List<BookingOffice> bookingView = dao.searchAll(textSearch, index);
			request.setAttribute("error", "Can not found: " + textSearch);
			request.setAttribute("filterSearch", filterSearch);
			request.setAttribute("textSearch", textSearch);
			request.setAttribute("bookingView", bookingView);
			request.setAttribute("endP", endPage);
			request.getRequestDispatcher("/resources/views/booking/search_booking.jsp").forward(request, response);
		} else if (filterSearch.equals("name")) {

			if (textSearch == null) {
				textSearch = "";
			}
			int count = dao.getTotalSearchContentByName(textSearch);
			String indexPage = request.getParameter("index");
			if (indexPage == null) {
				indexPage = "1";
			}
			int index = Integer.parseInt(indexPage);
			int endPage = count / 5;
			if (count % 5 != 0) {
				endPage++;
			}
			List<BookingOffice> bookingView = dao.searchByName(textSearch, index);
			request.setAttribute("error", "Can not found: " + textSearch);
			request.setAttribute("filterSearch", filterSearch);
			request.setAttribute("textSearch", textSearch);
			request.setAttribute("bookingView", bookingView);
			request.setAttribute("endP", endPage);
			request.getRequestDispatcher("/resources/views/booking/search_booking.jsp").forward(request, response);
		}
		if (filterSearch.equals("trip")) {
			if (textSearch == null) {
				textSearch = "";
			}
			int count = dao.getTotalSearchContentByDestination(textSearch);
			String indexPage = request.getParameter("index");
			if (indexPage == null) {
				indexPage = "1";
			}
			int index = Integer.parseInt(indexPage);
			int endPage = count / 5;
			if (count % 5 != 0) {
				endPage++;
			}
			List<BookingOffice> bookingView = dao.searchByDestination(textSearch, index);
			request.setAttribute("error", "Can not found: " + textSearch);
			request.setAttribute("filterSearch", filterSearch);
			request.setAttribute("textSearch", textSearch);
			request.setAttribute("bookingView", bookingView);
			request.setAttribute("endP", endPage);
			request.getRequestDispatcher("/resources/views/booking/search_booking.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

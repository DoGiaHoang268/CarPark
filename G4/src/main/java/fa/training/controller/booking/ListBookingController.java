package fa.training.controller.booking;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.BookingDao;
import fa.training.entity.BookingOffice;

@WebServlet("/ListBooking")
public class ListBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookingDao dao = new BookingDao();
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int count = dao.getTotalContent();
		// 5 contents on page list
		int endPage = count / 5;
		if (count % 5 != 0) {
			endPage++;
		}
		List<BookingOffice> bookingView = dao.pagingContent(index);
		request.setAttribute("bookingView", bookingView);
		request.setAttribute("endP", endPage);
		HttpSession session = request.getSession();
		session.setAttribute("title", "<i class='bi bi-cart-plus'></i> Booking Office");
		request.getRequestDispatcher("/resources/views/booking/list_booking.jsp").forward(request, response);				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

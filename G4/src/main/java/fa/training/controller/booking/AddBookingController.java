package fa.training.controller.booking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.BookingDao;
import fa.training.util.Validation;

@WebServlet("/AddBoking")
public class AddBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBookingController() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BookingDao dao = new BookingDao();
		ArrayList<String> listPlace = dao.GetListPlace();
		Validation validation = new Validation();
		String bookingname = request.getParameter("bookingname");
		String trip = request.getParameter("trip");
		String phonenumber = request.getParameter("phonenumber");
		String place = request.getParameter("place");
		String price = request.getParameter("price");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String sql = "insert into bookingoffice values ('" + to + "','" + bookingname + "','" + phonenumber + "','"
				+ place + "'," + price + ",'" + from + "'," + trip + ")";
		int n = 0;
		if (phonenumber != null && validation.checkphone(phonenumber)) {
			if (bookingname != null) {
				n = dao.execute(sql);
			}
			if (n != 0) {
				request.setAttribute("message", "Add successfull!");
			}
			HttpSession session = request.getSession();
			session.setAttribute("title", "<i class='bi bi-cart-plus'></i> Booking Office");
			request.setAttribute("listPlace", listPlace);
			request.getRequestDispatcher("/resources/views/booking/add_booking.jsp").forward(request, response);
		} else {
			if (phonenumber != null) {
				request.setAttribute("message", "Invali Phone Number!");
			}
			HttpSession session = request.getSession();
			session.setAttribute("title", "<i class='bi bi-cart-plus'></i> Booking Office");
			request.setAttribute("listPlace", listPlace);
			request.getRequestDispatcher("/resources/views/booking/add_booking.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}

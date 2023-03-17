package fa.training.controller.booking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.BookingDao;
import fa.training.entity.BookingOffice;


@WebServlet("/ViewBooking")
public class ViewBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		BookingDao dao = new BookingDao();
		int officeld = Integer.parseInt(request.getParameter("officeld"));
		BookingOffice bookingOffice = dao.GetBookingById(officeld);
		request.setAttribute("bookingOffice", bookingOffice);
		request.getRequestDispatcher("/resources/views/booking/view_booking.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

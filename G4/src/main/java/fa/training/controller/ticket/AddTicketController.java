package fa.training.controller.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.TicketDao;
import fa.training.util.Validation;


@WebServlet("/AddTicketController")
public class AddTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/resources/views/ticket/add_ticket.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Validation var = new Validation();
		TicketDao dao = new TicketDao();
		String bookingTime = request.getParameter("time");
		String customerName = request.getParameter("customer");
		String licensePlate = request.getParameter("license");
		String tripId = request.getParameter("trip");
		int tripId1 = Integer.parseInt(tripId);
		if( tripId == null) {
			customerName = "Nothing";
			tripId = "1";
		}
		if (!var.checkLicense(licensePlate)) {
			request.setAttribute("mess", "The license plate is incorrect form Ex: 26-G7 99999");
			request.setAttribute("time", bookingTime);
			request.setAttribute("customer", customerName);
			request.setAttribute("tripId", tripId);
			request.getRequestDispatcher("/resources/views/ticket/add_ticket.jsp").forward(request, response);
		}else {
			dao.addNewTicket(bookingTime, customerName, licensePlate, tripId1);
			request.setAttribute("message", "Add successfully!");
			request.getRequestDispatcher("/resources/views/ticket/add_ticket.jsp").forward(request, response);
		}
		

	}

}

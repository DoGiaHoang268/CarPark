package fa.training.controller.ticket;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.TicketDao;
import fa.training.entity.Ticket;


@WebServlet("/SearchTicketController")
public class SearchTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtSearch = request.getParameter("search");
		String indexPage = request.getParameter("sindex");
		String option = request.getParameter("select");
		if (option == null) {
			option = "0";
		}
		if (indexPage == null) {
			indexPage = "1";
		}
		int select = Integer.parseInt(option);
		int index = Integer.parseInt(indexPage);
		TicketDao dao = new TicketDao();
		List<Ticket> listT;
		HttpSession session = request.getSession();
		int count = dao.countPageSearchAll(txtSearch);
		// 5 content after search on page
		int pageSize = 5;
		int endPage = count / pageSize;
		if (count % pageSize != 0) {
			endPage++;
		}
		if (select == 0) {
			listT = dao.search(txtSearch, index, pageSize);
			session.setAttribute("listT", listT);
		} else if (select == 1) {
			listT = dao.searchByTicketId(txtSearch, index, pageSize);
			session.setAttribute("listT", listT);
		} else if (select == 2) {
			listT = dao.searchByBookingTime(txtSearch, index, pageSize);
			session.setAttribute("listT", listT);
		} else if (select == 3) {
			listT = dao.searchByCustomerName(txtSearch, index, pageSize);
			session.setAttribute("listT", listT);
		} else if (select == 4) {
			listT = dao.searchByLicensePlate(txtSearch, index, pageSize);
			session.setAttribute("listT", listT);
		} else if (select == 5) {
			listT = dao.searchByTripId(txtSearch, index, pageSize);
			session.setAttribute("listT", listT);
		}
			session.setAttribute("save", txtSearch);
			session.setAttribute("select", select);
			session.setAttribute("endP", endPage);
			request.getRequestDispatcher("/resources/views/ticket/search_ticket.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

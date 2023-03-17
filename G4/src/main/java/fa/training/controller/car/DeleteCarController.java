package fa.training.controller.car;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.entity.Car;
import fa.training.entity.Ticket;
import fa.training.dao.CarDao;
import fa.training.dao.TicketDao;

@WebServlet("/DeleteCarController")
public class DeleteCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCarController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String licenseplate = request.getParameter("licenseplate");
		TicketDao dao1 = new TicketDao();
		List<Ticket> list = dao1.getAllTicket();
		for (Ticket ticket : list) {
			if (ticket.getLicensePlate().equalsIgnoreCase(licenseplate)) {
				request.setAttribute("message1", "This car has ticket, cannot delete !");
				request.getRequestDispatcher("/resources/views/car/list_car.jsp").forward(request, response);
			}
		}
		CarDao dao = new CarDao();
		dao.deleteCarbyLicense(licenseplate);
		;
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int count = dao.getTotalCar();
		// 5 contents on page list
		int endPage = count / 5;
		if (count % 5 != 0) {
			endPage++;
		}
		List<Car> listC = dao.pagingCar(index);
		HttpSession session = request.getSession();
		session.setAttribute("listC", listC);
		session.setAttribute("endP", endPage);
		request.setAttribute("message", "Delete succesfully !");
		request.getRequestDispatcher("/resources/views/car/list_car.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

package fa.training.controller.parking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.ParkingDao;
import fa.training.util.Validation;

@WebServlet("/AddParking")
public class AddParkingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ParkingDao dao = new ParkingDao();
		Validation validation = new Validation();
		String parking = request.getParameter("parking");
		String listA = request.getParameter("listA");
		String area = request.getParameter("area");
		String price = request.getParameter("price");
		String sql = "insert into parkinglot values(" + area + ",'" + parking + "','" + listA + "'," + price
				+ ",'null')\r\n";
		if(area != null && validation.PriceAndArea(area)) {
			if (parking != null) {
				int n = dao.execute(sql);
				if (n != 0) {
					request.setAttribute("message", "Add successfull!");
				}
			}	
			HttpSession session = request.getSession();
			session.setAttribute("title", "<i class='i bi-geo-alt'></i> Parking lot");
			request.getRequestDispatcher("/resources/views/parking/add_parking.jsp").forward(request, response);
		} else {
			if (area != null) {
				request.setAttribute("message", "Invali area!");
			}
			HttpSession session = request.getSession();
			session.setAttribute("title", "<i class='i bi-geo-alt'></i> Parking lot");
			request.getRequestDispatcher("/resources/views/parking/add_parking.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}

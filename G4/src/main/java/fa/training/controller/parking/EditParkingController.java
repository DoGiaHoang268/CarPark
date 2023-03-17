package fa.training.controller.parking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.ParkingDao;
import fa.training.entity.Parking;

@WebServlet("/EditParking")
public class EditParkingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParkingDao dao = new ParkingDao();
		String idString = request.getParameter("parkId");
		Parking parking= dao.parkingById(Integer.parseInt(idString));
		request.setAttribute("parkingById", parking);
		request.getRequestDispatcher("/resources/views/parking/edit_parking.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		ParkingDao dao = new ParkingDao();
		String idString = request.getParameter("parkId");
		String parkingname = request.getParameter("parking");
		String listA = request.getParameter("listA");
		String area = request.getParameter("area");
		int areaInt= Integer.parseInt(area);
		String price = request.getParameter("price");
		int priceInt= Integer.parseInt(price);
		dao.updateParking(parkingname, listA, areaInt, priceInt, Integer.parseInt(idString));
		response.sendRedirect("ViewParking?index=1");
	}

}

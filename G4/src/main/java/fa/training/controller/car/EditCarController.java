package fa.training.controller.car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.CarDao;
import fa.training.entity.Car;

@WebServlet("/EditCarController")
public class EditCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCarController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String licenseplate = request.getParameter("licenseplate");
		CarDao dao = new CarDao();
		Car c = dao.getCarbyLicense(licenseplate);
		HttpSession session = request.getSession();
		session.setAttribute("c", c);
		request.getRequestDispatcher("/resources/views/car/edit_car.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarDao dao = new CarDao();
		String licenseplate = request.getParameter("license");
		String carColor = request.getParameter("color");
		String carType = request.getParameter("cartype");
		String company = request.getParameter("company");
		String parking = request.getParameter("parking");
		int parking1 = Integer.parseInt(parking);
		if (company == null && parking == null) {
			company = "FPT software";
			parking = "1";
		}
		dao.UpdateCar(carColor, carType, company, parking1, licenseplate);
		Car c = dao.getCarbyLicense(licenseplate);
		HttpSession session = request.getSession();
		session.setAttribute("c", c);
		request.setAttribute("message", "Update successfully");
		request.getRequestDispatcher("/resources/views/car/edit_car.jsp").forward(request, response);
	}

}

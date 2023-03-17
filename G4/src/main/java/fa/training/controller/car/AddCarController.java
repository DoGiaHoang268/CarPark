package fa.training.controller.car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.CarDao;
import fa.training.util.Validation;


@WebServlet("/AddCarController")
public class AddCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("title", "<i class='bi bi-car-front-fill'></i> Car");
		request.getRequestDispatcher("/resources/views/car/add_car.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Validation var = new Validation();
		CarDao dao = new CarDao();
		String licenseplate = request.getParameter("license");
		String carColor = request.getParameter("color");
		String carType = request.getParameter("cartype");
		String company = request.getParameter("company");
		String parking = request.getParameter("parking");
		int parking1 = Integer.parseInt(parking);
		if(company == null && parking == null) {
			company = "FPT software";
			parking = "1";
		}
		if (!var.checkLicense(licenseplate)) {
			request.setAttribute("message", "The license plate is incorrect form Ex: 26-G7 99999");
			request.setAttribute("color", carColor);
			request.setAttribute("cartype", carType);
			request.setAttribute("company", company);
			request.setAttribute("parking", parking);
			request.getRequestDispatcher("/resources/views/car/add_car.jsp").forward(request, response);
		}
		if(dao.getCarbyLicense(licenseplate)!= null) {
			request.setAttribute("message", "The license plate of the vehicle has been registered in the parking lot");
			request.setAttribute("color", carColor);
			request.setAttribute("cartype", carType);
			request.setAttribute("company", company);
			request.setAttribute("parking", parking);
			request.getRequestDispatcher("/resources/views/car/add_car.jsp").forward(request, response);
		}
		dao.addNewCar(licenseplate, carColor, carType, company, parking1);
		request.setAttribute("message1", "Add successfully");
		request.getRequestDispatcher("/resources/views/car/add_car.jsp").forward(request, response);
	}

}

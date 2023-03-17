package fa.training.controller.car;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.CarDao;
import fa.training.entity.Car;

@WebServlet("/ListCarController")
public class ListCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListCarController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		CarDao dao = new CarDao();
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
		session.setAttribute("title", "<i class='bi bi-car-front-fill'></i> Car");
		request.getRequestDispatcher("/resources/views/car/list_car.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

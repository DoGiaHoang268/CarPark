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

@WebServlet("/SearchCarController")
public class SearchCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchCarController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		CarDao dao = new CarDao();
		List<Car> listC;
		HttpSession session = request.getSession();
		int count;
		int pageSize;
		int endPage;
		if (select == 0) {
			count = dao.countPageSearchAll(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listC = dao.search(txtSearch, index, pageSize);
			if (count == 0 && listC.isEmpty()) {
				session.removeAttribute("listC");
				session.removeAttribute("endP");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listC", listC);
				session.setAttribute("endP", endPage);
			}
		} else if (select == 1) {
			count = dao.countPageSearchByLicense(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listC = dao.searchByLicensePlate(txtSearch, index, pageSize);
			if (count == 0 && listC.isEmpty()) {
				session.removeAttribute("listC");
				session.removeAttribute("endP");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listC", listC);
				session.setAttribute("endP", endPage);
			}
		} else if (select == 2) {
			count = dao.countPageSearchByCarType(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listC = dao.searchByCarType(txtSearch, index, pageSize);
			if (count == 0 && listC.isEmpty()) {
				session.removeAttribute("listC");
				session.removeAttribute("endP");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listC", listC);
				session.setAttribute("endP", endPage);
			}
		} else if (select == 3) {
			count = dao.countPageSearchByColor(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listC = dao.searchByCarColor(txtSearch, index, pageSize);
			if (count == 0 && listC.isEmpty()) {
				session.removeAttribute("listC");
				session.removeAttribute("endP");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listC", listC);
				session.setAttribute("endP", endPage);
			}
		} else if (select == 4) {
			count = dao.countPageSearchByCompany(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listC = dao.searchByCompany(txtSearch, index, pageSize);
			if (count == 0 && listC.isEmpty()) {
				session.removeAttribute("listC");
				session.removeAttribute("endP");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listC", listC);
				session.setAttribute("endP", endPage);
			}
		} else if (select == 5) {
			count = dao.countPageSearchByParkId(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listC = dao.searchByParkId(txtSearch, index, pageSize);
			if (count == 0 && listC.isEmpty()) {
				session.removeAttribute("listC");
				session.removeAttribute("endP");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listC", listC);
				session.setAttribute("endP", endPage);
			}
		}
		session.setAttribute("save", txtSearch);
		session.setAttribute("select", select);
		request.getRequestDispatcher("/resources/views/car/search_car.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

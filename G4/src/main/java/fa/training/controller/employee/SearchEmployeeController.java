package fa.training.controller.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.EmployeeDao;
import fa.training.entity.Employee;


@WebServlet("/searchEmployee")
public class SearchEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchEmployeeController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String txtSearch = request.getParameter("search");
		String indexPage = request.getParameter("sindex1");
		String option = request.getParameter("select");
		if (option == null) {
			option = "0";
		}
		if (indexPage == null) {
			indexPage = "1";
		}
		int select = Integer.parseInt(option);
		int index = Integer.parseInt(indexPage);
		EmployeeDao dao = new EmployeeDao();
		List<Employee> listE;
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
			listE = dao.search(txtSearch, index, pageSize);
			if (count == 0 && listE.isEmpty()) {
				session.removeAttribute("listEm");
				session.removeAttribute("endP1");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listEm", listE);
				session.setAttribute("endP1", endPage);
			}

		} else if (select == 1) {
			count = dao.countPageSearchByName(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listE = dao.searchByName(txtSearch, index, pageSize);
			if (count == 0 && listE.isEmpty()) {
				session.removeAttribute("listEm");
				session.removeAttribute("endP1");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listEm", listE);
				session.setAttribute("endP1", endPage);
			}

		} else if (select == 2) {
			count = dao.countPageSearchByDob(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listE = dao.searchByDob(txtSearch, index, pageSize);
			if (count == 0 && listE.isEmpty()) {
				session.removeAttribute("listEm");
				session.removeAttribute("endP1");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listEm", listE);
				session.setAttribute("endP1", endPage);
			}

		} else if (select == 3) {
			count = dao.countPageSearchByAddress(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listE = dao.searchByAddress(txtSearch, index, pageSize);
			if (count == 0 && listE.isEmpty()) {
				session.removeAttribute("listEm");
				session.removeAttribute("endP1");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listEm", listE);
				session.setAttribute("endP1", endPage);
			}

		} else if (select == 4) {
			count = dao.countPageSearchByPhone(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listE = dao.searchByPhone(txtSearch, index, pageSize);
			if (count == 0 && listE.isEmpty()) {
				session.removeAttribute("listEm");
				session.removeAttribute("endP1");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listEm", listE);
				session.setAttribute("endP1", endPage);
			}

		} else if (select == 5) {
			count = dao.countPageSearchByDepartment(txtSearch);
			pageSize = 5;
			endPage = count / pageSize;
			if (count % pageSize != 0) {
				endPage++;
			}
			listE = dao.searchByDepartment(txtSearch, index, pageSize);
			if (count == 0 && listE.isEmpty()) {
				session.removeAttribute("listEm");
				session.removeAttribute("endP1");
				request.setAttribute("error", "Can not found: " + txtSearch);
			} else {
				session.setAttribute("listEm", listE);
				session.setAttribute("endP1", endPage);
			}

		}

		session.setAttribute("save", txtSearch);
		session.setAttribute("select", select);
		request.getRequestDispatcher("/resources/views/employee/search_employee.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

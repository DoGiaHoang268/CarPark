package fa.training.controller.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.EmployeeDao;
import fa.training.entity.Employee;
import fa.training.util.Validation;


@WebServlet("/editEmployee")
public class EditEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditEmployeeController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("account");
		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.getUserByUsername(account);
		HttpSession session = request.getSession();
		session.setAttribute("e", employee);
		request.getRequestDispatcher("/resources/views/employee/edit_employee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String fullname = request.getParameter("fullname");
		String phonenumber = request.getParameter("phonenumber");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String username = request.getParameter("account");
		String department = request.getParameter("department");
		EmployeeDao dao = new EmployeeDao();
		//Employee employee = dao.getEmployeeById(id);
		Validation va = new Validation();
		if (fullname.isEmpty() || phonenumber.isEmpty() || dob.isEmpty() || username.isEmpty()
				|| department.isEmpty()) {
			request.setAttribute("err", "Fill out all!");
			request.getRequestDispatcher("/resources/views/employee/edit_employee.jsp").forward(request, response);
		} else if (!va.checkEmail(email)) {
			request.setAttribute("err", "Email need match format example123@example.com");
			request.getRequestDispatcher("/resources/views/employee/edit_employee.jsp").forward(request, response);
		} else if (!va.checkphone(phonenumber)) {
			request.setAttribute("err", "Phone has 10 number start with 0! ");
			request.getRequestDispatcher("/resources/views/employee/edit_employee.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			dao.updateEmployeeByEmId(username, department, address, dob, email, fullname, phonenumber, gender,
					id);
			Employee employee = dao.getEmployeeById(id);
			session.setAttribute("e", employee);
			request.setAttribute("message", "Update succesfully !");
			request.getRequestDispatcher("/resources/views/employee/edit_employee.jsp").forward(request, response);

		}

	}

}

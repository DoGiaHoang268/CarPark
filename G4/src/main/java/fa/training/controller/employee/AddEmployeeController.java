package fa.training.controller.employee;

import java.io.IOException;

import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.EmployeeDao;
import fa.training.util.Validation;

@WebServlet("/addEmployee")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddEmployeeController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("title", "<i class='bi bi-people-fill'></i> Employee");
		request.getRequestDispatcher("/resources/views/employee/add_employee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String phonenumber = request.getParameter("phonenumber");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String username = request.getParameter("account");
		String password = request.getParameter("password");
		String department = request.getParameter("department"); 
		EmployeeDao dao = new EmployeeDao();
		Validation va = new Validation();
		Base64.Encoder encoder = Base64.getMimeEncoder();  
		String ePassword = encoder.encodeToString(password.getBytes());

		if (fullname.isEmpty() || phonenumber.isEmpty() || dob.isEmpty() || username.isEmpty() || password.isEmpty()
				|| department.isEmpty()) {
			request.setAttribute("err", "Fill out all!");
			request.getRequestDispatcher("/resources/views/employee/add_employee.jsp").forward(request, response);
		}
		// email exist
		else if (dao.getUserByEmail(email) != null) {
			request.setAttribute("fullname", fullname);
			request.setAttribute("phonenumber", phonenumber);
			request.setAttribute("dob", dob);
			request.setAttribute("username", username);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("password", password);
			request.setAttribute("department", department);
			request.setAttribute("err", "Email already to use !");
			request.getRequestDispatcher("/resources/views/employee/add_employee.jsp").forward(request, response);
		}
		// email validate format adaa_323@example.com
		else if (!va.checkEmail(email)) {
			request.setAttribute("fullname", fullname);
			request.setAttribute("phonenumber", phonenumber);
			request.setAttribute("dob", dob);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("department", department);
			request.setAttribute("err", "Email need match format example123@example.com");
			request.getRequestDispatcher("/resources/views/employee/add_employee.jsp").forward(request, response);
		}
		// validate password have at least 6 characters, including uppercase lowercase
		// and number
		else if (!va.checkPassword(password)) {
			request.setAttribute("fullname", fullname);
			request.setAttribute("phonenumber", phonenumber);
			request.setAttribute("dob", dob);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("email", email);
			request.setAttribute("username", username);
			request.setAttribute("department", department);
			request.setAttribute("err", "The password must have at least 6 \r\n"
					+ "characters, including uppercase lowercase and \r\n" + "number. ");
			request.getRequestDispatcher("/resources/views/employee/add_employee.jsp").forward(request, response);
		}
		// phone number exist
		else if (dao.getUserByPhone(phonenumber) != null) {
			request.setAttribute("fullname", fullname);
			request.setAttribute("dob", dob);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("email", email);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("department", department);
			request.setAttribute("err", "Phone already to use! ");
			request.getRequestDispatcher("/resources/views/employee/add_employee.jsp").forward(request, response);
		}
		// validate phone start with 0 and must has 10 number
		else if (!va.checkphone(phonenumber)) {
			request.setAttribute("fullname", fullname);
			request.setAttribute("dob", dob);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("email", email);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("department", department);
			request.setAttribute("err", "Phone has 10 number start with 0! ");
			request.getRequestDispatcher("/resources/views/employee/add_employee.jsp").forward(request, response);
		}
		// user exist
		else if (dao.getUserByUsername(username) != null) {
			request.setAttribute("fullname", fullname);
			request.setAttribute("phonenumber", phonenumber);
			request.setAttribute("dob", dob);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("department", department);
			request.setAttribute("err", "User name already to use ! ");
			request.getRequestDispatcher("/resources/views/employee/add_employee.jsp").forward(request, response);
		} 
		else {
			dao.addEmployee(username, department, address, dob, email, fullname, phonenumber, ePassword, gender);
			request.setAttribute("fullname", fullname);
			request.setAttribute("phonenumber", phonenumber);
			request.setAttribute("dob", dob);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("email", email);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("department", department);
			request.setAttribute("message", "Add succesfully !");
			request.getRequestDispatcher("/resources/views/employee/add_employee.jsp").forward(request, response);

		}

	}

}

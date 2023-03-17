package fa.training.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.EmployeeDao;
import fa.training.entity.Employee;
import fa.training.util.Validation;

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePassword() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/resources/views/change_password.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("account");
		String oldPassword = request.getParameter("oldpassword");
		String newPassword = request.getParameter("newpassword");
		String confirmPassword = request.getParameter("confirmpassword");
		Validation va = new Validation();
		HttpSession session = request.getSession();
		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.getUserByUsername(account);
		Base64.Encoder encoder = Base64.getMimeEncoder();  
		String ePassword = encoder.encodeToString(newPassword.getBytes());	
		String eOldPassword = encoder.encodeToString(oldPassword.getBytes());
	
		employee = (Employee) session.getAttribute("e");
		if (!eOldPassword.equals(employee.getPassword())) {
			request.setAttribute("newpassword", newPassword);
			request.setAttribute("confrimpassword", confirmPassword);
			request.setAttribute("err", "Old password incorrect!!!");
			request.getRequestDispatcher("/resources/views/change_password.jsp").forward(request, response);
			return;
		}
		if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
			request.setAttribute("err", "Please fill out !");
			request.getRequestDispatcher("/resources/views/change_password.jsp").forward(request, response);
			return;
		}

		if (!newPassword.equals(confirmPassword)) {
			request.setAttribute("oldpassword", oldPassword);
			request.setAttribute("newpassword", newPassword);
			request.setAttribute("err", "Confirm password not match");
			request.getRequestDispatcher("/resources/views/change_password.jsp").forward(request, response);
			return;
		}
		if (!va.checkPassword(newPassword)) {
			request.setAttribute("oldpassword", oldPassword);
			request.setAttribute("err", "The password must have at least 6 \r\n"
					+ "characters, including uppercase lowercase and \r\n" + "number. ");
			request.getRequestDispatcher("/resources/views/change_password.jsp").forward(request, response);
			return;
		}

		if (newPassword.equals(oldPassword)) {
			request.setAttribute("oldpassword", oldPassword);
			request.setAttribute("err", "New password match old password! Please insert new password !");
			request.getRequestDispatcher("/resources/views/change_password.jsp").forward(request, response);
			return;
		}
		employee.setPassword(ePassword);
		dao.changePassword(employee);
		request.setAttribute("message", "Update password successfully!");
		request.getRequestDispatcher("/resources/views/change_password.jsp").forward(request, response);
	}

}

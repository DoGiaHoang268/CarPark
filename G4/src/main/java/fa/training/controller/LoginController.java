package fa.training.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.EmployeeDao;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie arr[] = request.getCookies();
		if (arr != null) {
			for (Cookie cookie : arr) {
				if (cookie.getName().equals("user1")) {
					request.setAttribute("username", cookie.getValue());
				}
				if (cookie.getName().equals("password1")) {
					request.setAttribute("password", cookie.getValue());
				}
			}
			request.getRequestDispatcher("/resources/views/login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/resources/views/login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		EmployeeDao dao = new EmployeeDao();
		HttpSession session = request.getSession();
		Base64.Encoder encoder = Base64.getMimeEncoder();
		String ePassword = encoder.encodeToString(password.getBytes());

		if (username.isEmpty() || password.isEmpty()) {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("message", "You must be filled out!");
			request.getRequestDispatcher("/resources/views/login.jsp").forward(request, response);
			// check format password
		}
		// Check user name doesn't exist
		if (dao.getUserByUsername(username) == null) {
			request.setAttribute("message", "User not exist!");
			request.getRequestDispatcher("/resources/views/login.jsp").forward(request, response);
			// Check empty input
		} else {
			// Check user name or password incorrect
			if (dao.checkAccount(username, ePassword) == null) {
				request.setAttribute("message", "Username or password incorrect!");
				request.getRequestDispatcher("/resources/views/login.jsp").forward(request, response);
			} else {
				session.setAttribute("user", dao.getUserByUsername(username));
				Cookie u = new Cookie("user1", username);
				Cookie p = new Cookie("password1", ePassword);
				u.setMaxAge(60 * 60);

				if (remember != null) {
					p.setMaxAge(60 * 60);
				} else {
					p.setMaxAge(0);
				}
				response.addCookie(u);
				response.addCookie(p);
				response.sendRedirect(request.getContextPath() + "/resources/views/home.jsp");
			}
		}
	}

}
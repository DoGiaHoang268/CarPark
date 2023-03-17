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


@WebServlet("/viewEmployee")
public class ViewEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ViewEmployeeController() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eId = request.getParameter("eId");
		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.getEmployeeById(eId);
		HttpSession session = request.getSession();
		session.setAttribute("e", employee);
		request.getRequestDispatcher("/resources/views/employee/view_employee.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

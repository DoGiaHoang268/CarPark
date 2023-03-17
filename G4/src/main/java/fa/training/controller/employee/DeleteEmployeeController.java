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


@WebServlet("/deleteEmployee")
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteEmployeeController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eId = request.getParameter("eId");
		EmployeeDao dao = new EmployeeDao();
		//delete contents by id
		dao.deleteEmpoyeeById(eId);		
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int count = dao.getTotalPage();
		// 5 contents on page list
		int endPage = count / 5;
		if (count % 5 != 0) {
			endPage++;
		}
		List<Employee> listE = dao.pagingEmployee(index);
		HttpSession session = request.getSession();
		session.setAttribute("listE", listE);
		session.setAttribute("endP", endPage);
		request.setAttribute("message", "Delete succesfully !");
		request.getRequestDispatcher("/resources/views/employee/list_employee.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

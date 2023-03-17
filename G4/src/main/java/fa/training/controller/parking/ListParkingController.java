package fa.training.controller.parking;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.ParkingDao;
import fa.training.entity.Parking;


@WebServlet("/ListParking")
public class ListParkingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ParkingDao dao = new ParkingDao();
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int count = dao.getTotalContent();
		// 5 contents on page list
		int endPage = count / 5;
		if (count % 5 != 0) {
			endPage++;
		}
		List<Parking> parking = dao.pagingContent(index);
		request.setAttribute("parking", parking);
		request.setAttribute("endP", endPage);
		HttpSession session = request.getSession();
		session.setAttribute("title", "<i class='i bi-geo-alt'></i> Parking lot");
		request.getRequestDispatcher("/resources/views/parking/list_parking.jsp").forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

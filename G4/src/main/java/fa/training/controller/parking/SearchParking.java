package fa.training.controller.parking;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.ParkingDao;
import fa.training.entity.Parking;


/**
 * Servlet implementation class SearchParking
 */
@WebServlet("/SearchParking")
public class SearchParking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchParking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String textSearch = request.getParameter("search");
		String filterSearch = request.getParameter("filterSearch");
		ParkingDao dao = new ParkingDao();
		if (filterSearch.equals("all")) {

			System.out.println(filterSearch);
			System.out.println(textSearch);
			if (textSearch == null) {
				textSearch = "";
			}
			int count = dao.getTotalSearchContent(textSearch);
			String indexPage = request.getParameter("index");
			if (indexPage == null) {
				indexPage = "1";
			}
			int index = Integer.parseInt(indexPage);
			int endPage = count / 5;
			if (count % 5 != 0) {
				endPage++;
			}
			List<Parking> parkingView = dao.searchAll(textSearch, index);
			request.setAttribute("error", "Can not found: " + textSearch);
			request.setAttribute("filterSearch", filterSearch);
			request.setAttribute("textSearch", textSearch);
			request.setAttribute("parking", parkingView);
			request.setAttribute("endP", endPage);
			request.getRequestDispatcher("/resources/views/parking/search_parking.jsp").forward(request, response);
		} else if (!filterSearch.equals("all")) {
			System.out.println(filterSearch);
			System.out.println(textSearch);
			if (textSearch == null) {
				textSearch = "";
			}
			int count = dao.getTotalSearchContentByFilter(textSearch,filterSearch);
			String indexPage = request.getParameter("index");
			if (indexPage == null) {
				indexPage = "1";
			}
			int index = Integer.parseInt(indexPage);
			int endPage = count / 5;
			if (count % 5 != 0) {
				endPage++;
			}
			List<Parking> parkingView = dao.searchByFilter(textSearch, index,filterSearch);
			request.setAttribute("error", "Can not found: " + textSearch);
			request.setAttribute("filterSearch", filterSearch);
			request.setAttribute("textSearch", textSearch);
			request.setAttribute("parking", parkingView);
			request.setAttribute("endP", endPage);
			request.getRequestDispatcher("/resources/views/parking/search_parking.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

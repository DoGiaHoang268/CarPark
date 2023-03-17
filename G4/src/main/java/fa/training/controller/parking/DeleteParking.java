package fa.training.controller.parking;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.ParkingDao;



/**
 * Servlet implementation class DeleteParking
 */
@WebServlet("/DeleteParking")
public class DeleteParking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteParking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ParkingDao dao = new ParkingDao();
		String parking = request.getParameter("parkId");
		ResultSet checkCarInParking= dao.getData("select * from parkinglot,"
				+ "car where car.parkId=parkinglot.parkId and parkinglot.parkId="+parking);
		try {
			if(checkCarInParking.next()) {
				request.setAttribute("message","Can't delete!");
				request.getRequestDispatcher("ViewParking").forward(request, response);
			}else {
				dao.Delete(Integer.parseInt(parking));
				request.setAttribute("message","Delete successfull!");
				request.getRequestDispatcher("ViewParking").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

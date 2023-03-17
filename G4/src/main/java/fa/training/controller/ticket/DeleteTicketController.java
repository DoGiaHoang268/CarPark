package fa.training.controller.ticket;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.TicketDao;
import fa.training.entity.Ticket;


@WebServlet("/DeleteTicketController")
public class DeleteTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ticketId = request.getParameter("ticketId");

        TicketDao dao = new TicketDao();
        dao.deleteTicketById(ticketId);
        
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
        List<Ticket> listT = dao.pagingContent(index);
        HttpSession session = request.getSession();
        session.setAttribute("listT", listT);
        session.setAttribute("endP", endPage);
        request.setAttribute("message", "Delete succesfully !");
        request.getRequestDispatcher("/resources/views/ticket/list_ticket.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

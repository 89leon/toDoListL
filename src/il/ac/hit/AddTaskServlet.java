package il.ac.hit;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import il.ac.hit.HibernateToDoListDao;
import il.ac.hit.tables.Tasks;
import il.ac.hit.tables.Users;

/**
 * Servlet implementation class AddTaskServlet
 * class that adding a task to our DB
 */
@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HibernateToDoListDao query;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users user =  (Users) session.getAttribute("user");
		if (user !=null){
			String dateString = request.getParameter("date");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date date = null;
			try {
				date  = dateFormat.parse(dateString);
			} catch (ParseException pe){
				pe.printStackTrace();
			}
			Tasks task = new Tasks(request.getParameter("task"),request.getParameter("status"),user,date);
			query = new HibernateToDoListDao();
			user.getItems().add(task);
			query.addUser(task);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UpdateServlet");
			requestDispatcher.forward(request, response);
		}
		else{
			RequestDispatcher requestDispetcher = getServletContext().getRequestDispatcher("/login.jsp");
			requestDispetcher.forward(request, response);
		}
	}
/**
 * doPost 
 * see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 * @param HttpServletRequest
 * @param HttpServletResponse
 * @throws ServletException, IOException
 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/home.jsp");
		requestDis.forward(request, response);
	}

}

package il.ac.hit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import il.ac.hit.HibernateToDoListDao;
import il.ac.hit.tables.Users;
/**
 * Servlet implementation class LoginServlet
 * this class with combination of UpdateServlet checks if there a user in DB .
 * @author 89leo
 *
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HibernateToDoListDao query;
	Users user;// check if needed

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		query = new HibernateToDoListDao();
	}
	/**
	 * doPost 
	 * see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users user = query.getUser(request.getParameter("name"), request.getParameter("password"));
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);// setting input to session.
			session.setMaxInactiveInterval(300);// session time limit
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UpdateServlet");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omniSpectrum.Quizzium.DAL.QuizDAO;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QuizDAO db;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        db = new QuizDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO check if loggedIn
		
		request.setAttribute("quizList", db.getAllQuizes());	
		String viewToGo = "WEB-INF/TeacherViews/Dashboard.jsp";
		
		//redirect to page	
		RequestDispatcher view = request.getRequestDispatcher(viewToGo);
		view.forward(request, response);
	}
}

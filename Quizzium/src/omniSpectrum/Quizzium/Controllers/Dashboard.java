package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omniSpectrum.Quizzium.dummy.DAL.QuizDAO;
import omniSpectrum.Quizzium.dummy.Models.Quiz;
import omniSpectrum.Quizzium.utils.Helper;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String DASHBOARD_VIEW = "WEB-INF/TeacherViews/Dashboard.jsp";
	private final String LOGIN_CONTROLLER = "Login";
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
		
		//check if loggedIn
		if (!Helper.checkIfLoggedIn(request.getSession())) {
			// if NOT loggedIn
			response.sendRedirect(LOGIN_CONTROLLER);
						
		}
		else{
			request.setAttribute("quizList", db.getAllQuizes());	
			
			//redirect to page	
			RequestDispatcher view = request.getRequestDispatcher(DASHBOARD_VIEW);
			view.forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting parameters
		Integer quizId = Integer.parseInt((String)request.getParameter("quizId"));
		Boolean targetState = 
				Boolean.valueOf((String)request.getParameter("targetState"));   

		Quiz cq = db.getQuizById(quizId);
		db.updateQuizState(cq, targetState);			
	}
}

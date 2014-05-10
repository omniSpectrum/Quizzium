package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omniSpectrum.Quizzium.DAL.QuizDAO;
import omniSpectrum.Quizzium.utils.Qhelper;
import omniSpectrum.Quizzium.utils.SiteNav;

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
		
		/*No caching for attempt page*/
		Qhelper.turnNoCache(response);
		
		//check if loggedIn
		if (!Qhelper.checkIfLoggedIn(request.getSession())) {
			// if NOT loggedIn
			response.sendRedirect(SiteNav.LOGIN_CONTROLLER);	
		}
		else{
			request.setAttribute("quizList", db.findAll());	
			
			String version = Qhelper.appVersion(getServletContext());
			request.setAttribute("version", version);	
			
			//redirect to page	
			RequestDispatcher view = request.getRequestDispatcher(SiteNav.DASHBOARD_VIEW);
			view.forward(request, response);
		}
	}
}

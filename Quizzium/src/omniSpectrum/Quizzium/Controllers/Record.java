package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omniSpectrum.Quizzium.dummy.DAL.StudentDAO;
import omniSpectrum.Quizzium.dummy.Models.StudentAttempt;
import omniSpectrum.Quizzium.utils.Helper;

/**
 * Servlet implementation class Record
 * Displays Single Student attempt with actual and expected answers
 */
@WebServlet("/GradingTable/Record")
public class Record extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String RECORD_VIEW = "/WEB-INF/TeacherViews/AttemptRecord.jsp";
	private final String ERROR_VIEW = "/WEB-INF/404.jsp";
	private final String LOGIN_CONTROLLER = "Login";
	private StudentDAO db;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Record() {
        super();
        db = new StudentDAO();
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
			// get request parameter
			Integer attId = Integer.parseInt((String)request.getParameter("a"));
			
			// find Attempt in DB
			StudentAttempt att = db.getSingleAttempt(attId);
			String viewToGo = ERROR_VIEW;

			if (att != null) {
				// pass Attempt to View
				request.setAttribute("attempt", att);
				viewToGo = RECORD_VIEW;
			}
			//redirect to page
			RequestDispatcher view = request.getRequestDispatcher(viewToGo);
			view.forward(request, response);
		}
	}

} 	

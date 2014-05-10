package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omniSpectrum.Quizzium.DAL.QuizDAO;
import omniSpectrum.Quizzium.DAL.StudentDAO;
import omniSpectrum.Quizzium.Models.Quizz;
import omniSpectrum.Quizzium.Models.Student;
import omniSpectrum.Quizzium.utils.Qhelper;
import omniSpectrum.Quizzium.utils.SiteNav;

/**
 * Servlet implementation class GradingTable
 */
@WebServlet("/GradingTable")
public class GradingTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDAO dbS;
    QuizDAO dbQ;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradingTable() {
        super();
        dbS = new StudentDAO();
        dbQ = new QuizDAO();
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
			// get List of the students,
			// which also has List<Attempt> for each student object
			List<Student> studentList = dbS.findAll();
			List<Quizz> quizList = dbQ.findAll();
			
			// pass List to View
			request.setAttribute("studentList", studentList);
			request.setAttribute("quizList", quizList);
			
			//redirect to page	
			RequestDispatcher view = request.getRequestDispatcher(SiteNav.GRADING_VIEW);
			view.forward(request, response);
		}
	}

}

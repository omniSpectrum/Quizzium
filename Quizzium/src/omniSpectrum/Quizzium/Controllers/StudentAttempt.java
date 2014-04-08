package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omniSpectrum.Quizzium.DAL.QuizDAO;
import omniSpectrum.Quizzium.Models.Quiz;

/**
 * Default application entry-point. 
 * redirects a student to attempt page
 */
@WebServlet("/StudentAttempt")
public class StudentAttempt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QuizDAO dbQuiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAttempt() {
        super();
        dbQuiz = new QuizDAO();
    }

	/**
	 * Default application page, returns either quiz questions or sorry message
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Quiz
		Quiz currentQuiz = dbQuiz.getCurrentQuiz();
		String viewToGo;
		
		if (currentQuiz == null) {
			viewToGo = "WEB-INF/StudentViews/AttemptOff.jsp";
		}
		else{
			//pass quiz to view
			request.setAttribute("currentQuiz", currentQuiz);
			//View to go
			viewToGo = "WEB-INF/StudentViews/AttemptOn.jsp";
		}
			
		//redirect to page	
		RequestDispatcher view = request.getRequestDispatcher(viewToGo);
	    view.forward(request, response);
	}

	/**
	 * Handles student answers and gives evaluation for quiz attempt
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//In case student was doing quiz for 10 hours
		Quiz currentQuiz = dbQuiz.getCurrentQuiz();
		String viewToGo;
		
		if (currentQuiz == null) {
			viewToGo = "WEB-INF/StudentViews/AttemptOff.jsp";
		}
		else{
			
			// TODO Validate that all check-boxes are done 

			// TODO Validate that student number is ^a[0-9]{7}&
			// TODO Cross-check actual answer against expected (correct) answer
			// TODO Calculate points "n out of m"
			// TODO Attach an object to request
			
			viewToGo = "NOT IMPLEMENTED YET";
		}
		
		//redirect to page	
		RequestDispatcher view = request.getRequestDispatcher(viewToGo);
		view.forward(request, response);
	}

}

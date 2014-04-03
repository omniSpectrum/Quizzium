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
 * Servlet implementation class StudentAttempt
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Quiz
		Quiz currentQuiz = dbQuiz.getCurrentQuiz();
		request.setAttribute("currentQuiz", currentQuiz);
		
		//redirect to page
		String studentAttemptPage = "WEB-INF/StudentViews/StudentAttemptPage.jsp";
		RequestDispatcher view = request.getRequestDispatcher(studentAttemptPage);
	    view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omniSpectrum.Quizzium.dummy.DAL.QuizDAO;
import omniSpectrum.Quizzium.dummy.DAL.StudentDAO;
import omniSpectrum.Quizzium.dummy.Models.Quiz;
import omniSpectrum.Quizzium.dummy.Models.Student;
import omniSpectrum.Quizzium.utils.Helper;

/**
 * Servlet implementation class GradingTable
 */
@WebServlet("/GradingTable")
public class GradingTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String GRADING_VIEW = "WEB-INF/TeacherViews/GradingTable.jsp";
	private final String LOGIN_CONTROLLER = "Login";
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

		//check if loggedIn
		if (!Helper.checkIfLoggedIn(request.getSession())) {
			// if NOT loggedIn
			response.sendRedirect(LOGIN_CONTROLLER);
								
		}
		else{
			// get List of the students,
			// which also has List<Attempt> for each student object
			ArrayList<Student> studentList = dbS.getAllStudents();
			ArrayList<Quiz> quizList = dbQ.getAllQuizes();
			
			// pass List to View
			request.setAttribute("studentList", studentList);
			request.setAttribute("quizList", quizList);
			
			//redirect to page	
			RequestDispatcher view = request.getRequestDispatcher(GRADING_VIEW);
			view.forward(request, response);
		}
	}

}

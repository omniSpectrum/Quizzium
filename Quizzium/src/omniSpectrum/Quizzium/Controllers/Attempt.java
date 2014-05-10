package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omniSpectrum.Quizzium.DAL.*;
import omniSpectrum.Quizzium.Models.*;
import omniSpectrum.Quizzium.utils.Qhelper;
import omniSpectrum.Quizzium.utils.SiteNav;

/**
 * Default application entry-point. 
 * redirects a student to attempt page
 */
@WebServlet("/Attempt")
public class Attempt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QuizDAO dbQuiz;
	private StudentDAO dbStudent;
	private AttemptDao dbAttempt;
	private AnswerDAO dbAnswer;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attempt() {
        super();
        dbQuiz = new QuizDAO();
        dbStudent = new StudentDAO();
    }

	/**
	 * Default application page, returns either quiz questions or sorry message
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*No caching for attempt page*/
		Qhelper.turnNoCache(response);
		
		//Get Quiz
		Quizz currentQuiz = dbQuiz.getCurrentQuiz();		
		String viewToGo;
		
		if (currentQuiz == null) {
			viewToGo = SiteNav.ATTEMPT_OFF_VIEW;
		}
		else{
			//Check session
			StudentAttempt myAttempt = (StudentAttempt) request.getSession().getAttribute("attempt");
			
			if (myAttempt != null) {
				request.setAttribute("attempt", myAttempt);			
				viewToGo = SiteNav.RECORD_VIEW;
			}
			else{				
				//pass quiz to view
				request.setAttribute("currentQuiz", currentQuiz);
				//View to go
				viewToGo = SiteNav.ATTEMPT_ON_VIEW;
			}
		}
		
		//redirect to page	
		RequestDispatcher view = request.getRequestDispatcher(viewToGo);
	    view.forward(request, response);
	}

	/**
	 * Handles student answers and gives evaluation for quiz attempt
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DAOs
		dbAttempt = new AttemptDao();
        dbAnswer = new AnswerDAO();
        
		//In case student was doing quiz for 10 hours
		Quizz currentQuiz = dbQuiz.getCurrentQuiz();
		//In case student tries to do same Quiz again
		String studentNumber = request.getParameter("studentNumber");
		StudentAttempt myAttempt = 
				dbStudent.getSingleAttempt(studentNumber, currentQuiz.getQuizzId());
				
		String viewToGo;
		
		if (currentQuiz == null || myAttempt != null) {
			String mess = "Or student with number " 
						+ studentNumber.toString() 
						+ " has already done this quiz";
			request.setAttribute("offMessage", mess);
			viewToGo = SiteNav.ATTEMPT_OFF_VIEW;
		}
		else{
			
			//Connect objects
			myAttempt = new StudentAttempt();
			myAttempt.setQuizz(currentQuiz);
			myAttempt.setStudent(dbStudent.findById(studentNumber));
			
			// Insert attempt into DB
			dbAttempt.save(myAttempt);
			
			//Collect Values, Collect points "n out of m"
			int amountRight = 0;
			int amountOut = currentQuiz.getQuestions().size();
			
			for (Question question : currentQuiz.getQuestions()) {
				
				//Fetch what answer student selected
				Integer quesId = question.getQuestionId();
				String answerChoosen = request.getParameter(quesId.toString());
				int studentAnswerNumber = 
						Integer.parseInt(answerChoosen != null ? answerChoosen : "0");
				
				for (Alternative answerAlternative : question.getAlternatives()) {
					
					if(answerAlternative.getAlternativeId() == studentAnswerNumber){

						//Add answer object to Attempt
						StudentAnswers myAnswer = new StudentAnswers(answerAlternative, myAttempt);										
						myAttempt.getStudentAnswerses().add(myAnswer);
						
						// Insert myAnswer to DB
						dbAnswer.save(myAnswer);
						
						// Cross-check actual answer against expected (correct) answer
						if (question.getCorrectAnswers()
								.iterator().next()
								.getAlternative().getAlternativeId() == answerAlternative.getAlternativeId()) {
							amountRight++;
						}
					}
				}
			}
			
			// Calculate result percentage			
			int total = (int) Math.round((amountRight*100.0) / amountOut);
			myAttempt.setResult(total);
			
			//Update Attempt
			dbAttempt.update(myAttempt);
			
			// Attach an object to request
			request.setAttribute("attempt", myAttempt);				
			viewToGo = SiteNav.RECORD_VIEW;
			
			//Set session
			request.getSession().setAttribute("attempt", myAttempt);
		}
		
		//redirect to page	
		RequestDispatcher view = request.getRequestDispatcher(viewToGo);
		view.forward(request, response);
	}
}

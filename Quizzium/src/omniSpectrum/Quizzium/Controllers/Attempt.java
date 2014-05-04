package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omniSpectrum.Quizzium.DAL.*;
import omniSpectrum.Quizzium.Models.*;

/**
 * Default application entry-point. 
 * redirects a student to attempt page
 */
@WebServlet("/Attempt")
public class Attempt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String ATTEMPT_OFF_VIEW = "WEB-INF/StudentViews/AttemptOff.jsp";
	private final String ATTEMPT_ON_VIEW = "WEB-INF/StudentViews/AttemptOn.jsp";
	private final String ATTEMPT_RESULT_VIEW = "WEB-INF/StudentViews/AttemptResult.jsp";
	
	private QuizDAO dbQuiz;
	private StudentDAO dbStudent;
       
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
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		
		//Get Quiz
		Quizz currentQuiz = dbQuiz.getCurrentQuiz();
			
		System.out.println(((currentQuiz == null)? "Nothing" : currentQuiz.getName()));

		String viewToGo;
		
//		Quiz currentQuiz = dbQuiz.getCurrentQuiz();
//		String viewToGo;
//				
//		// If no current Quiz
//		if (currentQuiz == null) {
//			viewToGo = ATTEMPT_OFF_VIEW;
//		}
//		else{
//			//Check session
//			StudentAttempt myAttempt = 
//					(StudentAttempt) request.getSession().getAttribute("attempt");
//			// If student has already Done the Current Quiz
//			if (myAttempt != null) {
//				request.setAttribute("AttemptRecord", myAttempt);			
//				viewToGo = ATTEMPT_RESULT_VIEW;
//			}
//			else{
//				//Random order of questions
//				Collections.shuffle(currentQuiz.getQuestions());
//				
//				//Random order of answers within questions
//				for (Question question : currentQuiz.getQuestions()){
//					Collections.shuffle(question.getAnswerOptions());
//				}
//
//				//pass quiz to view
//				request.setAttribute("currentQuiz", currentQuiz);
//				//View to go
//				viewToGo = ATTEMPT_ON_VIEW;
//			}
//		}
//			
//		//redirect to page	
//		RequestDispatcher view = request.getRequestDispatcher(viewToGo);
//	    view.forward(request, response);
	}

	/**
	 * Handles student answers and gives evaluation for quiz attempt
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		//In case student was doing quiz for 10 hours
//		Quiz currentQuiz = dbQuiz.getCurrentQuiz();
//		//In case student tries to do same Quiz again
//		String studentNumber = request.getParameter("studentNumber");
//		StudentAttempt myAttempt = 
//				dbStudent.getSingleAttempt(studentNumber, currentQuiz.getId());
//		
//		String viewToGo;
//		
//		if (currentQuiz == null || myAttempt != null) {
//			String mess = "Or student with number " 
//						+ studentNumber.toString() 
//						+ " has already done this quiz";
//			request.setAttribute("offMessage", mess);
//			viewToGo = ATTEMPT_OFF_VIEW;
//		}
//		else{
//			
//			//Connect objects
//			myAttempt = new StudentAttempt();
//			myAttempt.setQuiz(currentQuiz);
//			myAttempt.setStudent(dbStudent.getSingleStudent(studentNumber));
//			
//			//Collect Values, Collect points "n out of m"
//			int amountRight = 0;
//			int amountOut = currentQuiz.getQuestions().size();
//			
//			for (Question question : currentQuiz.getQuestions()) {
//				
//				Integer quesId = question.getQuestionId();
//				String answerChoosen = request.getParameter(quesId.toString());
//				int studentAnswer = 
//						Integer.parseInt(answerChoosen != null ? answerChoosen : "0");
//				
//				for (AnswerAlternative answerAlternative : question.getAnswerOptions()) {
//					
//					if(answerAlternative.getAlternativeId() == studentAnswer){
//						myAttempt.getStudentAnswers().add(answerAlternative);
//						
//						// Cross-check actual answer against expected (correct) answer
//						if (answerAlternative == question.getCorrectAnswer()) {
//							amountRight++;
//						}
//					}
//				}
//			}
//			
//			// Calculate result percentage			
//			int total = (int) Math.round((amountRight*100.0) / amountOut);
//			myAttempt.setResult(total);
//			
//			//Insert attempt into DB
//			dbStudent.addAttempt(myAttempt);
//			
//			// Attach an object to request
//			request.setAttribute("AttemptRecord", myAttempt);
//				
//			viewToGo = ATTEMPT_RESULT_VIEW;
//			//Set session
//			request.getSession().setAttribute("attempt", myAttempt);
//		}
//		
//		//redirect to page	
//		RequestDispatcher view = request.getRequestDispatcher(viewToGo);
//		view.forward(request, response);
	}
}

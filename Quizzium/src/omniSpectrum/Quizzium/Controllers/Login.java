package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import omniSpectrum.Quizzium.DAL.TeacherDAO;
import omniSpectrum.Quizzium.Models.Teacher;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    String loggedIn = (String) session.getAttribute("username");
	    
	    String viewToGo;
	    
	    if (loggedIn != null) {
			// TODO redirect to Home dash
	    	viewToGo = "_"; 
		}
	    else {
	    	viewToGo = "WEB-INF/TeacherViews/LogIn.jsp"; 
		}
		
		//redirect to page	
		RequestDispatcher view = request.getRequestDispatcher(viewToGo);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = (String) request.getAttribute("username");
		String pass = (String) request.getAttribute("password");
		
		TeacherDAO db = new TeacherDAO();
		Teacher test = db.teacherLoginCheck(username, pass);
		
		String viewToGo; 
		
		if (test == null) {
			viewToGo = "WEB-INF/TeacherViews/LogIn.jsp";
		} 
		else{
			HttpSession session = request.getSession();
		    session.setAttribute("username", username);
		    viewToGo = "_"; // TODO Dash home path
		}
		
		//redirect to page	
		RequestDispatcher view = request.getRequestDispatcher(viewToGo);
		view.forward(request, response);		
	}

}

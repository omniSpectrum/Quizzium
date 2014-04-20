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
import omniSpectrum.Quizzium.utils.Helper;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String DASHBOARD_CONTROLLER = "Dashboard";
	private final String LOGIN_VIEW = "WEB-INF/TeacherViews/LogIn.jsp";
       
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
	    
	    if (Helper.checkIfLoggedIn(request.getSession())) {
 
	    	//In case if already loggedIn
	    	response.sendRedirect(DASHBOARD_CONTROLLER); 
		}
	    else {
	    	RequestDispatcher view = request.getRequestDispatcher(LOGIN_VIEW);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = (String) request.getParameter("username");
		String pass = (String) request.getParameter("password");
		
		TeacherDAO db = new TeacherDAO();
		Teacher test = db.teacherLoginCheck(username, pass);
		
		if (test == null) {

			request.setAttribute("LoginMessage", "Invalid username or password");
			RequestDispatcher view = request.getRequestDispatcher(LOGIN_VIEW);
			view.forward(request, response);	
		} 
		else{			
			HttpSession session = request.getSession();
		    session.setAttribute("username", username);
		    response.sendRedirect(DASHBOARD_CONTROLLER);	
		}			
	}

}

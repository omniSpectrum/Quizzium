package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String LOGIN_VIEW = "WEB-INF/TeacherViews/LogIn.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    String loggedIn = (String) session.getAttribute("username");
	    
	    if (loggedIn != null) {
	    	 
	    	//In case if loggedOn
	    	session.removeAttribute("username");
		}
	    
	    response.sendRedirect(LOGIN_VIEW);
	}

}
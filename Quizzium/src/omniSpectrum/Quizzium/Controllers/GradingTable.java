package omniSpectrum.Quizzium.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradingTable
 */
@WebServlet("/GradingTable")
public class GradingTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String GRADING_VIEW = "WEB-INF/TeacherViews/GradingTable.jsp";
	// TODO StudentDAO db;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradingTable() {
        super();
        // TODO db = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO check if loggedIn
		
		//TODO get List of the students,
		// which also has ArrayList<Attempt> for each student object
		
		// TODO pass List to VIew
		
		//redirect to page	
		RequestDispatcher view = request.getRequestDispatcher(GRADING_VIEW);
		view.forward(request, response);
	}

}

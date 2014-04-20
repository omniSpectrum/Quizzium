package omniSpectrum.Quizzium.utils;

import javax.servlet.http.HttpSession;

public class Helper {

	public static boolean checkIfLoggedIn(HttpSession session){
		
		return session.getAttribute("username") != null;
	}
}

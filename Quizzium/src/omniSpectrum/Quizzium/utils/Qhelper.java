package omniSpectrum.Quizzium.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Qhelper {

	public static boolean checkIfLoggedIn(HttpSession session){
		
		return session.getAttribute("username") != null;
	}
	
	public static void turnNoCache(HttpServletResponse response){
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
	}
	
	public static String appVersion(ServletContext sc){
		
		//Get version of application
		java.util.Properties prop = new java.util.Properties();
		try {
			prop.load(sc.getResourceAsStream("/META-INF/MANIFEST.MF"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("Implementation-Version"); 
	}
	
	public static String isNewerVersionAvailible(ServletContext sc){
		
		String localVersion = appVersion(sc);

		try {
			URL remoteUrl = 
					new URL("https://raw.githubusercontent.com/omniSpectrum/Quizzium/master/Quizzium/WebContent/META-INF/MANIFEST.MF");
			
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(remoteUrl.openStream()));
			
			String StringBuffer;
	        String stringText = "";
	        while ((StringBuffer = bufferReader.readLine()) != null) {
	        	stringText += StringBuffer;
	        }
	        bufferReader.close();
			
			return stringText;
			
		} catch (MalformedURLException e) {
			return e.toString();
		} catch (IOException e) {
			return e.toString();
		}
	}
}

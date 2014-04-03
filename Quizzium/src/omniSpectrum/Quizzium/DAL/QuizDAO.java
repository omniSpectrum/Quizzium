package omniSpectrum.Quizzium.DAL;

import omniSpectrum.Quizzium.Models.Quiz;

public class QuizDAO {
	
	public QuizDAO(){
		
	}

	public Quiz getCurrentQuiz(){
		
		//TODO Fetch Quiz with state 1 from database
		
		Quiz currentQuiz = new Quiz("My First Quiz");
		return currentQuiz;
	}
}

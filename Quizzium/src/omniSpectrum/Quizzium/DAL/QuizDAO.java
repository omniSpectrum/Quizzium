package omniSpectrum.Quizzium.DAL;

import omniSpectrum.Quizzium.Models.Quiz;

public class QuizDAO {
	
	public QuizDAO(){
		
	}

	public Quiz getCurrentQuiz(){
		
		//TODO Fetch Quiz with state 1 from database
		Quiz dummy = new Quiz();
		dummy.setName("My First Quiz");
		
		return dummy;
	}
}

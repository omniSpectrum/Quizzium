package omniSpectrum.Quizzium.DAL;

import java.util.ArrayList;

import omniSpectrum.Quizzium.Models.Quiz;

public class QuizDAO {
	
	public QuizDAO(){
		
	}

	public ArrayList<Quiz> getAllQuizes(){
		return DbEmulation.getDbInstance().getQuizTable();
	}
	
	public Quiz getCurrentQuiz(){
		
		//TODO Fetch Quiz with state 1 from database
		
		for (Quiz quiz : DbEmulation.getDbInstance().getQuizTable()) {
			
			if (quiz.isState())
				return quiz;
		}
		return null;
	}
}

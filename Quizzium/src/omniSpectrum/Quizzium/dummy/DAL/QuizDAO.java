package omniSpectrum.Quizzium.dummy.DAL;

import java.util.ArrayList;

import omniSpectrum.Quizzium.dummy.Models.Quiz;

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

	public void updateQuizState(Quiz cq, Boolean targetState) {
		
		// TODO real DB interaction UPDATE
		for (Quiz q : DbEmulation.getDbInstance().getQuizTable()) {
			q.setState(Boolean.FALSE);
		}
		cq.setState(targetState);
	}

	public Quiz getQuizById(Integer quizId) {

		// TODO real DB interaction SELECT WHERE
		for (Quiz q : DbEmulation.getDbInstance().getQuizTable()) {			
			if (q.getId() == quizId) {
				return q;
			}
		}
		return null;
	}
}

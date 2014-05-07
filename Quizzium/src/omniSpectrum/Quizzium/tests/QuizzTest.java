package omniSpectrum.Quizzium.tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import omniSpectrum.Quizzium.DAL.QuizDAO;
import omniSpectrum.Quizzium.Models.Quizz;

import org.junit.Test;

public class QuizzTest {

	@Test
	public void testGetCurrentQuiz() throws ParseException {
		QuizDAO currentQuizz = new QuizDAO();
		Quizz myQuizz = currentQuizz.getCurrentQuiz();
		
		assertNotNull(myQuizz);
	}
}
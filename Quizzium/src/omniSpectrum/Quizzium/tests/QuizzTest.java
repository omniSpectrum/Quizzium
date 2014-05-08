package omniSpectrum.Quizzium.tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

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
	
	@Test
	public void testFindAll(){
		QuizDAO dbQuizz = new QuizDAO();
		List<Quizz> myList = dbQuizz.findAll();
		
		int expectation = 1;
		int harshReality = myList.size();
		
		assertEquals(expectation, harshReality);
	}
}
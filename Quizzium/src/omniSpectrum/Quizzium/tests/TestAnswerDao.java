package omniSpectrum.Quizzium.tests;

import static org.junit.Assert.*;
import omniSpectrum.Quizzium.DAL.AlternativeDao;
import omniSpectrum.Quizzium.DAL.AnswerDAO;
import omniSpectrum.Quizzium.DAL.AttemptDao;
import omniSpectrum.Quizzium.Models.Alternative;
import omniSpectrum.Quizzium.Models.StudentAnswers;
import omniSpectrum.Quizzium.Models.StudentAnswersId;
import omniSpectrum.Quizzium.Models.StudentAttempt;

import org.apache.catalina.ant.FindLeaksTask;
import org.junit.Test;

public class TestAnswerDao {

	private AnswerDAO answer = new AnswerDAO();
	private AlternativeDao alternative = new AlternativeDao();
	private AttemptDao attempt = new AttemptDao();
	
//	@Test
//	public void testSave() {
//		Alternative myAlternative = alternative.findById(1);
//		StudentAnswersId id = new StudentAnswersId(1, 1);
//		StudentAttempt studentAttempt = attempt.findById(1);
//		StudentAnswers myAnswers = new StudentAnswers(id, myAlternative, studentAttempt);
//		answer.save(myAnswers);
//		
//		StudentAnswersId id2 = new StudentAnswersId(1, 1);
//		
//		assertNotNull(answer.findById(id2));
//	}
	@Test
	public void testSave2() {
		Alternative myAlternative = alternative.findById(1);
		StudentAttempt studentAttempt = attempt.findById(1);
		
		StudentAnswers myAnswers = new StudentAnswers(myAlternative, studentAttempt);
		answer.save(myAnswers);
		
		StudentAnswersId id2 = new StudentAnswersId(1, 1);
		
		assertNotNull(answer.findById(id2));
	}
}

package omniSpectrum.Quizzium.DAL;

import omniSpectrum.Quizzium.Models.StudentAnswers;
import omniSpectrum.Quizzium.Models.StudentAnswersId;

public class AnswerDAO extends GenericDao <StudentAnswers, StudentAnswersId>{

	@Override
	protected Class<StudentAnswers> getEntityClass() {
		return StudentAnswers.class;
	}
}

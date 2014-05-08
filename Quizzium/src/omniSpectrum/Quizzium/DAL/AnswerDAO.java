package omniSpectrum.Quizzium.DAL;

import java.util.Set;

import org.hibernate.Transaction;

import omniSpectrum.Quizzium.Models.StudentAnswers;
import omniSpectrum.Quizzium.Models.StudentAnswersId;

public class AnswerDAO extends GenericDao <StudentAnswers, StudentAnswersId>{

	@Override
	protected Class<StudentAnswers> getEntityClass() {
		return StudentAnswers.class;
	}
	
	public void saveMany(Set<StudentAnswers> answers){
		Transaction tx = getCurrentSession().beginTransaction();
		for (StudentAnswers studentAnswers : answers) {
			save(studentAnswers);
		}
		
		tx.commit();
	}
}

package omniSpectrum.Quizzium.DAL;

import java.util.Calendar;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;

import omniSpectrum.Quizzium.Models.StudentAttempt;

public class AttemptDao extends GenericDao<StudentAttempt, Integer> {

	@Override
	protected Class<StudentAttempt> getEntityClass() {
		return StudentAttempt.class;
	}

	@Override
	public void save(StudentAttempt attempt){		
		attempt.setAttemptDate(Calendar.getInstance().getTime());
		
		Transaction trans = getCurrentSession().beginTransaction();
		getCurrentSession().save(attempt);
		trans.commit();
	}
	
	@Override
	public StudentAttempt findById(Integer id){
		
		Transaction tx = getCurrentSession().beginTransaction();
		StudentAttempt att = (StudentAttempt) getCurrentSession().get(getEntityClass(), id);
		
		if (att != null) {
			Hibernate.initialize(att.getStudentAnswerses());
			Hibernate.initialize(att.getQuizz());
			Hibernate.initialize(att.getQuizz().getQuestions());
		}

		tx.commit();
        return att;
	}
}

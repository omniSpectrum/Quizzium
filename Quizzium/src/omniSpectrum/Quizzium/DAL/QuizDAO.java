package omniSpectrum.Quizzium.DAL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import omniSpectrum.Quizzium.Models.Quizz;

public class QuizDAO extends GenericDao<Quizz, Integer> {
	
	public QuizDAO(){
		
	}
	
	@Override
	protected Class<Quizz> getEntityClass() {
		return Quizz.class;
	}

//	public ArrayList<Quiz> getAllQuizes(){
//		return DbEmulation.getDbInstance().getQuizTable();
//	}
	
	public Quizz getCurrentQuiz(String currentDate) throws ParseException{
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date restrictedDate = df.parse(currentDate);
		org.hibernate.Transaction tx = getCurrentSession().beginTransaction();
		Criteria criteria = getCurrentSession().createCriteria(Quizz.class);
		criteria.add(Restrictions.le("quizzStarted", restrictedDate));
		criteria.add(Restrictions.gt("quizzEnded", restrictedDate));
		return (Quizz)criteria.uniqueResult();
	}

//	public void updateQuizState(Quiz cq, Boolean targetState) {
//		
//		// TODO real DB interaction UPDATE
//		for (Quiz q : DbEmulation.getDbInstance().getQuizTable()) {
//			q.setState(Boolean.FALSE);
//		}
//		cq.setState(targetState);
//	}
//
//	public Quiz getQuizById(Integer quizId) {
//
//		// TODO real DB interaction SELECT WHERE
//		for (Quiz q : DbEmulation.getDbInstance().getQuizTable()) {			
//			if (q.getId() == quizId) {
//				return q;
//			}
//		}
//		return null;
//	}

}

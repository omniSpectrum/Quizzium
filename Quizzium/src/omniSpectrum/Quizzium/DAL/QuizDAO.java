package omniSpectrum.Quizzium.DAL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import omniSpectrum.Quizzium.Models.Quizz;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class QuizDAO extends GenericDao<Quizz, Integer> {
	
	String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	
	public QuizDAO(){
		
	}
	
	@Override
	protected Class<Quizz> getEntityClass() {
		return Quizz.class;
	}
	
	public Quizz getCurrentQuiz(String currentDate) throws ParseException{
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(DATE_FORMAT_NOW);
		java.util.Date restrictedDate = df.parse(currentDate);
		org.hibernate.Transaction tx = getCurrentSession().beginTransaction();
		Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.le("quizzStarted", restrictedDate));
		criteria.add(Restrictions.gt("quizzEnded", restrictedDate));

		return (Quizz)criteria.uniqueResult();
	}
	public Quizz getCurrentQuiz(){
	    Date currentDateTime = Calendar.getInstance().getTime();
	    SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_NOW);
	    String stringDate = df.format(currentDateTime);
	    try{
	        return this.getCurrentQuiz(stringDate);	        
	    }
	    catch(ParseException e){
	     	return null;
	    }
	}
}

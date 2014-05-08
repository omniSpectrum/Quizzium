package omniSpectrum.Quizzium.DAL;

import java.util.Calendar;

import org.hibernate.Transaction;

import omniSpectrum.Quizzium.Models.Student;
import omniSpectrum.Quizzium.Models.StudentAnswers;
import omniSpectrum.Quizzium.Models.StudentAttempt;

public class StudentDAO extends GenericDao <Student, String> {

	@Override
	protected Class<Student> getEntityClass() {
		return Student.class;
	}
	
	public StudentAttempt getSingleAttempt(String studentNumber, int quizId) {
		
		Student student = findById(studentNumber);
		StudentAttempt attempt = null;
		
		//If student exists --> find attempt
		if (student != null) {
			//Check for attempt
			for (StudentAttempt att : student.getStudentAttempts()) {
				if (att.getQuizz().getQuizzId() == quizId) {
					attempt = att;
				}
			}
		}
		//ELSE --> create student, return null
		else {
			save(new Student(studentNumber));			
		}
		
		return attempt;
	}
	
	public void saveAttempt(StudentAttempt attempt){		
		attempt.setAttemptDate(Calendar.getInstance().getTime());
		
		Transaction trans = getCurrentSession().beginTransaction();
		getCurrentSession().save(attempt);
		trans.commit();
	}
}

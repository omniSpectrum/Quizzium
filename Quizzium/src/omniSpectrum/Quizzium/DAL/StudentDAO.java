package omniSpectrum.Quizzium.DAL;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Hibernate;
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
		
		Transaction tx = getCurrentSession().beginTransaction();
		Student student = (Student) getCurrentSession().get(getEntityClass(), studentNumber);

		StudentAttempt attempt = null;
		
		//If student exists --> find attempt
		if (student != null) {
			
			// Fetch student's attempts
			Hibernate.initialize(student.getStudentAttempts());
			//Check for attempt
			for (StudentAttempt att : student.getStudentAttempts()) {
				if (att.getQuizz().getQuizzId() == quizId) {
					attempt = att;
				}
			}
		}
		//ELSE --> create student, return null
		else {
			getCurrentSession().save(new Student(studentNumber));
		}
		
		tx.commit();
		return attempt;
	}
	
	@Override
	public List<Student> findAll(){
		
		Transaction trans = getCurrentSession().beginTransaction();
		List<Student> myList = findByCriteria();
		
		for (Student student : myList) {
			Hibernate.initialize(student.getStudentAttempts());
		}
		trans.commit();
		return myList;
	}
}

package omniSpectrum.Quizzium.DAL;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import omniSpectrum.Quizzium.Models.Student;
import omniSpectrum.Quizzium.Models.StudentAttempt;
import omniSpectrum.Quizzium.DAL.*;
public class StudentDAO extends GenericDao <Student, String> {

	@Override
	protected Class<Student> getEntityClass() {
		return Student.class;
	}

	public StudentAttempt getSingleAttempt(int studentNumber, int quizId) {
		
		//IF student exists --> check if contains Quiz with QuizId		
		Student s = getSingleStudent(studentNumber);
		
		if (s != null) {		
			for (StudentAttempt st : s.getAttempts()) {
				if(st.getQuiz().getId() == quizId)
					return st;
			}
		}
		//ELSE student DOESNT exist --> create, add to DB, return NULL
		else{
			s = new Student();
			s.setStudentNumber(studentNumber);
			db.getStudentTable().add(s);
		}
		return null;
	}
	public StudentAttempt getSingleAttempt(int attemptId) {
		
		for (StudentAttempt att : DbEmulation.getDbInstance().getAttemptTable()) {
			if(att.getAttemptId() == attemptId)
				return att;
		}
		return null;
	}
	
	public Student getSingleStudent(int studentNumber)
	{
		for (Student s : db.getStudentTable()) {
			if(s.getStudentNumber() == studentNumber)
				return s;
		}
		
		return null;
	}

	public void addAttempt(StudentAttempt attempt) {
		
		attempt.setAttemptDate(new Date());
		attempt.setAttemptId((new Random()).nextInt(1000));
		attempt.getStudent().getAttempts().add(attempt);
		DbEmulation.getDbInstance().getAttemptTable().add(attempt);
	}
	
	public ArrayList<Student> getAllStudents(){
		
		// THIS METHOD SHOULD ALSO INCLUDE RELATED ATTEMPTS
		return DbEmulation.getDbInstance().getStudentTable();
	}
}

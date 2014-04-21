package omniSpectrum.Quizzium.DAL;

import java.util.ArrayList;
import java.util.Date;

import omniSpectrum.Quizzium.Models.Student;
import omniSpectrum.Quizzium.Models.StudentAttempt;

public class StudentDAO {

	DbEmulation db;
	
	public StudentDAO(){
		db = DbEmulation.getDbInstance();
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
		attempt.getStudent().getAttempts().add(attempt);
	}
	
	public ArrayList<Student> getAllStudents(){
		
		// THIS METHOD SHOULD ALSO INCLUDE RELATED ATTEMPTS
		return DbEmulation.getDbInstance().getStudentTable();
	}
}

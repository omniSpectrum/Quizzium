package omniSpectrum.Quizzium.DAL;

import omniSpectrum.Quizzium.Models.Student;
import omniSpectrum.Quizzium.Models.StudentAttempt;

public class StudentDAO extends GenericDao <Student, String> {

	@Override
	protected Class<Student> getEntityClass() {
		return Student.class;
	}

	public StudentAttempt getSingleAttempt(String studentNumber, int quizId) {
		
		//IF student exists --> check if contains Quiz with QuizId		
		Student s = findById(studentNumber);
		
		if (s != null) {		
			for (StudentAttempt st : s.getStudentAttempts()) {
				if(st.getQuizz().getQuizzId() == quizId)
					return st;
			}
		}
		//ELSE student DOESNT exist --> create, add to DB, return NULL
		else{
			s = new Student();
			s.setStudentNumber(studentNumber);
			super.save(s);
		}
		return null;
	}
//	public StudentAttempt getSingleAttempt(int attemptId) {
//		
//		for (StudentAttempt att : DbEmulation.getDbInstance().getAttemptTable()) {
//			if(att.getAttemptId() == attemptId)
//				return att;
//		}
//		return null;
//	}
	
//	public void addAttempt(StudentAttempt attempt) {
//		
//		attempt.setAttemptDate(new Date());
//		attempt.setAttemptId((new Random()).nextInt(1000));
//		attempt.getStudent().getAttempts().add(attempt);
//		DbEmulation.getDbInstance().getAttemptTable().add(attempt);
//	}
//	
//	public ArrayList<Student> getAllStudents(){
//		
//		// THIS METHOD SHOULD ALSO INCLUDE RELATED ATTEMPTS
//		return DbEmulation.getDbInstance().getStudentTable();
//	}
}

package omniSpectrum.Quizzium.Models;


import java.util.Date;

public class StudentAttempt implements java.io.Serializable {

	private StudentAttemptId id;
	private Student student;
	private Quizz quizz;
	private Date attemptDate;

	public StudentAttempt() {
	}

	public StudentAttempt(StudentAttemptId id, Student student, Quizz quizz,
			Date attemptDate) {
		this.id = id;
		this.student = student;
		this.quizz = quizz;
		this.attemptDate = attemptDate;
	}

	public StudentAttemptId getId() {
		return this.id;
	}

	public void setId(StudentAttemptId id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Quizz getQuizz() {
		return this.quizz;
	}

	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}

	public Date getAttemptDate() {
		return this.attemptDate;
	}

	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}

}

package omniSpectrum.Quizzium.Models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class StudentAttempt implements java.io.Serializable {

	private Integer studentAttemptId;
	private Student student;
	private Quizz quizz;
	private Date attemptDate;
	private int result;
	private Set studentAnswerses = new HashSet(0);

	public StudentAttempt() {
	}

	public StudentAttempt(Student student, Quizz quizz, Date attemptDate,
			int result) {
		this.student = student;
		this.quizz = quizz;
		this.attemptDate = attemptDate;
		this.result = result;
	}

	public StudentAttempt(Student student, Quizz quizz, Date attemptDate,
			int result, Set studentAnswerses) {
		this.student = student;
		this.quizz = quizz;
		this.attemptDate = attemptDate;
		this.result = result;
		this.studentAnswerses = studentAnswerses;
	}

	public Integer getStudentAttemptId() {
		return this.studentAttemptId;
	}

	public void setStudentAttemptId(Integer studentAttemptId) {
		this.studentAttemptId = studentAttemptId;
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

	public int getResult() {
		return this.result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Set getStudentAnswerses() {
		return this.studentAnswerses;
	}

	public void setStudentAnswerses(Set studentAnswerses) {
		this.studentAnswerses = studentAnswerses;
	}

}

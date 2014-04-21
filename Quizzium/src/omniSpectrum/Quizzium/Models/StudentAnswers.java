package omniSpectrum.Quizzium.Models;

public class StudentAnswers implements java.io.Serializable {

	private StudentAnswersId id;
	private Alternative alternative;
	private StudentAttempt studentAttempt;

	public StudentAnswers() {
	}

	public StudentAnswers(StudentAnswersId id, Alternative alternative,
			StudentAttempt studentAttempt) {
		this.id = id;
		this.alternative = alternative;
		this.studentAttempt = studentAttempt;
	}

	public StudentAnswersId getId() {
		return this.id;
	}

	public void setId(StudentAnswersId id) {
		this.id = id;
	}

	public Alternative getAlternative() {
		return this.alternative;
	}

	public void setAlternative(Alternative alternative) {
		this.alternative = alternative;
	}

	public StudentAttempt getStudentAttempt() {
		return this.studentAttempt;
	}

	public void setStudentAttempt(StudentAttempt studentAttempt) {
		this.studentAttempt = studentAttempt;
	}

}

package omniSpectrum.Quizzium.Models;


public class StudentAttemptId implements java.io.Serializable {

	private int quizzQuizzId;
	private String studentStudentNumber;

	public StudentAttemptId() {
	}

	public StudentAttemptId(int quizzQuizzId, String studentStudentNumber) {
		this.quizzQuizzId = quizzQuizzId;
		this.studentStudentNumber = studentStudentNumber;
	}

	public int getQuizzQuizzId() {
		return this.quizzQuizzId;
	}

	public void setQuizzQuizzId(int quizzQuizzId) {
		this.quizzQuizzId = quizzQuizzId;
	}

	public String getStudentStudentNumber() {
		return this.studentStudentNumber;
	}

	public void setStudentStudentNumber(String studentStudentNumber) {
		this.studentStudentNumber = studentStudentNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudentAttemptId))
			return false;
		StudentAttemptId castOther = (StudentAttemptId) other;

		return (this.getQuizzQuizzId() == castOther.getQuizzQuizzId())
				&& ((this.getStudentStudentNumber() == castOther
						.getStudentStudentNumber()) || (this
						.getStudentStudentNumber() != null
						&& castOther.getStudentStudentNumber() != null && this
						.getStudentStudentNumber().equals(
								castOther.getStudentStudentNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getQuizzQuizzId();
		result = 37
				* result
				+ (getStudentStudentNumber() == null ? 0 : this
						.getStudentStudentNumber().hashCode());
		return result;
	}

}

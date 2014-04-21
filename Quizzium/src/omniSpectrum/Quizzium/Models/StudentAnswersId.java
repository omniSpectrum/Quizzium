package omniSpectrum.Quizzium.Models;

public class StudentAnswersId implements java.io.Serializable {

	private int studentAttemptStudentAttemptId;
	private int alternativeAlternativeId;

	public StudentAnswersId() {
	}

	public StudentAnswersId(int studentAttemptStudentAttemptId,
			int alternativeAlternativeId) {
		this.studentAttemptStudentAttemptId = studentAttemptStudentAttemptId;
		this.alternativeAlternativeId = alternativeAlternativeId;
	}

	public int getStudentAttemptStudentAttemptId() {
		return this.studentAttemptStudentAttemptId;
	}

	public void setStudentAttemptStudentAttemptId(
			int studentAttemptStudentAttemptId) {
		this.studentAttemptStudentAttemptId = studentAttemptStudentAttemptId;
	}

	public int getAlternativeAlternativeId() {
		return this.alternativeAlternativeId;
	}

	public void setAlternativeAlternativeId(int alternativeAlternativeId) {
		this.alternativeAlternativeId = alternativeAlternativeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudentAnswersId))
			return false;
		StudentAnswersId castOther = (StudentAnswersId) other;

		return (this.getStudentAttemptStudentAttemptId() == castOther
				.getStudentAttemptStudentAttemptId())
				&& (this.getAlternativeAlternativeId() == castOther
						.getAlternativeAlternativeId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getStudentAttemptStudentAttemptId();
		result = 37 * result + this.getAlternativeAlternativeId();
		return result;
	}

}

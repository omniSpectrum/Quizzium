package omniSpectrum.Quizzium.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentAnswersId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int studentAttemptStudentAttemptId;
	private int alternativeAlternativeId;

	public StudentAnswersId() {
	}

	public StudentAnswersId(int studentAttemptStudentAttemptId,
			int alternativeAlternativeId) {
		this.studentAttemptStudentAttemptId = studentAttemptStudentAttemptId;
		this.alternativeAlternativeId = alternativeAlternativeId;
	}

	@Column(name = "StudentAttempt_StudentAttemptId", nullable = false)
	public int getStudentAttemptStudentAttemptId() {
		return this.studentAttemptStudentAttemptId;
	}

	public void setStudentAttemptStudentAttemptId(
			int studentAttemptStudentAttemptId) {
		this.studentAttemptStudentAttemptId = studentAttemptStudentAttemptId;
	}

	@Column(name = "Alternative_alternativeId", nullable = false)
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

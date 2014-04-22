package omniSpectrum.Quizzium.Models;


import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CorrectAnswerId implements java.io.Serializable {

	private int questionQuestionId;
	private int alternativeAlternativeId;

	public CorrectAnswerId() {
	}

	public CorrectAnswerId(int questionQuestionId, int alternativeAlternativeId) {
		this.questionQuestionId = questionQuestionId;
		this.alternativeAlternativeId = alternativeAlternativeId;
	}

	@Column(name = "Question_questionId", nullable = false)
	public int getQuestionQuestionId() {
		return this.questionQuestionId;
	}

	public void setQuestionQuestionId(int questionQuestionId) {
		this.questionQuestionId = questionQuestionId;
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
		if (!(other instanceof CorrectAnswerId))
			return false;
		CorrectAnswerId castOther = (CorrectAnswerId) other;

		return (this.getQuestionQuestionId() == castOther
				.getQuestionQuestionId())
				&& (this.getAlternativeAlternativeId() == castOther
						.getAlternativeAlternativeId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getQuestionQuestionId();
		result = 37 * result + this.getAlternativeAlternativeId();
		return result;
	}

}

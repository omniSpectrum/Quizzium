package omniSpectrum.Quizzium.Models;

public class CorrectAnswer implements java.io.Serializable {

	private CorrectAnswerId id;
	private Question question;
	private Alternative alternative;

	public CorrectAnswer() {
	}

	public CorrectAnswer(CorrectAnswerId id, Question question,
			Alternative alternative) {
		this.id = id;
		this.question = question;
		this.alternative = alternative;
	}

	public CorrectAnswerId getId() {
		return this.id;
	}

	public void setId(CorrectAnswerId id) {
		this.id = id;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Alternative getAlternative() {
		return this.alternative;
	}

	public void setAlternative(Alternative alternative) {
		this.alternative = alternative;
	}

}

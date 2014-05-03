package omniSpectrum.Quizzium.dummy.Models;

public class AnswerAlternative {

	int alternativeId;
	Question question;
	String answerText;
	
	public AnswerAlternative(){}

	public int getAlternativeId() {
		return alternativeId;
	}

	public void setAlternativeId(int alternativeId) {
		this.alternativeId = alternativeId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
}

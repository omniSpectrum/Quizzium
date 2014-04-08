package omniSpectrum.Quizzium.Models;

public class Question {

	String questionText;
	Object[] answerOptions;
	
	public Question(String questionText, Object[] answerOptions) {
		super();
		this.questionText = questionText;
		this.answerOptions = answerOptions;
	}
	public Question(String questionText){
		this(questionText, null);
	}
	
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
}

package omniSpectrum.Quizzium.dummy.Models;
import java.util.ArrayList;

public class Question {

	int questionId;
	String questionText;
	ArrayList<AnswerAlternative> answerOptions;
	AnswerAlternative correctAnswer;
	
	public Question() {
		super();
		answerOptions = new ArrayList<AnswerAlternative>();
	}
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public ArrayList<AnswerAlternative> getAnswerOptions() {
		return answerOptions;
	}
	public void setAnswerOptions(ArrayList<AnswerAlternative> answerOptions) {
		this.answerOptions = answerOptions;
	}
	public AnswerAlternative getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(AnswerAlternative correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}

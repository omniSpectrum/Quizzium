package omniSpectrum.Quizzium.Models;


import java.util.HashSet;
import java.util.Set;

public class Alternative implements java.io.Serializable {

	private Integer alternativeId;
	private Question question;
	private String description;
	private Set studentAnswerses = new HashSet(0);
	private Set correctAnswers = new HashSet(0);

	public Alternative() {
	}

	public Alternative(Question question, String description) {
		this.question = question;
		this.description = description;
	}

	public Alternative(Question question, String description,
			Set studentAnswerses, Set correctAnswers) {
		this.question = question;
		this.description = description;
		this.studentAnswerses = studentAnswerses;
		this.correctAnswers = correctAnswers;
	}

	public Integer getAlternativeId() {
		return this.alternativeId;
	}

	public void setAlternativeId(Integer alternativeId) {
		this.alternativeId = alternativeId;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getStudentAnswerses() {
		return this.studentAnswerses;
	}

	public void setStudentAnswerses(Set studentAnswerses) {
		this.studentAnswerses = studentAnswerses;
	}

	public Set getCorrectAnswers() {
		return this.correctAnswers;
	}

	public void setCorrectAnswers(Set correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

}

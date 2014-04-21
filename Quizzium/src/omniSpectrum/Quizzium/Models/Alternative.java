package omniSpectrum.Quizzium.Models;

import java.util.HashSet;
import java.util.Set;

public class Alternative implements java.io.Serializable {

	private Integer alternativeId;
	private Question question;
	private String description;
	private Set studentAttempts = new HashSet(0);
	private Set questions = new HashSet(0);

	public Alternative() {
	}

	public Alternative(Question question, String description) {
		this.question = question;
		this.description = description;
	}

	public Alternative(Question question, String description,
			Set studentAttempts, Set questions) {
		this.question = question;
		this.description = description;
		this.studentAttempts = studentAttempts;
		this.questions = questions;
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

	public Set getStudentAttempts() {
		return this.studentAttempts;
	}

	public void setStudentAttempts(Set studentAttempts) {
		this.studentAttempts = studentAttempts;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

}

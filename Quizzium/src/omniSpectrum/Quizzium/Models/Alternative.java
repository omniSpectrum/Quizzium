package omniSpectrum.Quizzium.Models;

import java.util.HashSet;
import java.util.Set;

 class Alternative implements java.io.Serializable {

	private int alternativeId;
	private Question question;
	private String description;
	private Set questions = new HashSet(0);

	public Alternative() {
	}

	public Alternative(int alternativeId, Question question, String description) {
		this.alternativeId = alternativeId;
		this.question = question;
		this.description = description;
	}

	public Alternative(int alternativeId, Question question,
			String description, Set questions) {
		this.alternativeId = alternativeId;
		this.question = question;
		this.description = description;
		this.questions = questions;
	}

	public int getAlternativeId() {
		return this.alternativeId;
	}

	public void setAlternativeId(int alternativeId) {
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

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

}

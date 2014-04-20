package omniSpectrum.Quizzium.Models;



import java.util.HashSet;
import java.util.Set;


public class Question implements java.io.Serializable {

	private Integer questionId;
	private Quizz quizz;
	private String description;
	private Set alternatives = new HashSet(0);
	private Set alternatives_1 = new HashSet(0);

	public Question() {
	}

	public Question(Quizz quizz, String description) {
		this.quizz = quizz;
		this.description = description;
	}

	public Question(Quizz quizz, String description, Set alternatives,
			Set alternatives_1) {
		this.quizz = quizz;
		this.description = description;
		this.alternatives = alternatives;
		this.alternatives_1 = alternatives_1;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Quizz getQuizz() {
		return this.quizz;
	}

	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getAlternatives() {
		return this.alternatives;
	}

	public void setAlternatives(Set alternatives) {
		this.alternatives = alternatives;
	}

	public Set getAlternatives_1() {
		return this.alternatives_1;
	}

	public void setAlternatives_1(Set alternatives_1) {
		this.alternatives_1 = alternatives_1;
	}

}

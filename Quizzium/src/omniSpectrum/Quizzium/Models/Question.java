package omniSpectrum.Quizzium.Models;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Question", catalog = "quizziumdb2")
public class Question implements java.io.Serializable {

	private Integer questionId;
	private Quizz quizz;
	private String description;
	private Set alternatives = new HashSet(0);
	private Set correctAnswers = new HashSet(0);

	public Question() {
	}

	public Question(Quizz quizz, String description) {
		this.quizz = quizz;
		this.description = description;
	}

	public Question(Quizz quizz, String description, Set alternatives,
			Set correctAnswers) {
		this.quizz = quizz;
		this.description = description;
		this.alternatives = alternatives;
		this.correctAnswers = correctAnswers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "questionId", unique = true, nullable = false)
	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Quizz_quizzId", nullable = false)
	public Quizz getQuizz() {
		return this.quizz;
	}

	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	public Set getAlternatives() {
		return this.alternatives;
	}

	public void setAlternatives(Set alternatives) {
		this.alternatives = alternatives;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	public Set getCorrectAnswers() {
		return this.correctAnswers;
	}

	public void setCorrectAnswers(Set correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

}

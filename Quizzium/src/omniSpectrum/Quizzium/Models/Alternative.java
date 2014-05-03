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
@Table(name = "Alternative", catalog = "quizziumdb2")
public class Alternative implements java.io.Serializable {

	private Integer alternativeId;
	private Question question;
	private String description;
	private Set<StudentAnswers> studentAnswerses = new HashSet<StudentAnswers>(0);
	private Set<CorrectAnswer> correctAnswers = new HashSet<CorrectAnswer>(0);

	public Alternative() {
	}

	public Alternative(Question question, String description) {
		this.question = question;
		this.description = description;
	}

	public Alternative(Question question, String description,
			Set<StudentAnswers> studentAnswerses, Set<CorrectAnswer> correctAnswers) {
		this.question = question;
		this.description = description;
		this.studentAnswerses = studentAnswerses;
		this.correctAnswers = correctAnswers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "alternativeId", unique = true, nullable = false)
	public Integer getAlternativeId() {
		return this.alternativeId;
	}

	public void setAlternativeId(Integer alternativeId) {
		this.alternativeId = alternativeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Question_questionId", nullable = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alternative")
	public Set<StudentAnswers> getStudentAnswerses() {
		return this.studentAnswerses;
	}

	public void setStudentAnswerses(Set<StudentAnswers> studentAnswerses) {
		this.studentAnswerses = studentAnswerses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alternative")
	public Set<CorrectAnswer> getCorrectAnswers() {
		return this.correctAnswers;
	}

	public void setCorrectAnswers(Set<CorrectAnswer> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

}

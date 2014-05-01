package omniSpectrum.Quizzium.Models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CorrectAnswer", catalog = "quizziumdb2")
public class CorrectAnswer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
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

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "questionQuestionId", column = @Column(name = "Question_questionId", nullable = false)),
			@AttributeOverride(name = "alternativeAlternativeId", column = @Column(name = "Alternative_alternativeId", nullable = false)) })
	public CorrectAnswerId getId() {
		return this.id;
	}

	public void setId(CorrectAnswerId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Question_questionId", nullable = false, insertable = false, updatable = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Alternative_alternativeId", nullable = false, insertable = false, updatable = false)
	public Alternative getAlternative() {
		return this.alternative;
	}

	public void setAlternative(Alternative alternative) {
		this.alternative = alternative;
	}

}

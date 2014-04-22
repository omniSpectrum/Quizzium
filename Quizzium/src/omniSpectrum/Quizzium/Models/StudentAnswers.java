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
@Table(name = "StudentAnswers", catalog = "quizziumdb2")
public class StudentAnswers implements java.io.Serializable {

	private StudentAnswersId id;
	private Alternative alternative;
	private StudentAttempt studentAttempt;

	public StudentAnswers() {
	}

	public StudentAnswers(StudentAnswersId id, Alternative alternative,
			StudentAttempt studentAttempt) {
		this.id = id;
		this.alternative = alternative;
		this.studentAttempt = studentAttempt;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "studentAttemptStudentAttemptId", column = @Column(name = "StudentAttempt_StudentAttemptId", nullable = false)),
			@AttributeOverride(name = "alternativeAlternativeId", column = @Column(name = "Alternative_alternativeId", nullable = false)) })
	public StudentAnswersId getId() {
		return this.id;
	}

	public void setId(StudentAnswersId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Alternative_alternativeId", nullable = false, insertable = false, updatable = false)
	public Alternative getAlternative() {
		return this.alternative;
	}

	public void setAlternative(Alternative alternative) {
		this.alternative = alternative;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "StudentAttempt_StudentAttemptId", nullable = false, insertable = false, updatable = false)
	public StudentAttempt getStudentAttempt() {
		return this.studentAttempt;
	}

	public void setStudentAttempt(StudentAttempt studentAttempt) {
		this.studentAttempt = studentAttempt;
	}

}

package omniSpectrum.Quizzium.Models;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "StudentAttempt", catalog = "quizziumdb2")
public class StudentAttempt implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer studentAttemptId;
	private Student student;
	private Quizz quizz;
	private Date attemptDate;
	private int result;
	private Set<StudentAnswers> studentAnswerses = new HashSet<StudentAnswers>(0);

	public StudentAttempt() {
	}

	public StudentAttempt(Student student, Quizz quizz, Date attemptDate,
			int result) {
		this.student = student;
		this.quizz = quizz;
		this.attemptDate = attemptDate;
		this.result = result;
	}

	public StudentAttempt(Student student, Quizz quizz, Date attemptDate,
			int result, Set<StudentAnswers> studentAnswerses) {
		this.student = student;
		this.quizz = quizz;
		this.attemptDate = attemptDate;
		this.result = result;
		this.studentAnswerses = studentAnswerses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "StudentAttemptId", unique = true, nullable = false)
	public Integer getStudentAttemptId() {
		return this.studentAttemptId;
	}

	public void setStudentAttemptId(Integer studentAttemptId) {
		this.studentAttemptId = studentAttemptId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Student_studentNumber", nullable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Quizz_quizzId", nullable = false)
	public Quizz getQuizz() {
		return this.quizz;
	}

	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "attemptDate", nullable = false, length = 0)
	public Date getAttemptDate() {
		return this.attemptDate;
	}

	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}

	@Column(name = "Result", nullable = false)
	public int getResult() {
		return this.result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentAttempt")
	public Set<StudentAnswers> getStudentAnswerses() {
		return this.studentAnswerses;
	}

	public void setStudentAnswerses(Set<StudentAnswers> studentAnswerses) {
		this.studentAnswerses = studentAnswerses;
	}
}

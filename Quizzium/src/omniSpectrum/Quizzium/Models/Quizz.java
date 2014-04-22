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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Quizz", catalog = "quizziumdb2", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Quizz implements java.io.Serializable {

	private Integer quizzId;
	private Teacher teacher;
	private String name;
	private Date createdAt;
	private boolean state;
	private Set<StudentAttempt> studentAttempts = new HashSet<StudentAttempt>(0);
	private Set<Question> questions = new HashSet<Question>(0);

	public Quizz() {
	}

	public Quizz(Teacher teacher, String name, Date createdAt, boolean state) {
		this.teacher = teacher;
		this.name = name;
		this.createdAt = createdAt;
		this.state = state;
	}

	public Quizz(Teacher teacher, String name, Date createdAt, boolean state,
			Set<StudentAttempt> studentAttempts, Set<Question> questions) {
		this.teacher = teacher;
		this.name = name;
		this.createdAt = createdAt;
		this.state = state;
		this.studentAttempts = studentAttempts;
		this.questions = questions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "quizzId", unique = true, nullable = false)
	public Integer getQuizzId() {
		return this.quizzId;
	}

	public void setQuizzId(Integer quizzId) {
		this.quizzId = quizzId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Teacher_createdBy", nullable = false)
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Column(name = "name", unique = true, nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false, length = 0)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "state", nullable = false)
	public boolean isState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quizz")
	public Set<StudentAttempt> getStudentAttempts() {
		return this.studentAttempts;
	}

	public void setStudentAttempts(Set<StudentAttempt> studentAttempts) {
		this.studentAttempts = studentAttempts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quizz")
	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}

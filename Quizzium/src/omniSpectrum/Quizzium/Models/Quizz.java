package omniSpectrum.Quizzium.Models;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Quizz implements java.io.Serializable {

	private Integer quizzId;
	private Teacher teacher;
	private String name;
	private Date createdAt;
	private boolean state;
	private Set studentAttempts = new HashSet(0);
	private Set questions = new HashSet(0);

	public Quizz() {
	}

	public Quizz(Teacher teacher, String name, Date createdAt, boolean state) {
		this.teacher = teacher;
		this.name = name;
		this.createdAt = createdAt;
		this.state = state;
	}

	public Quizz(Teacher teacher, String name, Date createdAt, boolean state,
			Set studentAttempts, Set questions) {
		this.teacher = teacher;
		this.name = name;
		this.createdAt = createdAt;
		this.state = state;
		this.studentAttempts = studentAttempts;
		this.questions = questions;
	}

	public Integer getQuizzId() {
		return this.quizzId;
	}

	public void setQuizzId(Integer quizzId) {
		this.quizzId = quizzId;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
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

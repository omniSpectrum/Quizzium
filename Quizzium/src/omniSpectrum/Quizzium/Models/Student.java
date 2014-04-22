package omniSpectrum.Quizzium.Models;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Student", catalog = "quizziumdb2")
public class Student implements java.io.Serializable {

	private String studentNumber;
	private String password;
	private Set<StudentAttempt> studentAttempts = new HashSet<StudentAttempt>(0);

	public Student() {
	}

	public Student(String studentNumber, String password) {
		this.studentNumber = studentNumber;
		this.password = password;
	}

	public Student(String studentNumber, String password, Set<StudentAttempt> studentAttempts) {
		this.studentNumber = studentNumber;
		this.password = password;
		this.studentAttempts = studentAttempts;
	}

	@Id
	@Column(name = "studentNumber", unique = true, nullable = false, length = 45)
	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<StudentAttempt> getStudentAttempts() {
		return this.studentAttempts;
	}

	public void setStudentAttempts(Set<StudentAttempt> studentAttempts) {
		this.studentAttempts = studentAttempts;
	}

}

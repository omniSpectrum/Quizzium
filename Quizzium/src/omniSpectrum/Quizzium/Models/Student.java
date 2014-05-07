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
	private Set<StudentAttempt> studentAttempts = new HashSet<StudentAttempt>(0);

	public Student() {
	}

	public Student(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Student(String studentNumber, Set<StudentAttempt> studentAttempts) {
		this.studentNumber = studentNumber;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
	public Set<StudentAttempt> getStudentAttempts() {
		return this.studentAttempts;
	}

	public void setStudentAttempts(Set<StudentAttempt> studentAttempts) {
		this.studentAttempts = studentAttempts;
	}

}

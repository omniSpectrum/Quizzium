package omniSpectrum.Quizzium.Models;


import java.util.HashSet;
import java.util.Set;


public class Student implements java.io.Serializable {

	private String studentNumber;
	private String password;
	private Set studentAttempts = new HashSet(0);

	public Student() {
	}

	public Student(String studentNumber, String password) {
		this.studentNumber = studentNumber;
		this.password = password;
	}

	public Student(String studentNumber, String password, Set studentAttempts) {
		this.studentNumber = studentNumber;
		this.password = password;
		this.studentAttempts = studentAttempts;
	}

	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getStudentAttempts() {
		return this.studentAttempts;
	}

	public void setStudentAttempts(Set studentAttempts) {
		this.studentAttempts = studentAttempts;
	}

}

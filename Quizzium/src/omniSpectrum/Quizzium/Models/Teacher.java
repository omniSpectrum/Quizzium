package omniSpectrum.Quizzium.Models;

import java.util.HashSet;
import java.util.Set;

public class Teacher implements java.io.Serializable {

	private Integer teacherId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Set quizzs = new HashSet(0);

	public Teacher() {
	}

	public Teacher(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Teacher(String username, String password, String firstName,
			String lastName, Set quizzs) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.quizzs = quizzs;
	}

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set getQuizzs() {
		return this.quizzs;
	}

	public void setQuizzs(Set quizzs) {
		this.quizzs = quizzs;
	}

}

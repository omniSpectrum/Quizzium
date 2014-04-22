package omniSpectrum.Quizzium.Models;

// default package
// Generated Apr 22, 2014 5:03:12 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher", catalog = "quizziumdb2")
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

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "teacherId", unique = true, nullable = false)
	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@Column(name = "username", nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstName", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
	public Set getQuizzs() {
		return this.quizzs;
	}

	public void setQuizzs(Set quizzs) {
		this.quizzs = quizzs;
	}

}

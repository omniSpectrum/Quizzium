package omniSpectrum.Quizzium.Models;


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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Teacher", catalog = "quizziumdb2", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Teacher implements java.io.Serializable {

	private Integer teacherId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Set<Quizz> quizzs = new HashSet<Quizz>(0);

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

	@Column(name = "username", unique = true, nullable = false, length = 45)
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
	public Set<Quizz> getQuizzs() {
		return this.quizzs;
	}

	public void setQuizzs(Set<Quizz> quizzs) {
		this.quizzs = quizzs;
	}

}

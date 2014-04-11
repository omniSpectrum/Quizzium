package omniSpectrum.Quizzium.Models;

import java.util.ArrayList;

public class Teacher {
	
	private int teacherId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	private ArrayList<Quiz> quizes;
	
	public Teacher(){
		quizes = new ArrayList<Quiz>();
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(ArrayList<Quiz> quizes) {
		this.quizes = quizes;
	}
}

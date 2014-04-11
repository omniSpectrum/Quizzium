package omniSpectrum.Quizzium.Models;

import java.util.ArrayList;

public class Student {
	
	private int studentNumber;
	
	private ArrayList<StudentAttempt> attempts;
	
	public Student(){
		attempts = new ArrayList<StudentAttempt>();
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public ArrayList<StudentAttempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(ArrayList<StudentAttempt> attempts) {
		this.attempts = attempts;
	}
}

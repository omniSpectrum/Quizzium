package omniSpectrum.Quizzium.Models;

import java.util.ArrayList;

public class Student {
	
	private int studentNumber;
	
	private ArrayList<Attempt> attempts;
	
	public Student(){
		attempts = new ArrayList<Attempt>();
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public ArrayList<Attempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(ArrayList<Attempt> attempts) {
		this.attempts = attempts;
	}
}

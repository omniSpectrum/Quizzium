package omniSpectrum.Quizzium.dummy.Models;

import java.util.ArrayList;

public class Student {
	
	private int studentNumber;
	
	private ArrayList<StudentAttempt> studentAttempts;
	
	public Student(){
		studentAttempts = new ArrayList<StudentAttempt>();
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public ArrayList<StudentAttempt> getAttempts() {
		return studentAttempts;
	}

	public void setAttempts(ArrayList<StudentAttempt> studentAttempts) {
		this.studentAttempts = studentAttempts;
	}
}

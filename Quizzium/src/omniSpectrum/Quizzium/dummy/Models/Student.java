package omniSpectrum.Quizzium.dummy.Models;

import java.util.ArrayList;

public class Student {
	
	private String studentNumber;
	
	private ArrayList<StudentAttempt> studentAttempts;
	
	public Student(){
		studentAttempts = new ArrayList<StudentAttempt>();
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public ArrayList<StudentAttempt> getAttempts() {
		return studentAttempts;
	}

	public void setAttempts(ArrayList<StudentAttempt> studentAttempts) {
		this.studentAttempts = studentAttempts;
	}
}

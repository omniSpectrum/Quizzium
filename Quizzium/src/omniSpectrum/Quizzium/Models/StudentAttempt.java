package omniSpectrum.Quizzium.Models;

import java.util.ArrayList;

public class StudentAttempt {
	
	Student student;
	Quiz quiz;
	//TODO DATETIME FIELD
	int result; // between 0 and 100;
	ArrayList<AnswerAlternative> studentAnswers;
	
	public StudentAttempt(){
		studentAnswers = new ArrayList<AnswerAlternative>();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public ArrayList<AnswerAlternative> getStudentAnswers() {
		return studentAnswers;
	}

	public void setStudentAnswers(ArrayList<AnswerAlternative> studentAnswers) {
		this.studentAnswers = studentAnswers;
	}
}

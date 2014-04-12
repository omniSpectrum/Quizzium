package omniSpectrum.Quizzium.DAL;

import java.util.ArrayList;
import java.util.Date;

import omniSpectrum.Quizzium.Models.*;

public class DbEmulation {
	
	private static DbEmulation db; // Single instance only
	
	private ArrayList<Teacher> teacherTable;
	private ArrayList<Student> studentTable;
	private ArrayList<Quiz> quizTable;
	private ArrayList<Attempt> attemptTable;
	
	public DbEmulation(){
		
		teacherTable = new ArrayList<Teacher>();
		studentTable = new ArrayList<Student>();
		quizTable = new ArrayList<Quiz>();
		attemptTable = new ArrayList<Attempt>();
		
		populate();
	}
	
	public static DbEmulation getDbInstance(){
		return db = (db != null) ? db : new DbEmulation();
	}
	
	public void populate(){
		//ADDING TEACHER
		Teacher t = new Teacher();
		t.setTeacherId(1);
		t.setUsername("admin");
		t.setPassword("admin");
		t.setLastName("Makinen");
		t.setQuizes(quizTable);
		teacherTable.add(t);
		
		//ADDING QUIZES
		Quiz q1 = new Quiz();
		q1.setId(11);
		q1.setName("Super First Quiz");
		q1.setCreatedAt(new Date());
		q1.setState(true);
		q1.setCreatedBy(t);
		quizTable.add(q1);
		
		Quiz q2 = new Quiz();
		q2.setId(12);
		q2.setName("Super Second Quiz");
		q2.setCreatedAt(new Date());
		q2.setState(false);
		q2.setCreatedBy(t);
		quizTable.add(q2);
		
		Quiz q3 = new Quiz();
		q3.setId(13);
		q3.setName("Super Third Quiz");
		q3.setCreatedAt(new Date());
		q3.setState(false);
		q3.setCreatedBy(t);
		quizTable.add(q3);
		
		//Adding QUESTIONS
		q1.getQuestions().add(new Question("What is meaning of Java?"));
		q1.getQuestions().add(new Question("What is meaning of Eclipse?"));
		q1.getQuestions().add(new Question("What is meaning of Android?"));
		q2.getQuestions().add(new Question("What is meaning of Life?"));		
	}

	public ArrayList<Teacher> getTeacherTable() {
		return teacherTable;
	}

	public void setTeacherTable(ArrayList<Teacher> teacherTable) {
		this.teacherTable = teacherTable;
	}

	public ArrayList<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(ArrayList<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public ArrayList<Quiz> getQuizTable() {
		return quizTable;
	}

	public void setQuizTable(ArrayList<Quiz> quizTable) {
		this.quizTable = quizTable;
	}

	public ArrayList<Attempt> getAttemptTable() {
		return attemptTable;
	}

	public void setAttemptTable(ArrayList<Attempt> attemptTable) {
		this.attemptTable = attemptTable;
	}
}

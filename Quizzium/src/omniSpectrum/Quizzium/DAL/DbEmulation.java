package omniSpectrum.Quizzium.DAL;

import java.util.ArrayList;
import java.util.Date;

import omniSpectrum.Quizzium.Models.*;

public class DbEmulation {
	
	private static DbEmulation db; // Single instance only
	
	private ArrayList<Teacher> teacherTable;
	private ArrayList<Student> studentTable;
	private ArrayList<Quiz> quizTable;
	private ArrayList<AnswerAlternative> answerTable;
	private ArrayList<StudentAttempt> attemptTable;
	
	public DbEmulation(){
		
		teacherTable = new ArrayList<Teacher>();
		studentTable = new ArrayList<Student>();
		quizTable = new ArrayList<Quiz>();
		answerTable = new ArrayList<AnswerAlternative>();
		attemptTable = new ArrayList<StudentAttempt>();
		
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
		Question ques1 = new Question();
		ques1.setQuestionId(101);
		ques1.setQuestionText("What is meaning of Java?");
		Question ques2 = new Question();
		ques2.setQuestionId(102);
		ques2.setQuestionText("What is meaning of Eclipse?");
		Question ques3 = new Question();
		ques3.setQuestionId(103);
		ques3.setQuestionText("What is meaning of Android?");
		Question ques4 = new Question();
		ques4.setQuestionId(104);
		ques4.setQuestionText("What is meaning of Life?");
		
		q1.getQuestions().add(ques1);
		q1.getQuestions().add(ques2);
		q1.getQuestions().add(ques3);
		q2.getQuestions().add(ques4);
		
		//Adding Answer Options
		AnswerAlternative a1 = new AnswerAlternative();
		a1.setAlternativeId(1);
		a1.setAnswerText("yes");
		AnswerAlternative a2 = new AnswerAlternative();
		a2.setAlternativeId(2);
		a2.setAnswerText("no");
		AnswerAlternative a3 = new AnswerAlternative();
		a3.setAlternativeId(3);
		a3.setAnswerText("maybe");
		AnswerAlternative a4 = new AnswerAlternative();
		a4.setAlternativeId(4);
		a4.setAnswerText("possible");
		
		//Assigning answers to questions
		int r = 0;
		
		for (Question myQ : q1.getQuestions()) {
			
			ArrayList<AnswerAlternative> aa = myQ.getAnswerOptions();
			
			aa.add(a1);
			aa.add(a2);
			aa.add(a3);
			aa.add(a4);
			
			myQ.setCorrectAnswer(aa.get(r++));
		}
		
		//Adding Students
		Student s1 = new Student();
		s1.setStudentNumber(1234567);
		Student s2 = new Student();
		s2.setStudentNumber(1234588);
		Student s3 = new Student();
		s3.setStudentNumber(1234599);
		
		getStudentTable().add(s1);
		getStudentTable().add(s2);
		getStudentTable().add(s3);
		
		//Adding Attempts
		StudentAttempt att1 = new StudentAttempt();
		att1.setAttemptDate(new Date());
		att1.setQuiz(q1);
		att1.setResult(75);
		
		StudentAttempt att2 = new StudentAttempt();
		att2.setAttemptDate(new Date());
		att2.setQuiz(q2);
		att2.setResult(89);
		
		//Assigning attempts to Students
		s1.getAttempts().add(att1);
		s2.getAttempts().add(att1);
		s3.getAttempts().add(att1);
		
		s1.getAttempts().add(att2);
		s2.getAttempts().add(att2);
		s3.getAttempts().add(att2);
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

	public ArrayList<AnswerAlternative> getAnswerTable() {
		return answerTable;
	}

	public void setAnswerTable(ArrayList<AnswerAlternative> answerTable) {
		this.answerTable = answerTable;
	}

	public ArrayList<StudentAttempt> getAttemptTable() {
		return attemptTable;
	}

	public void setAttemptTable(ArrayList<StudentAttempt> attemptTable) {
		this.attemptTable = attemptTable;
	}
}

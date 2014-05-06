package omniSpectrum.Quizzium.dummy.DAL;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import omniSpectrum.Quizzium.Models.*;

public class DbEmulationHibernate {
	
	private static DbEmulationHibernate db; // Single instance only
	
	private Set<Teacher> teacherTable;
	private Set<Student> studentTable;
	private Set<Quizz> quizTable;
	private Set<Alternative> answerTable;
	private Set<StudentAttempt> attemptTable;
	
	public DbEmulationHibernate(){
		
		teacherTable = new HashSet<Teacher>();
		studentTable = new HashSet<Student>();
		quizTable = new HashSet<Quizz>();
		answerTable = new HashSet<Alternative>();
		attemptTable = new HashSet<StudentAttempt>();
		
		populate();
	}
	
	public static DbEmulationHibernate getDbInstance(){
		return db = (db != null) ? db : new DbEmulationHibernate();
	}
	
	public void populate(){
		//ADDING TEACHER
		Teacher t = new Teacher();
		t.setTeacherId(1);
		t.setUsername("admin");
		t.setPassword("admin");
		t.setLastName("Makinen");
		t.setQuizzs(quizTable);
		teacherTable.add(t);
		
		//ADDING QUIZES
		Quizz q1 = new Quizz();
		q1.setQuizzId(11);
		q1.setName("Super First Quiz");
		q1.setCreatedAt(new Date());
		q1.setQuizzStarted(new Date());
		q1.setQuizzEnded(new Date());
		q1.setTeacher(t);
		quizTable.add(q1);
		
		Quizz q2 = new Quizz();
		q2.setQuizzId(12);
		q2.setName("Super Second Quiz");
		q2.setCreatedAt(new Date());
		q2.setQuizzStarted(new Date());
		q2.setQuizzEnded(new Date());
		q2.setTeacher(t);
		quizTable.add(q2);
		
		Quizz q3 = new Quizz();
		q3.setQuizzId(13);
		q3.setName("Super Third Quiz");
		q3.setCreatedAt(new Date());
		q3.setQuizzStarted(new Date());
		q3.setQuizzEnded(new Date());
		q3.setTeacher(t);
		quizTable.add(q3);
	}

	public Set<Teacher> getTeacherTable() {
		return teacherTable;
	}

	public void setTeacherTable(Set<Teacher> teacherTable) {
		this.teacherTable = teacherTable;
	}

	public Set<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(Set<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public Set<Quizz> getQuizTable() {
		return quizTable;
	}

	public void setQuizTable(Set<Quizz> quizTable) {
		this.quizTable = quizTable;
	}

	public Set<StudentAttempt> getAttemptTable() {
		return attemptTable;
	}

	public void setAttemptTable(Set<StudentAttempt> attemptTable) {
		this.attemptTable = attemptTable;
	}
}

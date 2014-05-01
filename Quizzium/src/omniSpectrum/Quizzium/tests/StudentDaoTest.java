package omniSpectrum.Quizzium.tests;

import static org.junit.Assert.*;
import omniSpectrum.Quizzium.DAL.StudentDAO;
import omniSpectrum.Quizzium.Models.Student;

import org.junit.Test;

public class StudentDaoTest {

	private StudentDAO student = new StudentDAO();
	
	@Test
	public void testSave() {
		Student mystudent = new Student("a1203245");
		Student mystudent1 = new Student("a1203247");
		Student mystudent2 = new Student("a1203249");

		student.save(mystudent);
		student.save(mystudent1);
		student.save(mystudent2);
		
		assertNotNull(student.findById("a1203245"));
		assertNotNull(student.findById("a1203247"));
		assertNotNull(student.findById("a1203249"));
	}
	
	@Test
	public void testFindById(){
		Student expected = new Student("a1203245");
		Student actual = student.findById("a1203245");
		
		assertEquals(expected.getStudentNumber(), actual.getStudentNumber());
	}
	
	@Test
	public void testDelete() {
		Student mystudent = student.findById("a1203245");
		student.delete(mystudent);
		
		assertNull(student.findById("a1203245"));
	}

}

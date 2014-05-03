package omniSpectrum.Quizzium.tests;

import static org.junit.Assert.*;
import omniSpectrum.Quizzium.DAL.TeacherDAO;
import omniSpectrum.Quizzium.Models.Teacher;

import org.junit.Test;

public class TeacherDAOTests {
	
	private TeacherDAO teacherDao = new TeacherDAO(); 
	
	@Test
	public void testSave() {
		Teacher teacher = new Teacher("jukka", "jusju");
		teacherDao.save(teacher);
		
		assertNotNull(teacherDao.findById(3));
	}

}

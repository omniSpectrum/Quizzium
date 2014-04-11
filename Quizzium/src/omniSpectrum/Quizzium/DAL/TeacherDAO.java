package omniSpectrum.Quizzium.DAL;

import omniSpectrum.Quizzium.Models.Teacher;

public class TeacherDAO {
	
	Teacher dummy;
	
	public TeacherDAO() {
		dummy = new Teacher();
		dummy.setTeacherId(1);
		dummy.setUsername("admin");
		dummy.setPassword("admin");
	}
	
	public Teacher teacherLoginCheck(String username, String password){
		return dummy;
	}
	
}

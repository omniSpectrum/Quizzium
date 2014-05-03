package omniSpectrum.Quizzium.dummy.DAL;

import omniSpectrum.Quizzium.dummy.Models.Teacher;

public class TeacherDAO {
	
	public TeacherDAO() {

	}
	
	public Teacher teacherLoginCheck(String username, String password){

		for (Teacher t : DbEmulation.getDbInstance().getTeacherTable()) {
			
			if(t.getUsername().equals(username)  && t.getPassword().equals(password))
				return t;
		}
		return null;
	}
	
}

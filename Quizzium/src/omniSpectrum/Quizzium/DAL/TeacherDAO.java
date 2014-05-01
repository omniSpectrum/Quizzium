package omniSpectrum.Quizzium.DAL;

import omniSpectrum.Quizzium.Models.Teacher;

public class TeacherDAO extends GenericDao<Teacher, Integer> {
	
	
	@Override
	protected Class<Teacher> getEntityClass() {
		return Teacher.class;
	}
	
//	public Teacher teacherLoginCheck(String username, String password){
//
//		for (Teacher t : DbEmulation.getDbInstance().getTeacherTable()) {
//			
//			if(t.getUsername().equals(username)  && t.getPassword().equals(password))
//				return t;
//		}
//		return null;
//	}
}

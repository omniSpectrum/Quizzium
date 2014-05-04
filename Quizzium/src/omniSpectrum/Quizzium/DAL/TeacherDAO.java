package omniSpectrum.Quizzium.DAL;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import omniSpectrum.Quizzium.Models.Teacher;

public class TeacherDAO extends GenericDao<Teacher, Integer> {
	
	
	@Override
	protected Class<Teacher> getEntityClass() {
		return Teacher.class;
	}
	
	public Teacher teacherLoginCheck(String username, String password){
		getCurrentSession().beginTransaction();
		Criteria criteria = getCurrentSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		
		Teacher teacher = (Teacher)criteria.uniqueResult();
		
		return teacher;
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

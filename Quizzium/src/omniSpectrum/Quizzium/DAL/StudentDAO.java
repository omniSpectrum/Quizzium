package omniSpectrum.Quizzium.DAL;

import java.util.Date;

import omniSpectrum.Quizzium.Models.Student;
import omniSpectrum.Quizzium.Models.StudentAttempt;
import omniSpectrum.Quizzium.DAL.*;
public class StudentDAO extends GenericDao <Student, String> {

	@Override
	protected Class<Student> getEntityClass() {
		return Student.class;
	}

}

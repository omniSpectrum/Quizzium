package omniSpectrum.Quizzium.DAL;

import omniSpectrum.Quizzium.Models.StudentAttempt;

public class AttemptDao extends GenericDao<StudentAttempt, Integer> {

	@Override
	protected Class<StudentAttempt> getEntityClass() {
		return StudentAttempt.class;
	}

}

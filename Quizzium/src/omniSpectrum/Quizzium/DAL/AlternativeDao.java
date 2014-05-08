package omniSpectrum.Quizzium.DAL;

import omniSpectrum.Quizzium.Models.Alternative;

public class AlternativeDao extends GenericDao <Alternative, Integer>{

	@Override
	protected Class<Alternative> getEntityClass() {
		return Alternative.class;
	}

}

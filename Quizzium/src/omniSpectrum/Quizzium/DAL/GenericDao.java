package omniSpectrum.Quizzium.DAL;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	
	PK save(T newInstance);
	void update(T transientObject);
	void saveOrUpdate(T transientObject);
	void delete (T persistentObject);
	T findById(PK id);
	List<T> findAll();
	List<T> findByProperty(String propertyName, Object value);

}

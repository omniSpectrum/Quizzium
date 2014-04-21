package omniSpectrum.Quizzium.DAL;

import java.util.List;

public interface GenericDao<T> {
	T find(Integer id);
	void save (T t);
	List<T> findAll();
	Integer countAll();
	void delete(T t);

}

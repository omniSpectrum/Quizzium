package omniSpectrum.Quizzium.DAL;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

public abstract class GenericDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

	private SessionFactory sessionFactory;
	
	protected final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public PK save(T newInstance) {
		
		return (PK) getCurrentSession().save(newInstance);
	}

	@Override
	public void update(T transientObject) {
		// TODO Auto-generated method stub
		getCurrentSession().update(transientObject);
		
	}

	@Override
	public void saveOrUpdate(T transientObject) {
		// TODO Auto-generated method stub
		getCurrentSession().saveOrUpdate(transientObject);
		
	}

	@Override
	public void delete(T persistentObject) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(persistentObject);
		
	}

	@Override
	public T findById(PK id) {
		return (T) getCurrentSession().get(getEntityClass(), id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	
    protected abstract Class<T> getEntityClass();
    protected DetachedCriteria createDetachedCriteria() {
          return DetachedCriteria.forClass(getEntityClass());
    };

}

package omniSpectrum.Quizzium.DAL;

import java.io.Serializable;
import java.util.List;

import omniSpectrum.Quizzium.utils.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

public abstract class GenericDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	protected final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T newInstance) {
		
		   Transaction trans= getCurrentSession().beginTransaction();
		   getCurrentSession().save(newInstance);
		   trans.commit();
		   }

	@Override
	public void update(T transientObject) {
		Transaction trans = getCurrentSession().beginTransaction();
		getCurrentSession().update(transientObject);
		trans.commit();
		
	}

	@Override
	public void saveOrUpdate(T transientObject) {
		Transaction trans = getCurrentSession().beginTransaction();
		getCurrentSession().saveOrUpdate(transientObject);
		trans.commit();
	}

	@Override
	public void delete(T persistentObject) {
		Transaction trans = getCurrentSession().beginTransaction();
		getCurrentSession().delete(persistentObject);
		trans.commit();
	}

	//TODO: Fix the bug here!!!!
	@Override
	public T findById(PK id) {
		Transaction tx = getCurrentSession().beginTransaction();
		T instance = (T) getCurrentSession().get(getEntityClass(), id);
		tx.commit();
        return instance;

	}

	@Override
	public List<T> findAll() {
		getCurrentSession().beginTransaction();
		return findByCriteria();
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
    
    protected List<T> findByCriteria(Criterion... criterion) {  
        Criteria crit = getCurrentSession().createCriteria(getEntityClass());  
        for (Criterion c : criterion) {  
            crit.add(c);  
        }  
        return crit.list();  
   }

}

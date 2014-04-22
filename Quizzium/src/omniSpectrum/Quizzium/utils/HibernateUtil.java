package omniSpectrum.Quizzium.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
	private static SessionFactory buildSessionFactory(){
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			return sessionFactory;
		} catch (Throwable ex){
			System.err.println("SessionFactory creation failed" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void close(){
		getSessionFactory().close();
	}

}

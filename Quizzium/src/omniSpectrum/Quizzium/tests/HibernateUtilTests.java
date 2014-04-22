package omniSpectrum.Quizzium.tests;

import static org.junit.Assert.*;
import omniSpectrum.Quizzium.utils.HibernateUtil;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class HibernateUtilTests {

	@Test
	public void testGetSessionFactory() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		assertNotNull(sessionFactory);
		HibernateUtil.close();
	}

}

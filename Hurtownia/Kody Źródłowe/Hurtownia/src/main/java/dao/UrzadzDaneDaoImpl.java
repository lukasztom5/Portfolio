package dao;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.*;

public class UrzadzDaneDaoImpl implements UrzadzDaneDao{
	private static final Log log = LogFactory.getLog(UrzadzenieDaoImpl.class);

	private Session session;
	private Transaction tx;
public UrzadzenieDane findByIdurzadzenie(int idurzadzenie) {
		
		log.debug("getting URZADZENIE_DANE instance with ID: " + idurzadzenie);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			UrzadzenieDane result = (UrzadzenieDane) session.get(UrzadzenieDane.class, idurzadzenie);
			tx.commit();
			log.debug("get successful");
			return result;
		} catch (RuntimeException e) {
			log.error("get failed", e);
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
}

}

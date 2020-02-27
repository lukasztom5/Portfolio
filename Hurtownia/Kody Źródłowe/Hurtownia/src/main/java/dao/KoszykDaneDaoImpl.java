package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.*;

public class KoszykDaneDaoImpl implements KoszykDaneDao{
	private static final Log log = LogFactory.getLog(ModelDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public KoszykDane findByIdkosz(int idkosz) {
		log.debug("getting KOSZYK_DANE instance with ID: " + idkosz);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			KoszykDane result = (KoszykDane) session.get(KoszykDane.class, idkosz);
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

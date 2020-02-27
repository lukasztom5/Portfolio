package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.KatWidok;

public class KatDaneDaoImpl implements KatDaneDao{
	private static final Log log = LogFactory.getLog(ModelDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public KatWidok findByIdkat(int idkat) {
		log.debug("getting KAT_WIDOK instance with ID: " + idkat);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			KatWidok result = (KatWidok) session.get(KatWidok.class, idkat);
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

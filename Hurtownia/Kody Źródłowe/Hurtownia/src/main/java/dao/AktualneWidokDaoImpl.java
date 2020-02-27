package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.*;

public class AktualneWidokDaoImpl implements AktualneWidokDao{
	private static final Log log = LogFactory.getLog(AktualneDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public AktualneWidok findByIdakt(int idakt) {
		log.debug("getting AKTUALNE_WIDOK instance with ID: " + idakt);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			AktualneWidok result = (AktualneWidok) session.get(AktualneWidok.class, idakt);
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

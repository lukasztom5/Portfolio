package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.*;

public class HistoriaWidokDaoImpl implements HistoriaWidokDao{
	private static final Log log = LogFactory.getLog(HistoriaDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public HistoriaWidok findByIdhist(int idhist) {
		log.debug("getting HISTORIA_WIDOK instance with ID: " + idhist);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			HistoriaWidok result = (HistoriaWidok) session.get(HistoriaWidok.class, idhist);
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

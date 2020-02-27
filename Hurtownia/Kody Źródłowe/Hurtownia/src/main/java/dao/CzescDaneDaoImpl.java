package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.CzescWidok;

public class CzescDaneDaoImpl implements CzescDaneDao{
	private static final Log log = LogFactory.getLog(CzescDaoImpl.class);

	private Session session;
	private Transaction tx;
	@Override
	public CzescWidok findByIdczesc(int idczesc) {
		log.debug("getting CZESC_WIDOK instance with ID: " + idczesc);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			CzescWidok result = (CzescWidok) session.get(CzescWidok.class, idczesc);
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

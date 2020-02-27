package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.*;

public class RozlWidokDaoImpl implements RozlWidokDao{
	private static final Log log = LogFactory.getLog(RozliczenieDaoImpl.class);

	private Session session;
	private Transaction tx;

	@SuppressWarnings("unchecked")
	public List<RozlWidok> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<RozlWidok> List = new ArrayList<RozlWidok>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from ROZL_WIDOK");
			q.addEntity(RozlWidok.class);
			List = q.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return List;
	}
	public RozlWidok findByIdrozl(int idrozl) {
		
		log.debug("getting ROZL_WIDOK instance with id: " + idrozl);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			RozlWidok result = (RozlWidok) session.get(RozlWidok.class, idrozl);
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

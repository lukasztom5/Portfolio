package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import encje.KlientDane;

public class KlientDaneDaoImpl implements KlientDaneDao{
	private static final Log log = LogFactory.getLog(KlientDaoImpl.class);

	private Session session;
	private Transaction tx;

	@SuppressWarnings("unchecked")
	public List<KlientDane> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<KlientDane> List = new ArrayList<KlientDane>();
		try {
			tx = session.getTransaction();
			tx.begin();
			SQLQuery q = session.createSQLQuery(
					"select * from KLIENT_DANE");
			q.addEntity(KlientDane.class);
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
	public KlientDane findByIdklient(int idklient) {
		
		log.debug("getting KLIENT_DANE instance with id: " + idklient);
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			KlientDane result = (KlientDane) session.get(KlientDane.class, idklient);
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
